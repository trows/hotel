window.onload = function () {
    initPage();
};
function initPage() {

}

function checkOut() {
    var room_id = $("#room_id").val();
    if(room_id.length == 0){
        swal('error','请填写房间号码','error');
        return
    }
    $('#room').val(room_id);
    $('#subForm').submit();
}