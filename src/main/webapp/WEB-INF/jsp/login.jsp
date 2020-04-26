<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="cabecera.jsp"></jsp:include>

<html>
<head>
<title>LogIn</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="/css/login.css"
	media="screen" />
</head>



<body style="background-color:#b8b078">

	<div class="blanco"></div>
	<div>
		<!-- Podemos acceder a tipos basicos (String, int...) mediante esta etiqueta -->
		<br>
		<h1>${mensajeError}</h1>
	</div>
	
	
	<div class="center">
	<form method="POST" action="${loginBean.method}"
		modelAttribute="loginBean">
		<fieldset>
		<div class="cabeza">
			<legend>LOG IN</legend>
		</div>
		
		<div class="contenido">
			<label>Correo electronico</label>
			<input type="email" name="email" path="email" /> 
		</div>	
			
		<div class="contenido">
			<label for="password">Contrasena</label>
			<input type="password" id="password" name="password" path="password" />
			<button class="btn btn-primary" type="button"
				onclick="mostrarContrasena('password')">Mostrar</button>
		</div>
		
		<div class="container" id="container_boton">
		<input type="submit" value="Entrar">
		</div>
		</fieldset>
	</form>


	<div class="container" id="container_boton">
	<form action="/signup">
		<input type="submit" value="Ir a registrar">
	</form>
	</div>
	</div>

	<script>
		function mostrarContrasena(x) {
			var tipo = document.getElementById(x);
			if (tipo.type == "password") {
				tipo.type = "text";
			} else {
				tipo.type = "password";
			}
		}
	</script>

</body>
</html>