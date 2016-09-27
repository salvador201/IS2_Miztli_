<%-- 
    Document   : crear
    Created on : 26-sep-2016, 21:01:49
    Author     : Marco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="<c:url value="/js/jquery-1.12.4.min.js" />" ></script>
        <script src="<c:url value="/js/jquery.validate.js" />" ></script>
        <script src="<c:url value="/js/form-validation.js" />" ></script>
    </head>
    <body>
        <form name="crear_cliente" method="POST" action="/IngeSoft2/crearCliente">
            <h2>Completa el formulario para crear cliente</h2>
            
            <input id="correo" name="correo" type="text" placeholder=" correo">
            <input id="password" name="password" type="text" placeholder=" password">
            <input id="Nombre_Cliente" name="Nombre_Cliente" type="text" placeholder=" Nombre_Cliente">
            <input id="Telefono_Local" name="Telefono_Local" type="text" placeholder=" Telefono_Local">
            <input id="Telefono_Movil" name="Telefono_Movil" type="text" placeholder=" Nombre_Usuario">
            <input id="Nombre_Usuario" name="Nombre_Usuario" type="text" placeholder=" Telefono_Movil">
            <input id="Area" name="Area" type="text" placeholder=" Area">
            <input id="Puesto" name="Puesto" type="text" placeholder=" Puesto">
            <input id="Nombre_Empresa" name="Nombre_Empresa" type="text" placeholder=" Nombre_Empresa">
            <button type="submit">Aceptar</button>
        </form>
    </body>
</html>
