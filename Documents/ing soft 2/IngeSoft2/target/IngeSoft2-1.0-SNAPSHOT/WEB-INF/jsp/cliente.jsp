<%-- 
    Document   : cliente
    Created on : 04-oct-2016, 19:06:51
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
        
        table {
    border-collapse: collapse;
    width: 90%;
}

th, td {
    text-align: left;
    padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
    background-color: #0040FF;
    color: white;
}
        
   .formlog2{
    border: 5px solid #A0B5EC;
    width: 80%;
    padding: 10px;
  

    
}

    .formlog{
    border: 5px solid #A0B5EC;
    width: 80%;
    padding: 10px;
}


input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
    border-radius: 15px;
}

button {
    background-color: #2E9AFE;
    color: white;
    padding: 7px 12px;
    margin: 2px 0;
    border: none;
    cursor: pointer;
    width: 10%;
    border-radius: 15px;
}

.cancelbtn {
    width: auto;
    padding: 10px 18px;
    background-color: #f44336;
}

.imgcontainer {
    text-align: center;
    margin: 24px 0 12px 0;
}

img.avatar {
    width: 40%;
    border-radius: 50%;
}

.container {
    padding: 16px;
}

div.doe{
  opacity: 0.1;
  position: absolute;
  left: 10%;  
  
}

span.psw {
    float: right;
    padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 50px) {
    span.psw {
       display: block;
       float: none;
    }
    .cancelbtn {
       width: 100%;
    }
}
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
        <form name="crear_cliente" method="POST" action="/IngeSoft2/administrador/modificarCliente">
            <h2>Información de la cuenta</h2>
            <p>Aqui podra actualizar la información del cliente</p>
            <input id="id" name="id_cliente" type="text" value="${cliente.id_cliente}" readonly>
             <input id="Nombre_Cliente" name="Nombre_Cliente" type="text" placeholder=" Nombre_Cliente" value="${cliente.nombre_cliente}">
             <input id="apellidop" name="apellidop" type="text" placeholder=" Apellido Paterno" value="${cliente.apellido_paterno_cliente}">
            <input id="apellidom" name="apellidom" type="text" placeholder=" Apellido Materno" value="${cliente.apellido_materno_cliente}">    
            <input id="correo" name="correo" type="text" placeholder=" correo" value="${cliente.correo}">
            <input id="telefono_local" name="Telefono_Local" type="text" placeholder=" Telefono Local" value="${cliente.telefono_local}">
            <input id="telefono_Movil" name="Telefono_Movil" type="text" placeholder=" Nombre Usuario" value="${cliente.nombre_usuario}">
            <input id="nombre_usuario" name="Nombre_Usuario" type="text" placeholder=" Telefono móvil" value="${cliente.telefono_movil}">
            <input id="area" name="Area" type="text" placeholder=" Área" value="${cliente.area}">
            <input id="Puesto" name="Puesto" type="text" placeholder=" Puesto" value="${cliente.puesto}">
            <input id="Nombre_Empresa" name="Nombre_Empresa" type="text" placeholder=" Nombre de Empresa" value="${cliente.nombre_empresa}">
            <input type="checkbox" name="habilitado" value="1" ${checado}> Habilitado
            <button type="submit">Actualizar</button>
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
