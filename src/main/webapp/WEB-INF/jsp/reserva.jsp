<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="cabecera.jsp"></jsp:include>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Home Page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
#button {
  margin: 0;
  padding: 20;
  overflow: hidden;
  background-color: #333;
 }
#button li {
 display: inline;
 }
#button li img{
  display: inline-block;
 float: left;
 padding: 0px;
 border: 1px;
 height: 40;
 width: 40;
}
#menu{
  display: inline-block;
 font-family: Arial;
 font-size: 15px;
 float: right;
 padding: 10px;
 }
 a:link{
  color: white;
  text-decoration: none;
 }
  a:visited{
  color: white;
    text-decoration: none;
   }
    a:active{
    color: red;
   text-decoration: none;
   }
  
  .hotel {
    font-family: Helvetica;
    padding:5px;
  }
  
  .fecha {
    font-family: Helvetica;
    margin-left:50px;
    padding:5px;
  }
  
    .habitacion {
    font-family: Helvetica;
    padding:5px;
  }
  
  .tarifa {
    font-family: Helvetica;
    margin-left:50px;
    padding:5px;
  }
  
  .reserva {
    background-color:#A8F4EA;
    border: 1px solid black;
    margin-top:5px;
    overflow:hidden
  }
  
  .cancelar {
    float:right;
    color:red;
    border:1px solid #FA220C;
    padding:5px;
    margin-right:10px;
    background-color:FFA79B
  }
  
  .titulo_historial {
    margin-top:30px;
    text-align:center;
    font-family: 'Open Sans Condensed',sans-serif; 
    font-size: 40px;
    text-decoration:underline;
  }
  
  .historial {
    background-color:#A8F4EA;
    border: 1px solid black;
    overflow:hidden
  }
  
  .fondo {
    background-color:D1F0EC;
  }
  
  .valoranos {
    float:right;
    margin-right:20px;
    display: block;
    rows:2;
  }
  
  .enviar {
    float:right;
    margin-right:30px
  }
  
    </style>
 </head>
 <body>


 <div class="reserva">
   <p class ="hotel">Hotel _____ en ______ 
   	<span class ="fecha">De dd/mm/aaaa a dd/mm/aaaa</span>
   </p>
   <p class="habitacion">Habitación:______
   	<span class="tarifa">Tarifa:______</span>
    <span class ="cancelar">Cancelar reserva</span>
   </p>
 </div>
  
    <h2 class="titulo_historial">Historial</h2>
 <div class="historial">
   <p>Hotel _____ en ______
      <span class ="valoranos">
          <textarea name="Text1" cols="40" rows="3">Cuentanos tu experiencia</textarea>
    </span>  
   </p>
   <p>De dd/mm/aaaa a dd/mm/aaaa</p>
   <p>Habitación:______
    <span>
     <button class="enviar">Enviar</button>
   </span>
   </p>
 </div>
 </body>
</html>