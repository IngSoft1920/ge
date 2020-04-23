<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="cabecera.jsp"></jsp:include>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<html lang="en">
<header>
     	<meta name="viewport" content="width=device-width, initial-scale=1">
		<script src="https://kit.fontawesome.com/4a78b6bb03.js" crossorigin="anonymous"></script> 
        <meta charset="UTF-8"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
   </header> 

      
<body>
    <style>
        
        
        .container {
            background: url(/imagenes/fondo2.jpg) fixed center no-repeat;
            background-size: cover;
            margin-top: 20px;
            margin-bottom: 20px;
            padding: 10px;
            border-color: black;
            border-style: solid;
            background-color: #333;
            opacity: 85%;
            text-align: center;
            color: #b8b070;        
        }
        
         #cabecera{
	            background-color: #333;
	            opacity: 90%;
	            border-top-style: solid;
	            border-bottom-style: solid;
	            border-color: black;
	            color: #b8b070;
	            margin-top: 80px; 
	            margin-bottom: 30px;
	        }
	        
	   .card{
            border-style: solid;
            border-color: black;            
            padding:15px;
            margin-bottom: 50px;
            margin-left: 10px;
            margin-right: 10px;
            cursor: pointer;
        }
        
        .card:hover {
            box-shadow: 0 12px 15px 0 rgba(0,0,0,0.2);
        }
        
        #reservas{
            background-color: #333;
            border: 3px solid rgba(0, 0, 0, 0.8);
            color: white;
            padding: 20px;
            text-align: center;
            text-decoration: none;
            text-decoration: none;
            font-size: 16px;
            cursor: pointer;
            border-radius: 50%;
            opacity:70%;
            
        }
        
        #reservas:hover{
        	opacity:90%;
        }

    </style>
    
    <head>
       <div id="cabecera" class="row justify-content-center">
          <h1 style="font-size: 50px; font-family:Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;">¿Qué le gustaría hacer?</h1>
        </div> 
     </head>
   
     
        <div id="cuerpo" class="container  mb-0 p-5" >
            
            <div class="row">
                <div class="col-xl-6 col-sm-12">
                    <div class="card" style="background-color:#333; opacity: 100%;" onclick="document.location = '/recibirServicios'">
                        <a><b>Servicios</b></a> 
                        <p>¡Gestione los servicios solicitados!</p>
                        <i class="far fa-address-card"></i>
                    </div>
                </div>
                <div class="col-xl-6 col-sm-12">
                    <div class="card" style="background-color:#333; opacity: 100%;" onclick="document.location = '/incidencias'">
                        <a><b>Incidencias</b></a> 
                        <p>¡Acceda para gestionar y reportar los servicios solicitados!</p>
                        <i class="far fa-edit" ></i>
                    </div>
                </div>
            </div>
            
           
            
           
            
            <div class="row">
                <!-- Boton de reservas -->
                <div style="width:100%;justify-content:center; display:flex;" onclick="document.location = '/recibirReservas'">
                   <input id="reservas" type="button" value="Reservas en curso">
             	    </div>
            
            </div>
        
        </div>
        
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
        
               
    </body>
</html>