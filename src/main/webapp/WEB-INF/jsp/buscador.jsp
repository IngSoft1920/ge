<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="cabecera.jsp"></jsp:include>

<html>
<head>

<title>Buscador</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>

.buscador{

height: auto; 
width: 1000px;
margin: 0 auto; 

 display: inline;
 font-family: Arial;
 font-size: 15px;
float: center;
padding: 20 px;
overflow: hidden;
background-size: cover;
background-attachment: fixed;
position: relative;

}

h2{
text-align: center;
font-family: Oldtown, fantasy;
font-size: 50px;

}
.postbuscar{
text-align: center;
font-family: Oldtown, fantasy;
font-size: 20px;
}

.buscar{
display: inline;
Line-Height:30px;

}

.columna{
float:left;
width:30%;
padding: 10px;
text-align: center;

}
@media screen and (max-width: 600px) {
  .columna {
    width: 100%;
  }
  }

fila{
content:"";
display:table;
clear:both;

}

h3{

font-family: Oldtown, fantasy;

Line-Height:5px;
font-size: 25px;

}

input[type=date] {
    width: 100%;
    padding: 15px 22px;
    margin: 10px 5px;
	border: none;
background-color:#B0E0E6;	
}
input[type=date]:focus {
	background-color:#87CEFA;
	border: 5 px;
}

select{
font-family: Oldtown, fantasy;
font-size: 15px;
 width: 100%;
 padding: 15px 22px;
 margin: 10px 5px;
 border: none;
 color: white;
 background-color: #B0E0E6;  


}

.contenido{
background-color:#B0C4DE;

}



</style>
</head>

<div class="contenido">

	<div class="buscador">
	<br>
	<div class="buscar">
	<h2> Encuentra tu mejor oportunidad:</h2> 
	<p class="postbuscar"><i>Y disfruta de esta gran experiencia con nosotros</i></p><br>
	</div>	
	
	<div class="fila">
	<form:form method="POST" action="buscar"
		modelAttribute="busquedaBean">
			<div class="columna">
		<h3>Fecha inicio</h3> 
		<form:input type="date" name="fechaInicio" path="fechaInicio"/> 
			</div>
		
			<div class="columna">
		<h3> Fecha salida </h3> 
		<form:input type="date" name="fechaFin" path="fechaFin"/>
			</div>
	</form:form>

		<div class="columna">
	<h3> Hotel </h3> 
	<select name="hotel">	
	<option> Business Hotels </option>
	<option> Vacation Hotels </option>
	<option> Resorts </option>	
	</select>
		</div>
	
	</div>
	
	
	</div>	
	<br> 
	<br>
	<br> 
	<br>
	<br> 
	<br>
	<br>  
	<br>
	
	</div>
	<hr>


</body>
</html>


<!---
Falta saber de donde se coge los hoteles

--->