<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Map</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/style.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <table>
            <tr>
                <div class="map-header">
                            <span>
                                Determining Duties
                            </span>
                </div>
                <td class="mapsector-determining">
                    <div class="map-container">
                        <div class="map-body">
                            <ul class="duty-list">
                                <c:forEach var="num" items="${determiningDutiesList}">
                                    <br>
                                    <li>
                                        <div id="${num.id}" class="duty-block ui-widget ui-corner-all ui-state-error">
                                            <c:out value="${num.dutyName}"/>
                                        </div>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                </td>
                <td class="mapsector-performing">
                    <div class="map-container">
                        <div class="map-header">
                            <span>
                               Performing Duties
                            </span>
                        </div>
                        <div class="map-body">
                            <ul class="duty-list">
                                <c:forEach var="num" items="${performingDutiesList}">
                                    <br>
                                    <li>
                                        <div  class="duty-block ui-widget ui-corner-all ui-state-error">
                                            <c:out value="${num.dutyName}"/>
                                        </div>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
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

    <!-- Modal error -->
    <div id="error" class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
        <div class="modal-dialog modal-sm" role="document">
            <div class="modal-content">
                ...
            </div>
        </div>
    </div>

    <script
            src="https://code.jquery.com/jquery-3.2.1.js"
            integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE="
            crossorigin="anonymous"></script>
    <script src="//ajax.aspnetcdn.com/ajax/jquery.ui/1.10.3/jquery-ui.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>

    <script type="text/javascript">
        $(function() {
            $('.duty-block').draggable({
                containment: "tr"
                /* containment: [115,50,245,595]*/
            })
        });
    </script>
    <script type="text/javascript">

            $('.duty-block').mouseup(function () {
                var id = this.id;
                if($('#'+id).offset().left >490.5){
                    $('#error').modal('toggle');
                }
            });

    </script>
    <script type="text/javascript">

    </script>
</body>
</html>
