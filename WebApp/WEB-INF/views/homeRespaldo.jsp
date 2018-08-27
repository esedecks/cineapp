<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bienvenido a Cineapp</title>
	<spring:url value="/resources" var="urlPublic" />
	<link href="${urlPublic}/css/myStyle.css" rel="stylesheet">
	<link rel="stylesheet" href="${urlPublic}/bootstrap/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	
	
</head>
<body>

	<div class="panel panel-default">
  		<div class="panel-heading">Lista de peliculas</div>
 			<div class="panel-body">
			<table class="table table-striped table-bordered table-hover"  >
				<thead>
					<tr>
						<th>Id Pelicula</th>
						<th>Título</th>
						<th>Duración</th>
						<th>Clasificación</th>
						<th>Género</th>
						<th>Imagen</th>
						<th>Fecha de estreno</th>
						<th>Estatus</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${peliculas}" var="pelicula">
						<tr>
							<td>${pelicula.id}</td>
							<td>${pelicula.titulo}</td>
							<td>${pelicula.duracion}</td>
							<td>${pelicula.clasificacion}</td>
							<td>${pelicula.genero}</td>
							<td><img width="80px" height="100px" alt="imagen" src="${urlPublic}/images/${pelicula.imagen}"></td>
							<td><fmt:formatDate value="${pelicula.fechaEstreno}" pattern="dd-MM-yyyy"/> </td>
							<td>
								<c:choose>
									<c:when test="${pelicula.estatus =='Activa'}">
										<span class="label label-success">ACTIVA</span>
									</c:when>
									<c:otherwise>
										<span class="label label-danger">INACTIVA</span>
									</c:otherwise>
								 </c:choose> 
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		 </div>
	</div>
</body>
</html>
