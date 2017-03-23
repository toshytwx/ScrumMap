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
            <li role="presentation"><a href="${contextPath}/progressDuties">Duties in progress</a></li>
            <li role="presentation"><a href="${contextPath}/doneDuties">Done duties</a></li>
            <li role="presentation"><a href="${contextPath}/allDuties">All</a></li>
        </ul>
        <br>
        <div class="alert alert-success" role="alert">
            <span><strong>Green</strong> colored duty means that you done it!</span>
        </div>
        <div class="alert alert-info" role="alert">
            <span><strong>Blue</strong> colored duty means that you are performing it!</span>
        </div>
                <div class="panel panel-default">
                    <!-- Default panel contents -->
                    <div class="panel-heading">
                        <p>
                            Hi, ${pageContext.request.userPrincipal.name} there is a list of all your current duties. Here you can create, edit and delete your duties. Enjoy!
                        </p>
                    </div>
                    <!-- Table -->
                    <table class="table">
                        <tr>
                            <th>Title</th>
                            <th>Day to start</th>
                            <th>

                            </th>
                            <th>

                            </th>
                        </tr>
                        <c:forEach var="num" items="${list}">
                                <tr class="${num.dutyStatus}">
                                    <td id="${num.id}_dutyName"><c:out  value=" ${num.dutyName}" /></td>
                                    <td><c:out  value=" ${num.dateInStringFormat}" /></td>
                                    <td>
                                        <form action="${contextPath}/details/${num.id}">
                                            <input id="${num.id}" class="btn btn-lg btn-primary btn-block" type="submit" value="Details"/>
                                        </form>
                                    </td>
                                    <td role="presentation" class="active" data-toggle="modal" data-target="#Delete">
                                        <button  id="${num.id}" onclick="markActiveLink(this);" class="btn btn-lg btn-primary btn-block" type="submit">Delete</button>
                                    </td>
                                </tr>
                        </c:forEach>
                    </table>
                </div>

        <div class="modal fade" id="myModal" role="dialog">
            <div class="modal-dialog modal-sm">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">New Duty</h4>
                    </div>
                    <div class="modal-body">
                        <form  method="POST" action="${contextPath}/addduty" class="form-signin">
                            <input required name="dutyname" type="text" class="form-control" placeholder="Duty Name" autofocus="true"/>
                            <input required name="dutyduration" type="time" class="form-control" placeholder="Duty Duration"/>
                            <input required name="dutystartdate" type="date" class="form-control" placeholder="Duty Start Date"/>
                            <input required name="dutydescription" type="text" class="form-control" placeholder="Write some words"/>
                            <select class="mySelect" required name="dutyimportance">
                                <option value="Important">Important duty</option>
                                <option value="Non-important">Non-important duty</option>
                            </select>
                            <br />
                            <select class="mySelect" required name="dutystatus">
                                <option value="Performs">Duty in progress</option>
                                <option value="Done">Duty is done</option>
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
        <div class="modal fade" id="Delete" role="dialog">
            <div class="modal-dialog modal-sm">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Delete Duty</h4>
                    </div>
                    <div class="modal-body">
                        <form  method="POST" action="${contextPath}/deleteduty" class="form-signin">
                            <h2>Are you sure you want to delete this duty?</h2>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            <input name="dutyid" id="dutyidd" value="" type="hidden"/>
                            <input name="dutyidd" id="duutyid" value="" type="hidden"/>
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
<script
        src="https://code.jquery.com/jquery-3.1.1.js"
        integrity="sha256-16cdPddA6VdVInumRGo6IbivbERE8p7CQR3HzTBuELA="
        crossorigin="anonymous"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${contextPath}/resources/js/onClick.js"></script>
<script src="${contextPath}/resources/js/main.js"></script>
</body>
</html>