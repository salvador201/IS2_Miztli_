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

    <style>
        
       
        
        table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    text-align: left;
    padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
    background-color: #0040FF;
    color: white;
}


        
   .formlog2{
    border: 5px solid #A0B5EC;
    width: 30%;
    padding: 10px;
   position: relative;
    left: 30px;

    
}

    .formlog{
    border: 5px solid #A0B5EC;
    width: 70%;
    position: absolute;
    right: 180px;
    padding: 10px;
}


input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
    border-radius: 15px;
}

button {
    background-color: #2E9AFE;
    color: white;
    padding: 10px 16px;
    margin: 6px 0;
    border: none;
    cursor: pointer;
    width: 10%;
    border-radius: 15px;
}

.cancelbtn {
    width: auto;
    padding: 10px 18px;
    background-color: #f44336;
}

.imgcontainer {
    text-align: center;
    margin: 24px 0 12px 0;
}

img.avatar {
    width: 40%;
    border-radius: 50%;
}

.container {
    padding: 16px;
}

div.doe{
  opacity: 0.1;
  position: absolute;
  left: 10%;  
  
}

span.psw {
    float: right;
    padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 50px) {
    span.psw {
       display: block;
       float: none;
    }
    .cancelbtn {
       width: 100%;
    }
}
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
                <li><a href="<c:url value="/home"/> ">Clientes</a></li>
                <li><a href="<c:url value="/prueba"/>">Pruebas</a></li>
                <li><a href="#">Proyectos</a></li>
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
      <form>
          <label>1. No pierdo la concentración cuando se presentan eventos inesperados en mi trabajo. *</label>
          <br>
           <input type="radio" name="uno" value="1"> Totalmente en desacuerdo<br>
  <input type="radio" name="uno" value="2"> . En desacuerdo
<br>
  <input type="radio" name="uno" value="3"> Ni de acuerdo ni en desacuerdo<br>
   <input type="radio" name="uno" value="4"> De acuerdo<br>
  <input type="radio" name="uno" value="5"> Totalmente de acuerdo<br>
  
  <label>2. Aunque las situaciones no sean estables, soy totalmente competente. *</label>
  <br>
           <input type="radio" name="dos" value="1"> Totalmente en desacuerdo<br>
  <input type="radio" name="dos" value="2"> . En desacuerdo
<br>
  <input type="radio" name="dos" value="3"> Ni de acuerdo ni en desacuerdo<br>
   <input type="radio" name="dos" value="4"> De acuerdo<br>
  <input type="radio" name="dos" value="5"> Totalmente de acuerdo<br>
  
  <label>3. Es difícil para mí encarar eventos inesperados. *</label>
  <br>
           <input type="radio" name="tres" value="1"> Totalmente en desacuerdo<br>
  <input type="radio" name="tres" value="2"> . En desacuerdo
<br>
  <input type="radio" name="tres" value="3"> Ni de acuerdo ni en desacuerdo<br>
   <input type="radio" name="tres" value="4"> De acuerdo<br>
  <input type="radio" name="tres" value="5"> Totalmente de acuerdo<br>
  
  <label>4. Me cuesta trabajo ser una persona madura. *</label>
  <br>
           <input type="radio" name="cuatro" value="1"> Totalmente en desacuerdo<br>
  <input type="radio" name="cuatro" value="2"> . En desacuerdo
<br>
  <input type="radio" name="cuatro" value="3"> Ni de acuerdo ni en desacuerdo<br>
   <input type="radio" name="cuatro" value="4"> De acuerdo<br>
  <input type="radio" name="cuatro" value="5"> Totalmente de acuerdo<br>
  
  <label>5. Mi desempeño es igual de bueno en diferentes entornos. *</label>
  <br>
           <input type="radio" name="cinco" value="1"> Totalmente en desacuerdo<br>
  <input type="radio" name="cinco" value="2"> . En desacuerdo
<br>
  <input type="radio" name="cinco" value="3"> Ni de acuerdo ni en desacuerdo<br>
   <input type="radio" name="cinco" value="4"> De acuerdo<br>
  <input type="radio" name="cinco" value="5"> Totalmente de acuerdo<br>
  
  <label>6. Tengo agilidad mental. *</label>
  <br>
           <input type="radio" name="seis" value="1"> Totalmente en desacuerdo<br>
  <input type="radio" name="seis" value="2"> . En desacuerdo
<br>
  <input type="radio" name="seis" value="3"> Ni de acuerdo ni en desacuerdo<br>
   <input type="radio" name="seis" value="4"> De acuerdo<br>
  <input type="radio" name="seis" value="5"> Totalmente de acuerdo<br>
  
  <label>7. Soy una persona madura que sabe cómo actuar en eventos impredecibles. *</label>
  <br>
           <input type="radio" name="siete" value="1"> Totalmente en desacuerdo<br>
  <input type="radio" name="siete" value="2"> . En desacuerdo
<br>
  <input type="radio" name="siete" value="3"> Ni de acuerdo ni en desacuerdo<br>
   <input type="radio" name="siete" value="4"> De acuerdo<br>
  <input type="radio" name="siete" value="5"> Totalmente de acuerdo<br>
  
  <label>8. Me considero hábil para resolver eventos inesperados. *</label>
  <br>
           <input type="radio" name="uno" value="1"> Totalmente en desacuerdo<br>
  <input type="radio" name="dos" value="2"> . En desacuerdo
<br>
  <input type="radio" name="tres" value="3"> Ni de acuerdo ni en desacuerdo<br>
   <input type="radio" name="cuatro" value="4"> De acuerdo<br>
  <input type="radio" name="cinco" value="5"> Totalmente de acuerdo<br>
  
  <label>9. Aunque las situaciones en mi trabajo sean inciertas, soy capaz de encararlas. *</label>
  <br>
           <input type="radio" name="uno" value="1"> Totalmente en desacuerdo<br>
  <input type="radio" name="dos" value="2"> . En desacuerdo
<br>
  <input type="radio" name="tres" value="3"> Ni de acuerdo ni en desacuerdo<br>
   <input type="radio" name="cuatro" value="4"> De acuerdo<br>
  <input type="radio" name="cinco" value="5"> Totalmente de acuerdo<br>
  
  <label>10. Aunque no conozca a fondo la situación en la que me encuentre salgo adelante. *</label>
  <br>
           <input type="radio" name="uno" value="1"> Totalmente en desacuerdo<br>
  <input type="radio" name="dos" value="2"> . En desacuerdo
<br>
  <input type="radio" name="tres" value="3"> Ni de acuerdo ni en desacuerdo<br>
   <input type="radio" name="cuatro" value="4"> De acuerdo<br>
  <input type="radio" name="cinco" value="5"> Totalmente de acuerdo<br>
  
  <label>11. Me siento entusiasmado cuando me enfrento a un reto difícil de resolver. *</label>
  <br>
           <input type="radio" name="uno" value="1"> Totalmente en desacuerdo<br>
  <input type="radio" name="dos" value="2"> . En desacuerdo
<br>
  <input type="radio" name="tres" value="3"> Ni de acuerdo ni en desacuerdo<br>
   <input type="radio" name="cuatro" value="4"> De acuerdo<br>
  <input type="radio" name="cinco" value="5"> Totalmente de acuerdo<br>
  
  <label>12. Resuelvo los conflictos de forma eficaz. *</label>
  <br>
           <input type="radio" name="uno" value="1"> Totalmente en desacuerdo<br>
  <input type="radio" name="dos" value="2"> . En desacuerdo
<br>
  <input type="radio" name="tres" value="3"> Ni de acuerdo ni en desacuerdo<br>
   <input type="radio" name="cuatro" value="4"> De acuerdo<br>
  <input type="radio" name="cinco" value="5"> Totalmente de acuerdo<br>
  
  <label>13. No soy innovador. *</label>
  <br>
           <input type="radio" name="uno" value="1"> Totalmente en desacuerdo<br>
  <input type="radio" name="dos" value="2"> . En desacuerdo
<br>
  <input type="radio" name="tres" value="3"> Ni de acuerdo ni en desacuerdo<br>
   <input type="radio" name="cuatro" value="4"> De acuerdo<br>
  <input type="radio" name="cinco" value="5"> Totalmente de acuerdo<br>
  
  <label>14. Muchos me consideran una persona cuadrada. *</label>
  <br>
           <input type="radio" name="uno" value="1"> Totalmente en desacuerdo<br>
  <input type="radio" name="dos" value="2"> . En desacuerdo
<br>
  <input type="radio" name="tres" value="3"> Ni de acuerdo ni en desacuerdo<br>
   <input type="radio" name="cuatro" value="4"> De acuerdo<br>
  <input type="radio" name="cinco" value="5"> Totalmente de acuerdo<br>
  
  <label>15. Soy astuto para salir de los apuros. *</label>
  <br>
           <input type="radio" name="uno" value="1"> Totalmente en desacuerdo<br>
  <input type="radio" name="dos" value="2"> . En desacuerdo
<br>
  <input type="radio" name="tres" value="3"> Ni de acuerdo ni en desacuerdo<br>
   <input type="radio" name="cuatro" value="4"> De acuerdo<br>
  <input type="radio" name="cinco" value="5"> Totalmente de acuerdo<br>
  
  <label>16. ¿Cuál es la respuesta correcta de la siguiente operación 38+21-66? *</label>
  <br>
           <input type="radio" name="uno" value="1"> -5<br>
  <input type="radio" name="dos" value="2"> -6
<br>
  <input type="radio" name="tres" value="3"> 7<br>
   <input type="radio" name="cuatro" value="4"> 6<br>
  <input type="radio" name="cinco" value="5"> -7<br>
  
  <label>17. Soluciono conflictos hábilmente. *</label>
  <br>
           <input type="radio" name="uno" value="1"> Totalmente en desacuerdo<br>
  <input type="radio" name="dos" value="2"> . En desacuerdo
<br>
  <input type="radio" name="tres" value="3"> Ni de acuerdo ni en desacuerdo<br>
   <input type="radio" name="cuatro" value="4"> De acuerdo<br>
  <input type="radio" name="cinco" value="5"> Totalmente de acuerdo<br>
  
  <label>18. Me causa desconfianza escuchar a personas que no siguen los pasos específicos necesarios para alcanzar una meta. *</label>
  <br>
           <input type="radio" name="uno" value="1"> Totalmente en desacuerdo<br>
  <input type="radio" name="dos" value="2"> . En desacuerdo
<br>
  <input type="radio" name="tres" value="3"> Ni de acuerdo ni en desacuerdo<br>
   <input type="radio" name="cuatro" value="4"> De acuerdo<br>
  <input type="radio" name="cinco" value="5"> Totalmente de acuerdo<br>
  
  <label>19. Soy creativo, a menudo se me ocurren diferentes formas de hacer las cosas. *</label>
  <br>
           <input type="radio" name="uno" value="1"> Totalmente en desacuerdo<br>
  <input type="radio" name="dos" value="2"> . En desacuerdo
<br>
  <input type="radio" name="tres" value="3"> Ni de acuerdo ni en desacuerdo<br>
   <input type="radio" name="cuatro" value="4"> De acuerdo<br>
  <input type="radio" name="cinco" value="5"> Totalmente de acuerdo<br>
  
  <label>20. Encuentro rápidamente respuestas a los problemas. *</label>
  <br>
           <input type="radio" name="uno" value="1"> Totalmente en desacuerdo<br>
  <input type="radio" name="dos" value="2"> . En desacuerdo
<br>
  <input type="radio" name="tres" value="3"> Ni de acuerdo ni en desacuerdo<br>
   <input type="radio" name="cuatro" value="4"> De acuerdo<br>
  <input type="radio" name="cinco" value="5"> Totalmente de acuerdo<br>
  
  <label>21. Se me dificulta establecer nuevas relaciones personales en la empresa. *</label>
  <br>
           <input type="radio" name="uno" value="1"> Totalmente en desacuerdo<br>
  <input type="radio" name="dos" value="2"> . En desacuerdo
<br>
  <input type="radio" name="tres" value="3"> Ni de acuerdo ni en desacuerdo<br>
   <input type="radio" name="cuatro" value="4"> De acuerdo<br>
  <input type="radio" name="cinco" value="5"> Totalmente de acuerdo<br>
  
  <label>22. No soy comunicativo. * </label>
  <br>
           <input type="radio" name="uno" value="1"> Totalmente en desacuerdo<br>
  <input type="radio" name="dos" value="2"> . En desacuerdo
<br>
  <input type="radio" name="tres" value="3"> Ni de acuerdo ni en desacuerdo<br>
   <input type="radio" name="cuatro" value="4"> De acuerdo<br>
  <input type="radio" name="cinco" value="5"> Totalmente de acuerdo<br>
  
  <label>23. Algunas personas dicen que soy irritante. *</label>
  <br>
           <input type="radio" name="uno" value="1"> Totalmente en desacuerdo<br>
  <input type="radio" name="dos" value="2"> . En desacuerdo
<br>
  <input type="radio" name="tres" value="3"> Ni de acuerdo ni en desacuerdo<br>
   <input type="radio" name="cuatro" value="4"> De acuerdo<br>
  <input type="radio" name="cinco" value="5"> Totalmente de acuerdo<br>
  
  <label>24. La relación con mis compañeros de trabajo es limitada. *</label>
  <br>
           <input type="radio" name="uno" value="1"> Totalmente en desacuerdo<br>
  <input type="radio" name="dos" value="2"> . En desacuerdo
<br>
  <input type="radio" name="tres" value="3"> Ni de acuerdo ni en desacuerdo<br>
   <input type="radio" name="cuatro" value="4"> De acuerdo<br>
  <input type="radio" name="cinco" value="5"> Totalmente de acuerdo<br>
  
  <label>25. Prefiero estar solo que mal acompañado. *</label>
  <br>
           <input type="radio" name="uno" value="1"> Totalmente en desacuerdo<br>
  <input type="radio" name="dos" value="2"> . En desacuerdo
<br>
  <input type="radio" name="tres" value="3"> Ni de acuerdo ni en desacuerdo<br>
   <input type="radio" name="cuatro" value="4"> De acuerdo<br>
  <input type="radio" name="cinco" value="5"> Totalmente de acuerdo<br>
  
  <label>26. A veces soy inmaduro en mi trabajo. *</label>
  <br>
           <input type="radio" name="uno" value="1"> Totalmente en desacuerdo<br>
  <input type="radio" name="dos" value="2"> . En desacuerdo
<br>
  <input type="radio" name="tres" value="3"> Ni de acuerdo ni en desacuerdo<br>
   <input type="radio" name="cuatro" value="4"> De acuerdo<br>
  <input type="radio" name="cinco" value="5"> Totalmente de acuerdo<br>
  
  <label>27. Me enojo muy rápido si alguien me contradice. *</label>
  <br>
           <input type="radio" name="uno" value="1"> Totalmente en desacuerdo<br>
  <input type="radio" name="dos" value="2"> . En desacuerdo
<br>
  <input type="radio" name="tres" value="3"> Ni de acuerdo ni en desacuerdo<br>
   <input type="radio" name="cuatro" value="4"> De acuerdo<br>
  <input type="radio" name="cinco" value="5"> Totalmente de acuerdo<br>
  
  <label>28. Soy agresivo con aquellos que me provocan. *</label>
  <br>
           <input type="radio" name="uno" value="1"> Totalmente en desacuerdo<br>
  <input type="radio" name="dos" value="2"> . En desacuerdo
<br>
  <input type="radio" name="tres" value="3"> Ni de acuerdo ni en desacuerdo<br>
   <input type="radio" name="cuatro" value="4"> De acuerdo<br>
  <input type="radio" name="cinco" value="5"> Totalmente de acuerdo<br>
  
  <label>29. Soy tímido, me cuesta trabajo hablar con desconocidos. *</label>
  <br>
           <input type="radio" name="uno" value="1"> Totalmente en desacuerdo<br>
  <input type="radio" name="dos" value="2"> . En desacuerdo
<br>
  <input type="radio" name="tres" value="3"> Ni de acuerdo ni en desacuerdo<br>
   <input type="radio" name="cuatro" value="4"> De acuerdo<br>
  <input type="radio" name="cinco" value="5"> Totalmente de acuerdo<br>
  
  <label>30. Puedo ser irrespetuoso. *</label>
  <br>
           <input type="radio" name="uno" value="1"> Totalmente en desacuerdo<br>
  <input type="radio" name="dos" value="2"> . En desacuerdo
<br>
  <input type="radio" name="tres" value="3"> Ni de acuerdo ni en desacuerdo<br>
   <input type="radio" name="cuatro" value="4"> De acuerdo<br>
  <input type="radio" name="cinco" value="5"> Totalmente de acuerdo<br>
  <button>Enviar</button>
</form>
  

  </div>
  

        
        

    
  </body>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"/>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"/>
</html>
