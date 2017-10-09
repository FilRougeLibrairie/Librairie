<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/zocial.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <title>Caroline</title>
    </head>
    <body>
        <div class="contener">

            <div class ="cadre">
        
        
        
        <c:url value="ControllerMain?section=menu-main" var="url01" />
        <c:import url="${url01}" />
        <h1>Home</h1>
        
            </div>
        </div>
    </body>
</html>