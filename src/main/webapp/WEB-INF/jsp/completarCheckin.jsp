<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="cabecera.jsp"></jsp:include>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<header>
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
		integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
		crossorigin="anonymous">

</header>




<jsp:useBean id="bean" class="ingsoft1920.ge.BeansGE1.VerReservasBean" />


<body>
	<style>
.container {
	margin-top: 20px;
	margin-bottom: 20px;
	padding: 10px;
	border-color: black;
	border-style: solid;
	background-color: #333;
	opacity: 85%;
	text-align: center;
	color: #b8b070;
}

#cabecera {
	background-color: #333;
	opacity: 90%;
	border-top-style: solid;
	border-bottom-style: solid;
	border-color: black;
	color: #b8b070;
	margin-top: 80px;
	margin-bottom: 30px;
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
<head>
<div id="cabecera" class="row justify-content-center">
	<h1
		style="font-size: 50px; font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;"></h1>
</div>
</head>
<!-- Rellenar datos que faltan -->
<div class="container">
	<div class="row justify-content-center pb-3 ">
		<h3>Rellene los datos que faltan</h3>
	</div>


	<div>
	
		<label>Tarjeta de crédito <input type="text" id="tarjeta"
			name="tarjeta" /></label> <br> <br> <br>
			
		<%-- <c:forEach var="reserva" items="${reservas}"> --%>
		
		<!-- endpoint de prueba a reserva numero 1 -->
			<form action="/checkin/1" method="post"> 
				<input type="submit" value="Siguiente">
			</form>
			
		<%-- </c:forEach> --%>


	</div>


	<script src="https://code.jquery.com/jquery-3.4.1.min.js"
		integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
		crossorigin="anonymous"></script>




	</body>
</html>