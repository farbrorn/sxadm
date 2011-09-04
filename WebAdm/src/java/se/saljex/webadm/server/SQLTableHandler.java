/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package se.saljex.webadm.server;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.DataFormatException;
import javax.persistence.OrderBy;
import se.saljex.sxlibrary.SXUtil;
import se.saljex.webadm.client.rpcobject.ErrorConvertingFromResultsetException;
import se.saljex.webadm.client.rpcobject.IsSQLTable;
import se.saljex.webadm.client.rpcobject.Offert2;
import se.saljex.webadm.client.rpcobject.SQLTableList;

/**
 *
 * @author Ulf
 */
public class SQLTableHandler {

	public static final Double dummyDouble = (double)0;
	public static final String dummyString = "";
	public static final Integer dummyInteger = 0;
	public static final Short dummyShort = (short)0;
	public static final java.sql.Date dummySQLDate = new java.sql.Date(0);


	public static String getSelectColumns(Class c) {
		StringBuilder sqlField = new StringBuilder();
		Field[] fields = c.getFields();
		for (Field f : fields) {
			if (sqlField.length()>1) sqlField.append(", ");
			sqlField.append(f.getName());
		}
		return sqlField.toString();
	}

	public static String getSelectStatement(IsSQLTable o) {
		return "select " + getSelectColumns(o.getClass()) + " from " + o.getSQLTableName();
	}

	public static void fillSQLTable(Connection con, IsSQLTable o, SQLTableList list, String SQLWhere, String SQLOrderBy, String extraSQL, Object[] parameters, boolean addPrimaryKeySort, boolean descandentSort, int offset, int limit) throws SQLException, ErrorConvertingFromResultsetException{
		ResultSet rs = getResultSet(con, o, SQLWhere, SQLOrderBy, extraSQL, parameters, addPrimaryKeySort, descandentSort, offset, limit);
		fetchFromResultSet(rs, o, list, offset, limit);
	}
	
	public static ResultSet getResultSet(Connection con, IsSQLTable o, String SQLWhere, String SQLOrderBy, String extraSQL, Object[] parameters, boolean addPrimaryKeySort, boolean descandentSort, int offset, int limit) throws SQLException{
		String sql = getSelectStatement(o);
		if (SQLWhere==null) SQLWhere="";
		if (SQLOrderBy==null) SQLOrderBy="";
		if (extraSQL==null) extraSQL="";

		if (!SXUtil.isEmpty(SQLWhere)) {
			sql = sql + " where " + SQLWhere;
		}

		if (addPrimaryKeySort) {
			String primarayKey = getPrimaryKeyOrderByString(o, descandentSort);
			if (!SXUtil.isEmpty(primarayKey)) {
				if (!SXUtil.isEmpty(SQLOrderBy)) SQLOrderBy = SQLOrderBy + ", ";
				SQLOrderBy = SQLOrderBy + " " + primarayKey;
			}
		}


		if (!SXUtil.isEmpty(SQLOrderBy)) {
			sql = sql + " order by " + SQLOrderBy;
		}

		if (offset>0) {
			extraSQL = extraSQL + " offset " + offset;
		}
		if (limit>0) {
			extraSQL = extraSQL + " limit " + (limit+1);
		}

		if (!SXUtil.isEmpty(extraSQL)) {
			sql = sql + " " + extraSQL;
		}

		PreparedStatement stm = con.prepareStatement(sql);
		if (parameters.length>0) {
			int cn=0;
			for (Object p : parameters) {
				cn++;
				stm.setObject(cn, p);
			}
		}
		return stm.executeQuery();
	}

	public static void getValues(IsSQLTable o, ResultSet rs) throws ErrorConvertingFromResultsetException {
		Field[] fields = o.getClass().getFields();
		for ( Field f : fields) {
			try {
//				System.out.print("----" + f.getName() + " " + f.getType().getName());// + " " + rs.getObject(f.getName()).getClass().getName());
				if (  f.get(o) instanceof Integer)  f.set(o, rs.getInt(f.getName()));
				else if (  f.get(o) instanceof Short || f.getType()==Short.class)  f.set(o, rs.getShort(f.getName()));
				else if (  f.get(o) instanceof Double || f.getType()==Double.class)  f.set(o, rs.getDouble(f.getName()));
				else if (  f.get(o) instanceof Float || f.getType()==Float.class)  f.set(o, rs.getFloat(f.getName()));
				else f.set(o, f.getType().cast(rs.getObject(f.getName())));
//				System.out.print("set   ----" + f.getName() + " " + f.getType().getName());// + " " + rs.getObject(f.getName()).getClass().getName());

			}catch (Exception e) {  e.printStackTrace(); throw new ErrorConvertingFromResultsetException("Fel vid konvertering från SQL Redsultset till class: " + e.toString() + " " + e.getMessage());}
		}
	}

	public static void fetchFromResultSet(ResultSet rs, IsSQLTable sqlTable, SQLTableList list, int offset, int limit) throws SQLException, ErrorConvertingFromResultsetException{
		IsSQLTable row;
		int cn = 0;
		list.hasMoreRows = false;
		while (rs.next()) {
			cn++;
			if (cn > limit && limit > 0) {
				list.hasMoreRows=true;
				break;
			}
			row = sqlTable.newInstance();
			getValues(row, rs);
			list.lista.add(row);
		}
		list.limit = limit;
		list.offset = offset;

	}

	public static String getPrimaryKeyOrderByString(IsSQLTable o, boolean descandingSortOrder) {
		//Lägg till grundsortering på primary key
		String[] primaryKeyLabels = o.getPrimaryKeyLabels();
		String orderBy="";
		for (String label : primaryKeyLabels) {
			if (orderBy.length()>0) orderBy = orderBy + ", ";
			orderBy = orderBy + " " + label;
			if (descandingSortOrder) orderBy = orderBy + " desc ";
		}
		return orderBy;

	}

	//Hittar angiven kolumnnamn och konverteraar en string till ett object av samma typ
	//Returnerar värdet som ett object av rätt typ, eller null m kolumnen inte finns
	public static Object getObjectAsColumnType(IsSQLTable table, String columnName, String varde) throws ParseException{
		try {
		Field[] fields = table.getClass().getFields();
		for (Field field : fields) {
			if (field.getName().equals(columnName)) {
				if (field.getType().isInstance(dummyString ) || field.get(table) instanceof String){
//System.out.print("Kolumn " + columnName + " är String");
					return varde;
				} else if (field.getType().isInstance(dummySQLDate) || field.get(table) instanceof java.sql.Date ) {

//System.out.print("Kolumn " + columnName + " är Date");
					java.util.Date d = DateFormat.getInstance().parse(varde);
					if (d!=null) {
						return new java.sql.Date(d.getTime());
					}
				} else if (field.get(table) instanceof Integer || field.getType().isInstance(dummyInteger)) {
//System.out.print("Kolumn " + columnName + " är Integer");
					return new Integer(varde);
				} else if (field.get(table) instanceof Short || field.getType().isInstance(dummyShort)) {
//System.out.print("Kolumn " + columnName + " är Short");
					return new Short(varde);
				} else if (field.get(table) instanceof Double || field.getType().isInstance(dummyDouble)) {
//7System.out.print("Kolumn " + columnName + " är Double");
					return new Double(varde);
				} else {
					throw new ParseException("Kan inte konvertera kolumn " + columnName + " till den typ som är definerad i sql-tabellen. Omvandlingsfunktion saknas eller är inte implementerad. Kontrollera i tabellen vilken datatyp det är och gör ev. ändring av typ till någon vanlig typ.", 0);
				}

			}
		}
		}  catch (IllegalAccessException e)  { e.printStackTrace();
		}
		return null;

	}

	//Kolla om angivet column-name är giltigt i tabelle,. Används när client sänder data om vilken kolumn han vill använda och skyddar mot sql-injection
	public static boolean isColumnNameValid(String columnName, IsSQLTable table) {
		Field[] fields = table.getClass().getFields();
		for (Field field : fields) {
			if (field.getName().equals(columnName)) return true;
		}
		return false;	//Vi hittade ingen giltig column
	}

	//Returnerar lista på alla kolumner som är av text. Används t.ex. i supersök
	public static List<String> getStringColumnNames(IsSQLTable table) {
		List<String> list = new ArrayList<String>();
		Field[] fields = table.getClass().getFields();
		for (Field field : fields) {
			try {
				if (field.getType().isInstance(dummyString ) || field.get(table) instanceof String) list.add(field.getName());
			} catch (IllegalAccessException e) {}
		}
		return list;
	}

}