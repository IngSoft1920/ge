<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
.card {
	background-color: lightsalmon;
	opacity: 60%;
	border: 1px solid rgba(0, 0, 0, 0.8);
	padding: 30px;
	margin: auto;
	width: 250px;
	text-align: center;
	margin-top: 250px;
}

.boton {
	padding: 20px;
	justify-content: center;
	display: flex;
}
</style>


</head>
<body style="background: radial-gradient(beige, transparent);">


	<div class="card">
		Incidencia enviada con éxito
		<div class="boton">
			<input type="submit" onclick="document.location ='/index'"
				value="Volver al inicio" />
		</div>

	</div>



</body>
</html>