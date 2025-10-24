<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Lista de contactos</title>
</head>
<body>

<nav>
  <a href="<c:url value='/contacto/form'/>">Formulario</a> |
  <a href="<c:url value='/contacto/lista'/>">Lista</a>
</nav>

<h1>Listado de contactos</h1>

<form action="<c:url value='/contacto/buscar'/>" method="get">
  <input type="text" name="nombre" placeholder="Buscar por nombre..." value="<c:out value='${q}'/>" />
  <button type="submit">Buscar</button>
  <a href="<c:url value='/contacto/lista'/>">Limpiar</a>
</form>

<c:if test="${empty contactos}">
  <p>No hay contactos registrados.</p>
</c:if>

<c:if test="${not empty contactos}">
  <table border="1" cellpadding="6" cellspacing="0">
    <thead>
      <tr>
        <th>#</th>
        <th>Nombre</th>
        <th>Correo</th>
        <th>Teléfono</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="c" items="${contactos}" varStatus="st">
        <tr>
          <td><c:out value="${st.index + 1}"/></td>
          <td><c:out value="${c.nombre}"/></td>
          <td><c:out value="${c.correo}"/></td>
          <td><c:out value="${c.telefono}"/></td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</c:if>

</body>
</html>
