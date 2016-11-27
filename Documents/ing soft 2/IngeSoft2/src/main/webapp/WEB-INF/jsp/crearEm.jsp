<%-- 
    Document   : crearEmpleado
    Created on : 24-oct-2016, 0:10:41
    Author     : Salvador
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       
        
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
							<li><a href="/IngeSoft2/logout"><svg class="glyph stroked cancel"><use xlink:href="#stroked-cancel"></use></svg> Salir</a></li>
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
				<h1 class="page-header">Crear cuenta de un cliente</h1>
			</div>
		</div><!--/.row-->
                
           
		<div class="row">
			<div class="col-md-8">
				<div class="panel panel-default">
					<div class="panel-heading"><svg class="glyph stroked male user "><use xlink:href="#stroked-male-user"/></svg> Información</div>
					<div class="panel-body">
						<form class="form-horizontal" name="crear_cliente" method="POST" action="/IngeSoft2/crearEmpleado">
							<fieldset>
								<!-- Name input-->
                                                                <p>Aqui podras crear una cuenta grupal</p>
                                                                
                                                                
                                                                <div class="form-group">
									<label class="col-md-3 control-label" for="id">Login</label>
									<div class="col-md-9">
									<input class="form-control" id="login_usuario" name="login_usuario" type="text" placeholder="login_usuario">
									</div>
								</div>
                                                                
                                                                
                                                                <div class="form-group">
									<label class="col-md-3 control-label" for="id">password_usuario</label>
									<div class="col-md-9">
									<input class="form-control" id="password_usuario" name="password_usuario" type="text" placeholder="password_usuario">
									</div>
								</div>
                                                                <div class="form-group">
									<label class="col-md-3 control-label" for="id">rol_usuario</label>
									<div class="col-md-9">
									<input class="form-control" id="rol_usuario" name="rol_usuario" type="text" placeholder="rol_usuario">
									</div>
								</div>
                                                                <div class="form-group">
									<label class="col-md-3 control-label" for="id">correo</label>
									<div class="col-md-9">
									<input class="form-control" id="correo" name="correo" type="text" placeholder=" correo">
									</div>
								</div>
                                                                <div class="form-group">
									<label class="col-md-3 control-label" for="id">nombre_cliente</label>
									<div class="col-md-9">
									<input class="form-control" id="nombre_cliente" name="nombre_cliente" type="text" placeholder=" nombre_cliente">
									</div>
								</div>
                                                                
                                                                <div class="form-group">
									<label class="col-md-3 control-label" for="id">apellido_paterno_cliente</label>
									<div class="col-md-9">
									<input class="form-control" id="apellido_paterno_cliente" name="apellido_paterno_cliente" type="text" placeholder=" apellido_paterno_cliente">
									</div>
								</div>
                                                                
                                                                <div class="form-group">
									<label class="col-md-3 control-label" for="id">apellido_materno_cliente</label>
									<div class="col-md-9">
									<input class="form-control" id="apellido_materno_cliente" name="apellido_materno_cliente" type="text" placeholder=" apellido_materno_cliente">
									</div>
								</div>
                                                                
                                                                <div class="form-group">
									<label class="col-md-3 control-label" for="id">telefono_local</label>
									<div class="col-md-9">
									<input class="form-control" id="telefono_local" name="telefono_local" type="text" placeholder=" telefono_local">
									</div>
								</div>
                                                                
                                                                <div class="form-group">
									<label class="col-md-3 control-label" for="id">telefono_movil</label>
									<div class="col-md-9">
									<input class="form-control" id="telefono_movil" name="telefono_movil" type="text" placeholder=" telefono_movil">
									</div>
								</div>
                                                                
                                                                <div class="form-group">
									<label class="col-md-3 control-label" for="id">area</label>
									<div class="col-md-9">
									<input class="form-control" id="area" name="area" type="text" placeholder=" area">
									</div>
								</div>
                                                                
                                                                <div class="form-group">
									<label class="col-md-3 control-label" for="id">puesto</label>
									<div class="col-md-9">
									<input class="form-control" id="puesto" name="puesto" type="text" placeholder=" puesto">
									</div>
								</div>
                                                                                                                                                                                            
                                                                <div class="form-group">
									<label class="col-md-3 control-label" for="id">Nombre empresa</label>
									<div class="col-md-9">
									<input class="form-control" id="Nombre_Empresa" name="Nombre_Empresa" type="text" placeholder=" Nombre de la Empresa">
									</div>
								</div>
                                                                
                                                                
                                                                <div class="form-group">
									<label class="col-md-3 control-label" for="Nombre_Cliente">Dirección</label>
									<div class="col-md-9">
									<input class="form-control" id="direccion" name="direccion" type="text" placeholder="direccion">
									</div>
								</div>
                                                                
                                                                
                                                                <div class="form-group">
									<label class="col-md-3 control-label" for="Horas">Horas de trabajo por semana</label>
									<div class="col-md-9">
                                                                            <input class="form-control" id="horas_x_semana" name="horas_x_semana" type="text" placeholder="horas_x_semana">
									</div>
								</div>
                                                                
                                                                
								<div class="form-group">
									<label class="col-md-3 control-label" for="Carrera">Carrera</label>
									<div class="col-md-9">
                                                                            <input class="form-control" id="carrera" name="carrera" type="text" placeholder="carrera">
									</div>
								</div>
							
								                                                                
                                                                <div class="form-group">
									<label class="col-md-3 control-label" for="Estado">Estado Civil</label>
									<div class="col-md-9">
										 <input class="form-control" id="estado_civil" name="estado_civil" type="text" placeholder="estado_civil">
									</div>
								</div>
                                                                
                                                                        
                                                                        <div class="form-group">
									<label class="col-md-3 control-label" for="hijos">Número de hijos</label>
									<div class="col-md-9">
                                                                            <input class="form-control" id="numero_hijos" name="numero_hijos" type="text" placeholder="numero_hijos"> 
									</div>
								</div>  
                                                                
								<div class="form-group">
									<label class="col-md-3 control-label" for="naciemiento">Fecha de naciemiento</label>
									<div class="col-md-9">
										 <input class="form-control" id="fecha_nacimiento" name="fecha_nacimiento" type="text" placeholder="fecha_nacimiento">
									</div>
								</div>
                                                                        
                                                                        
                                                                        <div class="form-group">
									<label class="col-md-3 control-label" for="Antiguedad">Antiguedad</label>
									<div class="col-md-9">
                                                                             <input class="form-control" id="antiguiedad" name="antiguiedad" type="text" placeholder="antiguiedad">
									</div>
								</div>  
                                                                        
                                                                        <div class="form-group">
									<label class="col-md-3 control-label" for="Sueldo">Sueldo mensual</label>
									<div class="col-md-9">
                                                                            <input class="form-control" id="sueldo_mensual" name="sueldo_mensual" type="text" placeholder="sueldo_mensual">
									</div>
								</div>  
                                                                        
                                                                        <div class="form-group">
									<label class="col-md-3 control-label" for="Sexo">Sexo</label>
									<div class="col-md-9">
                                                                           <input class="form-control" id="sexo" name="sexo" type="text" placeholder="sexo">
									</div>
								</div>  
                                                                        
                                                                        
                                                                        <div class="form-group">
									<label class="col-md-3 control-label" for="Candidato">Candidato</label>
									<div class="col-md-9">
                                                                            <input class="form-control" id="candidato" name="candidato" type="text" placeholder="candidato">
									</div>
								</div>  
                                                                        
                                                                       
								<!-- Message body -->
							
								
								<!-- Form actions -->
								<div class="form-group">
									<div class="col-md-12 widget-right">
										<button type="submit" class="btn btn-primary btn-md pull-right">Registrar</button>
									</div>
								</div>
							</fieldset>
						</form>
					</div>
				</div>
				
				
				
			</div><!--/.col-->
                </div>
			
         
	 <script src="<c:url value="/js/jquery-1.11.1.min.js" /> "></script>
          <script src="<c:url value="/js/bootstrap.min.js" /> "></script>
           <script src="<c:url value="/js/chart.min.js" /> "></script>
            <script src="<c:url value="/js/chart-data.js" /> "></script>
             <script src="<c:url value="/js/easypiechart.js" /> "></script>
              <script src="<c:url value="/js/easypiechart-data.js" /> "></script>
               <script src="<c:url value="/js/bootstrap-datepicker.js" /> "></script>
               <script src="<c:url value="/js/jquery.validate.js" />" ></script>
        <script src="<c:url value="/js/form-validation.js" />" ></script>
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
