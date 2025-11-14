<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crear Persona</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
<div class="container">
	<h2>Crear Persona</h2>
	<form action="/personas/guardar" method="post">
	   <div class="mb-3">
		  <label for="nombre" class="form-label">Nombre:</label>
		  <input type="text" class="form-control" id="nombre" name="nombre">
		</div>
		<div class="mb-3">
		  <label for="email" class="form-label">Email:</label>
		  <input type="email" class="form-control" id="email" name="email">
		</div>
	  	<button type="submit" class="btn btn-primary">Guardar Persona</button>
	</form>
</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
</body>
</html>