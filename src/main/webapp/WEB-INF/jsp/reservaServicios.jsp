<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="cabecera.jsp"></jsp:include>
<%@ page import="ingsoft1920.ge.ControllerGE1.*"%>

<!DOCTYPE html>
<html lang="en"  >

   <head >
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="UTF-8"/>

    
    
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
   </head> 
    
    <body >
        <style>
            .container {
                margin-top: 20px;
                margin-bottom: 20px;
                padding: 10px;
                background-color: #B0C4DE;
                opacity: 80%;
            }
            
            .card{
                background-color: #B0C4DE;
                border-color: black; 
            }

            .parte1 {
                grid-column-start: 1;
                grid-column-end: 5;
            }
            .body{
                background-color: #4f5457;
            }
            
            #datos_reserva{
                border-style: solid;
                border-radius: 5px;
                border-color: black;
                width: 300px;
                
            }
            
            
            
        </style>


	    <!-- Cabecera de la pagina -->
        <header>
            <div class="container">
                <div class="row justify-content-center" >
                    <h1 style="font-size: 50px; font-family:Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;">Reservas</h1>
                    </div> 
                </div>
        </header>
    
    
				 
    <div class="container" id="container1">
		<div class="row pl-3">
			<h3>Reservas en curso</h3>
          </div>
           
            <c:forEach var="reserva" items="${reservas}">
            
	         
	          
	           <c:if test="${reserva.estado=='check in'}">
	           
           		 <h5>Identificador de Reserva:</h5>   ${reserva.id_reserva}
                <h5>Numero de Habitacion:</h5>    ${reserva.num_hab}
              	 <h5>Fecha de Inicio:</h5>   ${reserva.fecha_inicio}
              	<h5> Fecha de Fin:</h5>   ${reserva.fecha_fin}
               <h5> Nombre del Hotel: </h5>  ${reserva.nombre_hotel} <br></br>
                
                
                <form action="/gestionar/${reserva.id_reserva}" method="POST">
               <input type="submit" value="Gestionar">
    			
				</form>
               
                 
                  </c:if>
                 
                  	
 
            </c:forEach>
          
	</div> 

            
        <!-- Realiza tu reserva -->
    <div class="container"> 
        <div class="row pl-3 ">
            <h3> Reservas pendientes </h3>
        </div>
        
         <c:forEach var="reserva" items="${reservas}">
            
	         
	          
	           <c:if test="${reserva.estado=='reserva'}">
	           
                <input type=hidden name=id_reserva value=${reserva.id_reserva}>Identificador de Reserva: <p>${reserva.id_reserva}</p> </input> 
                <input type=hidden name=num_hab value=${reserva.num_hab}>Numero de Habitacion:  <p>${reserva.num_hab}</p></input> 
                <input type=hidden name=fecha_inicio value=${reserva.fecha_inicio}>Fecha de Inicio: <p>${reserva.fecha_inicio}</p></input>
                <input type=hidden name=fecha_fin value=${reserva.fecha_fin}>Fecha de Fin: <p>${reserva.fecha_fin}</p></input>
                <input type=hidden name=nombre_hotel value=${reserva.nombre_hotel}>Nombre del Hotel: <p>${reserva.nombre_hotel}</p></input>   
                
                
                
                
            <form action="/checkin/{id}" method="POST">
               <input type="submit" value="Check In">    			
				</form>
                 
                 
                 </c:if>
               
                  	
 
            </c:forEach>
        
        
    </div>
  		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
        
          
    </body>
</html>
