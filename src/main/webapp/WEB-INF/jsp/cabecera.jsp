<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>
<head>

<title>Home Page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="/css/cabecera.css" media="screen" />

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