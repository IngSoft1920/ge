<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="cabecera.jsp"></jsp:include>

<html>
<head>
	<title>Home Page</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="/css/misReservas.css"
	media="screen" />

</head>
<body>
	<div class = "container" id ="blur">
	<div class="container">
		<figure>
		<img src="https://images.unsplash.com/photo-1564711165898-67fe8327b433?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1952&q=80">
		<div class="centered"><strong>Gestiona tus reservas</strong></div>
		</figure>
	
	<c:forEach items="${misReservasBean.reservas}" var="reserva">
		<div class="reserva">
			<p class="hotel">
				Hotel ${reserva.hotel} en ${reserva.ciudad} <span class="fecha">De
					${reserva.fechaInicio} a ${reserva.fechaFin} </span>
				<button class="factura" name="button" value="factura">Ver
					factura</button>
			</p>
			<p class="habitacion">
				Habitación: ${reserva.habitacion} <span class="tarifa">Tarifa:${reserva.tarifa}</span>
			<a href="#" onclick="toggle()" class ="cambiarReserva">Cambiar reserva</a>
		</div>

	</c:forEach>

	<h2 class="titulo_historial">Historial</h2>
	<c:forEach items="${misReservasBean.reservas}" var="reserva">

		<div class="historial">
			<p>Hotel ${reserva.hotel} en ${reserva.ciudad}</p>

			<p>De ${reserva.fechaInicio} a ${reserva.fechaFin}</p>

			<p>Habitación: ${reserva.habitacion}</p>
			<form method="POST" action="valorar" name="valoracionId">
				<div class="clasificacion">
					<input id="radio1" type="radio" name="estrellas" value="5">
					<label for="radio1">&#9733</label> 
					<input id="radio2" type="radio" name="estrellas" value="4"> 
					<label for="radio2">&#9733</label>
					<input id="radio3" type="radio" name="estrellas" value="3">
					<label for="radio3">&#9733</label> 
					<input id="radio4" type="radio" name="estrellas" value="2">
					<label for="radio4">&#9733</label>
					<input id="radio5" type="radio" name="estrellas" value="1">
					<label for="radio5">&#9733</label> <input type="submit">
				</div>
			</form>
		</div>
	</c:forEach>
	</div>
	</div>
	
	<div id="popup">
		<span class="close" onclick="toggle()">&times;</span>
		<h1>Cambie la reserva</h1>
		<fieldset>
			<div>
				<label for="tipoHabitacion">Seleccione el tipo de habitacion deseado: </label>
				<select id="dropdown">
					<option value="Normal">Normal</option>
					<option value="Suite">Suite</option>
				</select>
			</div>
			
			<div>
				<label for="tipoComida">Seleccione el tipo pensión deseada: </label>
				<select id="dropdown">
					<option value="Completa">Completa</option>
					<option value="Media">Media</option>
				</select>
			</div>
		</fieldset>
		<button class="enviarCambio" onclick="toggle()" type="submit" class="btn">Enviar</button>
	</div>

	<script>
		function toggle(){
			var blur = document.getElementById('blur');
			blur.classList.toggle('active');
			var popup = document.getElementById('popup');
			popup.classList.toggle('active');
		}
	</script>

</body>
</html>