/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package se.saljex.SxShop.client.rpcobject;

import com.google.gwt.user.client.rpc.IsSerializable;
import java.util.ArrayList;

/**
 *
 * @author ulf
 */
public class UtlevList implements IsSerializable{
	public UtlevList() {}
	public ArrayList<UtlevRow> rader = new ArrayList();
	public int nextRow;
	public int pageSize;
	public boolean hasMoreRows;
	public String frdat;
	public String tidat;
	public String sokstr;

}
