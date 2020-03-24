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
          
          <div id="datos_reserva" class="row ml-5 m-2 p-3">
	          <form  action="/cogerReserva" method="get" style="width: 100%;">
	        		<div class="col-auto">
                        <c:forEach var="num_reserva" items="${todo.num_reserva}">
                            <p><input class="d-none" name="id_reserva" value="${num_reserva}"> <b>N�mero de reserva:</b> ${num_reserva}</p>
                        </c:forEach>
                        
                        <c:forEach var="nombre" items="${todo.nombres}">
                            <p><input class="d-none" name="nombre_hotel" value="${nombre}"> <b>Nombre del hotel:</b>  ${nombre}</p>
                        </c:forEach>
                        
                        <c:forEach var="habitacion" items="${todo.num_hab}">
                            <p><input class="d-none" name="num_hab" value="${habitacion}"> <b>N�mero de habitaci�n:</b> ${habitacion}</p>
                        </c:forEach>
                        
                        <c:forEach var="inicio" items="${todo.fecha_inicial}">
                            <p><input class="d-none" name="fecha_inicio" value="${inicio}"> <b>Fecha de inicio:</b>  ${inicio}</p>
                        </c:forEach>
                        <p><input class="d-none" name="fecha_fin"><b> Fecha de fin:</b>  </p>
                  </div>
                  <div class="col-12">
	        		 <input type="submit" value="Acceder">
                  </div>
                  </form>
                  <div class="col">
                 	 <a href="/checkout" class="btn btn-primary">Check-out</a>
                  </div>
                  <div class="col">
                 	 <a href="/facturacion" class="btn btn-primary">Factura</a>
                  </div>
	        	</div>
           
          
<!--  
      <script>
      const container = document.getElementById('container1');
      const cards = [1,2,3,4];
      
      for(i=0; i<cards.length; i++){
      cards[i] = `
          <div class="row pl-3 pb-3">
          <div class="col-md-6 pb-3" var="festival">
                <div class="card" onclick="document.location = '/index'" style="width: 17rem;">
                    <div class="card-body">
                        <h5 class="card-title">Numero de reserva: </h5>
                        <h6 class="card-subtitle mb-2 text-muted">Fecha de reserva:</h6>
                        <p class="card-text">Nombre del Hotel:<br> N�mero de habitaci�n:</p>
                        <a href="/checkout" class="btn btn-primary">Check-out</a>
                        <a href="/facturacion" class="btn btn-primary">Factura</a>
                    </div>
                </div>
            </div>
            </div>`;
    
            container.innerHTML += cards[i];

      }

            </script>
      --> 

		</div> 
		
		
		
	
     

            
        <!-- Realiza tu reserva -->
    <div class="container"> 
        <div class="row pl-3 ">
            <h3> Reservas pendientes </h3>
        </div>
        <div class="row pl-3 pb-3">
            <div class="col-4">
            <div class="card" onclick="document.location = '/index'" style="width: 17rem;">
                <div class="card-body">
                    <h5 class="card-title">Numero de reserva: </h5>
                    <h6 class="card-subtitle mb-2 text-muted">Fecha de reserva:</h6>
                    <p class="card-text">Nombre del Hotel:<br> N�mero de habitaci�n:</p>
                    <a href="/checkin" class="btn btn-primary" >Check-in</a>
                </div>
            </div>
            </div>
            
        </div>
        
    </div>
  		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
        
          
    </body>
</html>
