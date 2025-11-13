<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crear Producto</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
<div class="container">
	<h2>Crear Producto</h2>
	<form action="/productos/guardar" method="post">
	   <div class="mb-3">
		  <label for="nombre" class="form-label">Nombre:</label>
		  <input type="text" class="form-control" id="nombre" name="nombre">
		</div>
		<div class="mb-3">
		  <label for="precio" class="form-label">Precio:</label>
		  <input type="number" class="form-control" id="precio" name="precio" step="0.01">
		</div>
	  	<button type="submit" class="btn btn-primary">Guardar Producto</button>
	</form>
</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
</body>
</html>