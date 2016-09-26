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
        <h1>Ejemplo </h1>
         <form method="POST" action="/HQR/verCliente">
            <h2>Ingresa id del Cliente para ver sus datos</h2>
            <input id="id_cliente" name="id_cliente" type="text" placeholder=" Id Cliente">
            <button>Aceptar</button>
        </form>
        <br><hr>
         <form method="POST" action="/HQR/borraCliente">
            <h2>Ingresa id del Cliente para borrar datos</h2>
            <input id="id_cliente" name="id_cliente" type="text" placeholder=" Id Cliente">
            <button>Aceptar</button>
        </form>
        <br><hr>
        
        <br><hr>
         <form method="POST" action="/HQR/crearCliente">
            <h2>Ingresa id del Cliente para borrar datos</h2>
            <input id="id_cliente" name="id_cliente" type="text" placeholder=" Id Cliente">
            <input id="correo" name="correo" type="text" placeholder=" correo">
            <input id="password" name="password" type="text" placeholder=" password">
            <input id="Nombre_Cliente" name="Nombre_Cliente" type="text" placeholder=" Nombre_Cliente">
            <input id="Telefono_Local" name="Telefono_Local" type="text" placeholder=" Telefono_Local">
            <input id="Telefono_Movil" name="Telefono_Movil" type="text" placeholder=" Nombre_Usuario">
            <input id="Nombre_Usuario" name="Nombre_Usuario" type="text" placeholder=" Telefono_Movil">
            <input id="Area" name="Area" type="text" placeholder=" Area">
            <input id="Puesto" name="Puesto" type="text" placeholder=" Puesto">
            <input id="Nombre_Empresa" name="Nombre_Empresa" type="text" placeholder=" Nombre_Empresa">
            <button>Aceptar</button>
        </form>
        <br><hr>
        </body>
</html>
