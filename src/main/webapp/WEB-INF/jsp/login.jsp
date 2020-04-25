<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="cabecera.jsp"></jsp:include> 

<html>
<head>
	<title>LogIn</title> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body style="text-align: center; background-color: #A6A3A2; font-size: 1vw;">
	<br><br><br><br><br><br><br><br><br><br><br><br><br>
	<div>
		<!-- Podemos acceder a tipos basicos (String, int...) mediante esta etiqueta -->
		<br>
		<h1>${mensajeError}</h1>
	</div>
	<form method="POST" action="${loginBean.method}" modelAttribute="loginBean">
		<fieldset>
			<legend>LOG IN</legend>
			<br>
			<label>Email</label>
			<input type="email" name="email" path="email" />
			<br>
			<br>
			<label for="password">Password</label>
			<input type="password" id="password" name="password" path="password" />
			<button class="btn btn-primary" type="button" onclick="mostrarContrasena('password')">Mostrar</button>
			<br>
			<br>
			<input type="submit" value="Entrar">
		</fieldset>
	</form>

	<form action="/signup">
		<input type="submit" value="Si aun no estas registrado. Registrate">
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