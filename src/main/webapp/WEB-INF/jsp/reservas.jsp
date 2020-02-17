<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="cabecera.jsp"></jsp:include>

<!DOCTYPE html>
<html lang="en">

    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <body style="background: radial-gradient(beige, transparent);">
    <style>
            .aspecto {
                margin: 20px;
                padding: 10px;
                background-color: lightsalmon;
                opacity: 30%;
            }

            .parte1 {
                grid-column-start: 1;
                grid-column-end: 5;
            }
            </style>
    <div style="margin-top:40px; background-color: lightsalmon; opacity: 30%;">
     <h1 style="text-align: center;font-size: 50px; font-family:Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;">Reservas</h1>
    </div> 
    <div class="aspecto">
		<div class="parte1">
			<h3>Gestiona tu reserva</h3>
            <form action="/my-handling-form-page" method="post">
            <p> Ver mi reserva:</p>

            <br><br>
            </form>
		</div>        
	</div>
        <!-- Realiza tu reserva -->
    <div class="aspecto"> 
        <div class="parte 2">
            <h3> Accedede a</h3>
            <label for="checkin"> Check in</label>
            <input id=checkin type="button" value="check-in">
            <br><br>
            <label for="checkout"> Check out </label>
            <input id="checkout" type="button" value="check-out">
            <br><br>                                   <label for="factura"> Tu factura</label>           
            <input id= factura type="button" value="factura">
        </div>
        </div>
   
    </body>
</html>
