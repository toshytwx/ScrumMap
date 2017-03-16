/**
 * Created by User on 16.03.2017.
 */

// $('#(this)_btn_edit').bind('click',function () {
//    var dutyName = $('.dutyName').html();
//    var dutyDescription = $('.dutyDescription').html();
//    $('input[name="dutyname"]').val(dutyName);
//    $('input[name="dutydescription"]').val(dutyDescription);
// });

function fillInputs(el) {
        var dutyName = $('#'+el+'_dutyName').html();
        var dutyDescription = $('#'+el+'_dutyDescription').html();
        $('input[name="dutyname"]').val(dutyName);
        $('input[name="dutydescription"]').val(dutyDescription);
}