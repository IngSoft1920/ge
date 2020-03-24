<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

    <!DOCTYPE html>

    <h1>
        ENCARGOS DE COMIDA
    </h1>

	<h2> Platos</h2>
	<form action="/enviarComanda" method="get">
	<c:forEach var="platos" items="${todo.platos}">
        <input type="checkbox" name="platos" value="${platos}" >${platos}</input> <br></br>
         <input type="text"> Cantidad</input> <br></br>

    </c:forEach>
    
    <input type="submit" value="Enviar">
 	</form>
 	
 	
 	<h2> Bebidas</h2>
 	
 	
    <c:forEach var="Servicios" items="${todo.item}">
        <h4>${Servicios} </h4>
         <input type="text"> Cantidad</input>

    </c:forEach>
    
    <button type=submit> Pedir </button>
    