<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:url value="ControllerMain?section=menu-main" var="url01" />
        <c:import url="${url01}" />
        <h2>DISPLAY CATALOG</h2>
    </body>
</html>
