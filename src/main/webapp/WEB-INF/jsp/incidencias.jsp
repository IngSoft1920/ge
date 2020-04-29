<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="cabecera.jsp"></jsp:include>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
	<header>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

    </header>




<jsp:useBean id="bean" class="ingsoft1920.ge.BeansGE1.IncidenciasBean" />


<body>
	<style>
 			.container {
                margin-top: 20px;
                margin-bottom: 20px;
                padding: 10px;
                border-color: black;
                border-style: solid;
                background-color: #333;
                opacity: 85%;
                text-align: center;
                color: #b8b070;
            }
            
             #cabecera{
	            background-color: #333;
	            opacity: 90%;
	            border-top-style: solid;
	            border-bottom-style: solid;
	            border-color: black;
	            color: #b8b070;
	            margin-top: 80px; 
	            margin-bottom: 30px;
	        }
         

			.aspecto2 {
				text-align: center;
				margin-top: 60px;
				margin: 20px;
				padding: 10px;
				background-color: #B0C4DE;
				opacity: 80%;
			}
			
			label {
				font-size: 20px
			}
			
			.parte1 {
				grid-column-start: 1;
				grid-column-end: 5;
			}
			
</style>

	<!-- Cabecera de la pagina -->
	<head>
       <div id="cabecera" class="row justify-content-center">
          <h1 style="font-size: 50px; font-family:Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;">Incidencias</h1>
        </div> 
     </head>
	<!-- Parte de incidencias -->
	<div class="container">
		<div class="row justify-content-center pb-3 ">
            <h3>Procesa tu incidencia</h3>
        </div>
        
		<form:form action="procesarIncidencias" modelAttribute="Incidencia"
			method="post">

			<label>Asunto</label>
			<form:select path="asunto"
				style="margin-top: 5px; margin-bottom: 10px">
				<option value="Limpieza">Limpieza</option>
				<option value="Mantenimiento">Mantenimiento</option>
				<!-- De momento son los asuntos establecidos por DHO -->
			</form:select>
			<%-- <form:input name="asunto" path="asunto" /> --%>
			<br>
			<br>
			<label>Mensaje</label>
			<form:select path="mensaje" id="eleccion"
				style="margin-top: 5px; margin-bottom: 10px">
				<option value="Predeterminado1">Mensaje predeterminado1
					(por establecer)</option>
				<option value="Predeterminado2">Mensaje predeterminado2
					(por establecer))</option>
				<option value="Otro">Otro...</option>
			</form:select>
			<br>
			<div class="row justify-content-center ml-5">
			<textarea id="mensaje2" name="mensaje" class="form-control "
				 rows="5" placeholder="Escribe tu mensaje"  style="display:none; width: 300px;"></textarea>
			</div>
				<br>
				
			<input type="submit" value="Enviar">
			<input type="reset" value="Borrar">
		</form:form>



		<%--  <form action="procesarIncidencias" modelAttribute="Incidencia"
			method="get">
			<!-- </input> <br> <label style="font-size: 18px; margin-right: 10px;">Asunto</label> -->
			<select name="asunto" value="${bean.asunto}"
				style="margin-top: 5px; margin-bottom: 10px">
				<option value="limpieza">Limpieza</option>
				<option value="Mantenimiento">Mantenimiento</option>
				<!-- De momento son los asuntos establecidos por DHO -->

			</select> <br> <label style="font-size: 18px; margin-right: 10px;">Mensaje</label><select
				name="mensaje1" id="eleccion"
				style="margin-top: 5px; margin-bottom: 10px">
				<option value="${bean.mensaje}">Mensaje predeterminado 1
					(por establecer)</option>
				<option value="${bean.mensaje}">Mensaje predeterminado 2
					(por establecer))</option>
				<option value="Otro">Otro...</option>
			</select> <br>
		</form>

		<textarea id="mensaje2" name="mensaje2" class="form-control "
			cols="30" rows="5" placeholder="Escribe tu mensaje" hidden></textarea>

		<br> <input type="submit" value="Enviar"> <input
			type="reset" value="Borrar"> --%>

	</div>
	
	   <!-- Parte de servicios reservados -->
	
	
		<div class="container">
			<div class="row justify-content-center pb-3 ">
	            <h3>Incidencias enviadas</h3>
	                    </div>
	
	
			<div class="row">
				<c:forEach var="incidencias_realizadas" items="${incidencias_realizadas}">
					<div class="col-xl-4 col-md-6 ml-xs-3">
						<div class="card">
							<b name=incidencia_nombre value=${incidencias_realizadas.incidencia_nombre}> Incidencia: ${incidencias_realizadas.incidencia_nombre}</b>
				         	<p>Fecha de reserva: ${incidencias_realizadas.fecha}</p>
				         	<p>Hora de reserva: ${incidencias_realizadas.hora}</p> 
				         </div>
				    </div>
				</c:forEach>
			</div>
		</div>


	<!-- necesario para el script -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"
		integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
		crossorigin="anonymous"></script>
		 
	<!-- Scripts de estilo -->	 
     

	<script>
		$('#eleccion').change(function() {
			var opcion = $(this).val();
			if (opcion == "Otro") {
				$('#mensaje2').show();
			} else {
				$('#mensaje2').hide();
			}
		})
	</script>

</body>
</html>