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
                                        <div id="${num.id}" class="${num.dutyStatus} ui-widget ui-corner-all ui-state-error">
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
                                        <div id="${num.id}" class="${num.dutyStatus} ui-widget ui-corner-all ui-state-error">
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
                                        <div id="${num.id}" class="${num.dutyStatus} ui-widget ui-corner-all ui-state-error">
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

    <div class="modal fade" id="toDetermining" role="dialog">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Change Duty status</h4>
                </div>
                <div class="modal-body">
                    <form  method="POST" action="${contextPath}/changetodetermining" class="form-signin">
                        <h2>Are you sure you want to change status of this duty to "Determining"?</h2>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <input name="dutyid" class="dutyid" value="" type="hidden"/>
                        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="toPerform" role="dialog">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Change Duty status</h4>
                </div>
                <div class="modal-body">
                    <form  method="POST" action="${contextPath}/changetoperform" class="form-signin">
                        <h2>Are you sure you want to change status of this duty to "Performing"?</h2>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <input name="dutyid" class="dutyid" value="" type="hidden"/>
                        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="toDone" role="dialog">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Change Duty status</h4>
                </div>
                <div class="modal-body">
                    <form  method="POST" action="${contextPath}/changetodone" class="form-signin">
                        <h2>Are you sure you want to change status of this duty to "Done"?</h2>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <input name="dutyid" class="dutyid" value="" type="hidden"/>
                        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
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
            $('.Determining').draggable({
                containment: "tr"
                /* containment: [115,50,245,595]*/
            })
            $('.Performs').draggable({
                containment: "tr"
                /* containment: [115,50,245,595]*/
            })
            $('.Done').draggable({
                containment: "tr"
                /* containment: [115,50,245,595]*/
            })
        });
    </script>
    <script type="text/javascript">

            $('.Determining').mouseup(function () {
                var id = this.id;
                if($('#' + id).offset().left >490.5 && $('#'+id).offset().left <867.5){
                    $('input[name=dutyid]').val(id);
                    $('#toPerform').modal('toggle');
                }
            });
            $('.Determining').mouseup(function () {
                var id = this.id;
                if($('#'+id).offset().left > 867.5){
                    $('input[name=dutyid]').val(id);
                    $('#toDone').modal('toggle');
                }
            });
            $('.Performs').mouseup(function () {
                var id = this.id;
                if(($(window).width() - ($('#'+id).offset().left + $('#'+id).outerWidth())) >= 865.5){
                    $('input[name=dutyid]').val(id);
                    $('#toDetermining').modal('toggle');
                }
            });
            $('.Performs').mouseup(function () {
                var id = this.id;
                if($('#'+id).offset().left > 872.5){
                    $('input[name=dutyid]').val(id);
                    $('#toDone').modal('toggle');
                }
            });
            $('.Done').mouseup(function () {
                var id = this.id;
                if(($(window).width() - ($('#'+id).offset().left + $('#'+id).outerWidth())) > ($(window).width() - ($('.mapsector-performing').offset().left + $('.mapsector-performing').outerWidth()))
                    && $('#'+id).offset().left > $('.mapsector-performing').offset().left){
                    $('input[name=dutyid]').val(id);
                    $('#toPerform').modal('toggle');
                }
            });
            $('.Done').mouseup(function () {
                var id = this.id;
                if(($(window).width() - ($('#'+id).offset().left + $('#'+id).outerWidth())) > ($(window).width() - ($('.mapsector-determining').offset().left + $('.mapsector-determining').outerWidth()))){
                    $('input[name=dutyid]').val(id);
                    $('#toDetermining').modal('toggle');
                }
            });

    </script>

    <script type="text/javascript">

    </script>
</body>
</html>
