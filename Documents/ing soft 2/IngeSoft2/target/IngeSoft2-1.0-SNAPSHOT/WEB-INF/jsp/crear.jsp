<%-- 
    Document   : crear
    Created on : 26-sep-2016, 21:01:49
    Author     : Marco
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
                <li><a href="/IngeSoft2/salir">Salir</a></li>
                
            </ul>
        </div>
    </nav>
    </head>
    <body>
    <center>
        <div class="formlog">
        <form name="crear_cliente" method="POST" action="/IngeSoft2/administrador/crearCliente">
            <h2>Completa el formulario para crear una cuenta grupal</h2>
            <input id="Nombre_Empresa" name="Nombre_Empresa" type="text" placeholder=" Nombre de la Empresa">
            <input id="Nombre_Cliente" name="Nombre_Cliente" type="text" placeholder=" Nombre titular empresa">
            <input id="apellidop" name="apellidop" type="text" placeholder=" Apellido Paterno" >
            <input id="apellidom" name="apellidom" type="text" placeholder=" Apellido Materno" >    
            <input id="Nombre_Usuario" name="Nombre_Usuario" type="text" placeholder=" Nombre de Usuario">
            <input id="Puesto" name="Puesto" type="text" placeholder=" Puesto"> 
            <input id="correo" name="correo" type="text" placeholder=" Correo">
            <input id="password" name="password" type="text" placeholder=" Contraseña">
            <input id="Telefono_Local" name="Telefono_Local" type="text" placeholder=" Telefono Local">
            <input id="Telefono_Movil" name="Telefono_Movil" type="text" placeholder=" Celular">
            <input id="Area" name="Area" type="text" placeholder=" Area">
            
            <button type="submit">Crear</button>
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
