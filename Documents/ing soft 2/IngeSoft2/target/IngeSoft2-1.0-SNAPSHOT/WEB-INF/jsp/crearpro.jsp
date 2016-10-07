<%-- 
    Document   : menu_pro
    Created on : 30-sep-2016, 16:14:29
    Author     : Salvador
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
        <form name="crear_proyecto" method="POST" action="/IngeSoft2/crearProyecto">
            <h2>Ingresa los datos del proyecto</h2>
            
            <input id="cli_id" name="cli_id" type="text" placeholder=" cli_id">
            <input id="prueba_id" name="prueba_id" type="text" placeholder=" prueba_id">
            <input id="descripcion" name="descripcion" type="text" placeholder=" descripcion">
            <input id="nom_pro" name="nom_pro" type="text" placeholder=" nom_pro">
            <input id="fecha_inicio" name="fecha_inicio" type="text" placeholder="inicio DD/MM/YYYY">
            <input id="fecha_fin" name="fecha_fin" type="text" placeholder="fin DD/MM/YYYY">
            
            
             <button type="submit">Aceptar</button>
        </form>
        
        
        
       
    </body>
</html>
