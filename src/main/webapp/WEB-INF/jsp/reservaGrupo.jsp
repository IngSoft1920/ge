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
	
	<form method="POST" action="${reservaGrupoBean.method}" modelAttribute="reservaGrupoBean">
	
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
			<input type="text" name="nombreGrupo" path="nombreGrupo" placeholder="Introduce el nombre del grupo..."/> 
			</div>
			

			<select id="tipoGrupo">
  			<option value="empresarial">Empresarial</option>
  			<option value="boda">Boda o bautizo</option>
			<option value="equipo deportivo">Equipo deportivo</option>
			<option value="fin de curso">Viaje de fin de curso</option> 
			<option value="otro">Otro</option>  
			</select>
            
            <div>
            <input type="text" id="email" name="email" path="email" placeholder="Introduce el correo electronico del representante..."/>
            </div>
			
			<div>
			<select name="hotel">
				<option value="">Hotel</option>
					<c:forEach items="${ListaHotel}" var="hotel">
						<option value="${hotel.nombre}">${hotel.nombre} en ${hotel.ciudad} con ${hotel.estrellas} estrellas</option>
					</c:forEach>
			</select>
			</div>

			<div>
				<label for="numeroHabitaciones"> Reserva hasta 30 habitaciones</label>
				<input type="number" id="numeroHabitaciones" name="numeroHabitaciones" path="numeroHabitaciones" min="5" max="20"/>
			</div>

			
			<div class="container reserva" id="container_boton">
			<a href="/metodopago"> Enviar reserva de grupo </a>
			</div>
			</div>
			</div>
	</form>


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