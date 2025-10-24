<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Nuevo contacto</title>
</head>
<body>

<nav>
  <a href="<c:url value='/contacto/form'/>">Formulario</a> |
  <a href="<c:url value='/contacto/lista'/>">Lista</a>
</nav>

<h1>Registrar contacto</h1>

<c:if test="${not empty mensaje}">
  <p><c:out value="${mensaje}"/></p>
</c:if>

<form:form action="${pageContext.request.contextPath}/contacto/registrar" method="post" modelAttribute="contacto">
  <label>Nombre:</label><br/>
  <form:input path="nombre" />
  <form:errors path="nombre" cssClass="error"/><br/><br/>

  <label>Correo:</label><br/>
  <form:input path="correo" />
  <form:errors path="correo" cssClass="error"/><br/><br/>

  <label>Teléfono:</label><br/>
  <form:input path="telefono" />
  <form:errors path="telefono" cssClass="error"/><br/><br/>

  <button type="submit">Guardar</button>
  <a href="<c:url value='/contacto/lista'/>">Ver lista</a>
</form:form>

</body>
</html>
