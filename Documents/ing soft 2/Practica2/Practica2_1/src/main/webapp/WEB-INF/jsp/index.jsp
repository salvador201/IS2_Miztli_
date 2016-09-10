<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IS2</title>
        <script src=" <c:url value="/js/jquery-1.12.3.min.js" /> "></script>
    </head>
    <body>
        <h1>Ejemplo Spring + JDBC + Hibernate</h1>
        <hr>
        <form method="POST" action="/Practica2_1/muestraAlumno">
            <h2>Ingresa id del Alumno para ver </h2>
            <input id="idalumno" name="idalumno" type="text" placeholder=" Id Alumno">
            <button>Aceptar</button>
        </form>
        <br><hr>
    
        
        <h2>Ingresa el nombre del Carrera para su id</h2>
        <form method="POST" action="/Practica2_1/preguntaA">    
            <input id="nombreCarrera" name="nombreCarrera" type="text" placeholder=" Nombre Carrera">
            <button>Muestra</button>
        </form>
        <br><hr>
         
      
         
         
        </body>
</html>
