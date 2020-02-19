<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="cabecera.jsp"></jsp:include>

<!DOCTYPE html>
<html lang="en">

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="/ge/src/main/java/ingsoft1920/ge/Controller/ge_Controller.java"></script>
    
    <style>
         .card {
      box-shadow: 0 4px 5px 0 rgba(0,0,0,0.2);
      transition: 0.3s;
      width: 30%;
    }
    
    .card:hover {
      box-shadow: 0 8px 10px 0 rgba(0,0,0,0.2);
    }
    div.w-33 {
  width: 100%;
  background-color: white;
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
    opacity: 60%;
    border: 1px solid rgba(0, 0, 0, 0.8);
    padding: 30px;
    width: 250px;
    margin-top: 30px;
    margin-left: 60px;
    margin-right: 60px;
    }
    </style>
    <body style="background: radial-gradient(beige, transparent);">
       
    <div style="margin-top:40px; background-color: lightsalmon; opacity: 30%;">
     <h1 style="text-align: center;font-size: 50px; font-family:Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;">Check in</h1>
    </div> 
    
    <div style="margin-top:60px; background-color: lightsalmon; opacity: 30%;">
    <h1 style="text-align: left;font-size: 50px; font-family:Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;">Check in</h1>
   </div> 
   <form:form method="POST" action="checkin"
		modelAttribute="CheckInBean">
   <input type="text" size="15"   id="reserva" name="reserva"  style="margin-top:30px;">   Identificador de Reserva
    </input></br>
    <input type="text" size="15"  id="entrada" name="entrada" style="margin-top:30px;">   Hora de Llegada
    </input></br>
    <textarea rows="5" size="15" maxlength="100" name="comentario" style="margin-top:30px">Escribe aqui tu comentario:
    </textarea>

    
       <div class="w-33">
        <div class="center">
          <button type="submit" onclick="submitCheckIn()">
            Enviar
          </button>
          </form:form>
        </div>
      </div></br>

<script>

function submitCheckIn(){
    var reserva = document.getElementById("reserva").value;
    var entrada = document.getElementById("entrada").value;
    
    var myJSON = { "reserva": reserva, "entrada": entrada };
    console.log(myJSON)

    return myJSON;
    
}

</script>
    </body>
</html>
