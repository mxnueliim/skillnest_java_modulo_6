<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Eventos</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-50 min-h-screen">
<div class="container mx-auto px-4 py-8 max-w-4xl">
<!-- Navegación -->
<nav class="mb-8 flex gap-4">
<a href="<c:url value='/eventos'/>" class="text-blue-600 hover:text-blue-800 font-medium">Eventos</a>
<a href="<c:url value='/eventos/nuevo'/>" class="text-blue-600 hover:text-blue-800 font-medium">Nuevo</a>
</nav>

<h1 class="text-3xl font-bold text-gray-900 mb-6">Agenda compartida</h1>

<!-- Filtro por fecha -->
<form class="bg-white shadow-md rounded-lg p-6 mb-8 flex flex-wrap gap-4 items-end" action="<c:url value='/eventos'/>" method="get">
<div class="flex-1 min-w-[200px]">
<label for="fecha" class="block text-sm font-semibold text-gray-700 mb-2">Filtrar por fecha:</label>
<input type="date" id="fecha" name="fecha" value="<c:out value='${filtro}'/>"
class="w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500 focus:border-blue-500">
</div>
<button type="submit" class="bg-blue-600 hover:bg-blue-700 text-white font-semibold py-2 px-6 rounded-lg transition duration-200">
Buscar
</button>
<a href="<c:url value='/eventos'/>" class="bg-gray-200 hover:bg-gray-300 text-gray-800 font-semibold py-2 px-6 rounded-lg transition duration-200">
Limpiar
</a>
</form>

<!-- Lista de eventos -->
<c:if test="${empty eventos}">
<div class="bg-white border-2 border-dashed border-gray-300 rounded-lg p-8 text-center text-gray-500">
No hay eventos para mostrar.
</div>
</c:if>

<c:if test="${not empty eventos}">
<div class="space-y-6">
<c:set var="ultimaFecha" value="" />
<c:forEach var="e" items="${eventos}">
<!-- Encabezado de grupo cuando cambia la fecha -->
<c:if test="${e.fecha ne ultimaFecha}">
<div class="border-b-2 border-gray-200 pb-2 mb-4">
<h2 class="text-2xl font-bold text-gray-800">
Fecha: <c:out value="${e.fecha}"/>
</h2>
</div>
<c:set var="ultimaFecha" value="${e.fecha}" />
</c:if>

<!-- Tarjeta del evento -->
<div class="bg-white shadow-md rounded-lg p-6 hover:shadow-lg transition duration-200">
<h3 class="text-xl font-semibold text-gray-900 mb-2">
<c:out value="${e.titulo}"/>
</h3>
<p class="text-sm text-gray-600 mb-3">
Responsable: <span class="font-medium"><c:out value="${e.responsable}"/></span>
</p>
<div class="text-gray-700">
<c:choose>
<c:when test="${not empty e.descripcion}">
<c:out value="${e.descripcion}"/>
</c:when>
<c:otherwise>
<span class="text-gray-400 italic">Sin descripción</span>
</c:otherwise>
</c:choose>
</div>
</div>
</c:forEach>
</div>
</c:if>
</div>
</body>
</html>