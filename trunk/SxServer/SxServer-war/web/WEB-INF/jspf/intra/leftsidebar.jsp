<%-- 
    Document   : leftsidebar
    Created on : 2008-jun-16, 20:43:50
    Author     : ulf
--%>
<%@ page import="se.saljex.sxserver.SXUtil" %>
<%@ page import="se.saljex.sxserver.web.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<a href="?id=welcome">Startsida</a><br/>

<%
Connection con = (Connection)request.getAttribute("con");

ResultSet rs = con.createStatement().executeQuery("select lagernr, bnamn  from lagerid order by bnamn");
while (rs.next()) {
	out.print("<a href=\"?id=viewlager&lagernr="+ rs.getInt(1) + "\">" + rs.getString(2) + "</a><br/>");
}
rs.close();
%>
<%
// Submeby f�r filial
if ("viewlager".equals(request.getParameter("id"))) {
	String lagernr = request.getParameter("lagernr");
	if (lagernr != null) {
		%>
		<p/>
		<a href="?id=rapp-lafervarde&lagernr=<%= lagernr %>">Lagerv�rde</a><br/>
		<a href="?id=rapp-filialforsaljning&lagernr=<%= lagernr %>">F�rs�ljnning</a><br/>
		<%
	}
}

%>

