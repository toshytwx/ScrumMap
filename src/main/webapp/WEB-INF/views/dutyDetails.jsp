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
        <p style="text-align: center">
            <a class="btn btn-lg btn-success" href="${contextPath}/welcome" role="button">Home</a>
            <span role="presentation" class="active" data-toggle="modal" data-target="#Edit">
                <button id="${dutyId}" class="btn btn-lg btn-success" type="submit">+Edit</button>
            </span>
        </p>
    </div>

    <div class="modal fade" id="Edit" role="dialog">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Edit Duty</h4>
                </div>
                <div class="modal-body">
                    <form  method="POST" action="${contextPath}/details/${dutyId}/editduty" class="form-signin">
                        <input required name="dutyname" type="text" class="form-control"  placeholder="Duty Name" autofocus="true" value="${dutyName}"/>
                        <input required name="dutyduration" type="time" class="form-control" placeholder="Duty Duration" value="${dutyDuration}"/>
                        <input required name="dutystartdate" type="datetime" class="form-control" placeholder="Duty Start Date" value="${dutyStartDate}"/>
                        <input required name="dutydescription" type="text" class="form-control" placeholder="Write some words" value="${dutyDescription}"/>
                        <select class="mySelect" name="dutyimportance">
                            <c:choose>
                                <c:when test="${dutyImportance ne 'Important'}">
                                    <option selected value="${dutyImportance}">Non-important duty</option>
                                    <option value="Important">Important Duty</option>
                                </c:when>
                                <c:otherwise>
                                    <option selected value="${dutyImportance}">Important Duty</option>
                                    <option value="Non-important">Non-important duty</option>
                                </c:otherwise>
                            </c:choose>
                        </select>
                        <br />
                        <select class="mySelect" required name="dutystatus">
                            <c:choose>
                                <c:when test="${dutyStatus eq 'Done'}">
                                    <option selected value="${dutyStatus}">Duty is done</option>
                                    <option value="Performs">Duty is performing</option>
                                    <option value="Determining">Duty is determining</option>
                                    <option value="Failed">Duty is failed</option>
                                </c:when>
                                <c:when test="${dutyStatus eq 'Performs'}">
                                    <option selected value="${dutyStatus}">Duty is performing</option>
                                    <option value="Done">Duty is done</option>
                                    <option value="Determining">Duty is determining</option>
                                    <option value="Failed">Duty is failed</option>
                                </c:when>
                                <c:when test="${dutyStatus eq 'Determining'}">
                                    <option selected value="${dutyStatus}">Duty is determining</option>
                                    <option value="Done">Duty is done</option>
                                    <option value="Performs">Duty is performing</option>
                                    <option value="Failed">Duty is failed</option>
                                </c:when>
                                <c:when test="${dutyStatus eq 'Failed'}">
                                    <option selected value="${dutyStatus}">Duty is failed</option>
                                    <option value="Done">Duty is done</option>
                                    <option value="Performs">Duty is performing</option>
                                    <option value="Determining">Duty is determining</option>
                                </c:when>
                            </c:choose>
                        </select>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <input name="dutyid" id="dutyid" value="" type="hidden"/>
                        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
</div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>

