<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="ingsoft1920.ge.Controller.*"%>


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
	<div class="container" id="blur">
		<div class="container">
			<figure>
				<img
					src="https://images.unsplash.com/photo-1564711165898-67fe8327b433?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1952&q=80">
				<div class="centered">
					<strong>Gestiona tus reservas</strong>
				</div>
			</figure>

			<div class="vertical-menu">
				<a href="#" onclick="toggleReserva()">Mis Reservas</a> <a href="#"
					onclick="toggleHistorial()">Historial</a>
			</div>


			<div class="toggle">
				<div id="misreservas">
					<c:forEach items="${Listareserva}" var="reserva">
						<div class="reserva">
							<p class="hotel">
								Hotel ${reserva.hotel_id} <span class="fecha">De
									${reserva.fecha_entrada} a ${reserva.fecha_salida} </span> <a
									href="https://docs.google.com/viewer?srcid=1goqsQoI22pJ5uJ6oDy6okMzTnl1ZQUhK&pid=explorer&efh=false&a=v&chrome=false&embedded=true"
									target="_blank" class="factura">Ver factura</a>
							</p>
							<p class="habitacion">
								Habitación: ${reserva.tipo_hab_id} <span class="tarifa">Tarifa:${reserva.importe}</span>
								<span class="regimen">Régimen:${reserva.regimen}</span>
							</p>


							<form action="/cancelar/${reserva.reserva_id}" method="POST"><input class="cambiarReserva" type="submit" class="btn"
								value="Cancelar reserva">
							</form>
						</div>
					</c:forEach>
				</div>

				<div id="historial">
					<c:forEach items="${Listareserva}" var="reserva">

						<div class="historial">
							<span>Hotel ${reserva.hotel_id}</span>
							<button class="factura" name="button" value="factura">Ver
								factura</button>

							<p>De ${reserva.fecha_entrada} a ${reserva.fecha_salida}</p>
							<span>Habitación: ${reserva.tipo_hab_id}</span>
							<div class="clasificacion">
								<form method="POST" action="valorar" name="valoracionId">

									<input id="radio1" type="radio" name="estrellas" value="5">
									<label for="radio1">&#9733</label> <input id="radio2"
										type="radio" name="estrellas" value="4"> <label
										for="radio2">&#9733</label> <input id="radio3" type="radio"
										name="estrellas" value="3"> <label for="radio3">&#9733</label>
									<input id="radio4" type="radio" name="estrellas" value="2">
									<label for="radio4">&#9733</label> <input id="radio5"
										type="radio" name="estrellas" value="1"> <label
										for="radio5">&#9733</label>

									<button type="submit" class="botonClasificacion">Enviar</button>

								</form>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>




	<div class="popup2" id="noClick">
		<div id="popup">
			<span class="close" onclick="toggle()">&times;</span>
			<h1>Cambie la reserva</h1>
			<fieldset>
				<div>
					<label for="tipoHabitacion">Seleccione el tipo de
						habitacion deseado: </label> <select id="dropdown">
						<option value="Normal">Normal</option>
						<option value="Suite">Suite</option>
					</select>
				</div>

				<div>
					<label for="tipoComida">Seleccione el tipo pensión deseada:
					</label> <select id="dropdown">
						<option value="Completa">Completa</option>
						<option value="Media">Media</option>
					</select>
				</div>
			</fieldset>
			<button class="enviarCambio" onclick="toggle()" type="submit"
				class="btn">Enviar</button>
			<button class="cancelar" onclick="toggleCancelar()" type="submit">Cancelar
				Reserva</button>
		</div>
	</div>

	<div id="cancelar">
		<span class="close" onclick="toggleCancelar()">&times;</span>
		<h1>¿Está seguro de que quiere cancelar la reserva?</h1>
		<c:forEach var="reserva" items="${reservas}">

		</c:forEach>
		<form:form method="POST" action="cancelar"
			modelAttribute="reservaBean">
			<c:forEach var="reserva" items="${reservas}">
				<c:set var="id" value="${reserva.reserva_id}" />

				<c:if test="${id<0}">
					<input class="SI" type="submit" class="btn" value="SI">
				</c:if>
			</c:forEach>
		</form:form>
		<button class="NO" onclick="toggleCancelar()">NO</button>
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
		
		function cambiarId(id){
			var int = id * -1;
			return int;
		}
	</script>

</body>
</html>