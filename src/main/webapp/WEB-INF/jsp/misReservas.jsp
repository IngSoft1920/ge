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
		
	<div class ="vertical-menu">
	 	<a href="#" onclick ="toggleReserva()">Mis Reservas</a>
  		<a href="#" onclick ="toggleHistorial()">Historial</a>
	</div>
	<form:form method="POST" action="misReservas" modelAttribute="mostarReservasBean">
	<div class="toggle">
	<div id ="misreservas">
	<c:forEach items="${reservas}" var="reserva">
		<div class="reserva">
			<p class="hotel">
				Hotel ${reserva.hotel_id} <span class="fecha">De
					${reserva.fecha_entrada} a ${reserva.fecha_salida} </span>
				<button class="factura" name="button" value="factura">Ver
					factura</button>
			</p>
			<p class="habitacion">
				Habitación: ${reserva.tipo_hab} <span class="tarifa">Tarifa:${reserva.importe}</span><span class="regimen">Régimen:${reserva.regimen}</span>
			<button onclick="toggle()" class ="cambiarReserva">Cambiar reserva</button>
		</div>
	</c:forEach>
	</div>

	<div id="historial">
	<c:forEach items="${reservas}" var="reserva">

		<div class="historial">
			<p>Hotel ${reserva.hotel_id}</p>

			<p>De ${reserva.fecha_entrada} a ${reserva.fecha_salida}
			<button class="factura" name="button" value="factura">Ver
					factura</button>
			</p>
			<p>Habitación: ${reserva.tipo_hab}</p>
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
					<label for="radio5">&#9733</label> 
				
					<button type="submit" class="botonClasificacion">Enviar</button>
					</div>
			</form>
		</div>
	</c:forEach>
	</form:form>
	</div>
	</div>
	
	
	</div>
	</div>
	
	<div class="popup2" id ="noClick">
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
		<button class="cancelar" onclick="toggleCancelar()" type="submit">Cancelar Reserva</button>
	</div>
	</div>
	
	<div id="cancelar">
		<span class="close" onclick="toggleCancelar()">&times;</span>
		<h1>¿Está seguro de que quiere cancelar la reserva?</h1>

		<button class="SI" type="submit" class="btn">SI</button>
		<button class="NO" type="submit">NO</button>
	</div>

	<script>
		function toggle(){
			var blur = document.getElementById('blur');
			blur.classList.toggle('active');
			var popup = document.getElementById('popup');
			popup.classList.toggle('active');
		}
		
		function toggleCancelar(){
			var cancelar = document.getElementById('cancelar');
			cancelar.classList.toggle('active');
			var noClick = document.getElementById('noClick');
			noClick.classList.toggle('active');
			
		}
		
		function toggleReserva() {
			var reserva = document.getElementById('misreservas');
			reserva.classList.toggle	('active');
			var historial = document.getElementById('historial');
			historial.classList.remove('active');
		}
		
		function toggleHistorial() {
			var reserva = document.getElementById('misreservas');
			reserva.classList.remove('active');
			var historial = document.getElementById('historial');
			historial.classList.toggle('active');
		}
	</script>

</body>
</html>