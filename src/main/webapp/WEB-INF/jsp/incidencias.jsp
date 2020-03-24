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
		<form action="/informarIncidencia" method="get">
			<br> <label>Asunto</label> <br> <select name="asunto"
				style="margin-top: 5px; margin-bottom: 10px">
				<option id="LIMPIEZA">Limpieza</option>
				<option id="MANTENIMIENTO">Mantenimiento</option>
				<!-- De momento son los asuntos establecidos por DHO -->
			</select> 
			<br>
			<select name="mensaje"
				style="margin-top: 5px; margin-bottom: 10px">
				<option>Mensaje predeterminado 1 (por establecer)</option>
				<option>Mensaje predeterminado 2 (por establecer))</option>
				<option>Otro...</option>
			</select> 
			
		<!--   <label>Mensaje</label><br>
			<textarea name="mensaje"
				style="margin-top: 5px; margin-bottom: 10px">
				</textarea>-->	
				
				
			<br> <br> <input type="submit" value="Enviar"> <input
				type="reset" value="Borrar">
		</form>
	</div>



</body>
</html>