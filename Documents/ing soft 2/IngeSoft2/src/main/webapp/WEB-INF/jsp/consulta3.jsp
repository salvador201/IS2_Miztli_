<%-- 
    Document   : consulta3
    Created on : 19-sep-2016, 23:13:28
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
        <h1>Consulta 3!</h1>
        <p>grupos que pidio:</p>
        
        <c:forEach var="grupo" items="${lista}">
            <h2>${grupo.nombregrupo}</h2>
        </c:forEach>
    </body>
</html>
