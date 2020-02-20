<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="cabecera.jsp"></jsp:include>

<html>
<head>Login
</head>
<body style="text-align: center; background-color: skyblue"
	<div>
		<!-- Podemos acceder a tipos basicos (String, int...) mediante esta etiqueta -->
		<h1>${mensajeError}</h1>
	</div>
	<form:form method="POST" action="login" modelAttribute="loginBean">
		<label>Nombre de usuario</label>
		<form:input type="text" name="usuario" path="usuario" />
		<br>
		<br>
		<label>Contrasena</label>
		<form:input type="password" name="password" path="password" />
		<input type="submit" value="Entrar">
		<br>
	</form:form>

</body>
</html>