<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Empleados</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Empleados y sus Cuentas</h1>
	    <table class="table">
	        <tr>
	        <th>#</th>
	            <th>Nombre</th>
	            <th>Puesto</th>
	            <th>Nombre de Usuario</th>
	            <th>Departamento</th>
	        </tr>
	        <c:forEach var="emp" items="${empleados}">
	            <tr>
	                <td>${emp.id}</td>
	                <td>${emp.nombre}</td>
	                <td>${emp.puesto}</td>
	                <td>${emp.cuentaUsuario.nombreUsuario}</td>
	                <td>${emp.departamento.nombre}</td>
	            </tr>
	        </c:forEach>
	    </table>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
</body>
</html>