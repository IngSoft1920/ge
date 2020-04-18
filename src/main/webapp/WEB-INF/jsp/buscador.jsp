
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="cabecera.jsp"></jsp:include>


<html>
<head>


<title>Buscador</title>


<meta charset="utf-8">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
  
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
  

<meta name="viewport" content="width=device-width, initial-scale=1">


<link rel="stylesheet" type="text/css" href="/css/buscador.css"
	media="screen" />
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">

</head>

<div class="container-fluid" id="buscadorTodo">

	<form:form method="POST" action=""
		modelAttribute="busquedaBean">
		<div class="buscador">
			<br>
			<br>
			<br>
			<br>
			<div class="buscar">
				<h2>Encuentra tu mejor oportunidad:</h2>
				<p class="postbuscar">
					<i>Y disfruta de esta gran experiencia con nosotros</i>
				</p>
				<br>
			</div>
			<div class="espacio"></div>

	<div class="container bg-dark" id="container_de_buscar">
	<br>
		<div class="row">
					
					<div class="col-md">
						<div class="container" id="container_de_columnas">
							<div class="icon">
								<i class="fa fa-calendar"></i>
							</div>
							<form><input type="text" name="fechaInicio" path="fechaInicio"
								placeholder="Entrada" onfocus="(this.type='date')"
								onblur="(this.type='text')" required>
								</form>
						</div>
					</div>

					<div class="col-md">
						<div class="container" id="container_de_columnas">
							<div class="icon">
								<i class="fa fa-calendar"></i>
							</div>
							<form:input type="text" name="fechaFin" path="fechaFin"
								placeholder="Salida" onfocus="(this.type='date')"
								onblur="(this.type='text')" />
						</div>
					</div>
					
					<div class="col-md">
						<div class="container" id="container_de_columnas">
							<div class="icon">
								<i class="fa fa-map-marker"></i>
							</div>
							<select name="ciudad">
								<option value="">Ciudad</option>
								<c:forEach items="${ciudades}" var="ciudad">
									<option value="${ciudad}">${ciudad}</option>
								</c:forEach>
							</select>
						</div>
					</div>


					<div class="col-md">
						<div class="container" id="container_de_columnas">
							<div class="icon">
								<i class="fa fa-search"></i>
							</div>							
							<select name="hotel">
								<option value="">Hotel</option>
								<c:forEach items="${hoteles}" var="hotel">
									<option value="${hotel.nombre}">${hotel.nombre}</option>
								</c:forEach>
							</select>							
						</div>
					</div>
					


					<div class="col-md">
						<div class="container" id="container_de_columnas">
							<div class="icon">
  							<div class="spinner-grow text-light"></div>
  							</div>
							<input type="submit" id="search" value="Search">
							</div>
					</div>
					
				
			</div>
			<br>
			</div>
			<div class="container">
			<div class="row">
			<div class="ml-auto" id="garantizado">
			<div class="icon"><i class="fa fa-plus"></i></div>
			<pre style= color:white>
			
<b>	MEJOR PRECIO
	GARANTIZADO</b>
			</pre>
			</div>
			</div>
			</div>
			<br> <br> <br> <br> <br> <br> <br>
		</div>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
	</form:form>
	<br> <br> <br> <br> <br> <br> <br>

</div>



<ul class="list">

	<c:forEach items="${hotelesDisponibles.hoteles}" var="hotel">
		<div class="rehabitacion">
		<br>
		<br>
			<li class="list2">
				<div class="encabecadohotel">
					<h2 style="display: center">Hotel ${hotel.nombre} en ${hotel.ciudad}</h2>
				</div>

				<div class="habitacion">
					<div class="columnaHabitacion">
					
					<div class="mitadColumnaHabitacion">
					<h3>Habitaciones:</h3>	
					<br>
					<div class="imagenHabitacionGrande">
<img src="/imagenes/habitacion.jpg" />
</div>
									

						</div>			
								

				<div class="mitadColumnaHabitacion">
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
						<c:forEach items="${hotel.habitaciones}" var="habitacion">

							<div class="habitacionTipo">
								<ul class="habitacion">
									<li class="habitacionLI">${habitacion.nombre}</li>
									<br>
								</ul>
							</div>

						</c:forEach>
						
						</div>
					</div>

					<div class="columnaHabitacion">
<div class="mitadColumnaHabitacion">
						<h3>Tarifas:</h3>
						<br>
						<div class="imagenHabitacionGrande">
<img src="/imagenes/hotelpeople.jpg" />
</div>
	</div>
	
	<div class="mitadColumnaHabitacion">
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
						<c:forEach items="${hotel.habitaciones}" var="habitacion">
						
							<div class="habitacionTipo">
								<ul class="habitacion">

									<li class="habitacionLI">${habitacion.precio_total}
									<br>
									<br>
									</li>
									
								</ul>
							</div>

						</c:forEach>
						</div>
						

					</div>
					
					
	<div class="mitadComida">				
	<br>
									<h3>Comidas:</h3>
									</div>
									
					<br>
				
					<c:forEach items="${hotel.habitaciones}" var="habitacion">
							<div class="bucle">
						<form:form method="POST" action="reservar"
							modelAttribute="reserva">
							<div class="columnaHabitacion">

				<div class="selectComidas">							
								
								<select name="comidas">
									<option value="+0, s�lo alojamiento">+0, s�lo
										alojamiento</option>
									<option value="+15, alojamiento y desayuno">+15,
										alojamiento y desayuno</option>
									<option value="+30, pensi�n completa">+30, pensi�n
										completa</option>
								</select>
								</div> 
							
							</div>
							
							<input type="hidden" name="habitacion_id"
									value="${habitacion.tipo_hab_id}" />
							<input type="hidden" name="hotel_id" value="${hotel.id}" />
							<input type="hidden" name="fecha_inicio" value="${busquedaBean.fechaInicio}" />
							<input type="hidden" name="fecha_fin" value="${busquedaBean.fechaFin}" />
							<input type="hidden" name="tarifa" value="${habitacion.precio_total}" />
							
							<div class="columnaHabitacion">
								<div class="habitacionTipo">
									<ul class="habitacion">										
										<input type="submit" value="Reservar" />
									</ul>
								</div>
							</div>
							

						</form:form>
						</div>
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

<div class="imagenHabitacionGrande">
<img src="/imagenes/habitacion.jpg" />
</div>
















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


