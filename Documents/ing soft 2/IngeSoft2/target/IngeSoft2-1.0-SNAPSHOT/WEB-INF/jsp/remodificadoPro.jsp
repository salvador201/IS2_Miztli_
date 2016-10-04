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
        <h1>el nombre del  : ${nom_pro}</h1>
              <h2>${id_pro}</h2>
            <h2>${cli_id}</h2>
            <h2>${prueba_id}</h2>
            <h2>${nom_pro}</h2>
            <h2>${descripcion}</h2>
            <h2>${fecha_inicio}</h2>
            <h2>${fecha_fin}</h2>
            <h2>habilitado :${habilitado}</h2>
          
           
            <input id="id_pro" value="${id_pro}" name="cli_id" type="text" placeholder=" id_pro">
            <input id="cli_id" value="${cli_id}" name="cli_id" type="text" placeholder=" cli_id">
            <input id="prueba_id" value="${prueba_id}" name="prueba_id" type="text" placeholder=" prueba_id">
            <input id="descripcion" value="${descripcion}" name="descripcion" type="text" placeholder=" descripcion">
            <input id="nom_pro"value="${nom_pro}" name="nom_pro" type="text" placeholder=" nom_pro">
           <input id="fecha_inicio" value="${fecha_inicio}" name="fecha_inicio" type="text" placeholder="inicio DD/MM/YYYY">
            <input id="fecha_fin" value="${fecha_fin}" name="fecha_fin" type="text" placeholder="fin DD/MM/YYYY"> 
            <input id="habilitado"value="${habilitado}" name="habilitado" type="text" placeholder=" habilitado">
            
             <button type="submit">Aceptar</button>
             </form>
    </body>
</html>
