<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
.card {
	background-color: lightsalmon;
	opacity: 60%;
	border: 1px solid rgba(0, 0, 0, 0.8);
	padding: 30px;
	margin: auto;
	width: 250px;
	text-align: center;
	margin-top: 250px;
}

.boton {
	padding: 20px;
	justify-content: center;
	display: flex;
}
</style>


</head>
<body style="background: radial-gradient(beige, transparent);">
	<jsp:useBean id="bean" class="ingsoft1920.ge.BeansGE1.IncidenciasBean" />
	



	<div class="card">
		<b>¡Incidencia enviada con éxito!</b> <br> <br>
		El asunto es ${Incidencia.asunto} con mensaje ${Incidencia.mensaje}
		<% out.print("ASUNTOBEAN: " + bean.getAsunto());%>
		<%-- <%
			String asunto = (String) request.getParameter("asunto");
			String asunto1 = (String) request.getParameter("asunto1");
			String mensaje1 = (String) request.getParameter("mensaje1");
			String mensaje2 = (String) request.getParameter("mensaje2");
			out.print("Asunto1: " + asunto1);
			out.print("<br/>");
			out.print("ASUNTOBEAN: " + bean.getAsunto());
			out.print("<br/>");
			out.print("Asunto: " + asunto);
			out.print("<br/>");
			out.print("mensaje111: " + mensaje1);
			out.print("<br/>");
			if (!mensaje1.equals("Otro")) {
				out.print("Mensaje: " + mensaje1);
			} else if (mensaje1.equals("Otro")) {
				out.print("Mensaje: " + mensaje2);
			}
		%>

<jsp:setProperty name="bean" property="asunto" value="<%=asunto%>" /> --%>

		<div class="boton">
			<input type="submit" onclick="document.location ='/index'"
				value="Volver al inicio" />
		</div>

	</div>



</body>
</html>