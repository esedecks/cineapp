<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">   
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Listado de Horarios</title>
  	<spring:url value="/resources" var="urlPublic" />
  	<spring:url value="/" var="urlRoot"/>
  	 <spring:url value="/horarios/create" var="nuevoHorario"/>
  	 <spring:url value="/horarios/edit" var="editarHorario"/>
  	 <spring:url value="/horarios/delete" var="eliminarHorario"/>
    <link href="${urlPublic}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">
    
  </head>

  <body>
	<jsp:include page="../includes/menu.jsp"/>

    <div class="container theme-showcase" role="main">

      <h3>Listado de Horarios</h3>
	<c:if test="${mensaje ne null }">
		<div class="alert alert-success" role="alert">
			${mensaje}
		</div>
	</c:if>
      <a href="${nuevoHorario}" class="btn btn-success" role="button" title="Nueva Horario" >Nuevo</a><br><br>
	
      <div class="table-responsive">
        <table class="table table-hover table-striped table-bordered">
        	<thead>
        		<tr>
	                <th>Pelicula</th>
	                <th>Fecha</th>
	                <th>Hora</th>
	                <th>Sala</th>
	                <th>Precio</th>
	                <th>Opciones</th>
            	</tr>
        	</thead>
            <tbody>
            	<c:forEach items="${horarios}" var="horario">
            		<tr>
		                <td>${horario.pelicula.titulo}</td>
		                <td>${horario.fecha}</td>
		                <td>${horario.hora}</td>
		                <td>${horario.sala}</td>
		                <td>${horario.precio}</td>              
		                <td>
							<a href="${editarHorario}/${horario.id}" class="btn btn-success btn-sm" role="button" title="Edit" ><span class="glyphicon glyphicon-pencil"></span></a>
							<a href="${eliminarHorario}/${horario.id}" class="btn btn-danger btn-sm" role="button" title="Delete" ><span class="glyphicon glyphicon-trash"></span></a>
						</td>
		            </tr>	
            	</c:forEach>
            </tbody>
<!--             <tr> -->
<!--                 <td>titulo</td> -->
<!--                 <td>fecha</td> -->
<!--                 <td>hora</td> -->
<!--                 <td>sala</td> -->
<!--                 <td>precio</td>               -->
<!--                 <td> -->
<!-- 					<a href="#" class="btn btn-success btn-sm" role="button" title="Edit" ><span class="glyphicon glyphicon-pencil"></span></a> -->
<!-- 					<a href="#" class="btn btn-danger btn-sm" role="button" title="Delete" ><span class="glyphicon glyphicon-trash"></span></a> -->
<!-- 				</td> -->
<!--             </tr> -->
<!--             <tr> -->
<!--                 <td>titulo</td> -->
<!--                 <td>fecha</td> -->
<!--                 <td>hora</td> -->
<!--                 <td>sala</td> -->
<!--                 <td>precio</td>     	     -->
<!--                 <td> -->
<!-- 					<a href="#" class="btn btn-success btn-sm" role="button" title="Edit" ><span class="glyphicon glyphicon-pencil"></span></a> -->
<!-- 					<a href="#" class="btn btn-danger btn-sm" role="button" title="Delete" ><span class="glyphicon glyphicon-trash"></span></a> -->
<!-- 				</td> -->
<!--             </tr> -->
<!--             <tr> -->
<!--                 <td>titulo</td> -->
<!--                 <td>fecha</td> -->
<!--                 <td>hora</td> -->
<!--                 <td>sala</td> -->
<!--                 <td>precio</td>     			 -->
<!--                 <td> -->
<!-- 					<a href="#" class="btn btn-success btn-sm" role="button" title="Edit" ><span class="glyphicon glyphicon-pencil"></span></a> -->
<!-- 					<a href="#" class="btn btn-danger btn-sm" role="button" title="Delete" ><span class="glyphicon glyphicon-trash"></span></a> -->
<!-- 				</td> -->
<!--             </tr> -->
        </table>
      </div>
      <hr class="featurette-divider">

      <!-- FOOTER -->
	<jsp:include page="../includes/footer.jsp"/>
    </div> <!-- /container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
    <script src="${urlPublic}/bootstrap/js/bootstrap.min.js"></script> 

  </body>
</html>
