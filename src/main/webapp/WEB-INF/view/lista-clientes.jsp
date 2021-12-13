<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Clientes</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/estilos.css"/>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body style="background-color:#D1ECFF">
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="#">Gestión clientes</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="lista">Inicio <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="lista2">Gestión Pedidos</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Dropdown
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="#">Action</a>
          <a class="dropdown-item" href="#">Another action</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">Something else here</a>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="lista3">Gestión Artículos</a>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>
<center>
<br>
<h1> Bienvenidos al Proyecto</h1>
<hr>
<img alt="foto" src="${pageContext.request.contextPath}/resources/imgs/clientes.jpg" hight="140" width="140">
<table border="1">
<tr id="cabecera">
<td> Id </td>
<td>Nombre</td>
<td> Apellidos </td>
<td> Email </td>
<td> Modificar </td>
<td> Eliminar </td>
</tr>
<c:forEach var="clienteTemp" items="${clientes}">
<c:url var="linkActualizar" value="/cliente/muestraFormularioActualizar">
<c:param name="clienteId" value="${clienteTemp.id}"/>
</c:url>
<c:url var="linkEliminar" value="/cliente/eliminar">
<c:param name="clienteId" value="${clienteTemp.id}"/>
</c:url>
<tr>
<td>${clienteTemp.id } </td>
<td>${clienteTemp.nombre } </td>
<td>${clienteTemp.apellido } </td>
<td>${clienteTemp.email } </td>
<td><a href="${linkActualizar}"><button type="button" class="btn btn-primary btn-lg">Modificar</button></a></td>
<td><a href="${linkEliminar}"><button type="button" class="btn btn-danger btn-lg" onclick="if(!(confirm('Vas a eliminar un registro.¿Estas seguro?'))) return false"/>Eliminar</button></a> </td>
</tr>
</c:forEach>
</table>
<br>
<button class="btn btn-outline-primary my-2 my-sm-0" onclick="window.location.href='muestraFormularioAgregar'; return false;">Agregar cliente</button>
<button class="btn btn-outline-dark my-2 my-sm-0" onclick="window.location.href='lista2'">Ver Pedidos</button>
<button class="btn btn-outline-primary my-2 my-sm-0" onclick="window.location.href='lista3'">Ver Artículos</button>
</center>
<br>
<br>
<br>
<footer>
	   <div class="container-footer-all">  
          
		  <div class="container-body">  
	          <div class="columna1">
			  <h2>Mas información de la compañía</h2>
			  Esto es un proyecto de clases
			  </div>  
		      <div class="columna2">
			     <h2>Redes Sociales</h2>
			     <div class="rows">
			         <img src="${pageContext.request.contextPath}/resources/imgs/facebook1.png"> 
					 <label>Siguenos en Facebook</label>
				 </div>
			     <div class="rows">
			         <img src="${pageContext.request.contextPath}/resources/imgs/twitter.png"> 
					 <label>Siguenos en Twitter</label>
				 </div>
				 <div class="rows">
			         <img src="${pageContext.request.contextPath}/resources/imgs/instagram1.png"> 
					 <label>Siguenos en Instagram</label>
				 </div>
				 <div class="rows">
			         <img src="${pageContext.request.contextPath}/resources/imgs/youtube1.png"> 
					 <label>Siguenos en YouTube</label>
				 </div>
				 <div class="rows">
			         <img src="${pageContext.request.contextPath}/resources/imgs/pinterest.png"> 
					 <label>Siguenos en Pinterest</label>
				 </div>
			  </div>  
			  
		      <div class="columna3">
			      <h2>Información Contactos</h2>
				  <div class="row2">
				      <img src="${pageContext.request.contextPath}/resources/imgs/casita.png"> 
			          <label>
					  Madrid,
					  España
					  Albufera
			          Centro Cultural Salmantino
					  </label>
				  </div>  
				  <div class="row2">
				      <img src="${pageContext.request.contextPath}/resources/imgs/telefono.png"> 
			          <label>+34 653212345</label>
				  </div>  
			      <div class="row2">
				      <img src="${pageContext.request.contextPath}/resources/imgs/gmail1.png"> 
			          <label>colegio@gmail.com</label>
				  </div>  
			  
			  </div>  
			</div>
        </div>           
		
		<div class="container-footer">
		  <div class="footer">
	       	   <div class="copyright">
	             Copyright ©2021 Todos los derechos reservados | <a href="salmantino.com">salmantino.com</a>
		       </div>
		       <div class="information">
			       <a href="">Política de Privacidad</a>|
			       <a href="">Términos y Condiciones</a>|
                   <a href="/">Aviso Legal</a>|
                   <a href="/">Quiénes somos</a>|
	               <a href="/">Contactar</a>
			   </div>
	       </div>
		 </div>
   </footer>   

     </body>
</html>
</body>
</html>
