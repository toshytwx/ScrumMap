<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Map</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/style.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="//ajax.aspnetcdn.com/ajax/jquery.ui/1.10.3/jquery-ui.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        $(function() {

            $('.duty-block').draggable({
                containment: "tr"
            })
        });
    </script>
</head>
<body>
    <div class="container">
        <table>
            <tr>
                <td class="mapsector-determining">
                    <div class="map-container">
                        <div class="map-header">
                            <span>
                                Determining Duties
                            </span>
                        </div>
                        <div class="map-body">
                            <ul class="duty-list">
                                <c:forEach var="num" items="${determiningDutiesList}">
                                    <br>
                                    <li>
                                        <div class="duty-block ui-widget ui-corner-all ui-state-error">
                                            <c:out value="${num.dutyName}"/>
                                        </div>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                </td>
                <td class="mapsector-performing">
                    <div class="map-header">
                        <span>
                            Performing Duties
                        </span>
                    </div>
                </td>
                <td class="mapsector-done">
                    <div class="map-container">
                        <div class="map-header">
                            <span>
                                Done Duties
                            </span>
                        </div>
                        <div class="map-body">
                            <ul class="duty-list">
                                <c:forEach var="num" items="${doneDutiesList}">
                                    <br>
                                    <li>
                                        <div class="duty-block ui-widget ui-corner-all ui-state-error">
                                            <c:out value="${num.dutyName}"/>
                                        </div>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                </td>
            </tr>
        </table>
    </div>
</body>
</html>
