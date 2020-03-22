<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

    <!DOCTYPE html>

    <h1>
        ENCARGOS DE COMIDA
    </h1>

    <c:forEach items="${EncargarComidController.recibirPlatos()}" var="platos">
        <p>Plato ${platos} </p>



    </c:forEach>
    