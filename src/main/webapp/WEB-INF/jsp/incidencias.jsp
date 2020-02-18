<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="cabecera.jsp"></jsp:include>

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
			style="text-align: center; font-size: 50px; font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;">Incidencias</h1>
	</div>

	<!-- Parte de incidencias -->
	<div class="aspecto">
		<h3>Incidencias</h3>
		<form action="/procesarIncidencias" method="get">
			<ul>
				<li><label>Nombre:</label> <input type="text" name="nombre"></li>
				<li><label>Correo electrónico:</label> <input type="email"
					name="email"></li>
				<li><label>Asunto:</label> <select>
						<option>Habitacion</option>
						<option>Restaurante - comida</option>
				</select></li>
				<li><label>Mensaje:</label> <textarea name="message"></textarea></li>
				<li><input type="submit" value="Enviar"></li>
			</ul>
		</form>
	</div>

</body>
</html>