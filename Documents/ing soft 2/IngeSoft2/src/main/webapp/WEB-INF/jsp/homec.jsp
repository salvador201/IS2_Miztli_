<%-- 
    Document   : consulta2
    Created on : 13-sep-2016, 20:10:47
    Author     : Marco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es-MX">
   <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="<c:url value="/imagenes/LogoHQRmediana.png" /> "/>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
    <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">

    <style>
</style>
    <title>HQR</title>
  	<nav class="navbar navbar-default w3-cyan" role="navigation">
        <!-- El logotipo y el icono que despliega el menú se agrupan
             para mostrarlos mejor en los dispositivos móviles -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target=".navbar-ex1-collapse">
                <span class="sr-only">Desplegar navegación</span>
                <span class="icon-bar">f</span>
                <span class="icon-bar">g</span>
                <span class="icon-bar">h</span>
            </button>
        </div>

        <!-- Agrupar los enlaces de navegación, los formularios y cualquier
             otro elemento que se pueda ocultar al minimizar la barra -->
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <ul class="nav navbar-nav">
               <li><a href="<c:url value="/homec"/> ">Proyectos</a></li>
                <li><a href="<c:url value="/cliente/show?correo=${username}"/>">Perfil</a></li>
                <li><a href="#">Reportes</a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">Usuario: ${username}</a></li>
                <li><a href="/IngeSoft2/logout">Salir</a></li>
                
            </ul>
        </div>
    </nav>
  </head>
  <body>
    <div id="first" class="first">  
   <center><img src="<c:url value="/imagenes/LogoHQRmediana.png" /> " height="250" width="180"></center>
    </div>
    
      <hr/>

      <div class="container doe">
      <img src="<c:url value="/imagenes/mexico.png" /> " style="width:100%; height:100%;">
      </div>
        <div class="col-xs-12">
          <center><h3>Eslogan de la empresa.</h3>

          </center>
          </div>
          <br>
          <br>
          <br>
         
          <br> 
          
          
          
  <center><h2>Mis proyectos:</h2>
      <br>
      <table>
          <tr>
              <th><h3>Nombre Proyecto</h3></th>
              <th><h3>Descripción</h3></th>
              <th><h3>Fecha inicio</h3></th>
              <th><h3>Fecha final</h3></th>
             
          </tr>
  <c:forEach var="proyecto" items="${proyectos}">
      <tr <c:if test="${proyecto.habilitado!=1}">bgcolor="#FD6C84"</c:if>>
          
          <td><a href="<c:url value="#" />">${proyecto.nombre_proyecto}</a></td>
          <td>${proyecto.descripcion}</td> 
          <td>${proyecto.fecha_inicio}</td>
          <td>${proyecto.fecha_fin}</td>
          
          
      </tr>
        </c:forEach>
      </table>
  </center>
      
<hr>
      <footer class="text-muted">
      <div class="col-sm-6">
          <center><p>&copy; <img src="<c:url value="/imagenes/miztli.png" /> " width="70" ></p></center>
        </div>      
    </footer>
        
        

    
  </body>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"/>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"/>
</html>
 