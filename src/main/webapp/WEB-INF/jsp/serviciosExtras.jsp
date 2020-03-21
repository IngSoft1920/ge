
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

<form:form method="POST" action="reservarServicios" modelAttribute="reservasBean">
	<div class="mitad_fila">
	<h3> SPA </h3>

	<div class="imagenfila">
	
	<img src="/imagenes/spa.jpg">
	<div class="centrarTodo">
	¡Apuntate a nuestro spa y di adios al estrés!
	</div>
	<div class="centrarTodo3">
	<select name="num_personas">
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
	<!--
	 <form:input type="text" name="fecha" path="fecha"
								placeholder="Fecha" onfocus="(this.type='date')"
								onblur="(this.type='text')" />	 
		-->
		<input type="text" name="fecha" path="fecha"
								placeholder="Fecha" onfocus="(this.type='date')"
								onblur="(this.type='text')" />
	 </div>
	 
	 	<div class="centrarTodo5">
	   			
			<select name="horas">
                         <option value="0">Ver Horas:</option>
						 <c:forEach items="${horasDisponibles}" var="hora">
						 <option value="${hora}">${hora}</option>
						 </c:forEach>
       </select>

       </div>
	   
	   
	
	
		<div class="centrarTodo2">
		
<input type="hidden" name="tipoServicio" value="spa"/>
	<input type="submit" id="reservar" value="Reservar">

	</div>
	</div>
	
	</div>
	</form:form>
	
	
	
	
	
	
		<form:form method="POST" action="reservarServicios" modelAttribute="reservasBean">
	
	
	<div class="mitad_fila">
	<h3> PISCINA </h3>
	
	
	<div class="imagenfila">
	<img src="/imagenes/piscina_niña.jpg">
		<div class="centrarTodo">
	¡Ven a nuestra piscina y disfruta como un niño!
	</div>
		<div class="centrarTodo3">
	<select name="num_personas">
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
	<!--
	 <form:input type="text" name="fecha" path="fecha"
								placeholder="Fecha" onfocus="(this.type='date')"
								onblur="(this.type='text')" />	 
		-->
		<input type="text" name="fecha" path="fecha"
								placeholder="Fecha" onfocus="(this.type='date')"
								onblur="(this.type='text')" />
	 </div>
	 
	 	<div class="centrarTodo5">
	   			<select name="horas">
                         <option value="0">Ver Horas:</option>
						 <c:forEach items="${horasDisponibles}" var="hora">
						 <option value="${hora}">${hora}</option>
						 </c:forEach>
       </select>
	   
	   			
			<!-- 
			Lista de horas 
			<button id="boton1"> Ver horas </button>
            <div id="mostrar" style="display: none" class="row" >
                <div id="horas1" class="horas" >
				BLAAAAA
				7:00
				8:00	
				<!--
                    <c:forEach items="${horasDisponibles}" var="hora">
					${hora}
					</c:forEach>
					
                </div>
            </div>
			
			
			
			    <script type="application/javascript">
        	$( "boton1" ).click(function() {
        	  $( "mostrar" ).show( "slow" );
        	});
          
			</script>
			-->
       </div>
	   
	
		<div class="centrarTodo2">

<input type="hidden" name="tipoServicio" value="piscina"/>
	<input type="submit" id="reservar" value="Reservar">
	</div>
	
	</div>
	
	
	</div>
	</form:form>


</div>

<br>
<br>

<div class="botonUltimo">
<a href="misRerservas.jsp"><button> Seguimos con la reserva </button> </a>
</div>


</body>
</html>




