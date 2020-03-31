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
        </style>
    
    <!-- Cabecera de la pagina -->
        <head>
        	<div  id="cabecera" class="row justify-content-center" >
        		<h1 style="font-size: 50px; font-family:Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;">Encargar comida</h1>
        	</div>     
        </head>
        
        <form action="/enviarComanda" method="get">
        <div class="container">
        	
        	
				<h2> Platos</h2> 
				
			
			<c:forEach var="platos" items="${todo.platos}">
				<div class="row pl-5">
					<div class="col justify-content-left">
		        		<input type=hidden name="platos" value="${platos}">${platos}</input> <br></br>
		        	</div>
		        	<div class="col">
		        		 <input name="num_platos" type="number" value=0 min=0>  </input> <br></br>
		        	 </div>
		         </div>
		
		    </c:forEach>
		    
		    
		 
		 	
 		</div>
 		<div class="container">
 		
		 	<h2> Bebidas</h2>
		 	<div class="row">
		 	
		 	</div>
		    <c:forEach var="item" items="${todo.item}">
		    <div class="row pl-5">
		        
		        <div class="col justify-content-left">
		         <input type=hidden name="items" value="${item}">${item}</input> <br></br>
		         </div>
		        	<div class="col">
		        		 <input name="num_items" type="number" value=0 min=0>  </input> <br></br>
		        	 </div>
		        </div>	 
		        
		
		    </c:forEach>
		    </div>
			<div style="text-align:center;" >
		     <input type="submit" value="Enviar">
		    </div>
		</form>
		    
	
		  <script src="https://code.jquery.com/jquery-3.3.1.min.js"  crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
    </body>
    </html>