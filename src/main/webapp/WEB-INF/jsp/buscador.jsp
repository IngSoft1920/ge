<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="cabecera.jsp"></jsp:include>


<html>
<head>

<title>Buscador</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
.buscador {
	height: auto;
	width: 1000px;
	margin: 0 auto;
	display: inline;
	font-family: Arial;
	font-size: 15px;
	float: center;
	padding: 20 px;
	overflow: hidden;
	background-size: cover;
	background-attachment: fixed;
	position: relative;
}

h2 {
	text-align: center;
	font-family: Oldtown, fantasy;
	font-size: 50px;
}

.postbuscar {
	text-align: center;
	font-family: Oldtown, fantasy;
	font-size: 20px;
}

.buscar {
	display: inline;
	Line-Height: 30px;
}

.columna {
	float: left;
	width: 22%;
	padding: 15px;
	text-align: center;
}

@media screen and (max-width: 600px) {
	.columna {
		width: 100%;
	}
}

fila {
	content: "";
	display: table;
	clear: both;
}

h3 {
	font-family: Oldtown, fantasy;
	Line-Height: 5px;
	font-size: 25px;
}

input[type=date] {
	width: 100%;
	padding: 15px 22px;
	margin: 10px 5px;
	border: none;
	background-color: #B0E0E6;
}

input[type=date]:focus {
	background-color: #87CEFA;
	border: 5 px;
}

select {
	font-family: Oldtown, fantasy;
	font-size: 15px;
	width: 100%;
	padding: 15px 22px;
	margin: 10px 5px;
	border: none;
	color: white;
	background-color: #B0E0E6;
}

input[type=button] {
	font-family: Oldtown, fantasy;
	font-size: 25px;
	width: 100%;
	padding: 15px 22px;
	margin: 10px 5px;
	border-color: black;
	background-color: #B0E0E6;
}

input[type=submit] {
	font-family: Oldtown, fantasy;
	font-size: 25px;
	width: 100%;
	padding: 15px 22px;
	margin: 10px 5px;
	border-color: black;
	background-color: #B0E0E6;
}

div {
	margin: -10px -7px -10px -5px;
}

.contenido {
	background-color: #B0C4DE;
}

ul {
	margin-left: -40px;
}

li {
	list-style: none;
}

.encabecadohotel {
	background-color: #DAD5D5;
}

.rehabitacion {
	background-color: #CDCDF7;
}

.habitacion {
	overflow: hidden;
	background-size: cover;
	background-attachment: fixed;
	position: relative;
	margin-top: 30px;
}

.columnaHabitacion {
	float: left;
	width: 22%;
	padding: 15px;
	text-align: center;
}

#panel, button {
	font-family: Oldtown, fantasy;
	font-size: 25px;
	width: 100%;
	padding: 15px 22px;
	margin: 10px 5px;
	background-color: #B0E0E6;
	text-align: center;
	color: white;
	margin: auto;
	border-color: black;
}

#panel {
	display: none;
}


.habitacionTipo{
	font-family: Oldtown, fantasy;
	font-size: 15px;
}

ul.habitacion{

margin: 15px 15px;

}

tarifas{
margin-top: -40px;

}



</style>
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
					<h3>Hotel</h3>

					<select name="hotel">
						<c:forEach items="${busquedaBean.hoteles}" var="hotel">

							<option value="${hotel}">${hotel}</option>
						</c:forEach>
					</select>
				</div>

				<div class="columna">

					<h3>Ciudad</h3>

					<select name="ciudad">
						<c:forEach items="${busquedaBean.ciudades}" var="ciudad">
							<option value="${ciudad}">${ciudad}</option>
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
	
	<h3>Tarifas: </h3>
	<c:forEach items="${hotel.habitaciones}" var="habitacion">
		<div class="habitacionTipo">
			<ul class="habitacion">							
							
				<li class="habitacionLI">${habitacion.tarifa}</li>
			</ul>
		</div>
				
	</c:forEach>
		
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


	<div class="columnaHabitacion">
		<input type="button" onclick="location.href=" #";" value="Reservar" />
	</div>
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

