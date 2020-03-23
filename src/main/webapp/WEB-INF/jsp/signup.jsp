<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="cabecera.jsp"></jsp:include>

<script>
  function mostrarContrasena(){
      var tipo = document.getElementById("password");
      if(tipo.type == "password"){
          tipo.type = "text";
      }else{
          tipo.type = "password";
      }
  }
</script>

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
		<label>Nombre</label>
		<form:input type="text" name="nombre" path="nombre" />
		<br>
		<br>
		<label>Apellidos</label>
		<form:input type="text" name="apellidos" path="apellidos" />
		<br>
		<br>
		<label>DNI</label>
		<form:input type="DNI" name="DNI" path="DNI" />
		<br>
		<br>
		<label>Email</label>
		<form:input type="text" name="email" path="email" />
		<br>
		<br>
		<label>Telefono</label>
		<form:input type="text" name="telefono" path="telefono" />
		<br>
		<br>
		<label>Nacionalidad</label>
		<form:input type="text" name="nacionalidad" path="nacionalidad" />
		<br>
		<br>
		<label >Password</label>
		<form:input type="password" name="password" path="password" />
		<button class="btn btn-primary" type="button" onclick="mostrarContrasena()">Mostrar</button>
		<br>
		<br>
		<label>Repite password</label>
		<form:input type="password" name="verificacionPassword" path="verificacionPassword" />
		<br>
		<br>
		<input type="submit" value="Registrar">
	</form:form>
</body>
</html>