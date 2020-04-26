<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="cabecera.jsp"></jsp:include>
<%@ page import="ingsoft1920.ge.ControllerGE1.*"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8" />



<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
</head>

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

.card {
	background-color: #333;
	opacity: 90%;
	border-style: solid;
	border-color: black;
	margin-bottom: 30px;
	padding: 15px;
}

.body {
	background-color: #4f5457;
}
</style>


	<!-- Cabecera de la pagina -->
<head>
<div id="cabecera" class="row justify-content-center">
	<h1
		style="font-size: 50px; font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;">Reservas</h1>
</div>
</head>



<div class="container">
	<div class="row pl-3">
		<h3>Reservas en curso</h3>
	</div>

	<div class="row">
		<c:forEach var="reserva" items="${reservas}">
			<c:if test="${reserva.estado=='check in'}">
				<div class="col-xl-4 col-md-6 col-sm-12">
					<div class="card">
						<input type=hidden name=nombre_hotel value=${reserva.nombre_hotel}>Nombre
						del Hotel:
						<p>${reserva.nombre_hotel}</p>
						<input type=hidden name=id_reserva value=${reserva.id_reserva}>
						<input type=hidden name=num_hab value=${reserva.num_hab}>Numero
						de Habitacion:
						<p>${reserva.num_hab}</p>
						<input type=hidden name=fecha_inicio value=${reserva.fecha_inicio}>Fecha de inicio:
						<p>${reserva.fecha_inicio}</p>
						<input type=hidden name=fecha_fin value=${reserva.fecha_fin}>

						<form action="/gestionar/${reserva.id_reserva}" method="POST">
							<input type="submit" value="Gestionar">
						</form>

						<form action="/checkout/${reserva.id_reserva}" method="POST">
							<input type="submit" value="Check Out">
						</form>

						<form action="">
							<input type="submit" value="Factura">
						</form>
					</div>
				</div>
			</c:if>
		</c:forEach>
	</div>

</div>


<!-- Realiza tu reserva -->
<div class="container">
	<div class="row pl-3 ">
		<h3>Reservas pendientes</h3>
	</div>


	<div class="row">
		<c:forEach var="reserva" items="${reservas}">
			<c:if test="${reserva.estado=='reserva'}">
				<div class="col-xl-4 col-md-6 col-sm-12">
					<div class="card">
						<input type=hidden name=nombre_hotel value=${reserva.nombre_hotel}>Nombre
						del Hotel:
						<p>${reserva.nombre_hotel}</p>
						<input type=hidden name=id_reserva value=${reserva.id_reserva}>
						<input type=hidden name=num_hab value=${reserva.num_hab}>Numero
						de Habitacion:
						<p>${reserva.num_hab}</p>
						<input type=hidden  id=fecha_inicio name=fecha_inicio
							value=${reserva.fecha_inicio}> Fecha de inicio:
							<p>${reserva.fecha_inicio}</p>
						<input type=hidden
							name=fecha_fin value=${reserva.fecha_fin}>
							
						
						<c:if test="${reserva.fecha_inicio=='2020-04-26'}">
						<%-- <form action="completarCheckin" method="POST"
							onsubmit="return comprobarFecha()">--%>
							 <form action="/checkin/${reserva.id_reserva}" method="POST">   
							<input type="submit" value="Check In">
						</form>
						</c:if>
					</div>
				</div>
			</c:if>
		</c:forEach>
	</div>




</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
	integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
	integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
	crossorigin="anonymous"></script>

<!-- Comprueba que la fecha no sea futura -->
<script>
	function comprobarFecha() {
		var hoy = new Date();

	    var fechainicial = document.getElementById("fecha_inicio").value;

	//	alert(fechainicial);
		
		//fecha actual
		var dd = hoy.getDate();
		var mm = hoy.getMonth() + 1;
		if (dd < 10) {
			dd = '0' + dd;
		}
		if (mm < 10) {
			mm = '0' + mm;
		}
		var yyyy = hoy.getFullYear();
		fecha_actual = yyyy + '-' + mm + '-' + dd;

		if (fechainicial > fecha_actual) {
			alert('No se puede hacer check in hasta el dia: ' +  fechainicial);
			event.preventDefault();
		}
	}
</script>


</body>
</html>