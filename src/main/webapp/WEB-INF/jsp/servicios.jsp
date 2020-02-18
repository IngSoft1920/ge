<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="cabecera.jsp"></jsp:include>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

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
        #myInput {
  background-image: url('/css/searchicon.png'); /* Add a search icon to input */
  background-position: 10px 12px; /* Position the search icon */
  background-repeat: no-repeat; /* Do not repeat the icon image */
  width: 80%; /* Full-width */
  font-size: 16px; /* Increase font-size */
  padding: 12px 20px 12px 40px; /* Add some padding */
  border: 1px solid #ddd; /* Add a grey border */
  margin-bottom: 12px; /* Add some space below the input */
}
​
#myUL {
  /* Remove default list styling */
  list-style-type: none;
  padding: 0;
  margin: 0;
}
​
#myUL li a {
  border: 1px solid #ddd; /* Add a border to all links */
  margin-top: -1px; /* Prevent double borders */
  background-color: #f6f6f6; /* Grey background color */
  padding: 12px; /* Add some padding */
  text-decoration: none; /* Remove default text underline */
  font-size: 18px; /* Increase the font-size */
  color: black; /* Add a black text color */
  display: block; /* Make it into a block element to fill the whole list */
}
​
#myUL li a:hover:not(.header) {
  background-color: #eee; /* Add a hover effect to all links, except for headers */
}
</style>
    <script>
function myFunction() {
  // Declare variables
  var input, filter, ul, li, a, i, txtValue;
  input = document.getElementById('myInput');
  filter = input.value.toUpperCase();
  ul = document.getElementById("myUL");
  li = ul.getElementsByTagName('li');
​
  // Loop through all list items, and hide those who don't match the search query
  for (i = 0; i < li.length; i++) {
    a = li[i].getElementsByTagName("a")[0];
    txtValue = a.textContent || a.innerText;
    if (txtValue.toUpperCase().indexOf(filter) > -1) {
      li[i].style.display = "";
    } else {
      li[i].style.display = "none";
    }
  }
}
</script>
	<!-- Cabecera de la pagina -->
	<div
		style="margin-top: 40px; background-color: lightsalmon; opacity: 30%;">
		<h1
			style="text-align: center; font-size: 50px; font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;">Servicios</h1>
	</div>
	<!-- Parte de servicios y reserva -->
	<div class="aspecto">
		<div class="parte1">
			<h3>Servicios</h3>
			<!-- Lista de servicios -->
			<select>
				<option>Spa</option>
				<option>Piscina</option>
			</select>
			<!-- Lista de horas -->
			<br/><br/>
			<select>
                <option>Día</option>
				<option>1</option>
				<option>2</option>
				<option>3</option>
				<option>4</option>
				<option>5</option>
				<option>6</option>
				<option>7</option>
				<option>8</option>
                <option>9</option>
                <option>10</option>
                <option>11</option>
                <option>12</option>
                <option>13</option>
                <option>14</option>
                <option>15</option>
                <option>16</option>
                <option>17</option>
                <option>18</option>
                <option>19</option>
                <option>20</option>
                <option>21</option>
                <option>22</option>
                <option>23</option>
                <option>24</option>
                <option>25</option>
                <option>26</option>
                <option>27</option>
                <option>28</option>
                <option>29</option>
                <option>30</option>
                <option>31</option>
               
                
			</select>
                <select>
                <option>Mes</option>
				<option>Enero</option>
				<option>Febrero</option>
				<option>Marzo</option>
				<option>Abril</option>
				<option>Mayo</option>
				<option>Junio</option>
				<option>Julio</option>
				<option>Agosto</option>
                <option>Septiembre</option>
                <option>Octubre</option>
                <option>Noviembre</option>
                <option>Diciembre</option>
			</select>
            <select>
				<option>10:00</option>
				<option>10:30</option>
				<option>11:00</option>
				<option>11:30</option>
				<option>12:00</option>
				<option>12:30</option>
				<option>13:00</option>
				<option>13:30</option>
			</select>
            <br/><br/>
			<!-- Boton de reservar -->
			<button type="submit">Reservar</button>
		</div>
        
	</div>
    <div class="aspecto">
        <div></div> 
			<h3>Encargar comida </h3>
			
      <input placeholder="Número de habitación" type="text" size="22" maxlength="9" value="" name="habitación" style="margin-top:30px;">   
        <div class="w-33">
        <div class="center">
        <textarea placeholder="Descripción del pedido" rows="5" size="15" maxlength="100" name="comentario" style="margin-top:30px"></textarea>
            
          <br/><br/>
            <button type="reset">
            Encargar
          </button>
        </div>
      </div></br>
    </input></br>
		</div>
<div class="aspecto">
		<div class="parte1">
			<h3>Reserva de mesa</h3>
			<!-- Lista de servicios -->
			<div class="custom-select" style="width:400px;">
  <select>
    <option value="0">Número de personas:</option>
    <option value="1">1</option>
    <option value="2">2</option>
    <option value="3">3</option>
    <option value="4">4</option>
    <option value="5">5</option>
    <option value="6">6</option>
    <option value="7">7</option>
    <option value="8">8</option>
    <option value="9">9</option>
    <option value="10">10</option>
  
  </select>
<br/><br/>
			<select>
                <option>Día</option>
				<option>1</option>
				<option>2</option>
				<option>3</option>
				<option>4</option>
				<option>5</option>
				<option>6</option>
				<option>7</option>
				<option>8</option>
                <option>9</option>
                <option>10</option>
                <option>11</option>
                <option>12</option>
                <option>13</option>
                <option>14</option>
                <option>15</option>
                <option>16</option>
                <option>17</option>
                <option>18</option>
                <option>19</option>
                <option>20</option>
                <option>21</option>
                <option>22</option>
                <option>23</option>
                <option>24</option>
                <option>25</option>
                <option>26</option>
                <option>27</option>
                <option>28</option>
                <option>29</option>
                <option>30</option>
                <option>31</option>
               
                
			</select>
                <select>
                <option>Mes</option>
				<option>Enero</option>
				<option>Febrero</option>
				<option>Marzo</option>
				<option>Abril</option>
				<option>Mayo</option>
				<option>Junio</option>
				<option>Julio</option>
				<option>Agosto</option>
                <option>Septiembre</option>
                <option>Octubre</option>
                <option>Noviembre</option>
                <option>Diciembre</option>
			</select>
                
                <select>
                <option>Hora</option>
				<option>10:00</option>
				<option>10:30</option>
				<option>11:00</option>
				<option>11:30</option>
				<option>12:00</option>
				<option>12:30</option>
				<option>13:00</option>
				<option>13:30</option>
			</select>
               <br/><br/> 
                
			<!-- Boton de reservar -->
			<button type="submit">Reservar</button>
                </div>
    </div>
    </div>
    <div class="aspecto">
        <div></div> 
			<h3>Servicios reservados </h3>
		<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Buscador">
​
<ul id="myUL">
  <li><a href="#">Spa[10:00]</a></li>
  <li><a href="#">Mesa reservada[14:30]</a></li>
​
  <li><a href="#">Piscina[12:00]</a></li>
 
</ul>
      </div></br>
    </input></br>
		</div>           
</body>
</html>