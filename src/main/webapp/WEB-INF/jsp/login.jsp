<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
	Login
</head>
<body>
	<div>
	<!-- Podemos acceder a tipos basicos (String, int...) mediante esta etiqueta -->
		<h1>
			${mensajeError}
		</h1>
	</div>
	<form:form method="POST" action="login"
		modelAttribute="loginBean">
		<label>Nombre de usuario</label>
		<form:input type="text" name="usuario" path="usuario" />
		<br>
		<label>Contraseña</label>
		<form:input type="password" name="password" path="password" />
		<input type="submit" value="Entrar">
		<br>
	</form:form>

	<!-- <input type="submit" value="SignUp" <a href="/signup"/> >-->
	<a href="/signup"><button>Signup</button></a>

</body>
</html>