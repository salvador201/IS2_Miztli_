<%-- 
    Document   : ogdi
    Created on : Aug 16, 2016, 3:17:13 PM
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
        <h1>Formulario 1</h1>
        <form action="/IngeSoft2/alumno" method="POST" >
        <input name="alumno" type="text" placeholder="alumno">
        <br>
        <input name="carrera" type="text" placeholder="carrera">
        <br>
        <input name="semestre" type="text" placeholder="semestre">
        <br>
        <input type="submit" value="Enviar">
        </form>
        <br>
        <br>
        <h1>Formulario 2</h1>
        <form action="/IngeSoft2/profesor" method="GET">
        <input name="profesor" type="text" placeholder="profesor">
        <br>
        <input name="carrera" type="text" placeholder="carrera">
        <br>
        <input name="materia" type="text" placeholder="materia">
        <br>
        <input type="submit" value="Enviar">
        </form>
        <h1>Consulta1</h1>
        <form action="/IngeSoft2/consulta1" method="POST">
            <input name ="carrera" type="text" placeholder="carrera">
            <br>
            <input type="submit" value="consultar">
        </form>
        
        <h1>Consulta2</h1>
        <form action="/IngeSoft2/consulta2" method="POST">
            <input name ="salon" type="text" placeholder="id grupo">
            <br>
            <input type="submit" value="consultar">
        </form>
        <h1>Consulta3</h1>
        <form action="/IngeSoft2/consulta3" method="POST">
            <input name ="nombre_alumno" type="text" placeholder="nombre del alumno">
            <br>
            <input type="submit" value="consultar">
        </form>
        <h1>Consulta4</h1>
        <form action="/IngeSoft2/consulta4" method="POST">
            <input name ="id" type="text" placeholder="id del alumno">
            <br>
            <input type="submit" value="consultar">
        </form>
        
        <h1>Consulta5</h1>
        <form action="/IngeSoft2/consulta5" method="POST">
            <input name ="id" type="text" placeholder="id del profesor">
            <br>
            <input type="submit" value="consultar">
        </form>
        <c:forEach var="alumno" items="${alumnos}">
            <h2>${alumno.nombrealumno}</h2>
        </c:forEach>
    </body>
</html>
