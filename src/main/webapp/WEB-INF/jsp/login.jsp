<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="cabecera.jsp"></jsp:include>

<html>
<head>

<title>LogIn</title>

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" type="text/css" href="/css/login.css" media="screen" />
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

</head>



<body style="background-color:#b8b078">

	<div>
		<!-- Podemos acceder a tipos basicos (String, int...) mediante esta etiqueta -->
		<br>
		<h1>${mensajeError}</h1>
	</div>
	
	
	<div class="center">
	<form method="POST" action="${loginBean.method}" modelAttribute="loginBean">
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