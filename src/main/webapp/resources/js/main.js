/**
 * Created by User on 16.03.2017.
 */
function fillInputs(el) {
        var elemsSuccess = document.getElementsByClassName("alert alert-success");
        for (var i=0;i<elemsSuccess.length;i+=1){elemsSuccess[i].style.display = 'none';}
        var elemsInfo = document.getElementsByClassName("alert alert-info");
        for (var i=0;i<elemsInfo.length;i+=1){elemsInfo[i].style.display = 'none';}
}

setTimeout(fillInputs, 7000);