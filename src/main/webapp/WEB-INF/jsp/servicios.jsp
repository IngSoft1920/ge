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
	.grid-container {
		display: grid;
		grid-template-columns: auto auto;
		justify-content: center;
		width:100%;
		}
		
	.container {
		 margin-top: 20px;
		 margin-bottom: 20px;
		 padding: 10px;
		 border-color: black;
		 border-style: solid;
		 background-color: #333;
		 opacity: 85%;
		 text-align: center;
		 color: #b8b070;
		 }
                
     #cabecera{
	            background-color: #333;
	            opacity: 90%;
	            border-top-style: solid;
	            border-bottom-style: solid;
	            border-color: black;
	            color: #b8b070;
	            margin-top: 80px; 
	            margin-bottom: 30px;
	        }
	    .card {
	    		color: #b8b070;
			    background-color: #333;
			    opacity: 90%;
			    border: 2px solid rgba(0, 0, 0, 0.8);
			    padding: 30px;
			    width: 280px;
			    margin-top:20px;
			    margin-left: 50px;
    			margin-right: 50px;
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
        <head>
        	<div id="cabecera" class="row justify-content-center">
        		<h1 style="font-size: 50px; font-family:Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;">Servicios</h1>
        	</div> 
        </head>
	<!-- Parte reserva de servicios -->

	<div class="container">
		<div class="row justify-content-center pb-3 ">
            <h3>Reserva de servicios</h3>
        </div>
        
		
        
        <!-- Lista de servicios -->
          <form method="get" style="width: 100%;" action="/enviarServicios">
            <div class="row">
                <div class="col-xl-3 col-l-4 col-sm-6 pb-3">              
					<select name="tipoServicio" id="servicio">
                        <option value="">tipo de servicio</option>
                        <c:forEach var="servicio" items="${muchas_cosas.servicios}">
                        		<c:if test="${not (servicio =='restaurante')}">
                        	<option name=servicios value="${servicio}"> ${servicio} </option>
                        		</c:if>
                        </c:forEach>
                    </select> 
                    
                </div>
                <div class="col-xl-3 col-l-4 col-sm-6 pb-3">
                     <select name="numPersonas" id="servicio">
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
                <div class="col-xl-3 col-l-4 col-sm-6 pb-3">
                   <input style="border-radius: 5px" type="date" name="fecha" id="fecha_reserva" max="31/12/2020">
                </div>
                
                 <div class="col-xl-3 col-l-4 col-sm-6 pb-3">
                    <select name="hora" id="hora" >
                    	<option value="">Horas disponibles</option>
                        <c:forEach var="hora" items="${muchas_cosas.horasServicios}">
                        	<option name="hora" value="${hora}"> ${hora} </option>
                        </c:forEach>
                    </select>
                </div>
                
                
                	                 <!-- Boton de reservar -->
	                <div class="col">
	                    <input type="submit" value="Reservar" class="btn btn-light" style="margin-bottom:15px; border: 3px solid darkseagreen">
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
                <!--<div class="col-xl-3 col-l-4 col-sm-6 pb-3">
                    <select id="nombreRestaurante" name="nombreRestaurante" >
                        <option value="">Nombre de restaurante</option>
                        <c:forEach var="restaurante" items="${muchas_cosas.restaurantes}">
                        	<option name=nombreRestaurante value="${restaurante}"> ${restaurante} </option>
                        </c:forEach>
                        
                       
                    </select>
                    
                </div>-->
                <div class="col-xl-3 col-l-4 col-sm-6 pb-3">
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
                <div class="col-xl-3 col-l-4 col-sm-6 pb-3">
                   <input style="border-radius: 5px" type="date" id="fecha" name="fecha" max="31/12/2020">
                </div>
                <div class="col-xl-3 col-l-4 col-sm-6 pb-3" >
                    <select id="hora" name="hora">
                    	<option value="">Horas disponibles</option>
                        <c:forEach var="horas" items="${muchas_cosas.horasRestaurantes}">
                        	<option name=hora value="${horas}"> ${horas} </option>
                        </c:forEach>
                    </select>
                </div>
                
                	                 <!-- Boton de reservar -->
	                <div class="col">
	                    <input type="submit" value="Reservar" class="btn btn-light" style="border: 3px solid darkseagreen">
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
                <a  href=/recibirPlatos class="btn btn-light" type="button" style="border: 3px solid darkseagreen"> Ver menú</a>
                <!--Debe redirigir a una pagina similar a la de food and beverage-->
            </div>
            
        </div>
        
       
	</div>
	
	
	
	        <!-- Parte de servicios reservados -->
	
	
		<div class="container">
			<div class="row justify-content-center pb-3 ">
	            <h3>Servicios reservados</h3>
	                    </div>
	
	
			<div class="row">
				<c:forEach var="reservas" items="${muchas_cosas.servicos_reservados}" varStatus="loop">
					<div class="col-xl-4 col-md-6 ml-xs-3">
						<div class="card">
							<b name=tipoServicio value="${reservas}"> Servicio Reservado: ${reservas}</b>
				         	<p>Fecha de reserva: ${muchas_cosas.fechas_reservadas[loop.count - 1]}</p> 
				         </div>
				    </div>
				</c:forEach>
			</div>
		</div>
      
      
	
	
	<!--  Parte de reservas realizadas -->
	
	
        
    
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"  crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
        
        
        
       
    </body>
</html>