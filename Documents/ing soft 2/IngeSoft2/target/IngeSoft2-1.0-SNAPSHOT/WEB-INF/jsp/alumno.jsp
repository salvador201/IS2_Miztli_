<%-- 
    Document   : alumno
    Created on : 23-ago-2016, 13:12:01
    Author     : Marco
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css" /> ">
         
    </head>
    <body>
        <div class="nombre">
        <h1>${alumno}</h1>
        </div>
        
        de la carrera 
        <div class="carrera"><h2>${carrera}</h2></div> 
        y el semestre 
        <div class="semestre"><h3>${semestre}</h3></div> 
    </body>
</html>
