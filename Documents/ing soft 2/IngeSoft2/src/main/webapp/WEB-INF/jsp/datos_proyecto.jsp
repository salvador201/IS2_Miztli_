<%-- 
    Document   : verpro
    Created on : 30-sep-2016, 17:33:22
    Author     : Salvador
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <a href="<c:url value="/verifica"/> "><button>Agregar Proyecto</button></a>
    <body>
        
        <center><h2>Proyectos:</h2>
      <table>
          <tr>
              <th>Nombre</th>
              <th>Descripcion</th>
              <th>Fecha Inicio</th>
              <th>Fecha Final</th>
              
          </tr>
  <c:forEach var="proyecto" items="${proyectos}">
      <tr>
  
          <td><a href="/IngeSoft2/show_P?id=${proyecto.id_proyecto}">${proyecto.nombre_proyecto}</a></td>
          <td>${proyecto.descripcion}</td>
          <td>${proyecto.fecha_inicio}</td>
          <td>${proyecto.fecha_fin}</td>
         
      </tr>
        </c:forEach>
      </table>
  </center>
        
       
    </body>
</html>
