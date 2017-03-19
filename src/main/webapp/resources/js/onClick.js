/**
 * Created by User on 12.03.2017.
 */
function markActiveLink(el) {
    document.getElementById('dutyid').value = ($(el).attr("id"));
    document.getElementById('dutyidd').value = ($(el).attr("id"));
    document.getElementById('duutyid').value = ($(el).attr("id"));
}
function markActiveLinkDetails(el) {
    document.getElementById('dd').value = ($(el).attr("id"));
}