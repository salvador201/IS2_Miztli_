<%-- 
    Document   : remodificadoPro
    Created on : 02-oct-2016, 18:46:12
    Author     : Salvador
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="<c:url value="/js/jquery-1.12.4.min.js" />" ></script>
        <script src="<c:url value="/js/jquery.validate.js" />" ></script>
        <script src="<c:url value="/js/form-validation.js" />" ></script>
        
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
                <li><a href="<c:url value="/home"/> ">Cuentas</a></li>
                <li><a href="<c:url value="/administrador/prueba"/>">Pruebas</a></li>
                <li><a href="<c:url value="/administrador/proyectos"/>">Proyectos</a></li>
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
    <center>
        <div class="formlog">
        <form method="POST" action="/IngeSoft2/modificaProyecto">
           
            <h2>Elige modifica el valor del Proyecto: ${proyecto.nombre_proyecto}   </h2>
            <h2>Identificadores:</h2>
            <input id="id_proyecto" value="${proyecto.id_proyecto}" name="id_proyecto" type="text" placeholder=" id_pro" readonly>
            
            <input id="cli_id" value="${proyecto.cliente_id}" name="cli_id" type="text" placeholder=" cli_id" readonly>
            <h2>Cuenta asociada a este proyecto:</h2>
            <input id="cli_id" value="${cliente.nombre_cliente} ${cliente.apellido_paterno_cliente} - Empresa:  ${cliente.nombre_empresa}" type="text" placeholder=" cli_id" readonly>
            
            <h2>Pruebas asignadas:</h2>
            <c:forEach var="prueba" items="${pruebas}">
                <input value="${prueba.nombre_prueba}" >     
            </c:forEach>
                
               
            <input id="descripcion" value="${proyecto.descripcion}" name="descripcion" type="text" placeholder=" descripcion">
            <input id="nom_pro" value="${proyecto.nombre_proyecto}" name="nom_pro" type="text" placeholder=" nom_pro">
           <input id="fecha_inicio" value="${proyecto.fecha_inicio}" name="fecha_inicio" type="text" placeholder="inicio DD/MM/YYYY">
            <input id="fecha_fin" value="${proyecto.fecha_fin}" name="fecha_fin" type="text" placeholder="fin DD/MM/YYYY">  
            <input type="checkbox" name="habilitado" value="1" ${checado}> Habilitado
             <button type="submit">Aceptar</button>
             </form>
         
    </div>
    </center>
    </body>
    <hr>
      <footer class="text-muted">
      <div class="col-sm-6">
          <center><p>&copy; <img src="<c:url value="/imagenes/miztli.png" /> " width="70" ></p></center>
        </div>      
    </footer>
</html>
