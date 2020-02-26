<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="cabecera.jsp"></jsp:include>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Home Page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
#button {
	margin: 0;
	padding: 20;
	overflow: hidden;
	background-color: #333;
}

#button li {
	display: inline;
}

#button li img {
	display: inline-block;
	float: left;
	padding: 0px;
	border: 1px;
	height: 40;
	width: 40;
}

#menu {
	display: inline-block;
	font-family: Arial;
	font-size: 15px;
	float: right;
	padding: 10px;
}

a:link {
	color: white;
	text-decoration: none;
}

a:visited {
	color: white;
	text-decoration: none;
}

a:active {
	color: red;
	text-decoration: none;
}

.hotel {
	font-family: Helvetica;
	padding: 5px;
}

.fecha {
	font-family: Helvetica;
	margin-left: 50px;
	padding: 5px;
}

.habitacion {
	font-family: Helvetica;
	padding: 5px;
}

.tarifa {
	font-family: Helvetica;
	margin-left: 50px;
	padding: 5px;
}

.reserva {
	background-color: #A8F4EA;
	border: 1px solid black;
	margin-top: 10px;
	overflow: hidden
}

.cancelar {
	color: red;
	border: 1px solid #FA220C;
	padding: 5px;
	font-size:15px;
	font-family: Helvetica;
	margin-right: 15px;
	background-color: FFA79B
}

.titulo_historial {
	margin-top: 30px;
	text-align: center;
	font-family: 'Open Sans Condensed', sans-serif;
	font-size: 40px;
	text-decoration: underline;
}

.historial {
	background-color: #A8F4EA;
	border: 1px solid black;
	overflow: hidden;
	padding: 5px;
	font-family: Helvetica;
}

.fondo {
	background-color: D1F0EC;
}

.clasificacion {
	margin-bottom: px;
	margin-right: 20px;
	font-size: 25px;
}

.enviar {
	float: right;
	margin-top: 7px;
	margin-right: 40px
}

input[type="radio"] {
	display: none;
}

label {
	color: black;
}

.clasificacion {
	direction: rtl;
	unicode-bidi: bidi-override;
}

.factura {
	color: blue;
	border: 1px solid blue;
	padding: 5px;
	font-size:15px;
	font-family: Helvetica;
	margin-right: 15px;
	background-color: 73F3E3
}

label:hover, label:hover ~ label {
	color: red;
}

input[type="radio"]:checked ~ label {
	color: red;
}
direction
:
 
rtl
;

      
unicode-bidi
:
 
bidi-override
;

  
}
</style>

</head>
<body>
	<c:forEach items="${misReservasBean.reservas}" var="reserva">
		<div class="reserva">
			<p class="hotel">
				Hotel ${reserva.hotel} en ${reserva.ciudad} 
				<span class="fecha">De ${reserva.fechaInicio} a ${reserva.fechaFin} </span>
					<span><table align="right">
					<tr>
						<td><button class="factura" name="button" value="factura">Ver factura</button></td>
					</tr>
					<tr>
						<td><button class="cancelar" name="button" value="cancelar">Cancelar Reserva</button></td>
					</tr>
					<tr>
						<td><div onclick="document.location = '/buscador'">
          					<a><button class="cancelar" name="button" value="cambiar">Cambiar Reserva</button></a> 
        					</div>
        				</td>
					</tr>	
				</table></span>
			</p>
			<p class="habitacion">
				Habitación: ${reserva.habitacion} <span class="tarifa">Tarifa:${reserva.tarifa}</span>
				<c:remove var="reserva"/>
			</p>	
				
      </div>

	</c:forEach>

		<h2 class="titulo_historial">Historial</h2>
<c:forEach items="${misReservasBean.reservas}" var="reserva">

		<div class="historial">
			<p>Hotel ${reserva.hotel} en ${reserva.ciudad}</p>
			
			<p>De ${reserva.fechaInicio} a ${reserva.fechaFin}</p>
			
			<p>Habitación: ${reserva.habitacion}</p>
			
			<form method="POST" action="valorar" name="valoracionId">
				<div class="clasificacion">
					<input id="radio1" type="radio" name="estrellas" value="5">

					<label for="radio1">&#9733</label> <input id="radio2" type="radio"
						name="estrellas" value="4"> <label for="radio2">&#9733</label>

					<input id="radio3" type="radio" name="estrellas" value="3">

					<label for="radio3">&#9733</label> <input id="radio4" type="radio"
						name="estrellas" value="2"> <label for="radio4">&#9733</label>

					<input id="radio5" type="radio" name="estrellas" value="1">

					<label for="radio5">&#9733</label> <input type="submit">
				</div>
			</form>
		</div>
	</c:forEach>
</body>
</html>