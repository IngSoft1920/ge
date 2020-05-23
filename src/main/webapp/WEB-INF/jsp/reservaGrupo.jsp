<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="cabecera.jsp"></jsp:include>


<html>
<head>


<title>Reserva en grupo</title>


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
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>


<meta name="viewport" content="width=device-width, initial-scale=1">


<link rel="stylesheet" type="text/css" href="/css/buscador.css"
	media="screen" />
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
    rel="stylesheet">
    
<link rel="stylesheet" type="text/css" href="/css/login.css" media="screen" />

</head>

<body class="body box">

	<div>
		<!-- Podemos acceder a tipos basicos (String, int...) mediante esta etiqueta -->
		<br>
		<h1>${mensajeError}</h1>
	</div>
	
	<form:form method="POST" action="reservaGrupo" modelAttribute="reservaGrupoBean">
	
			<div class="cabeza">
			<div class ="text sombraText">
			<div>
			RESERVA DE GRUPO
			</div>
			</div>
			</div>
			
		
			<div class ="text sombraText">
			<div class="boxline">
			<div>
			<input type="text" name="nombre" path="nombre" placeholder="Introduce el nombre del grupo..." required/>

			</div>
			

			<div>
				<label for="tipo"> </label>
				<input type="text" id="tipo" name="tipo" path="tipo" placeholder="Motivo de la reserva en grupo..." required/>
			</div>
            
            <div>
            <input type="text" id="email" name="email" path="email" placeholder="Introduce el correo electronico del representante..." required/>
            </div>
			
			<div>
			<select name="hotel_id" path="hotel_id" required>
				<option value="">Hotel</option>
					<c:forEach items="${ListaHotel}" var="hotel">
						<option value="${hotel.id}">${hotel.nombre} en ${hotel.ciudad} con ${hotel.estrellas} estrellas</option>
					</c:forEach>
			</select>
			</div>

			<div>
				<input type="text" name="fecha_entrada" path="fecha_entrada"
					placeholder="Fecha de entrada..." onfocus="(this.type='date')"
					onblur="(this.type='text')" required>
		</div>
		<div>
				<input type="text" name="fecha_salida" path="fecha_salida"
					placeholder="Fecha de salida..." onfocus="(this.type='date')"
					onblur="(this.type='text')" required>
			</div>
			
			

			<div>
				<label for="numeroHabitaciones"> Reserva hasta 30 habitaciones</label>
				<input type="number" id="numeroHabitaciones" name="numero_habitaciones" path="numero_habitaciones" min="5" max="30"/>
			</div>

			<div>
				<label for="numeroHabitaciones"> Numero de personas</label>
				<input type="number" id="numeroPersonas" name="numero_personas" path="numero_personas" min="5" max="60"/>
			</div>

			
			<div class="container reserva" id="container_boton">
			<input type="submit"></button>
			</div>
			</div>
			</div>
	</form:form>


	<script>
		function mostrarContrasena(x) {
			var tipo = document.getElementById(x);
			if (tipo.type == "password") {
				tipo.type = "text";
			} else {
				tipo.type = "password";
			}
		}
	</script>

</body>
</html>