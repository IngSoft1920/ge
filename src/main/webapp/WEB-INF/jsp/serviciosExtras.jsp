<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="cabecera.jsp"></jsp:include>


<html>
<head>


<title>Servicios Extras</title>



  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>


<link rel="stylesheet" type="text/css" href="/css/serviciosExtras.css"
	media="screen" />


</head>

<body>



<div class="container-fluid">

<div class="espacio"></div>

<div class="row">
	<div class="container-fluid" id="ServiciosZona">
	<br>
	<div class="row" id="tituloServicios">	
		<div class="col-sm-8"><br><br><br><h1>DESEA ALGUN SERVICIO MAS... </h1> </div>
		<div class="col-sm-4 d-none d-lg-block"> <img src="/imagenes/thankyou.gif"> </div>		
	</div>
	<br><br>
	</div>
</div>

<div class="row">
	<div class="container-fluid">
	<br><br>

		<c:forEach items="${servicios}" var="servicio">

			<form:form method="POST" modelAttribute="serviciosReservados"
				action="">
				<div class="container-fluid" id="mitad_fila">
				<br>
					<h3>${servicio.nombre}</h3>

					<div class="container-fluid">
					<div class="relativo">
						<img src="/imagenes/${servicio.nombre}.jpg">
					
						<div class="row">
						<div class="col" id="centrarTodo">
						<h2>Aprovecha nuestras instalaciones
							como ${servicio.nombre} y disfruta</h2>
						</div>
						</div>
						
						
						
						<div class="row">				
						
						<div class="col-md d-none d-lg-block" id="centrarTodo"></div>
						
						<div class="col-md btn" id="centrarTodo">
						<br>
							<select name="numPersonas">
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
						</div>
						<br><br><br><br>
						<div class="col-md btn" id="centrarTodo">
						<br>
							<input type="text" name="fecha" placeholder="Fecha"
								onfocus="(this.type='date')" onblur="(this.type='text')"max=${reserva.fecha_fin} min=${reserva.fecha_inicio} />
						</div>
						<br><br><br><br><br>
						
						<div class="col-md btn" id="centrarTodo2">
						
						<input type="hidden" name="precio" value="${servicio.precio}">
						<input type="hidden" name="tipoServicio" value="${servicio.nombre}">
						<input type="hidden" name="id" value="${servicio.id}">
						
						<input type="submit" id="reservar" value="Reservar" />
						</div>
						
						</div>
						</div>
					</div>

				</div>

			</form:form>

		</c:forEach>
	</div>
	</div>

	<br>
	<br>

	<div class="botonUltimo">
		<a href="datos"><button> Continuar con la Reserva </button></a>
	</div>
	
	
	</div>
</body>
</html>

