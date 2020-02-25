<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="cabecera.jsp"></jsp:include>

<!DOCTYPE html>
<html lang="en">

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="/ge/src/main/java/ingsoft1920/ge/Controller/ge_Controller.java"></script>
    
    <style>
 .aspecto{
    text-align:center;
    margin-top:60px;
    	margin: 20px;
	padding: 10px;
	background-color: #B0C4DE;
	opacity: 80%;
    }
    
         .card {
      box-shadow: 0 4px 5px 0 rgba(0,0,0,0.2);
      transition: 0.3s;
      width: 30%;
    }
    
    .card:hover {
      box-shadow: 0 8px 10px 0 rgba(0,0,0,0.2);
    }

div.center {
  text-align: center;
}


    .grid-container {
    display: grid;
    grid-template-columns: auto auto;
    padding: 10px;
    justify-content: center;
    }
    .card {
    background-color: orange;
    opacity: 80%;
    border: 1px solid rgba(0, 0, 0, 0.8);
    padding: 30px;
    width: 250px;
    margin-top: 30px;
    margin-left: 60px;
    margin-right: 60px;
    }
    label{
    font-size:20px
    }
    </style>
    <body>
       
    <div style="margin-top:40px; background-color: #B0C4DE; opacity: 60%;">
     <h1 style="text-align: center;font-size: 50px; font-family:Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;">Check In</h1>
    </div> 
    

<div class="aspecto">
		<form  method="POST" style="width:100%;" action="checkinEnviar" modelAttribute="checkInBean">
				<label>Identificador de reserva</label><br>
				<input type="text" size="20"  name="idReserva" style="margin-top:5px; margin-bottom:10px"></input><br>
				<label>Hora de llegada</label><br>
				<input type="text" size="20"  name="horaLlegada" style="margin-top:5px; margin-bottom:10px"></input><br>
     			<label>D&eacute;jenos su comentario!</label><br>
     			<textarea rows="5" size="20" maxlength="100" name="comentario" style="margin-top:5px; margin-bottom:10px"></textarea>
				<br><br>
				<input type="submit" value="Enviar">
		</form>
	</div>
	
    </body>
</html>
