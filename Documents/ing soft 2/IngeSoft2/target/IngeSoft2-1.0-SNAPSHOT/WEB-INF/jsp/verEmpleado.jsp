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
   <link href="<c:url value="/css/bootstrap.min.css" /> " rel="stylesheet"/>
    <link href="<c:url value="/css/datepicker3.css" /> " rel="stylesheet"/>
    <link href="<c:url value="/css/styles.css" /> " rel="stylesheet"/>
    <script src="<c:url value="/js/lumino.glyphs.js" /> "></script>

   
    <title>HQR</title>
  	
    </head>
    
    
    
    
    <body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"><span>HQR</span></a>
				<ul class="user-menu">
					<li class="dropdown pull-right">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown"><svg class="glyph stroked male-user"><use xlink:href="#stroked-male-user"></use></svg> Admin <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#"><svg class="glyph stroked male-user"><use xlink:href="#stroked-male-user"></use></svg> Profile</a></li>
							<li><a href="#"><svg class="glyph stroked gear"><use xlink:href="#stroked-gear"></use></svg> Settings</a></li>
							<li><a href="#"><svg class="glyph stroked cancel"><use xlink:href="#stroked-cancel"></use></svg> Logout</a></li>
						</ul>
					</li>
				</ul>
			</div>
							
		</div><!-- /.container-fluid -->
	</nav>
		
	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		<form role="search">
			<div class="form-group">
				<img src="<c:url value="/imagenes/LogoHQRmediana.png" /> " style="width:100%; height:100%;">
			</div>
		</form>
		<ul class="nav menu">
			<li class="active"><a href="<c:url value="/home" /> "><svg class="glyph stroked table"><use xlink:href="#stroked-table"></use></svg> Cuentas Empresas</a></li>
			<li><a href="<c:url value="/administrador/prueba" /> "><svg class="glyph stroked dashboard-dial"><use xlink:href="#stroked-dashboard-dial"></use></svg> Pruebas</a></li>
			<li><a href="<c:url value="/administrador/proyectos" /> "><svg class="glyph stroked calendar"><use xlink:href="#stroked-calendar"></use></svg> Proyectos</a></li>
			<li><a href="charts.html"><svg class="glyph stroked line-graph"><use xlink:href="#stroked-line-graph"></use></svg> Reportes</a></li>
			<li><a href="forms.html"><svg class="glyph stroked pencil"><use xlink:href="#stroked-pencil"></use></svg> Forms</a></li>
			<li><a href="panels.html"><svg class="glyph stroked app-window"><use xlink:href="#stroked-app-window"></use></svg> Alerts &amp; Panels</a></li>
			<li><a href="icons.html"><svg class="glyph stroked star"><use xlink:href="#stroked-star"></use></svg> Icons</a></li>
			<li class="parent ">
				<a href="#">
					<span data-toggle="collapse" href="#sub-item-1"><svg class="glyph stroked chevron-down"><use xlink:href="#stroked-chevron-down"></use></svg></span> Dropdown 
				</a>
				<ul class="children collapse" id="sub-item-1">
					<li>
						<a class="" href="#">
							<svg class="glyph stroked chevron-right"><use xlink:href="#stroked-chevron-right"></use></svg> Sub Item 1
						</a>
					</li>
					<li>
						<a class="" href="#">
							<svg class="glyph stroked chevron-right"><use xlink:href="#stroked-chevron-right"></use></svg> Sub Item 2
						</a>
					</li>
					<li>
						<a class="" href="#">
							<svg class="glyph stroked chevron-right"><use xlink:href="#stroked-chevron-right"></use></svg> Sub Item 3
						</a>
					</li>
				</ul>
			</li>
			<li role="presentation" class="divider"></li>
			<li><a href="login.html"><svg class="glyph stroked male-user"><use xlink:href="#stroked-male-user"></use></svg> Login Page</a></li>
		</ul>
		
	</div><!--/.sidebar-->
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">		
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><svg class="glyph stroked home"><use xlink:href="#stroked-home"></use></svg></a></li>
				<li class="active">Icons</li>
			</ol>
		</div><!--/.row-->
		
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Datos del Empleado</h1>
			</div>
		</div><!--/.row-->
                
                
                
                
		<div class="row">
			<div class="col-md-8">
				<div class="panel panel-default">
					<div class="panel-heading"><svg class="glyph stroked male user "><use xlink:href="#stroked-male-user"/></svg> Información</div>
					<div class="panel-body">
						<form class="form-horizontal" name="crear_cliente" method="POST" action="/IngeSoft2/mEmpleado">
							<fieldset>
								<!-- Name input-->
                                                                <p>Aqui podra actualizar la información del Empleado</p>
                                                                
                                                                <div class="form-group">
									<label class="col-md-3 control-label" for="id">Id</label>
									<div class="col-md-9">
									<input id="id" name="id" type="text" placeholder="id name" class="form-control" value="${cliente.id_cliente}" readonly>
									</div>
								</div>
                                                                
                                                                
                                                                        
                                                                         
                                                                <div class="form-group">
									<label class="col-md-3 control-label" for="Nombre_Usuario">Nombre Usuario</label>
									<div class="col-md-9">
									<input id="Nombre_Usuario" name="Nombre_Usuario" placeholder=" Nombre_Cliente" type="text" class="form-control" value="${cliente.usuario_id.login_usuario}">
									</div>
								</div>        
                                                                
                                                                
                                                                
                                                                <div class="form-group">
									<label class="col-md-3 control-label" for="Nombre_Cliente">Nombre</label>
									<div class="col-md-9">
									<input id="Nombre_Cliente" name="Nombre_Cliente" placeholder=" Nombre_Cliente" type="text" class="form-control" value="${cliente.nombre_cliente}">
									</div>
								</div>
                                                                
                                                                
                                                                <div class="form-group">
									<label class="col-md-3 control-label" for="apellidop">Apellido paterno</label>
									<div class="col-md-9">
                                                                            <input id="apellidop" name="apellidop" type="text" placeholder="Apellido paterno" class="form-control" value="${cliente.apellido_paterno_cliente}">
									</div>
								</div>
                                                                
                                                                
								<div class="form-group">
									<label class="col-md-3 control-label" for="apellidom">Apellido materno</label>
									<div class="col-md-9">
                                                                            <input id="apellidom" name="apellidom" type="text" placeholder="Apellido materno" class="form-control" value="${cliente.apellido_materno_cliente}">
									</div>
								</div>
							
								<!-- Email input-->
								<div class="form-group">
									<label class="col-md-3 control-label" for="correo">Correo electrónico</label>
									<div class="col-md-9">
										<input id="correo" name="correo" type="text" placeholder="ejemplo@.com" class="form-control" value="${cliente.correo}">
									</div>
								</div>
                                                                        
                                                                        <div class="form-group">
									<label class="col-md-3 control-label" for="telefono_local">Teléfono local</label>
									<div class="col-md-9">
                                                                            <input id="telefono_local" name="Telefono_Local" placeholder="tlefono" class="form-control" value="${cliente.telefono_local}">
									</div>
								</div>  
                                                                        
                                                                        <div class="form-group">
									<label class="col-md-3 control-label" for="telefono_Movil">Teléfono movil</label>
									<div class="col-md-9">
                                                                            <input id="telefono_Movil" name="Telefono_Movil" type="text" placeholder="Your name" class="form-control" value="${cliente.telefono_movil}">
									</div>
								</div>  
                                                                        
                                                                        
                                                                        <div class="form-group">
									<label class="col-md-3 control-label" for="area">Area</label>
									<div class="col-md-9">
                                                                            <input id="area" name="Area" type="text" placeholder="Area" class="form-control" value="${cliente.area}">
									</div>
								</div>  
                                                                        
                                                                         <div class="form-group">
									<label class="col-md-3 control-label" for="Puesto">Puesto</label>
									<div class="col-md-9">
                                                                            <input id="Puesto" name="Puesto" type="text" placeholder="Your name" class="form-control" value="${cliente.puesto}">
									</div>
								</div>  
                                                                      
                                                                        
                                                                        <div class="form-group">
									<label class="col-md-3 control-label" for="Nombre_Empresa">Empresa</label>
									<div class="col-md-9">
                                                                            <input id="Nombre_Empresa" name="Nombre_Empresa" type="text" placeholder="Your name" class="form-control" value="${cliente.nombre_empresa}">
									</div>
								</div>  
                                                                        <div class="form-group">
									<label class="col-md-3 control-label" for="Direccion">Direccion</label>
									<div class="col-md-9">
                                                                            <input id="Direccion" name="Direccion" type="text" placeholder="Direccion" class="form-control" value="${empleado.direccion}">
									</div>
								</div>  
                                                                        <div class="form-group">
									<label class="col-md-3 control-label" for="horas_x_semana">horas_x_semana</label>
									<div class="col-md-9">
                                                                            <input id="horas_x_semana" name="horas_x_semana" type="text" placeholder="horas_x_semana" class="form-control" value="${empleado.horas_x_semana}">
									</div>
								</div>  
                                                                        <div class="form-group">
									<label class="col-md-3 control-label" for="carrera">carrera</label>
									<div class="col-md-9">
                                                                            <input id="carrera" name="carrera" type="text" placeholder="Your name" class="form-control" value="${empleado.carrera}">
									</div>
								</div>  
                                                                        <div class="form-group">
									<label class="col-md-3 control-label" for="estado_civil">estado_civil</label>
									<div class="col-md-9">
                                                                            <input id="estado_civil" name="estado_civil" type="text" placeholder="estado_civil" class="form-control" value="${empleado.estado_civil}">
									</div>
								</div>  
                                                                        <div class="form-group">
									<label class="col-md-3 control-label" for="numero_hijos">numero_hijos</label>
									<div class="col-md-9">
                                                                            <input id="numero_hijos" name="numero_hijos" type="text" placeholder="numero_hijos" class="form-control" value="${empleado.numero_hijos}">
									</div>
								</div>  
                                                                        <div class="form-group">
									<label class="col-md-3 control-label" for="fecha_nacimiento">fecha_nacimiento</label>
									<div class="col-md-9">
                                                                            <input id="fecha_nacimiento" name="fecha_nacimiento" type="text" placeholder="fecha_nacimiento" class="form-control" value="${empleado.fecha_nacimiento}">
									</div>
								</div>  
                                                                        <div class="form-group">
									<label class="col-md-3 control-label" for="antiguedad">antiguedad</label>
									<div class="col-md-9">
                                                                            <input id="antiguedad" name="antiguedad" type="text" placeholder="antiguedad" class="form-control" value="${empleado.antiguedad}">
									</div>
								</div>  
                                                                        <div class="form-group">
									<label class="col-md-3 control-label" for="sueldo_mensual">sueldo_mensual</label>
									<div class="col-md-9">
                                                                            <input id="sueldo_mensual" name="sueldo_mensual" type="text" placeholder="sueldo_mensual" class="form-control" value="${empleado.sueldo_mensual}">
									</div>
								</div>  
                                                                        <div class="form-group">
									<label class="col-md-3 control-label" for="sexo">sexo</label>
									<div class="col-md-9">
                                                                            <input id="sexo" name="sexo" type="text" placeholder="sexo" class="form-control" value="${empleado.sexo}">
									</div>
								</div>  
                                                                        <div class="form-group">
									<label class="col-md-3 control-label" for="candidato">candidato</label>
									<div class="col-md-9">
                                                                            <input id="candidato" name="candidato" type="text" placeholder="candidato" class="form-control" value="${empleado.candidato}">
									</div>
								</div>  
                                                                        
                                                                        
                                                                        
                                                                        <div class="form-group">
									<label class="col-md-3 control-label" for="name">Habilitado</label>
									<div class="col-md-9">
                                                                             <input type="checkbox" name="habilitado" value="1" ${checado}>
									</div>
								</div>  
                                                              
								<div class="form-group">
									<div class="col-md-12 widget-right">
										<button type="submit" class="btn btn-primary btn-md pull-right">Actualizar</button>
									</div>
								</div>
							</fieldset>
						</form>
                                              
					</div>
				</div>
				
				
				
			
			

	 <script src="<c:url value="/js/jquery-1.11.1.min.js" /> "></script>
          <script src="<c:url value="/js/bootstrap.min.js" /> "></script>
           <script src="<c:url value="/js/chart.min.js" /> "></script>
            <script src="<c:url value="/js/chart-data.js" /> "></script>
             <script src="<c:url value="/js/easypiechart.js" /> "></script>
              <script src="<c:url value="/js/easypiechart-data.js" /> "></script>
               <script src="<c:url value="/js/bootstrap-datepicker.js" /> "></script>
	<script>
		$('#calendar').datepicker({
		});
		!function ($) {
		    $(document).on("click","ul.nav li.parent > a > span.icon", function(){          
		        $(this).find('em:first').toggleClass("glyphicon-minus");      
		    }); 
		    $(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
		}(window.jQuery);
		$(window).on('resize', function () {
		  if ($(window).width() > 768) $('#sidebar-collapse').collapse('show')
		})
		$(window).on('resize', function () {
		  if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide')
		})
	</script>	
</body>
</html>