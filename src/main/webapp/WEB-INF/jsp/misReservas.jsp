<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="ingsoft1920.ge.Controller.*"%>


<jsp:include page="cabecera.jsp"></jsp:include>

<html lang="en">
<head>
<title>Mis Reservas</title>
<meta http-equiv=”Content-Type” content=”text/html; charset=ISO-8859-1″ />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="/css/misReservas.css"
	media="screen" />
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">

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
					<c:forEach items="${reservas_pendientes}" var="reserva">
						<div class="reserva">
							<p class="hotel">
								Hotel ${reserva.hotel_nombre} <span class="fecha">De
									${reserva.fecha_entrada} a ${reserva.fecha_salida} </span> <a
									href="http://piedrafita.ls.fi.upm.es:7001/download/f/${sesionBean.usuarioID}"
									target="_blank" class="factura">Ver factura</a>
							</p>
							<p class="habitacion">
								Habitaci&oacuten: ${reserva.tipo_hab_nombre} <span
									class="tarifa">Tarifa:${reserva.importe}</span> <span
									class="regimen">R&eacutegimen:${reserva.regimen}</span>
							</p>
						</div>
					</c:forEach>
				</div>

				<div id="historial">
					<c:forEach items="${reservas_finalizadas}" var="reserva">

						<div class="historial">
							<span>Hotel ${reserva.hotel_nombre}</span> <a
								href="http://piedrafita.ls.fi.upm.es:7001/download/f/${sesionBean.usuarioID}"
								target="_blank" class="factura">Ver factura</a>

							<p>De ${reserva.fecha_entrada} a ${reserva.fecha_salida}</p>
							<span>Habitaci�n: ${reserva.tipo_hab_nombre}</span>

							<div class="container" id="botonValoracion">
								<br>
								<button type="button" class="btn btn-primary"
									data-toggle="modal" data-target="#valoracion"
									id="escribirValoracion">
									<i class="fa fa-pencils"></i> Valoraci�n
								</button>
							</div>

							<div class="modal" id="valoracion">

								<div class="modal-dialog">
									<div class="modal-content">

										<div class="modal-header">
											<h4 class="modal-title">Valoraci�n</h4>

											<button type="button" class="close" data-dismiss="modal"
												id="close">&times;</button>
										</div>
										<div class="modal-body" id="body_del_modal">
											<hr>
											<form:form method="POST" action="valorar">
												<div class="form-group">
													<input type="hidden" name="hotel_id"
														value="${reserva.hotel_id}">

													<div class="form-group" id="puntuar_uno_cinco">

														<input id="valorvaloracion" type="hidden" name="nota"
															value="0"> Puntuanos: <br>
														<div class="center_horizontal">
															<p class="clasificacion" style="font-size: 30px">
																<input id="radio5" type="radio"> <label
																	for="radio5" onclick="valorar('5');">&#9786</label> <input
																	id="radio4" type="radio"> <label for="radio4"
																	onclick="valorar('4');">&#9786</label> <input
																	id="radio3" type="radio"> <label for="radio3"
																	onclick="valorar('3');">&#9786</label> <input
																	id="radio2" type="radio"> <label for="radio2"
																	onclick="valorar('2');">&#9786</label> <input
																	id="radio1" type="radio"> <label for="radio1"
																	onclick="valorar('1');">&#9786</label>
															</p>
														</div>
													</div>
												</div>

												<div class="form-group">
													<label for="exampleFormControlInput1"
														class="col-sm-2 col-form-label">Cabecera:</label>
													<div class="col-sm-10">
														<input type="text" class="form-control" name="cabecera"
															id="exampleFormControlInput1" value=""
															placeholder="Asunto de mi valoracion...">
													</div>
												</div>

												<div class="form-group">
													<label for="message-text" class="col-sm-2 col-form-label">Mensaje:</label>
													<div class="col-sm-10">
														<textarea class="form-control" id="message-text"
															name="comentario" rows="10" path="comentario"
															placeholder="Mi valoracion ... "></textarea>
													</div>
												</div>
												<hr>
												<div class="modal-footer">
													<input type="submit" disabled="disabled"
														class="btn btn-danger" id="enviarValoracion"
														value="Enviar">
												</div>
											</form:form>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>

		<div id="modificar">
			<h1>�Qu� reserva desea cancelar?</h1>
			<c:forEach items="${reservas_pendientes}" var="reserva">
				<div class="modificar">
					<p>Reserva en hotel ${reserva.hotel_id} del
						${reserva.fecha_entrada} a ${reserva.fecha_salida}</p>
					<form action="/cancelar/${reserva.reserva_id}" method="POST">
						<input class="cambiarReserva" type="submit" class="btn"
							value="Cancelar reserva">
					</form>
				</div>
			</c:forEach>
		</div>
	</div>

	<div class="popup2" id="noClick">
		<div id="popup">
			<span class="close" onclick="toggle(0)">&times;</span>
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
					<label for="tipoComida">Seleccione el tipo pensi�n deseada:
					</label> <select id="dropdown">
						<option value="Completa">Completa</option>
						<option value="Media">Media</option>
					</select>
				</div>
			</fieldset>
			<button class="enviarCambio" onclick="toggle(0)" type="submit"
				class="btn">Enviar</button>
			<input type="hidden" id="id_reserva_cancelar">
			<button class="enviarCambio" onclick="toggleCancelar()" type="submit">Mas opciones</button>
		</div>
	</div>

	<div id="cancelar">
		<span class="close" onclick="toggleCancelar()">&times;</span>
		<h1>�Seguro que desea Cancelar la reserva?</h1>
		<h1 style="font-size: 10px">Cada vez que cancela una reserva
			muere un cachorrito #savethepuppies</h1>
		<br>
		<div class="center_horizontal">
			<input type="button" class="no_cancelar_reserva"
				onclick="toggleCancelar()" value="Atr�s">
		</div>
		<br> <br> <br>
		<form action="/cancelar" method="POST">
			<input type="hidden" id="reserva_a_cancelar" name="reserva_id">
			<div class="center_horizontal">
				<input class="cancelar_reserva" type="submit" class="btn"
					value="Cancelar reserva">
			</div>
		</form>
	</div>

	<script>	 
	
		function valorar(v) {
			var valor = document.getElementById('valorvaloracion');
			valor.value = v;
			var submit = document.getElementById('enviarValoracion');
			submit.disabled = false;
		}
		
		function toggle(reserva_id){
			var blur = document.getElementById('blur');
			blur.classList.toggle('active');
			var popup = document.getElementById('popup');
			popup.classList.toggle('active');
			var id_reserva_cancelar = document.getElementById('id_reserva_cancelar');
			id_reserva_cancelar.value = reserva_id;
		}
		
		function toggleCancelar(){
			var cancelar = document.getElementById('cancelar');
			cancelar.classList.toggle('active');
			var noClick = document.getElementById('noClick');
			noClick.classList.toggle('active');	
			
			var reserva_a_cancelar = document.getElementById('reserva_a_cancelar');
			var id_reserva_cancelar = document.getElementById('id_reserva_cancelar');
			reserva_a_cancelar.value = id_reserva_cancelar.value;
		}
		
		function toggleReserva() {
			var reserva = document.getElementById('misreservas');
			reserva.classList.toggle('active');
			var historial = document.getElementById('historial');
			historial.classList.remove('active');
			var modificar = document.getElementById('modificar');
			modificar.classList.remove('active');
		}
		
		function toggleHistorial() {
			var reserva = document.getElementById('misreservas');
			reserva.classList.remove('active');
			var historial = document.getElementById('historial');
			historial.classList.toggle('active');
			var modificar = document.getElementById('modificar');
			modificar.classList.remove('active');
		}
		
		function togglePopUpModificar(reserva_id) {
			var cancelar = document.getElementById('cancelar');
			cancelar.classList.toggle('active');
			if(cancelar.classList.contains('active')==true){
				var reserva_a_cancelar = document.getElementById('reserva_a_cancelar');
				reserva_a_cancelar.value = reserva_id;
			}
		}
		
		function toggleModificar() {
			var reserva = document.getElementById('misreservas');
			reserva.classList.remove('active');
			var historial = document.getElementById('historial');
			historial.classList.remove('active');
			var modificar = document.getElementById('modificar');
			modificar.classList.toggle('active');
			var cancelar = document.getElementById('cancelar');
			cancelar.classList.remove('active');
		}
	</script>

</body>
</html>