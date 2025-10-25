<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Nuevo evento</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-50 min-h-screen">
<div class="container mx-auto px-4 py-8 max-w-2xl">
<!-- Navegación -->
<nav class="mb-8 flex gap-4">
<a href="<c:url value='/eventos'/>" class="text-blue-600 hover:text-blue-800 font-medium">Ver eventos</a>
<a href="<c:url value='/eventos/nuevo'/>" class="text-blue-600 hover:text-blue-800 font-medium">Nuevo</a>
</nav>

<h1 class="text-3xl font-bold text-gray-900 mb-6">Registrar evento</h1>

<!-- Mensaje de éxito -->
<c:if test="${not empty mensaje}">
<div class="bg-green-50 border border-green-200 text-green-800 px-4 py-3 rounded-lg mb-6">
<c:out value="${mensaje}" />
</div>
</c:if>

<!-- Formulario -->
<form action="<c:url value='/eventos/guardar'/>" method="post" class="bg-white shadow-md rounded-lg p-6 space-y-5">
<div>
<label for="titulo" class="block text-sm font-semibold text-gray-700 mb-2">Título</label>
<input type="text" id="titulo" name="titulo" value="<c:out value='${evento.titulo}'/>" required
class="w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500 focus:border-blue-500">
</div>

<div>
<label for="fecha" class="block text-sm font-semibold text-gray-700 mb-2">Fecha</label>
<input type="date" id="fecha" name="fecha" value="<c:out value='${evento.fecha}'/>" required
class="w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500 focus:border-blue-500">
</div>

<div>
<label for="descripcion" class="block text-sm font-semibold text-gray-700 mb-2">Descripción</label>
<textarea id="descripcion" name="descripcion" rows="4"
class="w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500 focus:border-blue-500"><c:out value='${evento.descripcion}'/></textarea>
</div>

<div>
<label for="responsable" class="block text-sm font-semibold text-gray-700 mb-2">Responsable</label>
<input type="text" id="responsable" name="responsable" value="<c:out value='${evento.responsable}'/>" required
class="w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500 focus:border-blue-500">
</div>

<button type="submit" class="w-full bg-blue-600 hover:bg-blue-700 text-white font-semibold py-3 px-4 rounded-lg transition duration-200">
Guardar evento
</button>
</form>
</div>
</body>
</html>