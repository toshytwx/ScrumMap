/**
 * Created by User on 16.03.2017.
 */
new WOW().init();
function first() {
        var elemsSuccess = document.getElementsByClassName("alert alert-success");
        for (var i=0;i<elemsSuccess.length;i+=1){elemsSuccess[i].style.display = 'none';}
}
function second() {
    var elemsInfo = document.getElementsByClassName("alert alert-info");
    for (var i=0;i<elemsInfo.length;i+=1){elemsInfo[i].style.display = 'none';}
}
function third() {
    var elemsWarn = document.getElementsByClassName("alert alert-warning");
    for (var i=0;i<elemsWarn.length;i+=1){elemsWarn[i].style.display = 'none';}
}
function fourth() {
    var elemsDang = document.getElementsByClassName("alert alert-danger");
    for (var i=0;i<elemsDang.length;i+=1){elemsDang[i].style.display = 'none';}
}
setTimeout(first, 5500);
setTimeout(second, 6000);
setTimeout(third, 6500);
setTimeout(fourth, 7000);