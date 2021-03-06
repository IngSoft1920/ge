<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="ingsoft1920.ge.Controller.*"%>


<jsp:include page="cabecera.jsp"></jsp:include>

<html>
<head>
<title>Metodo Pago</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="/css/metodopago.css"
	media="screen" />
	<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">

</head>
<body>



<div class="container" id="conatiner_todo">

<div class="espacio"></div>

	<h2>Seleccione metodo de pago</h2>
<hr>
	<div class="container">
	<br>
	<br>
	<div class="row">


		<div class="col-md" id="col_primer">	
		<h3>Pago en efectivo:</h3>
		<br><br><br>
		<form:form action="/efectivo" method="GET" >	
		<input type="submit" class="btn btn-warning btn-block" id="pagar" value="PAGAR">		

		</form:form>
		</div>
		
		
		<div class="col-md" id="col_segundo">
		<h3>Pago con tarjeta:</h3>
		<br><br>
   
		
		<form:form action="tarjeta" method="GET">
		  <div class="form-row">
		    <div class="col-md">
		      <input type="text" class="form-control" placeholder="Nombre">
		    </div>
		    <div class="col">
		      <input type="text" class="form-control" placeholder="Apellidos">
		    </div>		   
		  </div>
		   <br>
		  <div class="form-row">
		  	<div class="col-md">
                  <input type="text" class="form-control" placeholder="Numero tarjeta" />
           	</div>
           	
           </div>
              <br>
             <div class="form-row"> 
		  
		   <div class="col-md-3 col-sm-3 col-xs-3">
                  <span class="help-block text-muted small-font" > Expiry Month</span>
                  <input type="text" class="form-control" placeholder="MM" />
              </div>
         <div class="col-md-3 col-sm-3 col-xs-3">
                  <span class="help-block text-muted small-font" >  Expiry Year</span>
                  <input type="text" class="form-control" placeholder="YY" />
              </div>
        <div class="col-md-3 col-sm-3 col-xs-3">
                  <span class="help-block text-muted small-font" >  CCV</span>
                  <input type="text" class="form-control" placeholder="CCV" />
              </div>
              
              <div class="col-md-3 col-sm-3 col-xs-3" id="tarjetaFoto">
              <br>
                  <img src="/imagenes/tarjetaCredito.jpg" class="img-rounded d-none d-lg-block" />
              </div>
              
		  </div>

		  <br>	
		  		
		         <div class="row ">	  <br>
                  <input type="submit"  class="btn btn-warning btn-block" value="PAGAR" />
          </div>
		</form:form>

		
		</div>
	
	</div>


	</div>
<br>
</div>

	

</body>
</html>