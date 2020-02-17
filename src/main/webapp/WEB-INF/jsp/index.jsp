<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>

<html lang="en">

    <meta name="viewport" content="width=device-width, initial-scale=1">
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
    background-color: lightsalmon;
    opacity: 60%;
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
    color:grey;
    }
   
    </style>

    <head charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Cliente</title>
    </head>

    <body style="background: radial-gradient(beige, transparent);">
       <div style="margin-top:40px; background-color: lightsalmon; opacity: 30%;">
        <h1 style="text-align: center;font-size: 50px; font-family:Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;">Welcome App</h1>
       </div> 

       <div class="grid-container">
       <div class="card" onclick="document.location = 'reservas.html'">
        <div class="container", style="padding-top:20px">
          <a href="/reservas"><b>Reservas</b></a> 
          <p style="font-family: cursive;text-align: center;">¡Acceda para gestionar su reserva!</p> 
        </div>
      </div>
      

      <div class="card">
        <div class="container", style="padding-top:20px">
          <a href="/servicios"><b>Servicios</b></a> 
          <p style="font-family: cursive;text-align: center;">¡Acceda para gestionar y reportar los servicios solicitados!</p> 
        </div>
      </div>
      
        <div class="card">
        <div class="container", style="padding-top:20px">
          <a href="/incidencias"><b>Incidencias</b></a> 
          <p style="font-family: cursive;text-align: center;">¡Acceda para gestionar y reportar los servicios solicitados!</p> 
        </div>
      </div>
      

      </div>

    <script>
        function login (event){
           alert("Login no implementado todavía!")
        }
        </script>
    </body>
</html>