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
		<form action="/informarIncidencia" method="POST">
			<br> <label style="font-size: 18px; margin-right: 10px;">Asunto</label>
			<select name="asunto" style="margin-top: 5px; margin-bottom: 10px">
				<option id="LIMPIEZA">Limpieza</option>
				<option id="MANTENIMIENTO">Mantenimiento</option>
				<!-- De momento son los asuntos establecidos por DHO -->
			</select> <br> <label style="font-size: 18px; margin-right: 10px;">Mensaje</label><select
				name="mensaje" id="eleccion"
				style="margin-top: 5px; margin-bottom: 10px">
				<option value=2>Mensaje predeterminado 1 (por establecer)</option>
				<option value=3>Mensaje predeterminado 2 (por establecer))</option>
				<option value=1>Otro...</option>
			</select> <br>

			<textarea name="mensaje" value="mensaje" class="form-control "
				cols="30" rows="5" placeholder="Escribe tu mensaje" hidden></textarea>

			<br> <input type="submit" value="Enviar"> <input
				type="reset" value="Borrar">
		</form>
	</div>


	<!-- necesario para el script -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"
		integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
		crossorigin="anonymous"></script>

	<script>
		$('#eleccion').change(function() {
			//asigna el valor a la variable opcion
			var opcion = $(this).val();
			//si la opci�n es 1 (otro)
			if (opcion == 1) {
				//muestra el text area de mensaje
				$('#mensaje').show();
			}
			else{
				$('#mensaje').hide();
			}
		})
	</script>

</body>
</html>