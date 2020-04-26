<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="ingsoft1920.ge.Controller.*"%>


<jsp:include page="cabecera.jsp"></jsp:include>

<html>
<head>
<title>Mis Reservas</title>
<meta charset="utf-8">
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
					<a href="#" onclick="togglePopUpModificar()">Cancelar reserva</a>
			</div>


			<div class="toggle">
				<div id="misreservas">
					<c:forEach items="${reservas_pendientes}" var="reserva">
						<div class="reserva">
							<p class="hotel">
								Hotel ${reserva.hotel_id} <span class="fecha">De
									${reserva.fecha_entrada} a ${reserva.fecha_salida} </span> <a
									href="http://piedrafita.ls.fi.upm.es:7001/download/f/${sesionBean.usuarioID}"
									target="_blank" class="factura">Ver factura</a>
							</p>
							<p class="habitacion">
								Habitación: ${reserva.tipo_hab} <span class="tarifa">Tarifa:${reserva.importe}</span>
								<span class="regimen">Régimen:${reserva.regimen}</span>
							</p>
							<p class="cambiarReserva" onclick="<c:set var="output" scope="session" value="${reserva.reserva_id}"/>; toggle()" class="btn">Cambiar reserva </p>
							<!--<form action="/cancelar/${reserva.reserva_id}" method="POST"><input class="cambiarReserva" type="submit" class="btn"
								value="Cancelar reserva">
							</form>-->
						</div>
					</c:forEach>
				</div>

				<div id="historial">
					<c:forEach items="${reservas_finalizadas}" var="reserva">

						<div class="historial">
							<span>Hotel ${reserva.hotel_id}</span>
							<a href="http://piedrafita.ls.fi.upm.es:7001/download/f/${sesionBean.usuarioID}"
									target="_blank" class="factura">Ver factura</a>

							<p>De ${reserva.fecha_entrada} a ${reserva.fecha_salida}</p>
							<span>Habitación: ${reserva.tipo_hab}</span>
							<div class="clasificacion">
								<form method="POST" action="valorar" name="valoracionId">

									<input id="radio1" type="radio" name="estrellas" value="5">
									<label for="radio1">&#9733</label> <input id="radio2"
										type="radio" name="estrellas" value="4"> <label
										for="radio2">&#9733</label> <input id="radio3" type="radio"
										name="estrellas" value="3"> <label for="radio3">&#9733</label>
									<input id="radio4" type="radio" name="estrellas" value="2">
									<label for="radio4">&#9733</label> <input id="radio5"
										type="radio" name="estrellas" value="1"> <label
										for="radio5">&#9733</label>

									<button type="submit" class="botonClasificacion">Enviar</button>
									<br>

								</form>
								
							</div>
							
							
							<div class="container" id="botonValoracion">
							<br>
							<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#valoracion" id="escribirValoracion"><i class="fa fa-pencils"></i>Valoracion</button>
							</div>					
								
								
								
								
								
								<div class="modal" id="valoracion">
															
								<form method="POST" action="valorar" name="valoracionId">
								
								<div class="modal-dialog">
    								<div class="modal-content">
    								      <div class="modal-header">
        										<h4 class="modal-title">Valoracion</h4>
        										
        										<button type="button" class="close" data-dismiss="modal" id="close">&times;</button>
     										</div>
    					<div class="modal-body" id="body_del_modal">
    					<hr>			
    						<form>		
       						<div class="form-group" id="puntuar_uno_cinco">
       						
       						
       							Puntuanos:
       							<br>
                        			<input id="radio1" type="radio" name="caras" value="1"> 
									<label for="radio1">&#9786</label>
																	
									<input id="radio2" type="radio" name="caras" value="2">
									<label for="radio2">&#9786</label> 	
									
																		
								<input id="radio3" type="radio" name="caras" value="3"/> 
								<label for="radio3">&#9786</label>	
								
								
								<input id="radio4" type="radio" name="caras" value="4"> 
								<label for="radio4">&#9786</label> 										
									
                        		<input id="radio5" type="radio" name="caras" value="5">
									<label for="radio5">&#9786</label> 									
								
										
                        </div>
                        
                        
                        
                        
                        
                         <div class="form-group">
            				<label for="exampleFormControlInput1" class="col-sm-2 col-form-label">Cabecera:</label>
            				<div class="col-sm-10">
    						<input type="text" class="form-control" id="exampleFormControlInput1" placeholder="Asunto de mi valoracion...">
          					</div>
          				</div>            
                        
                        
                        
                        <div class="form-group">
            			<label for="message-text" class="col-sm-2 col-form-label">Mensaje:</label>
            			<div class="col-sm-10">
            			<textarea class="form-control" id="message-text" rows="10" placeholder="Mi valoracion ... "></textarea>
            			</div>
         				 </div>
                        
                        
                        </form>
                        
 
                        <hr>
                        
      					</div>     
      								<div class="modal-footer">
      								
        								<button type="submit" class="btn btn-danger" data-dismiss="modal" id="enviarValoracion">Enviar</button>
      								</div>    								
    								
    								</div>
    								</div>									

								</form>
								
								</div>	
						
						</div>
					</c:forEach>
				</div>
			</div>
		
		<div id="modificar">
		<h1>¿Que reserva desea cancelar?</h1>
			<c:forEach items="${reservas_pendientes}" var="reserva">
			<div class="modificar">
				<p>Reserva en hotel ${reserva.hotel_id} del ${reserva.fecha_entrada} a ${reserva.fecha_salida}</p>
				<form action="/cancelar/${reserva.reserva_id}" method="POST"><input class="cambiarReserva" type="submit" class="btn"
								value="Cancelar reserva">
			</div>
			</c:forEach>
		</div>
	</div>
</div>
	

	


	<!--<div class="popup2" id="noClick">
		<div id="popup">
			<span class="close" onclick="toggle()">&times;</span>
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
					<label for="tipoComida">Seleccione el tipo pensión deseada:
					</label> <select id="dropdown">
						<option value="Completa">Completa</option>
						<option value="Media">Media</option>
					</select>
				</div>
			</fieldset>
			<button class="enviarCambio" onclick="toggle()" type="submit"
				class="btn">Enviar</button>
			<button class="cancelar" onclick="toggleCancelar()" type="submit">Cancelar
				Reserva</button>
		</div>
	</div>-->

	<div id="cancelar">
		<span class="close" onclick="togglePopUpModificar()">&times;</span>
		<h1>¿Está seguro de que quiere cancelar una reserva?</h1>
		<button class="SI" onclick="toggleModificar()">SI</button>
		<button class="NO" onclick="togglePopUpModificar()">NO</button>
	</div>

	<script>	 
		function toggle(){
			var blur = document.getElementById('blur');
			blur.classList.toggle('active');
			var popup = document.getElementById('popup');
			popup.classList.toggle('active');
		}
		
		function toggleCancelar(){
			var cancelar = document.getElementById('cancelar');
			cancelar.classList.toggle('active');
			var noClick = document.getElementById('noClick');
			noClick.classList.toggle('active');			
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
		
		function togglePopUpModificar() {
			var cancelar = document.getElementById('cancelar');
			var modificar = document.getElementById('modificar');
			if(modificar.classList.contains('active')==false){
			cancelar.classList.toggle('active');
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