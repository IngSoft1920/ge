<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="cabecera.jsp"></jsp:include>

<html>
<head>Signup
</head>
<body style="text-align: center; background-color: #A6A3A2">
	<div>
		<!-- Podemos acceder a tipos basicos (String, int...) mediante esta etiqueta -->
		<h1>${mensajeError}</h1>
	</div>
	<form:form method="POST" action="signup" modelAttribute="signupBean">
		<br>
		<br>
		<label>Nombre de usuario</label>
		<form:input type="text" name="usuario" path="usuario" />
		<br>
		<br>
		<label>Correo electronico</label>
		<form:input type="text" name="email" path="email" />
		<br>
		<br>
		<label>Contrasena</label>
		<form:input type="password" name="password" path="password" />
		<br>
		<br>
		<label>Repetir contrasena </label>
		<form:input type="password" name="verificacionPassword" path="verificacionPassword" />
		<br>
		<br>
		<label>Dni</label>
		<form:input type="dni" name="dni" path="dni" />
		<br>
		<br>
		<label>Nombre</label>
		<form:input type="text" name="nombre" path="nombre" />
		<br>
		<br>
		<label>Apellidos</label>
		<form:input type="text" name="apellidos" path="apellidos" />
		<br>
		<br>
		<input type="submit" value="Registrar">
	</form:form>
</body>
</html>