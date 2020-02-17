<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

	<!-- Cabecera de la pagina -->
	<div
		style="margin-top: 40px; background-color: lightsalmon; opacity: 30%;">
		<h1
			style="text-align: center; font-size: 50px; font-family: Cambria, Cochin, Georgia, Times,
			 'Times New Roman', serif;">Incidencias</h1>
	</div>

	<!-- Parte de incidencias -->
	<div class="aspecto">
		<h3>Incidencias</h3>
		<form action="/my-handling-form-page" method="post">
 <ul>
  <li>
    <label for="name">Nombre:</label>
    <input type="text" id="name" name="user_name">
  </li>
  <li>
    <label for="mail">Correo electrónico:</label>
    <input type="email" id="mail" name="user_mail">
  </li>
  <li><label for="asunto">Asunto:</label>
  <select>
  <option> Habitacion</option>
  <option> Restaurante - comida</option>
  </select>
   </li>
  <li>
    <label for="msg">Mensaje:</label>
    <textarea id="msg" name="user_message"></textarea>
  </li>
  <li><input type=button value="Enviar"></button>
   </li>
 </ul>
</form>
	</div>

</body>
</html>