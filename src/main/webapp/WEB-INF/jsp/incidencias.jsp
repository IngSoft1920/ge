<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="cabecera.jsp"></jsp:include>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<meta name="viewport" content="width=device-width, initial-scale=1">

<%
	String mensaje = request.getParameter("message");
	String asunto;
%>

<body style="background: radial-gradient(beige, transparent);">
	<style>
.aspecto {
	margin: 20px;
	padding: 10px;
	background-color: orange;
	opacity: 50%;
	text-align: center;
	margin-top: 0px;
}

.parte1 {
	grid-column-start: 1;
	grid-column-end: 5;
}
</style>

	<!-- Cabecera de la pagina -->
	<div style="margin-top: 40px; background-color: orange; opacity: 30%;" >
		<h1
			style="text-align: center; font-size: 50px; font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;">Incidencias</h1>
	</div>

	<!-- Parte de incidencias -->
	<div class="aspecto">
		<h3>Incidencias</h3>
		<form action="/procesarIncidencias" method="get">
				<!-- Se supone que el nombre de usuario y el email ya esta metido (ya esta logeado el user) -->
				<label>Asunto:</label> <select>
						<option id="habitacion">Habitacion</option>
						<option id="restaurante">Restaurante - comida</option>
						<option id="servicio">Servicio</option>
				</select>
				<br><br>
				<label>Mensaje:</label> <textarea name="message"></textarea>
				<br><br>
				<input type="submit" value="Enviar">
		</form>
	</div>

</body>
</html>