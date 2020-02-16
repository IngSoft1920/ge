<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Home Page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
#button {
  margin: 0;
  padding: 20;
  overflow: hidden;
  background-color: #333;
 }
#button li {
 display: inline;
 }
#button li img{
  display: inline-block;
 float: left;
 padding: 0px;
 border: 1px;
 height: 40;
 width: 40;
}
#menu{
  display: inline-block;
 font-family: Arial;
 font-size: 15px;
 float: right;
 padding: 10px;
 }
 a:link{
  color: white;
  text-decoration: none;
 }
  a:visited{
  color: white;
  text-decoration: none;
 }
  a:active{
  color: red;
 text-decoration: none;
 }
  .titulo {
  padding: 1px;
  text-align: center;
  background: #FA8072;
  color: white;
  font-size: 30px;
}
.hoteles {
   background: transparent;
   padding: 5px;
   font-size: 25px;
}
  .reserva {
    border: 1px solid #FA8072;
  }
  .fechas{
    font-size: 25px;
    padding: 5px;
    background: transparent;
  }
  .button {
    font-size:25px;
    background: transparent;
    padding: 5px ;
    margin-left: 300px;
  }
</style>
</head>
<body>
	<ul id="button">
 <li><a href="#"><img src="icon.png"></li>
 <li id="menu"><a href="#">Log in</a></li>
 <li id="menu"><a href="#">Buscar</a></li>
 <li id="menu"><a href="#">Reservas</a></li>
 </ul>
	<div class="titulo">
  		<h1>Haz tu reserva</h1>
  	</div>
   <div class="reserva">
  <div class="hoteles">
  	<label for="Hoteles">Escoge un hotel:</label>
		<select id="Hoteles">
          	<div class="opciones">
  			<option value="Hotel 1">Hotel 1</option>
  			<option value="Hotel 2">Hotel 2</option>
  			<option value="Hotel 3">Hotel 3</option>
  			<option value="Hotel 4">Hotel 4</option>
          </div>
		</select>
  </div>
  <div class ="fechas">
    <p>
      <label>Fecha de entrada:</label>
          <input type = "text" id = "myText" value = "Introduce fecha de entrada"/>
    </p>
     <p>
      <label>Fecha de salida:</label>
          <input type = "text" id = "myText" value = "Introduce fecha de salida"/>
    </p>
  </div>
  <button class="button">Buscar disponibilidad</button>
  </div>
</body>
</html>