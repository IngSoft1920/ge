<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="cabecera.jsp"></jsp:include>


<!DOCTYPE html>
<html lang="en">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
.aspecto {
	text-align: center;
	margin-top: 60px;
	margin: 20px;
	padding: 10px;
	background-color: orange;
	opacity: 50%;
}

.card {
	box-shadow: 0 4px 5px 0 rgba(0, 0, 0, 0.2);
	transition: 0.3s;
	width: 30%;
}

.card:hover {
	box-shadow: 0 8px 10px 0 rgba(0, 0, 0, 0.2);
}

div.w-33 {
	width: 100%;
	background-color: white;
}

div.center {
	text-align: center;
}

.grid-container {
	display: grid;
	grid-template-columns: auto auto;
	padding: 10px;
	justify-content: center;
}

.card {
	background-color: orange;
	opacity: 50%;
	border: 1px solid rgba(0, 0, 0, 0.8);
	padding: 30px;
	width: 250px;
	margin-top: 30px;
	margin-left: 60px;
	margin-right: 60px;
}
</style>
<body style="background: radial-gradient(beige, transparent);">

	<div style="margin-top: 40px; background-color: orange; opacity: 30%;">
		<h1
			style="text-align: center; font-size: 50px; font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;">Facturacion</h1>
	</div>

	<div class="aspecto">
		<form method="GET" style="width: 100%;" action="factura"
			modelAttribute="facturaBean">
			<label>Nº Reserva</label> <br>
			<textarea name="idReserva" rows="2" cols="10"
				style="margin-top: 5px; margin-bottom: 15px">
				</textarea>
			<br> <label>Factura PDF</label><br> <input type="text"
				size="20" value="hola" readonly name="facturaPdf"
				style="margin-top: 5px; margin-bottom: 10px"></input><br> <br>
			<br> <input type="submit" value="Enviar">
		</form>
	</div>
</body>
</html>

