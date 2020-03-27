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



<title>Datos Personales</title>
</head>
<style>
* {
	box-sizing: border-box;
}

.blanco {
	position: relative;
	margin-top: 100px;
}

.column {
	float: left;
	width: 33%;
	padding: 10px;
	background-color: #ccc;
}

.column2 {
	border-left: 6px solid #b8b078;
	height: 200px;
	position: absolute;
	left: 33%;
}

.column3 {
	border-left: 6px solid #b8b078;
	height: 200px;
	position: absolute;
	left: 66%;
}

.row:after {
	content: "";
	display: table;
	clear: both;
}
</style>
<body>
	<div class="blanco"></div>

	<h3>Escoga una de las siguientes opciones para confirmar su
		reserva</h3>


	<div class="row">
		<div class="column">
			<h2>Introduzca su correo:</h2>
			<form autocomplete="off">
				<label for="email">Email:</label> <input type="text" id="email"
					name="email">
			</form>
		</div>
		<div class="column2"></div>
		<div class="column">
			<h2>Registrese en la web</h2>
			<a href="/signup" value="signup">
				<button class="botonMyHotel">Registrarse</button>
			</a>
		</div>
		<div class="column3"></div>
		<div class="column">
			<h2>Inicie sesión</h2>
			<a href="/login" value="login">
				<button class="botonMyHotel">Log In</button>
			</a>
		</div>
	</div>

</body>
</html>