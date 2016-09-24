<%-- 
    Document   : consulta4
    Created on : 19-sep-2016, 23:38:00
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
        <h1>Consulta 4</h1>
        <c:forEach var="grupo" items="${lista}">
            <h2>${grupo.nombresalon}</h2>
        </c:forEach>
    </body>
    
</html>
