<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="cabecera.jsp"></jsp:include> 

<html>
<head>Log In 
</head>
<body style="text-align: center; background-color: skyblue">
	<div>
		<!-- Podemos acceder a tipos basicos (String, int...) mediante esta etiqueta -->
		<h1>${mensajeError}</h1>
	</div>
	<form:form method="POST" action="${loginBean.method}" modelAttribute="loginBean">
		<label>Nombre de usuario</label>
		<form:input type="text" name="usuario" path="usuario" />
		<br>
		<br>
		<label>Contrasena</label>
		<form:input type="password" name="password" path="password" />
		<input type="submit" value="Entrar">
	</form:form>

		<div class="card" onclick="document.location = '/signup'">
		 <div class="container", style="padding-top:20px">
		   <a><b><input type="submit" value="Si no estas registrado. Ir a Signup"></b></a> 
		 </div>

</body>
</html>