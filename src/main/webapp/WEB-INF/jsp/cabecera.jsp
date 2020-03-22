
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>

<body onload=backButton() >
<script>

function backButton(){
var pageName = window.location.href;

if(pageName=="http://localhost:7004/index" || pageName=="http://localhost:7004/home"){
    document.getElementById('backbut').style.visibility = 'hidden';
}
console.log(pageName);
}

</script>
<head>

<title>Home Page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="/css/cabecera.css"
	media="screen" />
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">
</head>

<header>
	<div class="topCabecera">
		<ul id="buttonCabecera">
			<div class="menu1Cabecera">
				<li><a href="/"><img src="/imagenes/LogoHotel.jpg" /></li>
			</div>
			<div class="menu1Cabecera">
				<li><a href="/misReservas"><i class="fa fa-book"></i>Mis
						Reservas</li>
			</div>
			<div class="menu1Cabecera">
				<li><a href="/servicios"><i class="fa fa-glass"></i>Servicios</li>
			</div>
			<div class="menu1Cabecera">
				<li><a href="/incidencias"><i class="fa fa-pencil"></i>Incidencias</li>
			</div>




			<li id="menu2Cabecera"><a href="/"> <i class="fa fa-list"></i>
					Inicio
			</a></li>


			<li id="menu2Cabecera">

				<div class="popup" onclick="myHotel()">

					<i class="fa fa-users"></i> MyAccount <span class="popuptext"
						id="myPopup"> <br> Accede a tu cuenta o registrate y
						obten descuentos <br> <br> <a href="/login"
						value="login">
							<button class="botonMyHotel">Log In</button>
					</a> <a href="/signup" value="signup">
							<button class="botonMyHotel">Registrarse</button>
					</a>
					</span> <span class="popuptext" id="UserPopup"> <br>
						!BIENVENIDO ${sesionBean.usuario}!<br> Disfruta de esta
						experiencia con nosotros <br> <a href="/reservas"
						value="reservas">
							<button class="botonMyHotel">Mis Reservas</button>
					</a> <a href="/servicios" value="servicios">
							<button class="botonMyHotel">Mis Servicios</button>
					</a>
							<button class="botonMyHotel">Cerrar sesión</button>
					
					</span>
				</div> <script>
						function myHotel() {
							var sessiones = '${sesionBean.usuario}';
							if (sessiones == "LogIn") {
								var popup = document.getElementById("myPopup");
								popup.classList.toggle("show");
							} else {
								var popup = document
										.getElementById("UserPopup");
								popup.classList.toggle("show");
							}
						}
					</script>




			</li>

		</ul>

	</div>
</header>

<body>

</body>


</html>

<!--  

				<div class="popup1" onclick="myMenu()">
				
					<i class="fa fa-list"></i> Menu 
					<span class="popuptext1"	id="myPopupMenu">
					 <br> <a href="/buscador" value="buscar">
							<button class="botonMyMenu">Buscar</button>
					</a> <br> <a href="/reservas" value="reservas">
							<button class="botonMyMenu">Reservas</button>
					</a> <br> <a href="/servicios" value="servicios">
							<button class="botonMyMenu">Servicios</button>
					</a> <br> <a href="/incidencias" value="incidencias">
							<button class="botonMyMenu">Incidencias</button>
					</a> <br>


					</span>
				</div> <script>
					function myMenu() {
						var popup1 = document.getElementById("myPopupMenu");
						popup1.classList.toggle("show1");
					}
				</script>















			<div class="LogIn">
				<li id="menu"><a href="${sesionBean.redirect}"
					value="${sesionBean.usuario}"> <var id="variable">${sesionBean.usuario}
						</var></a></li>
			</div>

<li id="menu"><a href="${sesionBean.redirect}"
				value="${sesionBean.usuario}"> <var id="variable">${sesionBean.usuario} </var></a> </li>
				
				
 <% if(request.getSession(false)==null){ %>
 ${sesionBean.usuarioID}
 
 <%}else{ %> 
 <a href="${sesionBean.redirect}" value="${sesionBean.usuario}">${sesionBean.usuario}</a> 
  
 <% } %>
-->