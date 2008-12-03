/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package se.saljex.sxserver;

import com.lowagie.text.DocumentException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ulf
 */
@Local
public interface LocalWebSupportLocal {

	  TableKund getTableKund(String kundnr);

	  TableFaktura1 getTableFaktura1(int faktnr);

	  List<TableFaktura2> getListTableFaktura2(int faktnr);

	  List<TableOrder2> getListTableOrder2(int ordernr);

	  List<TableOrder1> getListTableOrder1(String kundnr);

	  List<TableKundres> getListTableKundres(String kundnr);

	  TableOrder1 getTableOrder1(int ordernr);

	  List<TableRorder> getListTableRorder(String kundnr);

	  ByteArrayOutputStream getPdfFaktura(Integer nr) throws com.lowagie.text.DocumentException, java.io.IOException;
	  ByteArrayOutputStream getPdfBest(Integer nr) throws com.lowagie.text.DocumentException, java.io.IOException;

	  ByteArrayOutputStream getPdfFaktura(Integer nr, String kundnr) throws DocumentException, IOException;

	TableKundkontakt getTableKundkontakt(Integer kontaktid);

	TableKundlogin getTableKundlogin(String loginnamn);

}
