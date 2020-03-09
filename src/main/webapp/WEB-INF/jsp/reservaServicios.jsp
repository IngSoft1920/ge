<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="cabecera.jsp"></jsp:include>
<%@ page import="ingsoft1920.ge.ControllerGE1.*"%>

<!DOCTYPE html>
<html lang="en">

   <head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
   </head> 
    
    <body>
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
        </style>
        <header>
            <div class="container">
                <div class="row justify-content-center" >
                    <h1 style="font-size: 50px; font-family:Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;">Reservas</h1>
                    </div> 
                </div>
        </header>
    
    
    
    <div class="container" id="container1">


      <script>
      const container = document.getElementById('container1');
      var cards;
      const array = [1,2,3];
      
      for(i=0; i<array.length; i++){
      array[i] = `<div class="row pl-3">
			<h3>Reservas en curso</h3>
          </div>
          <div class="row pl-3 pb-3">
          <div class="col-md-6 pb-3" var="festival">
                <div class="card" onclick="document.location = '/reservas'" style="width: 17rem;">
                    <div class="card-body">
                        <h5 class="card-title">Numero de reserva: </h5>
                        <h6 class="card-subtitle mb-2 text-muted">Fecha de reserva:</h6>
                        <p class="card-text">Nombre del Hotel:<br> Número de habitación:</p>
                        <a href="/checkout" class="btn btn-primary">Check-out</a>
                        <a href="/facturacion" class="btn btn-primary">Factura</a>
                    </div>
                </div>
            </div>
            </div>`;
    
            container.innerHTML += array[i];

      }

            </script>
       

		</div>        
	
     <!--
            <input value=<%=ingsoft1920.ge.ControllerGE1.ReservasController.receivedJSON.get("datosReserva")%> readonly style="margin-top: 5px; margin-bottom: 10px;background-color:#B0C4DE;border: none"></input>
            <br><br> -->
            
        <!-- Realiza tu reserva -->
    <div class="container"> 
        <div class="row pl-3 ">
            <h3> Reservas pendientes </h3>
        </div>
        <div class="row pl-3 pb-3">
            <div class="col-4">
            <div class="card" onclick="document.location = '/reservas'" style="width: 17rem;">
                <div class="card-body">
                    <h5 class="card-title">Numero de reserva: </h5>
                    <h6 class="card-subtitle mb-2 text-muted">Fecha de reserva:</h6>
                    <p class="card-text">Nombre del Hotel:<br> Número de habitación:</p>
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
