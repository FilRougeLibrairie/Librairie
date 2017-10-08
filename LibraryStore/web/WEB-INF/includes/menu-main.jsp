<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p>
    <c:url value="ControllerMain" var="url01" />
    <c:url value="ControllerMain?section=catalog" var="url02" />
    <a href="${url01}">Accueil</a> |
    <a href="${url02}">CATALOG</a>
</p>
<hr />
