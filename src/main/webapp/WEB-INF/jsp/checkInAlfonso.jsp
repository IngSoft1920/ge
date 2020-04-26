<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="cabecera.jsp"></jsp:include>

<!DOCTYPE html>
<html lang="en">

<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="/ge/src/main/java/ingsoft1920/ge/Controller/ge_Controller.java"></script>

<style>
.aspecto {
	text-align: center;
	margin-top: 60px;
	margin: 20px;
	padding: 10px;
	background-color: #B0C4DE;
	opacity: 80%;
}

.card {
	box-shadow: 0 4px 5px 0 rgba(0, 0, 0, 0.2);
	transition: 0.3s;
	width: 30%;
}

.card:hover {
	box-shadow: 0 8px 10px 0 rgba(0, 0, 0, 0.2);
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
	background-color: #B0C4DE;
	opacity: 80%;
	border: 1px solid rgba(0, 0, 0, 0.8);
	padding: 30px;
	width: 250px;
	margin-top: 30px;
	margin-left: 60px;
	margin-right: 60px;
}

label {
	font-size: 20px
}
</style>
<body>

	<div style="margin-top: 40px; background-color: #B0C4DE; opacity: 60%;">
		<h1
			style="text-align: center; font-size: 50px; font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;">Check
			In</h1>
	</div>


	<div class="aspecto">
		<form method="POST" style="width: 100%;" action="/confirmarCheckin"
			modelAttribute="checkInBean" onsubmit="return validacion()">

			Nombre: <input type="text" id="nombre" name="nombre" /> <br></br>
			Apellidos: <input type="text" id="apellidos" name="apellidos" /><br></br>
			DNI: <input type="text" id="DNI" name="DNI" /><br></br> Email: <input
				type="text" id="email" name="email" /><br></br> Password: <input
				type="password" id="password" name="password" /><br></br>
			Nacionalidad: <input type="text" id="nacionalidad"
				name="nacionalidad" /><br></br> Telefono: <input type="text"
				id="telefono" name="telefono" /><br></br> <input type="submit"
				value="Enviar">
		</form>
	</div>

	<!-- necesario para el script -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"
		integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
		crossorigin="anonymous"></script>
<!-- 
	<script>
	function validacion(){
		
		var letras = ['T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D',
			'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E', 'T'];
		var patron = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,4})+$/;
		nombre = document.getElementById("nombre").value;
		apellidos = document.getElementById("apellidos").value;
		DNI = document.getElementById("DNI").value;
		email = document.getElementById("email").value;
		password = document.getElementById("password").value;
		nacionalidad = document.getElementById("nacionalidad").value;
		telefono = document.getElementById("telefono").value;
		
		if( nombre == null || nombre.length == 0 || apellidos == null || apellidos.length == 0 ||
				password == null || password.length == 0 || nacionalidad == null || nacionalidad.length == 0) {
			alert('[ERROR] No puede haber campos vacios');
			return false;
		}
		else if(!(/^\d{8}[A-Z]$/.test(DNI))){
			alert('[ERROR] DNI formato incorrecto');
			return false;
		}
		else if(!(/^\d{9}$/.test(valor))){
			alert('[ERROR] Telefono formato incorrecto');
			return false;
		}
		else if(email.search(patron)=!=0){
			alert('[ERROR] Email formato incorrecto');
			return false;
		}
		else return true;
	}
	</script> --> 

</body>
</html>