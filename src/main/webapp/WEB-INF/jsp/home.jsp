<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="cabecera.jsp"></jsp:include>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<html lang="en">

    <meta name="viewport" content="width=device-width, initial-scale=1">
	<script src="https://kit.fontawesome.com/4a78b6bb03.js" crossorigin="anonymous"></script>    
    <style>
    .card {
      box-shadow: 0 4px 5px 0 rgba(0,0,0,0.2);
      transition: 0.3s;
      width: 30%;
    }
    
    .card:hover {
      box-shadow: 0 8px 10px 0 rgba(0,0,0,0.2);
    }


    .grid-container {
    display: grid;
    grid-template-columns: auto auto auto;
    padding: 10px;
    justify-content: center;
    width:100%;
    text-align: center;
    }
    .card {
    background-color: black;
    opacity: 40%;
    border: 1px solid rgba(0, 0, 0, 0.8);
    padding: 30px;
    width: 250px;
    margin-top: 90px;
    margin-left: 60px;
    margin-right: 60px;
    height: 70%;
    }
    
    a{
    font-family: times new roman;
    font-size: 25px;
    text-align: center;
    color:white;
    }
    
    p{
    font-family: times new roman;
    text-align: center;
    color:white;
    font-size: 20px;
    }
    </style>
    
   

    <head charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Home</title>
        
    </head>

 
    <body style="background: radial-gradient(beige, transparent);">


       <div class="grid-container">
       <div class="card" onclick="document.location = '/buscador'">
        <div class="container", style="padding-top:20px">
          <a><b>Crear nueva reserva</b></a> 
        </div>
      </div>
      

      <div class="card" onclick="document.location = '/misReservas'">
        <div class="container", style="padding-top:20px">
          <a><b>Consultar reservas</b></a> 
        </div>
      </div>
      
        <div class="card" onclick="document.location = '/index'">
        <div class="container", style="padding-top:20px">
          <a><b>Gestionar mi estancia</b></a> 
        </div>
      </div>
      

      </div>


    </body>
</html>