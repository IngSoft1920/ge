<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="cabecera.jsp"></jsp:include>


<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<meta name="viewport" content="width=device-width, initial-scale=1">
<body style="background: radial-gradient(beige, transparent);">
	<style>
.aspecto {
	margin: 20px;
	padding: 10px;
	background-color: lightsalmon;
	opacity: 30%;
}
.parte1 {
	grid-column-start: 1;
	grid-column-end: 5;
}
</style>
	<!-- Cabecera de la pagina -->
	<div
		style="margin-top: 40px; background-color: lightsalmon; opacity: 30%;">
		<h1
			style="text-align: center; font-size: 50px; font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;">Servicios</h1>
	</div>
	<!-- Parte de servicios y reserva -->
	<div class="aspecto">
		<div class="parte1">
			<h3>Servicios</h3>
			<!-- Lista de servicios -->
			<select>
				<option>Spa</option>
				<option>Piscina</option>
			</select>
			<!-- Lista de horas -->
			<select>
				<option>10:00</option>
				<option>10:30</option>
				<option>11:00</option>
				<option>11:30</option>
				<option>12:00</option>
				<option>12:30</option>
				<option>13:00</option>
				<option>13:30</option>
			</select>
			<!-- Boton de reservar -->
			<button type="submit">Reservar</button>
		</div>
	</div>
</body>
</html>