<%-- 
    Document   : consulta5
    Created on : 20-sep-2016, 0:26:29
    Author     : Marco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Consulta 5!</h1>
        <c:forEach var="grupo" items="${lista}">
            <h2>${grupo.nombrealumno}</h2>
        </c:forEach>
    </body>
</html>
