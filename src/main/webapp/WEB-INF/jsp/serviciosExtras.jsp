


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="cabecera.jsp"></jsp:include>


<html>
<head>


<title>Servicios Extras</title>


<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">


<link rel="stylesheet" type="text/css" href="/css/serviciosExtras.css"
	media="screen" />


</head>

<body>
<div class="ServiciosZona">
<h1 class="tituloServicios"> ¿Quiere algun servicio mas?
<img src="/imagenes/thankyou.gif">
 </h1>

</div>

	

<div class="fila_1">



	 <c:forEach items="${servicios}" var="servicio">
	 
	 	<div class="mitad_fila">
	<h3> ${servicio.nombre} </h3>
	
	
	<div class="imagenfila">
	<img src="/imagenes/${servicio.nombre}.jpg">
		<div class="centrarTodo">
	¡Aprovecha nuestras instalaciones como ${servicio.nombre} y disfruta!
	</div>
	
	<form:form method="POST" action="serviciosExtras" modelAttribute="mostrarServiciosPostReservaBean">
		<div class="centrarTodo3">
	<select name="numPersonas">
                         <option value="0">Personas:</option><option value="1">1</option>
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
	   	<div class="centrarTodo4">

		<input type="text" name="fecha" path="fecha"
								placeholder="Fecha" onfocus="(this.type='date')"
								onblur="(this.type='text')"> </input>
	 </div>
	 
	 	<div class="centrarTodo5">
	   			<select name="horas">
                         <option value="0">Ver Horas:</option>						 
						 <option value="hora">${hora}</option>
						
       </select>
	   
	   			

       </div>
	   
	
		<div class="centrarTodo2">

<input type="hidden" name="tipoServicio" value="${servicio.nombre}"/>
<input type="hidden" name="hotel_id" value="${servicio.id}"/>
	<input type="submit" id="reservar" value="Reservar">
	</div>
		</form:form>
	
	</div>
	
	
	</div>
	 
	 </c:forEach>
	




</div>

<br>
<br>

<div class="botonUltimo">
<a href="misRerservas.jsp"><button> Seguimos con la reserva </button> </a>
</div>


</body>
</html>

