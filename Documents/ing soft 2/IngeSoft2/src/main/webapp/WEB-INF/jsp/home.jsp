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
    width: 30%;
    padding: 10px;
   position: relative;
    left: 30px;

    
}

    .formlog{
    border: 5px solid #A0B5EC;
    width: 30%;
    position: absolute;
    right: 30px;
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
          <a href="<c:url value="/crear"/> "><button>Agregar Cuenta</button></a>
          <br> 
          <br> 
          <a href="<c:url value="/verificaEmpleado"/> "><button>Agregar Empleado</button></a>
          <br> 
          
  <center><h2>Cuentas de empresas:</h2>
      <br>
      <table>
          <tr>
              <th><h3>Empresa</h3></th>
              <th><h3>Titular de Empresa</h3></th>
              <th><h3>Correo</h3></th>
              <th><h3>Puesto</h3></th>
              <th><h3>Área</h3></th>
          </tr>
  <c:forEach var="cliente" items="${clientes}">
      <tr <c:if test="${cliente.habilitado == 0}"> bgcolor="#FD6C84" </c:if>>
          
          <td><a href="<c:url value="/administrador/show?id=${cliente.id_cliente}" />">${cliente.nombre_empresa}</a></td>
          <td>${cliente.nombre_cliente}</td> 
          <td>${cliente.correo}</td>
          <td>${cliente.area}</td>
          <td>${cliente.puesto}</td>
          
      </tr>
        </c:forEach>
      </table>
  </center>
  
  <br>
  <br>
  <br>
 
     <a href="<c:url value="/exportarExcelCliente"/> "><button>Exportar Excel</button></a>
    
 

  
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
 