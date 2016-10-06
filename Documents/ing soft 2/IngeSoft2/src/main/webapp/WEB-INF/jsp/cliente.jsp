<%-- 
    Document   : cliente
    Created on : 04-oct-2016, 19:06:51
    Author     : Marco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="crear_cliente" method="POST" action="/IngeSoft2/modificarCliente">
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
    </body>
</html>
