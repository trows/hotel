function check_in() {
    var indent_id = $(".book:first").text().substring(4);
    var room_id = $("#room_id").text();
    console.log(indent_id);
    $.post(
        'booking_in.do',
        {
            id: indent_id,
            room_id: room_id
        },
        function (data) {
            if (data == 1) {
                swal('success', '入住成功', 'success');
            } else {
                swal('error', '您已入住', 'error');
            }
        }
    );
}

function del_indent() {
    var indent_id = $(".book:first").text().substring(4);
    var room_id = $("#room_id").text();
    $.post(
        'delIndent.do',
        {
            id: indent_id,
            room_id: room_id
        },
        function (data) {
            if (data == 1) {
                swal('success', '订单取消成功', 'success');
                setTimeout('window.location.href="./check_in.html"', 1500)
            } else {
                swal('error', '订单取消失败', 'error');
            }
        }
    );
}