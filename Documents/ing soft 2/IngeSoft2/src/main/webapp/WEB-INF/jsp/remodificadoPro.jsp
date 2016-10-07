<%-- 
    Document   : remodificadoPro
    Created on : 02-oct-2016, 18:46:12
    Author     : Salvador
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="POST" action="/IngeSoft2/modificaProyecto">
           
            <h2>Elige modifica el valor del Proyecto: ${proyecto.nombre_proyecto}   </h2>
            
            <input id="id_proyecto" value="${proyecto.id_proyecto}" name="id_proyecto" type="text" placeholder=" id_pro">
            <input id="cli_id" value="${proyecto.cliente_id}" name="cli_id" type="text" placeholder=" cli_id">
            <input id="prueba_id" value="${proyecto.id_proyecto}" name="prueba_id" type="text" placeholder=" prueba_id">
            <input id="descripcion" value="${proyecto.descripcion}" name="descripcion" type="text" placeholder=" descripcion">
            <input id="nom_pro" value="${proyecto.nombre_proyecto}" name="nom_pro" type="text" placeholder=" nom_pro">
           <input id="fecha_inicio" value="${proyecto.fecha_inicio}" name="fecha_inicio" type="text" placeholder="inicio DD/MM/YYYY">
            <input id="fecha_fin" value="${proyecto.fecha_fin}" name="fecha_fin" type="text" placeholder="fin DD/MM/YYYY"> 
            <input id="habilitado"value="${proyecto.habilitado}" name="habilitado" type="text" placeholder=" habilitado">
            
             <button type="submit">Aceptar</button>
             </form>
            
             <form method="POST" action="/IngeSoft2/borraProyecto">
            <h2>Elige Aceptar para eliminar el Proyecto</h2>
            <input id="nom_Pro" name="nom_Pro" type="text" placeholder=" nom_Pro" readonly="readonly" value="${proyecto.nombre_proyecto}">
            <button>Aceptar</button>
        </form>
    </body>
</html>
