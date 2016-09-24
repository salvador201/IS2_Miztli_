<%-- 
    Document   : consulta1
    Created on : 08-sep-2016, 0:03:27
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
        <h1>Consulta1</h1>
         <c:forEach var="grupo" items="${lista}">
            <h2>${grupo.nombre_grupo}</h2>
        </c:forEach>
    </body>
</html>
