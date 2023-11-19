<%-- 
    Document   : form
    Created on : 17 nov 2023, 20:59:32
    Author     : Juanjo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SportThingsManagement</title>
    </head>
    <body>
        <h1>SportThingsManagement</h1>

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
    </body>
</html>
