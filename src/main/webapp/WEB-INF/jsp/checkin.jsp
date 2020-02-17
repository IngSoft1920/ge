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
   <input type="text" size="15" maxlength="9" value="Ej.:ABC123456" name="reserva" style="margin-top:30px;">   Identificador de Reserva
    </input></br>
    <input type="text" size="15" maxlength="9" value="Ej.:14:00" name="entrada" style="margin-top:30px;">   Hora de Llegada
    </input></br>
    <textarea rows="5" size="15" maxlength="100" name="comentario" style="margin-top:30px">Escribe aqui tu comentario:
    </textarea>

    
       <div class="w-33">
        <div class="center">
          <button type="reset">
            Enviar
          </button>
        </div>
      </div></br>

    </body>
</html>
