<%-- 
    Document   : consulta3
    Created on : 19-sep-2016, 23:13:28
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
    
    <script src="<c:url value="/js/jquery-1.12.4.min.js" />" ></script>
    <script src="<c:url value="/js/jquery.multipage.js" />" ></script>
   
    
    <style>
        .multipage_nav { border-top:1px solid #CCC; padding-top:10px;}
.multipage_nav a { font-weight: bold; display:block; padding: 10px 20px; color: #FFF; text-shadow: #333 1px 1px 5px; text-decoration:none; -moz-box-shadow: 0px 0px 5px #333; -webkit-box-shadow: 0px 0px 5px #333; }
.multipage_nav .multipage_next { float:right;
	background: #a9db80; /* old browsers */
	background: -moz-linear-gradient(top, #a9db80 0%, #96c56f 100%); /* firefox */
	
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#a9db80), color-stop(100%,#96c56f)); /* webkit */
	
	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#a9db80', endColorstr='#96c56f',GradientType=0 ); /* ie */		
}

.multipage_nav .multipage_back { 
	float:left;
	background: #a9db80; /* old browsers */
	background: -moz-linear-gradient(top, #a9db80 0%, #96c56f 100%); /* firefox */
	
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#a9db80), color-stop(100%,#96c56f)); /* webkit */
	
	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#a9db80', endColorstr='#96c56f',GradientType=0 ); /* ie */		
}

.multipage_nav .submit { 

	background: #fceabb; /* old browsers */
	background: -moz-linear-gradient(top, #fceabb 0%, #fccd4d 50%, #f8b500 51%, #fbdf93 100%); /* firefox */
	
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#fceabb), color-stop(50%,#fccd4d), color-stop(51%,#f8b500), color-stop(100%,#fbdf93)); /* webkit */
	
	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#fceabb', endColorstr='#fbdf93',GradientType=0 ); /* ie */
}

.multipage_nav .multipage_state { display: block; text-align:center; width:100px; margin-left:auto;margin-right:auto; font-size:18px;}
.multipage fieldset { border:0px; padding:10px; margin:0px; }

div.clearer{
    display: block;
    visibility: hidden;
    clear: both;
    height:0;
    border-width:0;
    margin:0;
    padding:0;
}

ul.multipage_tabs { list-style-type: none; margin:0px; padding:0px; border-bottom:1px solid #CCC; margin-bottom:20px;}
ul.multipage_tabs li { display:block; float: left; margin-right:20px;}
ul.multipage_tabs li a { display:block; padding:10px; }
ul.multipage_tabs li.active { background: #CCC; } 


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
                <li><a href="#">Usuario: ${login}</a></li>
                <li><a href="/IngeSoft2/salir">Salir</a></li>
                
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
          
          
  <center><h2>Prueba de adaptabilidad laboral</h2></center>
  <br>
 
  <div class="formlog">
  <h3>Instrucciones:</h3> <p>A continuación encontrarás una serie de enunciados a los cuales debes responder considerando la

forma que has pensado, sentido y actuado ante determinadas situaciones en el ambiente laboral.

Te pedimos contestar de la manera más honesta y sincera posible ya que no existen respuestas

buenas o malas.</p>
  <br>
      <div style="width:500px; margin:20px; padding:10px; border:20px solid #F0F0F0;">
	<form id="multipage">
		<fieldset id="page_one">
			<legend>Pregunta 1</legend>
			    No pierdo la concentración cuando se presentan eventos inesperados en mi trabajo. *
			    <br>
			    <br>
			    <input id="1" type="radio" name="1" value="1"> 
				<label for="1">Totalmente en desacuerdo</label>
				
				<br>
                 <input id="2" type="radio" name="1" value="2"> 
				<label for="2">En desacuerdo</label>
				
				<br>
                 <input id="3" type="radio" name="1" value="3"> 
				<label for="3">Ni de acuerdo ni en desacuerdo</label>
				
				<br>
                 <input id="4" type="radio" name="1" value="4"> 
				<label for="4">De acuerdo</label>
				
				<br>
                 <input id="5" type="radio" name="1" value="5">
				<label for="5">Totalmente de acuerdo</label>
				
				
			
		</fieldset>
		<fieldset id="page_two">
		<legend>Pregunta 2</legend>
		 Aunque las situaciones no sean estables, soy totalmente competente. *
		 <br>
		 <br>
			    <input id="1" type="radio" name="1" value="1"> 
				<label for="1">Totalmente en desacuerdo</label>
				
				<br>
                 <input id="2" type="radio" name="1" value="2"> 
				<label for="2">En desacuerdo</label>
				
				<br>
                 <input id="3" type="radio" name="1" value="3"> 
				<label for="3">Ni de acuerdo ni en desacuerdo</label>
				
				<br>
                 <input id="4" type="radio" name="1" value="4"> 
				<label for="4">De acuerdo</label>
				
				<br>
                 <input id="5" type="radio" name="1" value="5">
				<label for="5">Totalmente de acuerdo</label>
			
		</fieldset>
		<fieldset id="page_three">
		<legend>Pregunta 3</legend>
		Es difícil para mí encarar eventos inesperados. *
		<br>
		<br>
			    <input id="1" type="radio" name="1" value="1"> 
				<label for="1">Totalmente en desacuerdo</label>
				
				<br>
                 <input id="2" type="radio" name="1" value="2"> 
				<label for="2">En desacuerdo</label>
				
				<br>
                 <input id="3" type="radio" name="1" value="3"> 
				<label for="3">Ni de acuerdo ni en desacuerdo</label>
				
				<br>
                 <input id="4" type="radio" name="1" value="4"> 
				<label for="4">De acuerdo</label>
				
				<br>
                 <input id="5" type="radio" name="1" value="5">
				<label for="5">Totalmente de acuerdo</label>
			
		</fieldset>

		<fieldset id="page_three">
		<legend>Pregunta 4</legend>
		Me cuesta trabajo ser una persona madura. *
		<br>
		<br>
			    <input id="1" type="radio" name="1" value="1"> 
				<label for="1">Totalmente en desacuerdo</label>
				
				<br>
                 <input id="2" type="radio" name="1" value="2"> 
				<label for="2">En desacuerdo</label>
				
				<br>
                 <input id="3" type="radio" name="1" value="3"> 
				<label for="3">Ni de acuerdo ni en desacuerdo</label>
				
				<br>
                 <input id="4" type="radio" name="1" value="4"> 
				<label for="4">De acuerdo</label>
				
				<br>
                 <input id="5" type="radio" name="1" value="5">
				<label for="5">Totalmente de acuerdo</label>
			
		</fieldset>

		<fieldset id="page_three">
		<legend>Pregunta 5</legend>
		 Mi desempeño es igual de bueno en diferentes entornos. *
		 <br>
		 <br>
			    <input id="1" type="radio" name="1" value="1"> 
				<label for="1">Totalmente en desacuerdo</label>
				
				<br>
                 <input id="2" type="radio" name="1" value="2"> 
				<label for="2">En desacuerdo</label>
				
				<br>
                 <input id="3" type="radio" name="1" value="3"> 
				<label for="3">Ni de acuerdo ni en desacuerdo</label>
				
				<br>
                 <input id="4" type="radio" name="1" value="4"> 
				<label for="4">De acuerdo</label>
				
				<br>
                 <input id="5" type="radio" name="1" value="5">
				<label for="5">Totalmente de acuerdo</label>
			
		</fieldset>

		<fieldset id="page_three">
		<legend>Pregunta 6</legend>
		Tengo agilidad mental. *
		<br>
		<br>
			    <input id="1" type="radio" name="1" value="1"> 
				<label for="1">Totalmente en desacuerdo</label>
				
				<br>
                 <input id="2" type="radio" name="1" value="2"> 
				<label for="2">En desacuerdo</label>
				
				<br>
                 <input id="3" type="radio" name="1" value="3"> 
				<label for="3">Ni de acuerdo ni en desacuerdo</label>
				
				<br>
                 <input id="4" type="radio" name="1" value="4"> 
				<label for="4">De acuerdo</label>
				
				<br>
                 <input id="5" type="radio" name="1" value="5">
				<label for="5">Totalmente de acuerdo</label>
			
		</fieldset>

		<fieldset id="page_three">
		<legend>Pregunta 7</legend>
		Soy una persona madura que sabe cómo actuar en eventos impredecibles. *
		<br>
		<br>
			    <input id="1" type="radio" name="1" value="1"> 
				<label for="1">Totalmente en desacuerdo</label>
				
				<br>
                 <input id="2" type="radio" name="1" value="2"> 
				<label for="2">En desacuerdo</label>
				
				<br>
                 <input id="3" type="radio" name="1" value="3"> 
				<label for="3">Ni de acuerdo ni en desacuerdo</label>
				
				<br>
                 <input id="4" type="radio" name="1" value="4"> 
				<label for="4">De acuerdo</label>
				
				<br>
                 <input id="5" type="radio" name="1" value="5">
				<label for="5">Totalmente de acuerdo</label>
			
		</fieldset>

		<fieldset id="page_three">
		<legend>Pregunta 8</legend>
		Me considero hábil para resolver eventos inesperados. *
		<br>
		<br>
			    <input id="1" type="radio" name="1" value="1"> 
				<label for="1">Totalmente en desacuerdo</label>
				
				<br>
                 <input id="2" type="radio" name="1" value="2"> 
				<label for="2">En desacuerdo</label>
				
				<br>
                 <input id="3" type="radio" name="1" value="3"> 
				<label for="3">Ni de acuerdo ni en desacuerdo</label>
				
				<br>
                 <input id="4" type="radio" name="1" value="4"> 
				<label for="4">De acuerdo</label>
				
				<br>
                 <input id="5" type="radio" name="1" value="5">
				<label for="5">Totalmente de acuerdo</label>
			
		</fieldset>

		<fieldset id="page_three">
		<legend>Pregunta 9</legend>
		Aunque las situaciones en mi trabajo sean inciertas, soy capaz de encararlas. *
		<br>
		<br>
			    <input id="1" type="radio" name="1" value="1"> 
				<label for="1">Totalmente en desacuerdo</label>
				
				<br>
                 <input id="2" type="radio" name="1" value="2"> 
				<label for="2">En desacuerdo</label>
				
				<br>
                 <input id="3" type="radio" name="1" value="3"> 
				<label for="3">Ni de acuerdo ni en desacuerdo</label>
				
				<br>
                 <input id="4" type="radio" name="1" value="4"> 
				<label for="4">De acuerdo</label>
				
				<br>
                 <input id="5" type="radio" name="1" value="5">
				<label for="5">Totalmente de acuerdo</label>
			
		</fieldset>

		<fieldset id="page_three">
		<legend>Pregunta 10</legend>
		Aunque no conozca a fondo la situación en la que me encuentre salgo adelante. *
		<br>
		<br>
			    <input id="1" type="radio" name="1" value="1"> 
				<label for="1">Totalmente en desacuerdo</label>
				
				<br>
                 <input id="2" type="radio" name="1" value="2"> 
				<label for="2">En desacuerdo</label>
				
				<br>
                 <input id="3" type="radio" name="1" value="3"> 
				<label for="3">Ni de acuerdo ni en desacuerdo</label>
				
				<br>
                 <input id="4" type="radio" name="1" value="4"> 
				<label for="4">De acuerdo</label>
				
				<br>
                 <input id="5" type="radio" name="1" value="5">
				<label for="5">Totalmente de acuerdo</label>
			
		</fieldset>

		<fieldset id="page_three">
		<legend>Pregunta 11</legend>
		 Me siento entusiasmado cuando me enfrento a un reto difícil de resolver. *
		 <br>
		 <br>
			    <input id="1" type="radio" name="1" value="1"> 
				<label for="1">Totalmente en desacuerdo</label>
				
				<br>
                 <input id="2" type="radio" name="1" value="2"> 
				<label for="2">En desacuerdo</label>
				
				<br>
                 <input id="3" type="radio" name="1" value="3"> 
				<label for="3">Ni de acuerdo ni en desacuerdo</label>
				
				<br>
                 <input id="4" type="radio" name="1" value="4"> 
				<label for="4">De acuerdo</label>
				
				<br>
                 <input id="5" type="radio" name="1" value="5">
				<label for="5">Totalmente de acuerdo</label>
			
		</fieldset>

		<fieldset id="page_three">
		<legend>Pregunta 12</legend>
		Resuelvo los conflictos de forma eficaz. *
		<br>
		<br>
			    <input id="1" type="radio" name="1" value="1"> 
				<label for="1">Totalmente en desacuerdo</label>
				
				<br>
                 <input id="2" type="radio" name="1" value="2"> 
				<label for="2">En desacuerdo</label>
				
				<br>
                 <input id="3" type="radio" name="1" value="3"> 
				<label for="3">Ni de acuerdo ni en desacuerdo</label>
				
				<br>
                 <input id="4" type="radio" name="1" value="4"> 
				<label for="4">De acuerdo</label>
				
				<br>
                 <input id="5" type="radio" name="1" value="5">
				<label for="5">Totalmente de acuerdo</label>
			
		</fieldset>

		<fieldset id="page_three">
		<legend>Pregunta 13</legend>
		No soy innovador. *
		<br>
		<br>
			    <input id="1" type="radio" name="1" value="1"> 
				<label for="1">Totalmente en desacuerdo</label>
				
				<br>
                 <input id="2" type="radio" name="1" value="2"> 
				<label for="2">En desacuerdo</label>
				
				<br>
                 <input id="3" type="radio" name="1" value="3"> 
				<label for="3">Ni de acuerdo ni en desacuerdo</label>
				
				<br>
                 <input id="4" type="radio" name="1" value="4"> 
				<label for="4">De acuerdo</label>
				
				<br>
                 <input id="5" type="radio" name="1" value="5">
				<label for="5">Totalmente de acuerdo</label>
			
		</fieldset>

		<fieldset id="page_three">
		<legend>Pregunta 14</legend>
		 Muchos me consideran una persona cuadrada. *
		 <br>
		 <br>
			    <input id="1" type="radio" name="1" value="1"> 
				<label for="1">Totalmente en desacuerdo</label>
				
				<br>
                 <input id="2" type="radio" name="1" value="2"> 
				<label for="2">En desacuerdo</label>
				
				<br>
                 <input id="3" type="radio" name="1" value="3"> 
				<label for="3">Ni de acuerdo ni en desacuerdo</label>
				
				<br>
                 <input id="4" type="radio" name="1" value="4"> 
				<label for="4">De acuerdo</label>
				
				<br>
                 <input id="5" type="radio" name="1" value="5">
				<label for="5">Totalmente de acuerdo</label>
			
		</fieldset>

		<fieldset id="page_three">
		<legend>Pregunta 15</legend>
		Soy astuto para salir de los apuros. *
		<br>
		<br>
			    <input id="1" type="radio" name="1" value="1"> 
				<label for="1">Totalmente en desacuerdo</label>
				
				<br>
                 <input id="2" type="radio" name="1" value="2"> 
				<label for="2">En desacuerdo</label>
				
				<br>
                 <input id="3" type="radio" name="1" value="3"> 
				<label for="3">Ni de acuerdo ni en desacuerdo</label>
				
				<br>
                 <input id="4" type="radio" name="1" value="4"> 
				<label for="4">De acuerdo</label>
				
				<br>
                 <input id="5" type="radio" name="1" value="5">
				<label for="5">Totalmente de acuerdo</label>
			
		</fieldset>

		<fieldset id="page_three">
		<legend>Pregunta 16</legend>
		¿Cuál es la respuesta correcta de la siguiente operación 38+21-66? *
		<br>
		<br>
			    <input id="1" type="radio" name="1" value="1"> 
				<label for="1">-5</label>
				
				<br>
                 <input id="2" type="radio" name="1" value="2"> 
				<label for="2">-6</label>
				
				<br>
                 <input id="3" type="radio" name="1" value="3"> 
				<label for="3">7</label>
				
				<br>
                 <input id="4" type="radio" name="1" value="4"> 
				<label for="4">6</label>
				
				<br>
                 <input id="5" type="radio" name="1" value="5">
				<label for="5">-7</label>
			
		</fieldset>

		<fieldset id="page_three">
		<legend>Pregunta 17</legend>
		Soluciono conflictos hábilmente. *
		<br>
		<br>
			    <input id="1" type="radio" name="1" value="1"> 
				<label for="1">Totalmente en desacuerdo</label>
				
				<br>
                 <input id="2" type="radio" name="1" value="2"> 
				<label for="2">En desacuerdo</label>
				
				<br>
                 <input id="3" type="radio" name="1" value="3"> 
				<label for="3">Ni de acuerdo ni en desacuerdo</label>
				
				<br>
                 <input id="4" type="radio" name="1" value="4"> 
				<label for="4">De acuerdo</label>
				
				<br>
                 <input id="5" type="radio" name="1" value="5">
				<label for="5">Totalmente de acuerdo</label>
			
		</fieldset>

		<fieldset id="page_three">
		<legend>Pregunta 18</legend>
		Me causa desconfianza escuchar a personas que no siguen los pasos específicos necesarios para alcanzar una meta. *
		<br>
		<br>
			    <input id="1" type="radio" name="1" value="1"> 
				<label for="1">Totalmente en desacuerdo</label>
				
				<br>
                 <input id="2" type="radio" name="1" value="2"> 
				<label for="2">En desacuerdo</label>
				
				<br>
                 <input id="3" type="radio" name="1" value="3"> 
				<label for="3">Ni de acuerdo ni en desacuerdo</label>
				
				<br>
                 <input id="4" type="radio" name="1" value="4"> 
				<label for="4">De acuerdo</label>
				
				<br>
                 <input id="5" type="radio" name="1" value="5">
				<label for="5">Totalmente de acuerdo</label>
			
		</fieldset>

		<fieldset id="page_three">
		<legend>Pregunta 19</legend>
		Soy creativo, a menudo se me ocurren diferentes formas de hacer las cosas. *
		<br>
		<br>
			    <input id="1" type="radio" name="1" value="1"> 
				<label for="1">Totalmente en desacuerdo</label>
				
				<br>
                 <input id="2" type="radio" name="1" value="2"> 
				<label for="2">En desacuerdo</label>
				
				<br>
                 <input id="3" type="radio" name="1" value="3"> 
				<label for="3">Ni de acuerdo ni en desacuerdo</label>
				
				<br>
                 <input id="4" type="radio" name="1" value="4"> 
				<label for="4">De acuerdo</label>
				
				<br>
                 <input id="5" type="radio" name="1" value="5">
				<label for="5">Totalmente de acuerdo</label>
			
		</fieldset>

		<fieldset id="page_three">
		<legend>Pregunta 20</legend>
		Encuentro rápidamente respuestas a los problemas. *
		<br>
		<br>
			    <input id="1" type="radio" name="1" value="1"> 
				<label for="1">Totalmente en desacuerdo</label>
				
				<br>
                 <input id="2" type="radio" name="1" value="2"> 
				<label for="2">En desacuerdo</label>
				
				<br>
                 <input id="3" type="radio" name="1" value="3"> 
				<label for="3">Ni de acuerdo ni en desacuerdo</label>
				
				<br>
                 <input id="4" type="radio" name="1" value="4"> 
				<label for="4">De acuerdo</label>
				
				<br>
                 <input id="5" type="radio" name="1" value="5">
				<label for="5">Totalmente de acuerdo</label>
			
		</fieldset>

		<fieldset id="page_three">
		<legend>Pregunta 21</legend>
		Se me dificulta establecer nuevas relaciones personales en la empresa. *
		<br>
		<br>
			    <input id="1" type="radio" name="1" value="1"> 
				<label for="1">Totalmente en desacuerdo</label>
				
				<br>
                 <input id="2" type="radio" name="1" value="2"> 
				<label for="2">En desacuerdo</label>
				
				<br>
                 <input id="3" type="radio" name="1" value="3"> 
				<label for="3">Ni de acuerdo ni en desacuerdo</label>
				
				<br>
                 <input id="4" type="radio" name="1" value="4"> 
				<label for="4">De acuerdo</label>
				
				<br>
                 <input id="5" type="radio" name="1" value="5">
				<label for="5">Totalmente de acuerdo</label>
			
		</fieldset>

		<fieldset id="page_three">
		<legend>Pregunta 22</legend>
		No soy comunicativo. *
		<br>
		<br>
			    <input id="1" type="radio" name="1" value="1"> 
				<label for="1">Totalmente en desacuerdo</label>
				
				<br>
                 <input id="2" type="radio" name="1" value="2"> 
				<label for="2">En desacuerdo</label>
				
				<br>
                 <input id="3" type="radio" name="1" value="3"> 
				<label for="3">Ni de acuerdo ni en desacuerdo</label>
				
				<br>
                 <input id="4" type="radio" name="1" value="4"> 
				<label for="4">De acuerdo</label>
				
				<br>
                 <input id="5" type="radio" name="1" value="5">
				<label for="5">Totalmente de acuerdo</label>
			
		</fieldset>

		<fieldset id="page_three">
		<legend>Pregunta 23</legend>
		Algunas personas dicen que soy irritante. *
		<br>
		<br>
			    <input id="1" type="radio" name="1" value="1"> 
				<label for="1">Totalmente en desacuerdo</label>
				
				<br>
                 <input id="2" type="radio" name="1" value="2"> 
				<label for="2">En desacuerdo</label>
				
				<br>
                 <input id="3" type="radio" name="1" value="3"> 
				<label for="3">Ni de acuerdo ni en desacuerdo</label>
				
				<br>
                 <input id="4" type="radio" name="1" value="4"> 
				<label for="4">De acuerdo</label>
				
				<br>
                 <input id="5" type="radio" name="1" value="5">
				<label for="5">Totalmente de acuerdo</label>
			
		</fieldset>

		<fieldset id="page_three">
			<legend>Pregunta 24</legend>
			 La relación con mis compañeros de trabajo es limitada. *
			 <br>
			 <br>
			    <input id="1" type="radio" name="1" value="1"> 
				<label for="1">Totalmente en desacuerdo</label>
				
				<br>
                 <input id="2" type="radio" name="1" value="2"> 
				<label for="2">En desacuerdo</label>
				
				<br>
                 <input id="3" type="radio" name="1" value="3"> 
				<label for="3">Ni de acuerdo ni en desacuerdo</label>
				
				<br>
                 <input id="4" type="radio" name="1" value="4"> 
				<label for="4">De acuerdo</label>
				
				<br>
                 <input id="5" type="radio" name="1" value="5">
				<label for="5">Totalmente de acuerdo</label>
		</fieldset>

		<fieldset id="page_three">
			<legend>Pregunta 25</legend>
			 Prefiero estar solo que mal acompañado. *
			 <br>
			 <br>
			    <input id="1" type="radio" name="1" value="1"> 
				<label for="1">Totalmente en desacuerdo</label>
				
				<br>
                 <input id="2" type="radio" name="1" value="2"> 
				<label for="2">En desacuerdo</label>
				
				<br>
                 <input id="3" type="radio" name="1" value="3"> 
				<label for="3">Ni de acuerdo ni en desacuerdo</label>
				
				<br>
                 <input id="4" type="radio" name="1" value="4"> 
				<label for="4">De acuerdo</label>
				
				<br>
                 <input id="5" type="radio" name="1" value="5">
				<label for="5">Totalmente de acuerdo</label>
		</fieldset>

		<fieldset id="page_three">
			<legend>Pregunta 26</legend>
			A veces soy inmaduro en mi trabajo. *
			<br>
			<br>
			    <input id="1" type="radio" name="1" value="1"> 
				<label for="1">Totalmente en desacuerdo</label>
				
				<br>
                 <input id="2" type="radio" name="1" value="2"> 
				<label for="2">En desacuerdo</label>
				
				<br>
                 <input id="3" type="radio" name="1" value="3"> 
				<label for="3">Ni de acuerdo ni en desacuerdo</label>
				
				<br>
                 <input id="4" type="radio" name="1" value="4"> 
				<label for="4">De acuerdo</label>
				
				<br>
                 <input id="5" type="radio" name="1" value="5">
				<label for="5">Totalmente de acuerdo</label>
		</fieldset>

		<fieldset id="page_three">
			<legend>Pregunta 27</legend>
			Me enojo muy rápido si alguien me contradice. *
			<br>
			<br>
			    <input id="1" type="radio" name="1" value="1"> 
				<label for="1">Totalmente en desacuerdo</label>
				
				<br>
                 <input id="2" type="radio" name="1" value="2"> 
				<label for="2">En desacuerdo</label>
				
				<br>
                 <input id="3" type="radio" name="1" value="3"> 
				<label for="3">Ni de acuerdo ni en desacuerdo</label>
				
				<br>
                 <input id="4" type="radio" name="1" value="4"> 
				<label for="4">De acuerdo</label>
				
				<br>
                 <input id="5" type="radio" name="1" value="5">
				<label for="5">Totalmente de acuerdo</label>
		</fieldset>

		<fieldset id="page_three">
			<legend>Pregunta 28</legend>
			Soy agresivo con aquellos que me provocan. *
			<br>
			<br>
			    <input id="1" type="radio" name="1" value="1"> 
				<label for="1">Totalmente en desacuerdo</label>
				
				<br>
                 <input id="2" type="radio" name="1" value="2"> 
				<label for="2">En desacuerdo</label>
				
				<br>
                 <input id="3" type="radio" name="1" value="3"> 
				<label for="3">Ni de acuerdo ni en desacuerdo</label>
				
				<br>
                 <input id="4" type="radio" name="1" value="4"> 
				<label for="4">De acuerdo</label>
				
				<br>
                 <input id="5" type="radio" name="1" value="5">
				<label for="5">Totalmente de acuerdo</label>
		</fieldset>

		<fieldset id="page_three">
			<legend>Pregunta 29</legend>
			Soy tímido, me cuesta trabajo hablar con desconocidos. *
			<br>
			<br>
			    <input id="1" type="radio" name="1" value="1"> 
				<label for="1">Totalmente en desacuerdo</label>
				
				<br>
                 <input id="2" type="radio" name="1" value="2"> 
				<label for="2">En desacuerdo</label>
				
				<br>
                 <input id="3" type="radio" name="1" value="3"> 
				<label for="3">Ni de acuerdo ni en desacuerdo</label>
				
				<br>
                 <input id="4" type="radio" name="1" value="4"> 
				<label for="4">De acuerdo</label>
				
				<br>
                 <input id="5" type="radio" name="1" value="5">
				<label for="5">Totalmente de acuerdo</label>
		</fieldset>

		<fieldset id="page_three">
			<legend>Pregunta 30</legend>
			Puedo ser irrespetuoso. *
			<br>
			<br>
			    <input id="1" type="radio" name="1" value="1"> 
				<label for="1">Totalmente en desacuerdo</label>
				
				<br>
                 <input id="2" type="radio" name="1" value="2"> 
				<label for="2">En desacuerdo</label>
				
				<br>
                 <input id="3" type="radio" name="1" value="3"> 
				<label for="3">Ni de acuerdo ni en desacuerdo</label>
				
				<br>
                 <input id="4" type="radio" name="1" value="4"> 
				<label for="4">De acuerdo</label>
				
				<br>
                 <input id="5" type="radio" name="1" value="5">
				<label for="5">Totalmente de acuerdo</label>
		</fieldset>

		<input type="submit" value="Terminar" />
	</form>
	</div>

  </div>
  

        
        

    
  </body>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"/>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"/>
</html>
