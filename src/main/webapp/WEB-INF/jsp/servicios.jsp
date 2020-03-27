<%@page import="ingsoft1920.ge.ControllerGE1.ReservarMesaController"%>
<%@page import="ingsoft1920.ge.ControllerGE1.pruebaConexion"%>
<%@page import="ingsoft1920.ge.ControllerGE1.ServiciosController"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="cabecera.jsp"></jsp:include>

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="en">
    <header>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

    </header>

    <body>
	<style>
        .container {
                margin-top: 20px;
                margin-bottom: 20px;
                padding: 10px;
                background-color: #B0C4DE;
                opacity: 80%;
                text-align: center;
            }
        
        label {
            font-size: 20px
        }

        li span {
            color: #fff;
            border: 1px solid #ccc;
            background-color: #808080;
            margin-right: 10px;
            padding: 0 2px;
            border-radius: 4px;
            -moz-border-radius: 4px;
            -webkit-border-radius: 4px;
            -o-border-radius: 4px;
            border-radius: 4px;
            font-weight: bold;
            font-size: 0.8em;
            cursor: pointer;
        }
        </style>

	<!-- Cabecera de la pagina -->
        <header>
            <div class="container">
                <div class="row justify-content-center" >
                    <h1 style="font-size: 50px; font-family:Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;">Servicios</h1>
                    </div> 
                </div>
        </header>
	<!-- Parte reserva de servicios -->

	<div class="container">
		<div class="row justify-content-center pb-3 ">
            <h3>Reserva de servicios</h3>
        </div>
        
		
        
        <!-- Lista de servicios -->
          <form method="get" style="width: 100%;" action="serviciosGet">
            <div class="row ">
                <div class="col pb-3">              
					<select name="servicio" id="tipoServicio">
                        <option value="">tipo de servicio</option>
                        <c:forEach var="servicio" items="${muchas_cosas.servicios}">
                        	<option name=servicios value="${servicio}"> ${servicio} </option>
                        </c:forEach>
                        
				
        
                    </select> 
                    
                </div>
                <div class="col pb-3">
                     <select name="num_personas">
                         <option value="0">Número de personas:</option><option value="1">1</option>
                         <option value="2">2</option>
                         <option value="3">3</option>
                         <option value="4">4</option>
                         <option value="5">5</option>
                         <option value="6">6</option>
                         <option value="7">7</option>
                         <option value="8">8</option>
                         <option value="9">9</option>
                         <option value="10">10</option>
                    </select>
                </div>
                <div class="col pb-3">
                   <input style="border-radius: 5px" type="date" id="fecha_reserva" max="31/12/2020">
                </div>
                <div class="col pb-3">
                    <button id="boton1"> Ver horas </button>
                </div>
            </div>
			
			<!-- Lista de horas -->
            <div id="mostrar" style="display: none" class="row" >
                <div id="horas1" class="col" >
                    <input type="time"  min="09:00" max="18:00" value="12:00">
                </div>
                <!-- Boton de reservar -->
                <div id="reservar1" class="col">
                    <input type="submit" value="Reservar">
                </div>
            </div>
        
	</form>	
			
	</div>


	<!-- Parte reserva de mesa -->

	<div class="container">
		<div class="row justify-content-center pb-3 ">
            <h3>Reserva de mesa</h3>
        </div>
        <!-- Lista de servicios -->
        <form  action="/enviarReserva" method="get" style="width: 100%;">
            <div class="row">
                <div class="col pb-3">
                    <select id="nombreRestaurante" name="nombreRestaurante" >
                        <!--Aquí hay que mostar los nombres de los restaurantes que nos manden-->
                        <option value="">Nombre de restaurante</option>
                        <c:forEach var="restaurante" items="${muchas_cosas.restaurantes}">
                        	<option name=nombreRestaurante value="${restaurante}"> ${restaurante} </option>
                        </c:forEach>
                        
                       
                    </select> 
                    
                </div>
                <div class="col pb-3">
                     <select name="numPersonas">
                         <option value="0">Número de personas:</option>
                         <option value="1">1</option>
                         <option value="2">2</option>
                         <option value="3">3</option>
                         <option value="4">4</option>
                         <option value="5">5</option>
                         <option value="6">6</option>
                         <option value="7">7</option>
                         <option value="8">8</option>
                         <option value="9">9</option>
                         <option value="10">10</option>
                    </select>
                </div>
                <div class="col pb-3">
                   <input style="border-radius: 5px" type="date" id="fecha" name="fecha" max="31/12/2020">
                </div>
                <div id="horas2" class="col pb-3" >
                    <select id="hora" name="hora">
                    	<option value="">Horas disponibles</option>
                        <c:forEach var="horas" items="${muchas_cosas.horasRestaurantes}">
                        	<option name=hora value="${horas}"> ${horas} </option>
                        </c:forEach>
                    </select>
                </div>
                </div>
                <div class="row ">

	                 <!-- Boton de reservar -->
	                <div class="col pt-3">
	                    <input type="submit" value="Reservar">
	                </div>
                </div>
            
            </form>
			
        
		
	</div>
        
        <!-- Parte de encargar comida -->

	<div class="container">
		<div class="row justify-content-center pb-3 ">
            <h3>Encargar comida</h3>
        </div>
        <div class="row">
            <div class="col">
                <a  href=/recibirPlatos class="btn btn-light" type="button"> Ver menú</a>
                <!--Debe redirigir a una pagina similar a la de food and beverage-->
            </div>
            
        </div>
        
       
	</div>
	
	<!--  Parte de reservas realizadas -->
	
	
        
    
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"  crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
   
        </body>
</html>