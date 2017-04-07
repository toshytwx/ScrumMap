/**
 * Created by User on 05.04.2017.
 */

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