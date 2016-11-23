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
   <link href="<c:url value="/css/bootstrap.min.css" /> " rel="stylesheet"/>
    <link href="<c:url value="/css/datepicker3.css" /> " rel="stylesheet"/>
    <link href="<c:url value="/css/styles.css" /> " rel="stylesheet"/>
    <link href="<c:url value="/css/bootstrap-table.css" /> " rel="stylesheet"/>
    
    <script src="<c:url value="/js/lumino.glyphs.js" /> "></script>
    
    
   
    <title>HQR</title>

    </head>
    
    <body>
      </div><!--/.col-->
                        <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">	
                        <div class="col-md-6">
				<div class="panel panel-default">
					<div class="panel-heading">Asignar Pruebas a Proyectos</div>
					<div class="panel-body">
                                            <form class="form-horizontal" method="POST" action="/IngeSoft2/asignarPruebaProyecto">
						<table data-toggle="table" data-url="tables/data2.json" >
						     <div class="form-group">
									<label class="col-md-3 control-label" >Selecionar Prueba</label>
									<div class="col-md-9">
                                                                            <select class="form-control">
                                                                            <c:forEach var="prueba" items="${pruebas}">
                                                                                <option value="${prueba.id_prueba}" name="proyecto_id" type="text">${prueba.nombre_prueba}</option>
                                                                             </c:forEach>
                                                                            </select>
									</div>
                                                                        
                                                                        <label class="col-md-3 control-label"  >Selecionar Proyectos</label>
									<div class="col-md-9">
                                                                            <select class="form-control">
                                                                            <c:forEach var="proyecto" items="${proyectos}">
                                                                                <option >${proyecto.nombre_proyecto}</option>
                                                                             </c:forEach>
                                                                            </select>
									</div>
								</div>
                                                    <button type="submit" class="btn btn-primary btn-md pull-right">Asignar</button>
						</table>
                                                </form>
					</div>
				</div>
			</div>
                        </div>
      
      <div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">Mis proyectos asignados</div>
					<div class="panel-body">
						<table data-toggle="table" data-url="tables/data1.json"  data-show-refresh="true" data-show-toggle="true" data-show-columns="true" data-search="true" data-select-item-name="toolbar1" data-pagination="true" data-sort-name="name" data-sort-order="desc">
						    <thead>
						    <tr>
						        <th data-field="nombre_proyecto" data-sortable="true">nombre_proyecto</th>
						        <th data-field="descripcion" data-sortable="true">descripcion</th>
						        <th data-field="fecha_inicio" data-sortable="true">fecha_inicio</th>
						        <th data-field="fecha_fin" data-sortable="true">fecha_fin</th>
						        
						       
                                                        
						    </tr>
						    </thead>
            <c:forEach var="proyecto" items="${proyectos}">
      <tr >
          
          <td><a href="<c:url value="/cliente/show_cp?id=${proyecto.id_proyecto}" />">${proyecto.nombre_proyecto}</a></td>
          <td>${proyecto.descripcion}</td>
          <td>${proyecto.fecha_inicio}</td>
          <td>${proyecto.fecha_fin}</td>
          
          
           
          
      </tr>
        </c:forEach>
						</table>
					</div>
				</div>
			</div>
		</div><!--/.row-->
      <div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">Pruebas Proyectos </div>
					<div class="panel-body">
						<table data-toggle="table" data-url="tables/data1.json"  data-show-refresh="true" data-show-toggle="true" data-show-columns="true" data-search="true" data-select-item-name="toolbar1" data-pagination="true" data-sort-name="name" data-sort-order="desc">
						    <thead>
						    <tr>
						        <th data-field="id_prueba_proyecto" data-sortable="true">id_prueba_proyecto</th>
						        <th data-field="prueba_id" data-sortable="true">prueba_id</th>
						        <th data-field="proyecto_id" data-sortable="true">proyecto_id</th>
						        <th data-field="puntaje_prueba" data-sortable="true">puntaje_prueba</th>
						        <th data-field="puntaje_prueba" data-sortable="true">fecha_creacion</th>
						        
						        
						       
                                                        
						    </tr>
						    </thead>
            <c:forEach var="pp" items="${pp}">
      <tr >
          
          <td>${ppp.id_prueba_proyecto}</a></td>
          <td>${ppp.prueba_id}</a></td>
          <td>${ppp.proyecto_id}</a></td>
          <td>${ppp.puntaje_prueba}</a></td>
          <td>${ppp.fecha_creacion}</a></td>
          
          
           
          
      </tr>
        </c:forEach>
						</table>
					</div>
				</div>
			</div>
		</div><!--/.row-->
      
      
      
    </body>
</html>
