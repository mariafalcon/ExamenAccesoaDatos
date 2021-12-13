<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/estilos.css"/>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body style="background-color:#D1ECFF">
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="#">Gestión Pedidos</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Inicio <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Link</a>
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
        <a class="nav-link disabled" href="#">Disabled</a>
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
  <h1>INSERTAR CLIENTE</h1>
  <hr>
   <!--  insertarCliente es el método de la interfaz -->
   <form:form action="insertar" modelAttribute="cliente" method="POST">   
   <!--  para usarlo en la parte de modificar el registro ya que carga el id tambien al recuperar el registro-->  
     <form:hidden path="id"/>  
     <table border="1">
      <tr>
      <td id="cabecera">Nombre</td><td><form:input path="nombre" /></td>
      </tr>
      <tr>
     <td id="cabecera">Apellidos</td><td><form:input path="apellido" /></td>
     </tr>
     <tr>
     <td id="cabecera">Email</td><td><form:input path="email" /></td>
     </tr>
     <tr>
     <td colspan="2"><button class="btn btn-dark btn-lg" type="submit">insertar/actualizar</button></td>
     </tr>
  </table>

</form:form>
<br>
<br>
   <button class="btn btn-outline-primary" onclick="window.location.href='lista';" type="button">Regresar</button>
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


