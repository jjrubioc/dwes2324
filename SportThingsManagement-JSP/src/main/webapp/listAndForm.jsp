<%-- 
    Document   : form
    Created on : 17 nov 2023, 20:59:32
    Author     : Juanjo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.mycompany.sportthingsmanagement.Deporte" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SportThingsManagement</title>
    </head>

    <h1>SportThingsManagement</h1>
    <% 
        ArrayList<Deporte> l=(ArrayList<Deporte>) session.getAttribute("listSports");
        if(l!=null){
            out.println("<table>");
            for (Object sp : l) {
            out.println("<tr>");
            Deporte s = (Deporte) sp;
            out.println("<td>Sport:</td><td> " + s.getName() + "</td>");
            out.println("</tr>");
            }
            out.println("</table>");
        } else {
    %>
    <h2>No data</h2>
    <%
        }
    %>
    <form action="helloworld">
        Deporte:<input type="text" name="deporte">
        <input type="hidden" name="task" value="insert" >
        <input type="submit" label="Insert">
    </form>
    <form action="helloworld">
        Deporte:<input type="text" name="deporte\">
                       <input type="hidden" name="task" value="delete" >
        <input type="submit" label="Delete">
    </form>
    <form action="helloworld">
        <input type="hidden" name="task" value="list" ">
        <input type="submit" value="List sports">
    </form>
</html>
