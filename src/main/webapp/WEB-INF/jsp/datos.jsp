<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="cabecera.jsp"></jsp:include>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="/css/datos.css"
	media="screen" />
	
<title>Datos Personales</title>
</head>



<body>
	<div class="blanco"></div>

	<h3>Escoga una de las siguientes opciones para confirmar su
		reserva</h3>


	<div class="row">
		<div class="column">
			<h2>Introduzca su correo:</h2>
			<form:form method="POST" action="reservaAnonima" autocomplete="off">
				<label for="email">Email:</label> 
				<input type="text" id="email"
					name="email">
				<input type="submit" value="Confirmar" >
			</form:form>
		</div>
		<div class="column2"></div>
		<div class="column">
			<h2>Registrese en la web</h2>
			<form:form action="reservaSignup" method="GET" >
				<input type="submit" value="Sign Up" >
			</form:form>
		</div>
		<div class="column3"></div>
		<div class="column">
			<h2>Inicie sesión</h2>
			<form:form action="reservaLogin" method="GET" >
				<input type="submit" value="Log In" >
			</form:form>
				
		</div>
	</div>
	
	<div class="espacio2"> </div>
		
		<div class="container" id="container_resumen">
		
		<br>
		
		<div class="row" id="row_resumen">				
		<h3> Hotel: </h3> <h2>${reservas.nombre_hotel} </h2>
		</div>
		
		<div class="row" id="row_resumen">	
		<h3> Tipo de habitacion: </h3> <h2>${reservas.nombre_habitacion} </h2>
		</div>
		
		<div class="row" id="row_resumen">	
		<h3> Fecha de estancia: </h3> <h2>${reservas.fecha_inicio} -	${reservas.fecha_fin} </h2>
		</div>
		
		<div class="row" id="row_resumen">	
		<h3> Regimen comidas: </h3> <h2> ${reservas.regimen_comidas} </h2>
		</div>		
		
	
		<div class="row" id="row_resumen">	
		<h3> Servicios contratados: </h3> <h2> ${servicio.tipoServicio} </h2>
		</div>
		
		<div class="row" id="row_resumen">	
		<h3> Numero de personas para ${servicio.tipoServicio}: </h3> <h2> ${servicio.numPersonas} </h2> 
		</div>
		
		<div class="row" id="row_resumen">	
		<h3> Fecha: </h3> <h2> ${servicio.fecha} </h2> 
		</div>
		
		<div class="row" id="row_resumen">	
		<h3> Hora: </h3> <h2> ${servicio.hora} </h2> 
		</div>
		
		<div class="row" id="row_resumen">	
		<h3> Precio: </h3> <h2> ${servicio.precio} </h2>	
		</div>	
	
		
		<div class="row" id="row_resumen">	
		<h3> Tarifa Total: </h3> <h2> ${reservas.tarifa} </h2>	
		</div>
				
		<br>
		</div>	
		
	<br> <br>

</body>
</html>