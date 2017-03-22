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

                <div class="panel panel-default">
                    <!-- Default panel contents -->
                    <div class="panel-heading">Panel heading</div>
                    <div class="panel-body">
                        <p>...</p>
                    </div>
                    <!-- Table -->
                    <table class="table">
                        <c:forEach var="num" items="${list}">
                            <tr id="${num.id}" class="duty_note">
                                <td id="${num.id}_dutyName"><c:out  value=" ${num.dutyName}" /></td>
                                <input type="hidden" name="" id="${num.id}_dutyDescription" value="${num.dutyDescription}"/>
                                <td>
                                    <form action="${contextPath}/details/${num.id}">
                                        <input id="${num.id}" class="btn btn-lg btn-primary btn-block" type="submit" value="Details"/>
                                    </form>
                                </td>
                                <td role="presentation" class="active" data-toggle="modal" data-target="#Delete">
                                    <button  id="${num.id}" onclick="markActiveLink(this);" class="btn btn-lg btn-primary btn-block" type="submit">Delete</button>
                                </td>
                                <c:choose>
                                    <c:when test="${num.dutyStatus ne 'Done'}">
                                        <td role="presentation" class="active" data-toggle="modal" data-target="#Edit">
                                            <button id="${num.id}" onclick="markActiveLink(this); fillInputs(${num.id})" class="btn btn-lg btn-primary btn-block" type="submit">+Edit</button>
                                        </td>
                                    </c:when>
                                    <c:otherwise>
                                        <td>

                                        </td>
                                    </c:otherwise>
                                </c:choose>
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
                            <select required name="dutyimportance">
                                <option value="Important">Important duty</option>
                                <option value="Non-important">Non-important duty</option>
                            </select>
                            <br />
                            <select required name="dutystatus">
                                <option value="In progress">Duty in progress</option>
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
       <%-- <div class="modal fade" id="Edit" role="dialog">
            <div class="modal-dialog modal-sm">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Edit Duty</h4>
                    </div>
                    <div class="modal-body">
                        <form  method="POST" action="${contextPath}/editduty" class="form-signin">
                            <input required name="dutyname" type="text" class="form-control"  placeholder="Duty Name" autofocus="true"/>
                            <input required name="dutyduration" type="time" class="form-control" placeholder="Duty Duration"/>
                            <input required name="dutystartdate" type="date" class="form-control" placeholder="Duty Start Date"/>
                            <input required name="dutydescription" type="text" class="form-control" placeholder="Write some words"/>
                            <select  name="dutyimportance">
                                <option selected disabled>Select importance</option>
                                <option value="Important">Important duty</option>
                                <option value="Non-important">Non-important duty</option>
                            </select>
                            <br />
                            <select required name="dutystatus">
                                <option selected disabled>Select Duty status</option>
                                <option value="In progress">Duty in progress</option>
                                <option value="Done">Duty is done</option>
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
        </div>--%>
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
<%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>--%>
<script
        src="https://code.jquery.com/jquery-3.1.1.js"
        integrity="sha256-16cdPddA6VdVInumRGo6IbivbERE8p7CQR3HzTBuELA="
        crossorigin="anonymous"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${contextPath}/resources/js/onClick.js"></script>
<script src="${contextPath}/resources/js/main.js"></script>
</body>
</html>