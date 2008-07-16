/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package se.saljex.sxserver.web;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import javax.sql.DataSource;
import se.saljex.sxserver.SXUtil;

/**
 *
 * @author ulf
 */
public class PageListFaktura1 extends PageList {
private String kundnr;
private Date tidat;

	public PageListFaktura1(DataSource ds, String kundnr) throws SQLException{
		super(ds);
		super.setPageSize(40);
		this.kundnr = kundnr;
		setTidat((Date)null);
	}
	
	public void setTidat(String tidatStr) {
		java.util.Date ti = null;
		try {
			ti = java.sql.Date.valueOf(tidatStr);
		} catch (Exception e1) {}
		setTidat(ti);
	}
	
	
	public void setTidat(Date ti) {
		this.tidat = ti;
	}
	public String getTidatStr() {
		return SXUtil.getFormatDate(tidat);
	}
	
	@Override 
	public void getPage(int page) {
		String whereStr;
		if (tidat == null) {
			whereStr = "f1.kundnr = ?";
		} else {
			whereStr = "f1.kundnr = ? and f1.datum <= '" + SXUtil.getFormatDate(tidat) + "'";
		}
		try {
			super.initSql("select f1.faktnr, f1.datum, f1.namn, f1.t_attbetala, u1.ordernr, u1.marke from faktura1 f1 left outer join utlev1 u1 on (u1.faktnr=f1.faktnr) where " + whereStr + " order by f1.faktnr desc");  
			super.query.setString(1, kundnr);
			super.getPage(page);
		} catch (SQLException sqe) { SXUtil.log("Exception i getPage" + sqe.toString()); }
	}	

	public Integer getFaktnr() {
		return (Integer)super.getColumn(1);
	}
	public Date getDatum() {
		return (java.util.Date)super.getColumn(2);
	}
	public String getNamn() {
		return (String)super.getColumn(3);
	}
	public Double getAttbetala() {
		return (Double)super.getColumn(4);
	}
	public Integer getOrdernr() {
		return (Integer)super.getColumn(5);
	}
	public String getMarke() {
		return (String)super.getColumn(6);
	}
	
}
