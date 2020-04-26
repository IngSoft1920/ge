<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="cabecera.jsp"></jsp:include>

<html>
<head>
<title>Signup</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="/css/signup.css" media="screen" />
</head>



<body style="background-color:#b8b078">
	
	
	<div class="center">
	<form method="POST" action="${signup.method}" modelAttribute="signupBean">
	
			
			<div class="cabeza">
			<legend>SIGN UP</legend>
			</div>
			
			
			<div class="contenido">
			<label>Nombre</label> 
			<input type="text" name="nombre"path="nombre" /> 
			</div>
			
			<div class="contenido">
			<label>Apellidos</label> 
			<input type="text" name="apellidos" path="apellidos" />
			</div>

			<div class="contenido">
			<label>DNI (sin letra)</label> 
			<input type="text" name="DNI"path="DNI"/> 
			</div>
			
			<div class="contenido">
			<label>Email</label> 
			<input type="email" name="email" path="email" />
			</div>
			
			<div class="contenido">
			<label>Telefono</label>
			<input type="text" name="telefono" path="telefono" /> 
			</div>
			
			<div class="contenido">
			<label>Nacionalidad</label> 
			<input type="text" name="nacionalidad" path="nacionalidad" />
			</div>
			
			<div class="contenido">
			<label for="password">Password</label>
			<input type="password" id="password" name="password" path="password" />
			<button class="btn btn-primary" type="button" onclick="mostrarContrasena('password')">Mostrar</button>
			</div>
			
			<div class="contenido">
			<label for="verificacioPassword">Repite Password</label>
			<input type="password" id="verificacionPassword" name="verificacionPassword" path="verificacionPassword" />
			<button class="btn btn-primary" type="button" onclick="mostrarContrasena('verificacionPassword')">Mostrar</button>
			<br><br>
			<div class="container" id="container_boton">
			<input type="submit" value="Registrar">
			</div>
			</div>
			

	</form>
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