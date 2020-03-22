<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

    <!DOCTYPE html>

    <h1>
        ENCARGOS DE COMIDA
    </h1>

    <c:forEach var="Servicios" items="${servicios_de_un_hotel}">
        <h1>Plato ${Servicios} </h1>



    </c:forEach>
    