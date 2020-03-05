<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="cabecera.jsp"></jsp:include>


<html>
<head>


<title>Buscador</title>


<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" type="text/css" href="/css/buscador.css" media="screen" />
</head>

<div class="contenido">

	<form:form method="POST" action="buscador"
		modelAttribute="busquedaBean">
		<div class="buscador">
			<br>
			<div class="buscar">
				<h2>Encuentra tu mejor oportunidad:</h2>
				<p class="postbuscar">
					<i>Y disfruta de esta gran experiencia con nosotros</i>
				</p>
				<br>
			</div>


			<div class="fila">
				<div class="columna">
					<h3>Fecha inicio</h3>
					<form:input type="date" name="fechaInicio" path="fechaInicio" />
				</div>

				<div class="columna">
					<h3>Fecha salida</h3>
					<form:input type="date" name="fechaFin" path="fechaFin" />
				</div>


				<div class="columna">

					<h3>Ciudad</h3>
					<select name="ciudad">
						<option value="">(Opcional)</option>
						<c:forEach items="${busquedaBean.ciudades}" var="ciudad">
							<option value="${ciudad}">${ciudad}</option>
						</c:forEach>
					</select>
				</div>

				<div class="columna">
					<h3>Hotel</h3>
					<select name="hotel">
						<option value="">(Opcional)</option>
						<c:forEach items="${busquedaBean.hoteles}" var="hotel">
							<option value="${hotel}">${hotel}</option>
						</c:forEach>
					</select>
				</div>



			</div>
		</div>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>

		<div class="buttonSearch">
			<input type="submit" id="search" value="Search">

		</div>

	</form:form>

</div>


<br>
<br>


<ul id="list">

	<c:forEach items="${hotelesDisponiblesBean.hoteles}" var="hotel">
		<div class="rehabitacion">
			<li>
				<div class="encabecadohotel">
					<h2 style="display: inline">Hotel ${hotel.nombre}</h2>
					<h2 style="display: inline">en ${hotel.ciudad}</h2>
				</div>

				<div class="habitacion">
					<div class="columnaHabitacion">
						<h3>Habitaciones:</h3>

						<c:forEach items="${hotel.habitaciones}" var="habitacion">

							<div class="habitacionTipo">
								<ul class="habitacion">


									<li class="habitacionLI">${habitacion.tipo}</li>
								</ul>
							</div>

						</c:forEach>
					</div>

					<div class="columnaHabitacion">

						<h3>Tarifas:</h3>
						<c:forEach items="${hotel.habitaciones}" var="habitacion">
							<div class="habitacionTipo">
								<ul class="habitacion">

									<li class="habitacionLI">${habitacion.tarifa}</li>
								</ul>
							</div>

						</c:forEach>

					</div>
					<!--  
					<div class="columnaHabitacion">

						<h3>¿Comida?</h3>

						

						<div class="tarifas">


							<ul>
								<li>

									<form method="POST" action="reservarTarifa">

										<button value="cero">+0 extra: alojamiento</button>

										<input type="hidden" name="optionComida" value=" 0 " />


										<c:forEach items="${hotel.habitaciones}" var="habitacion">
											<input type="hidden" name="habitacionId"
												value="${habitacion.getId()}" />

										</c:forEach>

									</form>
								</li>

								<li>

									<form method="POST" action="reservarTarifa">

										<button value="desayuno">+ ${hotel.desayuno} extra:
											alojamiento + desayuno</button>

										<input type="hidden" name="optionComida"
											value="${hotel.getDesayuno()}" />

										<c:forEach items="${hotel.habitaciones}" var="habitacion">
											<input type="hidden" name="habitacionId"
												value="${habitacion.getId()}" />
										</c:forEach>

									</form>
								</li>


								<li>
									<form method="POST" action="reservarTarifa">

										<button value="pensionCompleta">+
											${hotel.pensionCompleta} extra: pension completa</button>

										<input type="hidden" name="optionComida"
											value="${hotel.getPensionCompleta()}" />

										<c:forEach items="${hotel.habitaciones}" var="habitacion">
											<input type="hidden" name="habitacionId"
												value="${habitacion.getId()}" />
										</c:forEach>
									</form>

								</li>
							</ul>

						</div>

						
				</div>
					<div class="columnaHabitacion">
						<h3>Régimen de Comidas:</h3>
					</div>
					<div class="columnaHabitacion">
						<h3>Reservar:</h3>
					</div>-->
					<c:forEach items="${hotel.habitaciones}" var="habitacion">
						<form:form method="POST" action="reservar">
							<div class="columnaHabitacion">
									<select name="comidas">
										<option value="+0, sólo alojamiento">+0, sólo
											alojamiento</option>
										<option value="+${hotel.desayuno}, alojamiento y desayuno">+${hotel.desayuno},
											alojamiento y desayuno</option>
										<option value="+${hotel.pensionCompleta}, pensión completa">+${hotel.pensionCompleta},
											pensión completa</option>
									</select>
							</div>

							<div class="columnaHabitacion">
								<div class="habitacionTipo">
									<ul class="habitacion">
										<input type="hidden" name="habitacionId"
											value="${habitacion.getId()}" />
										<input type="submit" value="Reservar" />
									</ul>
								</div>
							</div>
						</form:form>
					</c:forEach>
				</div>
			</li>
		</div>
	</c:forEach>
</ul>


<script>
	function showMore() {
		document.getElementById("panel").style.display = "block";
	}

	function showLess() {
		document.getElementById("panel").style.display = "none";
	}
</script>


</body>
</html>

<!-- 

<div class="columnaHabitacion">
	<br>
	<button type="button" onclick="showMore()">+ info</button>
	</div>

<div class="columnaHabitacion">
		<div id="panel">
		<p>..extra</p>
	<button type="button" onclick="showLess()">- info</button>
</div>
</div>

 -->


