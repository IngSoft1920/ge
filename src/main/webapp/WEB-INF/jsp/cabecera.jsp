<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


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
 img {
  display: inline-block;
}

.top{
 
    position: fixed;
    
    background-color: #222;
    opacity: 1;
    width: 100%;
    top: 0;
    z-index: 1;
    
}

body{
width: 100%;
padding-top: 50px;
}



</style>
</head>
<header>
<div class="top">
	<ul id="button">
 <li><a href="/buscador"><img src="/imagenes/icon.jpg"/></li>
 
 
 <li id="menu"> 
 
 <a href="${sesionBean.redirect}" value="${sesionBean.usuario}">${sesionBean.usuario}</a> 
 <!--  
 <% if(request.getSession(false)==null){ %>
 ${sesionBean.usuarioID}
 
 <%}else{ %> 
 <a href="${sesionBean.redirect}" value="${sesionBean.usuario}">${sesionBean.usuario}</a> 
  
 <% } %>
-->
 
 </li>
 


 <li id="menu"><a href="/buscador">Buscar</a></li>
 </ul>
 
</div>
</header>

<body>

</body>
</html>