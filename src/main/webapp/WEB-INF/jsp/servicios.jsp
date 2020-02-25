<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="cabecera.jsp"></jsp:include>

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="en">
<meta name="viewport" content="width=device-width, initial-scale=1">
<body >
	<style>
.aspecto {
	text-align: center;
	margin-top: 60px;
	margin: 20px;
	padding: 10px;
	background-color: #B0C4DE;
	opacity: 80%;
}

label {
	font-size: 20px
}

li span {
	color: #fff;
	border: 1px solid #ccc;
	background-color: #808080;
	margin-right: 10px;
	padding: 0 2px;
	border-radius: 4px;
	-moz-border-radius: 4px;
	-webkit-border-radius: 4px;
	-o-border-radius: 4px;
	border-radius: 4px;
	font-weight: bold;
	font-size: 0.8em;
	cursor: pointer;
}
</style>
	<script>

function eliminar(elemento)
{
elemento.parentNode.remove();
}
</script>

	<!-- Cabecera de la pagina -->
	<div style="margin-top: 40px; background-color: #B0C4DE; opacity: 60%;">
		<h1
			style="text-align: center; font-size: 50px; font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;">Servicios</h1>
	</div>
	<!-- Parte de servicios y reserva -->

	<div class="aspecto">
		<form method="get" style="width: 100%;" action="/servicios">

			<h3>Servicios</h3>
			<!-- Lista de servicios -->
			<label>Nº Reserva</label> <br>
			<textarea name="idReserva" rows="2" cols="10"
				style="margin-top: 5px;">
				</textarea>
			<br> <br> 
			<select name="servicio" id="tipoServicio" onclick=funcion()>
				<option value="Spa">Spa</option>
				<option value="Piscina">Piscina</option>
				<option value="Reservar mesa">Reservar mesa</option>
			</select> 
			<script>
			function funcion(){
				var e = document.getElementById("tipoServicio");
				var seleccionado = e.options[e.selectedIndex].text;
			var reservaMesa = false;
			if (seleccionado== "Reservar mesa"){
				reservaMesa = true;
			}
			console.log(reservaMesa);
			}
			</script>
			<br /> <br /> <select name="num_personas">
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



			<!-- Lista de horas -->
			<br /> <br /> <select name="dia">
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
			</select> <select name="mes">
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
			</select> <select name="hora">
				<option>10:00</option>
				<option>10:30</option>
				<option>11:00</option>
				<option>11:30</option>
				<option>12:00</option>
				<option>12:30</option>
				<option>13:00</option>
				<option>13:30</option>
			</select> <br /> <br />
			<!-- Boton de reservar -->
			<input type="submit" value="Reservar">
		</form>
	</div>


	<div class="aspecto">
		<form method="get" style="width: 100%;" action="/servicios">

			<h3>Encargar comida</h3>



			<textarea placeholder="Descripción del pedido" rows="5" size="15"
				maxlength="100" name="comentario" style="margin-top: 20px"></textarea>

			<br /> <br /> <input type="submit" value="Encargar"> </br> </input></br>
		</form>
	</div>





	<div class="aspecto">
		<div></div>
		<h3>Servicios reservados</h3>
		<div>
			<ul id="lista">

				<li>Spa
					<button onclick='eliminar(this)'>cancelar reserva</button>
				</li>
				<li>Mesa reservada
					<button onclick='eliminar(this)'>cancelar reserva</button>
				</li>
				<li>Piscina
					<button onclick='eliminar(this)'>cancelar reserva</button>
				</li>

			</ul>

		</div>
</body>
</html>