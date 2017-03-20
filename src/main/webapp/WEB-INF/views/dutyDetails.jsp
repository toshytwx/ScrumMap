<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 19.03.2017
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Duty Details</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="jumbotron">
        <p>
            <h1><c:out value="${dutyName}"/></h1>
            <h3>Start Date: <c:out value="${dutyStartDate}"/> Alloted time: <c:out value="${dutyDuration}"/></h3>
        </p>
        <hr>
        <p class="lead">
            <h2>
                <c:out value="${dutyDescription}"/>
            </h2>
        <hr>
        <h2>
            <c:out value="${dutyStatus} / "/>
            <c:out value="${dutyImportance}"/>
        </h2>
        </p>
        <hr>
        <p style="text-align: center"><a class="btn btn-lg btn-success" href="${contextPath}/welcome" role="button">Home</a></p>
    </div>
</div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>

