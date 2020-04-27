<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<jsp:include page="cabecera.jsp"></jsp:include>

    <!DOCTYPE html>
    
    <html lang="en">
    <header>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

    </header>
    <body>
    <style>
        .container {
                margin-top: 20px;
                margin-bottom: 20px;
                padding: 10px;
                border-color: black;
                border-style:solid;
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

     
        
       
        </style>
    
    <!-- Cabecera de la pagina -->
        <head>
        	<div  id="cabecera" class="row justify-content-center" >
        		<h1 style="font-size: 50px; font-family:Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;">Encargar comida</h1>
        	</div>     
        </head>
        
        <form action="/enviarComanda" method="post">
        <div class="container p-3">
            
            <div class="row p-3">
                <div class="col-12" id="paraEmpezar">
                    <h3 class="text-center p-1" style="border-bottom: solid;border-bottom-width: thin; border-bottom-color:black" onclick="mostrarEntrantes()"> Platos principales</h3>
                </div>
            

                <div id="entrantes" class="col-12" style="  display: none">
                    <c:forEach var="platos" items="${todo.platos}">
                        <div class="row pl-5">
                            <div class="col m-b-3">
                                <input type=hidden name="platos" value="${platos}">${platos}
                            </div>
                            <div class="col m-b-3">
                                 <input name="num_platos" type="number" value=0 min=0>  
                             </div>
                         </div>
                        <br>

                    </c:forEach>

		    
                </div>
            </div>
        
            
 		
            
            <div class="row p-3">
                <div id="paraBeber" class="col-12"  onclick="mostrarBebidas()">
                    <h3 class="text-center p-1" style="border-bottom: solid;border-bottom-width: thin; border-bottom-color:black" >Para beber</h3>
                 </div>
                 <div id="bebidas" class="col-12" style="display: none" >
                    <c:forEach var="item" items="${todo.item}">
                    <div class="row pl-5">

                        <div class="col m-b-2">
                         <input type=hidden name="items" value="${item}">${item}
                         </div>
                            <div class="col">
                                 <input name="num_items" type="number" value=0 min=0>
                             </div>
                        </div>	 
                        <br>


                    </c:forEach>
                </div>
            </div>
        
        <div class="row p-3">
                <div id="Pedir" class="col-12"  onclick="mostrarBoton()">
                    <h3 class="text-centerp-1" style="border-bottom: solid;border-bottom-width: thin; border-bottom-color:black">Realizar pedido</h3>
                 </div>
            </div>
            <div class="row justify-content-center">
                <div id="boton" class="col-12 justify-content-center" style="display: none">
                 <input type="submit" value="Pedir">
                </div>
          </div>
       
    </div>
        </form>
        
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"  crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
        
        <script type="application/javascript">
            
            function mostrarEntrantes(){
                $('#entrantes').slideDown();
                $('#bebidas').slideUp();
                $('#boton').slideUp();
            }
            function mostrarBoton(){
                $('#boton').slideDown();
                $('#entrantes').slideUp();
                $('#postres').slideUp();
                $('#bebidas').slideUp();
            }
            
            function mostrarBebidas(){
                $('#bebidas').slideDown();
                $('#entrantes').slideUp();
                $('#boton').slideUp();
            }
        </script>
    </body>
    </html>