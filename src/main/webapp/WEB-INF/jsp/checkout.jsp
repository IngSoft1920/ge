<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="cabecera.jsp"></jsp:include>


<!DOCTYPE html>
<html lang="en">

    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <style>
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
    background-color: lightsalmon;
    opacity: 50%;
    border: 1px solid rgba(0, 0, 0, 0.8);
    padding: 30px;
    width: 250px;
    margin-top: 30px;
    margin-left: 60px;
    margin-right: 60px;
    }
 .aspecto{
    text-align:center;
    margin-top:60px;
    	margin: 20px;
	padding: 10px;
	background-color: orange;
	opacity: 50%;
    }
        label{
    font-size:20px
    }
    </style>
    <body style="background: radial-gradient(beige, transparent);">
       

        <div style="margin-top:40px; background-color: orange; opacity: 30%;">
     <h1 style="text-align: center;font-size: 50px; font-family:Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;">Check Out</h1>
    </div> 
    
    
    <div class="aspecto">
		<form  method="get" style="width:100%;">
				<label>Hora de salida</label><br>
				<input type="text"  style="margin-top:5px; margin-bottom:10px" size="20" maxlength="9" value="Ej.:14:00" name="reserva" ></input>
    			<br><br>
				<input type="submit" value="Enviar">
		</form>
	</div>
    </body>
</html>
