<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="cabecera.jsp"></jsp:include>

<html>
<head>

<title>Signup</title>


<meta name="viewport" content="width=device-width, initial-scale=1.0">


<link rel="stylesheet" type="text/css" href="/css/signup.css" media="screen" />
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

</head>



<body class="body box">
	
	<form method="POST" action="${signup.method}" modelAttribute="signupBean">
	
			
			<div class="cabeza">
			<div class ="text sombraText">
			<div>
			<legend>SIGN UP</legend>
			</div>
			</div>
			</div>
			
			<div class ="text sombraText">
			<div class="boxline">
			<div>
			<label>Nombre</label> 
			<input type="text" name="nombre"path="nombre" /> 
			</div>
		
			<div>
			<label>Apellidos</label> 
			<input type="text" name="apellidos" path="apellidos" />
			</div>
			

			<div>
			<label>DNI (sin letra)</label> 
			<input type="text" name="DNI"path="DNI"/> 
			</div>
			
			
			<div>
			<label>Email</label> 
			<input type="email" name="email" path="email" />
			</div>
			
			
			<div>
			<label>Telefono</label>
			<input type="text" name="telefono" path="telefono" /> 
			</div>
			
			
			<div>
			<label>Nacionalidad</label> 
			<input type="text" name="nacionalidad" path="nacionalidad" />
			</div>
			
			
			<div>
			<label for="password">Password</label>
			<input type="password" id="password" name="password" path="password" />
			<button class="btn btn-primary" type="button" onclick="mostrarContrasena('password')">Mostrar</button>
			</div>
			
			
			<div>
			<label for="verificacioPassword">Repite Password</label>
			<input type="password" id="verificacionPassword" name="verificacionPassword" path="verificacionPassword" />
			<button class="btn btn-primary" type="button" onclick="mostrarContrasena('verificacionPassword')">Mostrar</button>
			</div>
			
			
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