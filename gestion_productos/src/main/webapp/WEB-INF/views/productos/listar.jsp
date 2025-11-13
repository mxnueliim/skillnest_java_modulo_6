<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detalle de Producto</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
<div class="container">
	<h2>Lista de productos</h2>
	<p>${mensaje}</p>
	<div class="table-responsive">
	<table class="table">
	  <thead>
	    <tr>
	      <th scope="col">#</th>
	      <th scope="col">Nombre</th>
	      <th scope="col">Detalle</th>
	      <th scope="col">Cantidad</th>
	      <th scope="col">Precio</th>
	      <th scope="col-2">Acciones</th>
		</tr>
	  </thead>
	  <tbody>
  		<c:forEach var="producto" items="${lista_productos}">
		    <tr>
		      <th scope="row">${producto.id}</th>
		      <td>${producto.nombre}</td>
		      <td>${producto.detalle}</td>
		      <td>${producto.cantidad}</td>
		      <td>${producto.precio}</td>
		      <td>editar</td>
		      <td>eliminar</td>
		    </tr>
		</c:forEach>
  </tbody>
</table>
</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
</div>
</body>
</html>