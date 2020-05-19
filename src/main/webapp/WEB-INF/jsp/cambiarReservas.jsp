

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="cabecera.jsp"></jsp:include>


<html>
<head>


<title>Cambiar Reserva</title>


<meta charset="utf-8">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>


<meta name="viewport" content="width=device-width, initial-scale=1">


<link rel="stylesheet" type="text/css" href="/css/cambiarReservas.css"
	media="screen" />
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">

</head>

<body>

	<div class="container_fluid">

		<div class="container_fluid" id="blanco"></div>

		<div class="container">


			<br>

			<div class="row" id="encabecadohotel">
				<h3>Hotel:</h3>
				<h2>${reserva.hotel_nombre}</h2>
			</div>

			<br>

			<div class="row" id="row_resumen">
				<div class="col-sm-8">
					<h3>Fecha de estancia:</h3>
					<h2>
						<i class="fa fa-calendar"></i> ${reserva.fecha_entrada}-
						${reserva.fecha_salida}
					</h2>
				</div>

				<div class="col-sm-4">
					<br>
					<div class="row" id="botonCambio">

						<button type="button" class="btn btn-light" data-toggle="modal"
							data-target="#cambioFecha">Cambiar</button>
					</div>
				</div>
			</div>

			<br>
			<hr>
			<br>

			<div class="row" id="row_resumen">
				<div class="col-sm-8">
					<h3>Tipo de habitacion:</h3>
					<h2>
						<i class="fa fa-key"></i> ${reserva.tipo_hab_nombre}
					</h2>
				</div>
				<div class="col-sm-4">
					<br>
					<div class="row" id="botonCambio">
						<button type="button" class="btn btn-light" data-toggle="modal"
							data-target="#cambioHabitacion">Cambiar</button>
					</div>

				</div>
			</div>




			<br>
			<hr>
			<br>



			<div class="row" id="row_resumen">
				<div class="col-sm-8">
					<h3>Regimen comidas:</h3>
					<h2>
						<i class="fa fa-cutlery"></i> ${reserva.regimen}
					</h2>
				</div>

				<div class="col-sm-4">
					<br>
					<div class="row" id="botonCambio">
						<button type="button" class="btn btn-light" data-toggle="modal"
							data-target="#cambioRegimen">Cambiar</button>
					</div>
				</div>
			</div>

			<br>
			<hr>
			<br>



			<div class="row" id="row_resumen">
				<div class="col-sm">
					<h3>Precio total del régimen de comidas:</h3>
					<h2>
						<i class="fa fa-money"></i>${reserva.regimen}</h2>
				</div>
			</div>

			<br>
			<hr>
			<br>

			<div class="row" id="row_resumen">
				<div class="col-sm">
					<h3>Precio Habitación:</h3>
					<h2>
						<i class="fa fa-money"></i> ${reserva.importe}
					</h2>
				</div>
			</div>

			<br>
			<hr>
			<br>




			<c:forEach items="${servicios}" var="servicio">



				<div class="row" id="row_resumen">
					<h3>Servicios contratados:</h3>
					<h2>
						<i class="fa fa-glass"></i>${servicio.tipoServicio}</h2>
				</div>

				<br>
				<hr>
				<br>


				<div class="row" id="row_resumen">
					<div class="col-sm-8">
						<h3>Numero de personas para ${servicio.tipoServicio}:</h3>
						<h2>
							<i class="fa fa-sort-numeric-desc"></i> ${servicio.numPersonas}
						</h2>
					</div>
					<div class="col-sm-4">
						<br>
						<div class="row" id="botonCambio">
							<button type="button" class="btn btn-light" data-toggle="modal"
								data-target="#cambioNumeroServicio">Cambiar</button>
						</div>
					</div>
				</div>

				<br>
				<hr>
				<br>


				<div class="row" id="row_resumen">
					<div class="col-sm-8">
						<h3>Fecha:</h3>
						<h2>
							<i class="fa fa-calendar"></i> ${servicio.fecha}
						</h2>
					</div>
					<div class="col-sm-4">
						<br>
						<div class="row" id="botonCambio">
							<button type="button" class="btn btn-light" data-toggle="modal"
								data-target="#cambioFechaServicio">Cambiar</button>
						</div>
					</div>
				</div>


				<br>
				<hr>
				<br>

				<div class="row" id="row_resumen">
					<div class="col-sm-8">
						<h3>Hora:</h3>
						<h2>
							<i class="fa fa-clock-o"></i> ${servicio.hora}
						</h2>
					</div>
					<div class="col-sm-4">
						<br>
						<div class="row" id="botonCambio">
							<button type="button" class="btn btn-light" data-toggle="modal"
								data-target="#cambioHora">Cambiar</button>
						</div>
					</div>
				</div>

				<br>
				<hr>
				<br>

				<div class="row" id="row_resumen">
					<div class="col-sm">
						<h3>Precio:</h3>
						<h2>
							<i class="fa fa-money"></i>${servicio.precio}</h2>
					</div>
				</div>

				<br>
				<hr>
				<br>


			</c:forEach>

			<div class="row" id="row_resumen">
				<div class="col-sm">
					<h3>Tarifa Total:</h3>
					<h2>
						<i class="fa fa-credit-card"></i> ${reserva.importe}
					</h2>
				</div>
			</div>

			<br> <br>
			<div class="container_fluid" id="container_boton">
				<div class="row">
					<div class="col-sm" id="columna_abajao_botones">
						<button type="button" class="btn btn-light" data-toggle="modal"
							data-target="#cancelar">Mas opciones</button>
					</div>
					<div class="col-sm-offset-*" id="columna_abajao_botones">
						<form:form action="guardarDatos" method="POST">
							<input type="submit" value="Guardar">
						</form:form>
					</div>
				</div>
			</div>

			<br> <br>
		</div>




	</div>

	<div class="modal" id="cancelar">

		<div class="modal-dialog">
			<div class="modal-content">

				<div class="modal-header">

					<button type="button" class="close" data-dismiss="modal" id="close">&times;</button>

				</div>

				<div class="modal-body" id="body_del_modal">
					<div id="cancelarBoton">
						<form action="/cancelar/${reserva.reserva_id}" method="POST">
							<input class="cambiarReserva" type="submit" class="btn"
								value="Cancelar reserva">
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>


	<div class="modal" id="cambioFecha">

		<div class="modal-dialog">
			<div class="modal-content">

				<div class="modal-header">
					<h4 class="modal-title">
						Cambia la fecha de la reserva
						<hr>
					</h4>


					<button type="button" class="close" data-dismiss="modal" id="close">&times;</button>

				</div>

				<div class="modal-body" id="body_del_modal">

					<form:form method="POST" action="cambiarReserva">
						<input type="hidden" name="hotel_id" value="${reserva.hotel_id}">

						<div class="containe_fluid">
							<div class="row" id="inputs">

								<div class="col">
									<input type="text" name="fechaInicio" path="fechaInicio"
										placeholder="Entrada" onfocus="(this.type='date')"
										onblur="(this.type='text')" />
								</div>

								<div class="col">
									<input type="text" name="fechaFin" path="fechaFin"
										placeholder="Salida" onfocus="(this.type='date')"
										onblur="(this.type='text')" />
								</div>

							</div>
							<br>

							<div class="row" id="botonCambiar">

								<input type="submit" disabled="disabled" class="btn btn-danger"
									id="cambiarFecha" value="Cambiar">
							</div>

						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>



	<div class="modal" id="cambioFechaServicio">

		<div class="modal-dialog">
			<div class="modal-content">

				<div class="modal-header">
					<h4 class="modal-title">
						Cambia la fecha del servicio
						<hr>
					</h4>


					<button type="button" class="close" data-dismiss="modal" id="close">&times;</button>

				</div>

				<div class="modal-body" id="body_del_modal">

					<form:form method="POST" action="cambiarServicio">
						<input type="hidden" name="hotel_id" value="${reserva.hotel_id}">

						<div class="containe_fluid">
							<div class="row" id="inputs">

								<div class="col">
									<input type="text" name="fechaInicio" path="fechaInicio"
										placeholder="Entrada" onfocus="(this.type='date')"
										onblur="(this.type='text')" />
								</div>

								<div class="col">
									<input type="text" name="fechaFin" path="fechaFin"
										placeholder="Salida" onfocus="(this.type='date')"
										onblur="(this.type='text')" />
								</div>

							</div>
							<br>

							<div class="row" id="botonCambiar">

								<input type="submit" disabled="disabled" class="btn btn-danger"
									id="cambiarFecha" value="Cambiar">
							</div>

						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>



	<div class="modal" id="cambioNumeroServicio">

		<div class="modal-dialog">
			<div class="modal-content">

				<div class="modal-header">
					<h4 class="modal-title">
						Cambia el numero de personas en el servicio
						<hr>
					</h4>


					<button type="button" class="close" data-dismiss="modal" id="close">&times;</button>

				</div>

				<div class="modal-body" id="body_del_modal">

					<form:form method="POST" action="cambiarReserva">
						<input type="hidden" name="hotel_id" value="${reserva.hotel_id}">

						<div class="containe_fluid">
							<div class="row" id="inputs">

								<div class="col">
									<select name="numeroPersonas">
										<option value="0">Personas:</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
								<option value="7">7</option>
								<option value="8">8</option>
								<option value="9">9</option>
								<option value="10">10</option>
									</select>
									<%--
									<form:select name="numeroPersonas" path="numeroPersonas">
								<option value="0">Personas:</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
								<option value="7">7</option>
								<option value="8">8</option>
								<option value="9">9</option>
								<option value="10">10</option>							
									
									</form:select>
									
									--%>

								</div>

								<div class="col" id="botonCambiarRow">
									<input type="submit" disabled="disabled" class="btn btn-danger"
										id="cambiarFecha" value="Cambiar">
								</div>

							</div>
							<br>

						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>





	<div class="modal" id="cambioHabitacion">

		<div class="modal-dialog">
			<div class="modal-content">

				<div class="modal-header">
					<h4 class="modal-title">
						Cambia el tipo de habitación
						<hr>
					</h4>


					<button type="button" class="close" data-dismiss="modal" id="close">&times;</button>

				</div>

				<div class="modal-body" id="body_del_modal">

					<form:form method="POST" action="cambiarReserva">
						<input type="hidden" name="hotel_id" value="${reserva.hotel_id}">

						<div class="containe_fluid">
							<div class="row" id="inputs">

								<div class="col">
									<select name="habitaciones">
										<option value="1">premiun</option>
										<option value="2">normal</option>
									</select>
									<%--
									<form:select name="comidas" path="habitacion">
									
									<c:forEach items="${hotel.habitaciones}" var="habitacion">
										<option value="${habitacion.nombre}">${habitacion.nombre}</option>
									</c:forEach>
									
									</form:select>
									
									--%>

								</div>

								<div class="col" id="botonCambiarRow">
									<input type="submit" disabled="disabled" class="btn btn-danger"
										id="cambiarFecha" value="Cambiar">
								</div>

							</div>
							<br>

						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>



	<div class="modal" id="cambioRegimen">

		<div class="modal-dialog">
			<div class="modal-content">

				<div class="modal-header">
					<h4 class="modal-title">
						Cambia Regimen de comidas
						<hr>
					</h4>


					<button type="button" class="close" data-dismiss="modal" id="close">&times;</button>

				</div>

				<div class="modal-body" id="body_del_modal">

					<form:form method="POST" action="cambiarReserva">
						<input type="hidden" name="hotel_id" value="${reserva.hotel_id}">

						<div class="containe_fluid">
							<div class="row" id="inputs">

								<div class="col">
									<select name="comida">
										<option value="1">+0 regimen</option>
										<option value="2">+15 pension</option>
									</select>
									<%--
									<form:select name="comidas" path="regimen_comidas">
										<option value="1">+0, sólo alojamiento</option>
										<option value="2">+15, alojamiento y desayuno</option>
										<option value="3">+30, pensión completa</option>
										<option value="3">+45, todo incluído</option>
									</form:select>
									--%>
								</div>

								<div class="col" id="botonCambiarRow">
									<input type="submit" disabled="disabled" class="btn btn-danger"
										id="cambiarFecha" value="Cambiar">
								</div>

							</div>
							<br>


						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>


</body>
</html>