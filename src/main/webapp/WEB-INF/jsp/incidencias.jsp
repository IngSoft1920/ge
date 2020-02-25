<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="cabecera.jsp"></jsp:include>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<meta name="viewport" content="width=device-width, initial-scale=1">


<body>
	<style>
.aspecto {
	margin: 20px;
	padding: 10px;
	background-color: #B0C4DE;
	opacity: 80%;
	text-align: center;
	margin-top: 0px;
}

.aspecto2 {
	text-align: center;
	margin-top: 60px;
	margin: 20px;
	padding: 10px;
	background-color: #B0C4DE;
	opacity: 80%;
}

label {
	font-size: 20px
}

.parte1 {
	grid-column-start: 1;
	grid-column-end: 5;
}
</style>

	<!-- Cabecera de la pagina -->
	<div style="margin-top: 40px; background-color: #B0C4DE; opacity: 60%;">
		<h1
			style="text-align: center; font-size: 50px; font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;">Incidencias</h1>
	</div>

	<!-- Parte de incidencias -->
	<div class="aspecto2">
		<form action="/incidencias" method="post">
			<label>Nº Reserva</label> <br>
			<textarea name="idReserva" rows="2" cols="10"
				style="margin-top: 5px; margin-bottom: 15px">
				</textarea>
			<br> <label>Asunto</label> <br> <select name="Asunto"
				style="margin-top: 5px; margin-bottom: 10px">
				<option id="habitacion">Habitacion</option>
				<option id="restaurante">Mantenimiento</option>
				<option id="servicio">Otros...</option>
			</select> <br>
			<br> <label>Mensaje</label><br>
			<textarea name="mensaje" placeholder="Escriba su mensaje"
				style="margin-top: 5px; margin-bottom: 10px">
				</textarea>
			<br>
			<br> <input type="submit" value="Enviar">
		</form>
	</div>

</body>
</html>