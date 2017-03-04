<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 02.03.2017
  Time: 13:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<div class="container">

    <c:if test="${pageContext.request.userPrincipal.name != null}">

        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <h2>Welcome ${pageContext.request.userPrincipal.name} |
            <a onclick="document.forms['logoutForm'].submit()">Logout</a> |
        </h2>
        <ul class="nav nav-pills">
            <li role="presentation" class="active" data-toggle="modal" data-target="#myModal"><a href="#">Add new Duty</a></li>
            <li role="presentation"><a href="#">Profile</a></li>
            <li role="presentation"><a href="#">Messages</a></li>
        </ul>
        <div class="modal fade" id="myModal" role="dialog">
            <div class="modal-dialog modal-sm">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">New Duty</h4>
                    </div>
                    <div class="modal-body">
                        <form  method="POST" action="${contextPath}/addduty" class="form-signin">
                            <input name="dutyname" type="text" class="form-control" placeholder="Duty Name" autofocus="true"/>
                            <input name="dutyduration" type="text" class="form-control" placeholder="Duty Duration"/>
                            <input name="dutystartdate" type="date" class="form-control" placeholder="Duty Start Date"/>
                            <input name="dutydescription" type="text" class="form-control" placeholder="Write some words"/>
                            <select name="dutyimportance">
                                <option disabled>Select importance</option>
                                <option value="Important">Important duty</option>
                                <option value="Non-important">Non-important duty</option>
                            </select>
                            <br />
                            <select name="dutystatus">
                                <option disabled>Select Duty status</option>
                                <option value="inprogress">Duty in progress</option>
                                <option value="done">Duty is done</option>
                            </select>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
    </c:if>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>