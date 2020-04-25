<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="cabecera.jsp"></jsp:include>

<html>
<head>
<title>Signup</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body
	style="text-align: center; background-color: #A6A3A2; font-size: 2vw;">
	<div>
		<br>
	</div>
	<form method="POST" action="${signup.method}"
		modelAttribute="signupBean">
		<fieldset>
		<br><br><br><br><br><br><br><br>
			<legend>REGISTRO</legend>
			<br>
			<p style="font-size: 30px; color: red; font-family: 'Courier New'">${mensajeError}</p>
			<br> <label>Nombre</label> <input type="text" name="nombre"
				path="nombre" /> <br> <br> <label>Apellidos</label> <input
				type="text" name="apellidos" path="apellidos" /> <br> <br>
			<label>DNI (sin letra)</label> <input type="text" name="DNI"
				path="DNI" /> <br> <br> <label>Email</label> <input
				type="email" name="email" path="email" /> <br> <br> <label>Telefono</label>
			<input type="text" name="telefono" path="telefono" /> <br> <br>
			<label>Nacionalidad</label> <input type="text" name="nacionalidad"
				path="nacionalidad" /> <br> <br> <label for="password">Password</label>
			<input type="password" id="password" name="password" path="password" />
			<button class="btn btn-primary" type="button"
				onclick="mostrarContrasena('password')">Mostrar</button>
			<br> <br> <label for="verificacioPassword">Repite
				Password</label> <input type="password" id="verificacionPassword"
				name="verificacionPassword" path="verificacionPassword" />
			<button class="btn btn-primary" type="button"
				onclick="mostrarContrasena('verificacionPassword')">Mostrar</button>
			<br> <br> <input type="submit" value="Registrar">
		</fieldset>
	</form>

	<script>
		function mostrarContrasena(x){
			var tipo = document.getElementById(x);
			if(tipo.type == "password"){
				tipo.type = "text";
			}else{
				tipo.type = "password";
			}
		}
	  </script>

</body>
</html>