
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>

<head>

<title>Home Page</title>
<meta charset="utf-8">


<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
  
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
  

<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" type="text/css" href="/css/cabecera.css"
	media="screen" />
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">
</head>

<header>

<nav class="navbar fixed-top navbar-expand-md bg-dark navbar-dark" id="todoJunto">
	
				<a class="navbar-brand" href="/"><img class="img-fluid" src="/imagenes/LogoHotel.jpg"/></a>
		
		 <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
            <span class="navbar-toggler-icon"></span>
        </button>

<div class="collapse navbar-collapse" id="navbarCollapse">
		
		<ul class="navbar-nav" id="ul_de_cabecera_izq">		

			<li class="nav-item">
			<button id="backbut" value="back" onclick="history.back()" style="
    	    float:left;
    	    margin-top: 5px;
    	    margin-right:15px;
    	    color: white;
    	    border-radius: 50%;
    	    border: none;
    	    background: #b8b078;
    	    font-family: cursive;
    	    width: auto;
    	    height:auto;
    	    text-align: center;">&#8249;
    	    </button></li>


				<li class="nav-item">
				<a href="/login">
				<div id="redirigir1">
					 <i class="fa fa-book"> </i>Mis
							Reservas	
				</div>	
				</a>
				</li>

				<li class="nav-item">
					<a href="/login">
				<div id="redirigir2"> <i class="fa fa-glass"> </i>Servicios				
					</div>
						</a>
				</li>
				
				<li class="nav-item">
					<a href="/login">
				<div id="redirigir5"> <i class="fa fa-pencil"> </i>Historial
					</div>
					</a>
				</li>
			
				<li class="nav-item">
					<a href="/recibirReservas"> 
				<div id="redirigir3">
						<i class="fa fa-book"> </i>Mis
							Reservas
					</div>
					</a>
				</li>
		

				<li class="nav-item">
				
					<a href="/servicios">
				<div id="redirigir4"> <i class="fa fa-glass"> </i>Servicios
					</div>
					</a>
				</li>
			
				<li class="nav-item">
				
					<a href="/misReservas">
				<div id="redirigir6"><i class="fa fa-pencil"> </i>Historial
					</div>
					</a>
				</li>
				

			<script type="text/javascript">			
			
			function myRegistro(){
				
				var sessiones = '${sesionBean.usuario}';
				
				if (sessiones == "LogIn" || sessiones == "") {
					document.getElementById("redirigir1").style.display = "inline-block";
					
					document.getElementById("redirigir2").style.display = "inline-block";
					
					document.getElementById("redirigir5").style.display = "inline-block";
					

					document.getElementById("redirigir3").style.display = "none";
					
					document.getElementById("redirigir4").style.display = "none";
					
					document.getElementById("redirigir6").style.display = "none";
					
				} else {
					document.getElementById("redirigir1").style.display = "none";
					
					
					document.getElementById("redirigir2").style.display = "none";

					document.getElementById("redirigir5").style.display = "none";


					document.getElementById("redirigir3").style.display = "inline-block";
					
					document.getElementById("redirigir4").style.display = "inline-block";

					document.getElementById("redirigir6").style.display = "inline-block";
				
				}
				backButton();
			}
			
			function backButton(){
				var pageName = window.location.href;

				if(pageName=="http://localhost:7004/index" || pageName=="http://localhost:7004/home" || pageName=="http://localhost:7004/"){
				    document.getElementById('backbut').style.visibility = 'hidden';
				}
				console.log(pageName);
				}
			
			</script>
			
	
		</ul>
		
		
		
		
		
		
		<ul class="navbar-nav ml-auto" id="ul_de_cabecera_dch">
		



			<li class="nav-item">
			
  <!-- Trigger the modal with a button -->
  
  <button type="button" class="btn btn-link" id="botonModal"><i class="fa fa-users"></i> MyAccount</button>
			</li>
			
						<li class="nav-item">
			<a href="/"> <i class="fa fa-list"></i>
					Inicio
					</a>
			</li>


		</ul>
	</div>
	</nav>

  
  <!-- Modal Si no hemos iniciado sesion -->
  <div class="modal fade" id="myModal" role="dialog">
 <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="modalTexto">Accede a tu cuenta o registrate y
						obten descuentos</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      <div class="container-fluid">
      <div class="row">
      <div class="col">
      <form:form action="login" method="GET" >
        <button type="submit" class="btn btn-primary" id="modalBotones" value="Log In">Log In</button>
		</form:form>
       </div>
       <div class="col"> 
       <form:form action="signup" method="GET" >
        	<button type="submit" class="btn btn-primary" id="modalBotones" value="Sign Up">Registrarse</button>
		</form:form>
        </div>
        </div>
        </div>
        
      </div>
    </div>
  </div>
  </div>
  
  <!-- Modal Si hemos iniciado sesion-->
  <div class="modal fade" id="userPopup" role="dialog">
 <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="modalTexto">BIENVENIDO ${sesionBean.usuario}</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      
       <div class="container-fluid">
      <div class="row">
      <div class="col">
      <form:form action="misReservas" method="GET" >
        <button type="submit" class="btn btn-primary" id="modalBotones" value="Mis Reservas">Mis Reservas</button>
		</form:form>       
        </div>
         <div class="col">
         <form:form action="servicios" method="GET" >
        <button type="submit" class="btn btn-primary" id="modalBotones" value="Mis servicios">Mis Servicios</button>      
		</form:form>
        </div>
         <div class="col">
         <form:form action="logout" method="GET" >
        <button type="submit" class="btn btn-primary" id="modalBotones"value="Cerrar Sesion">Cerrar sesión</button>        
		</form:form>
        </div>
        </div>
        </div>
        
      </div>
    </div>
  </div>
  </div>  
  <script>
  
$(document).ready(function(){
	var sessiones = '${sesionBean.usuario}';
	if (sessiones == "LogIn" || sessiones == "") {
		  $("#botonModal").click(function(){
		    $("#myModal").modal();   });	
	}else{
		 $("#botonModal").click(function(){
		$("#userPopup").modal();  });
	}
});
</script>
  

</header>

<body onload="myRegistro()" onload="backButton()">


</body>


</html>

<!--  
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

-->
<!--  






			<div class="menu1Cabecera">
				<li><a href="/incidencias"><i class="fa fa-pencil"></i>Incidencias</li>
			</div>





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