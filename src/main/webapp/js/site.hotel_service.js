function check_service(){
    var room_id = $("#room_id").val();
    if(room_id.length == 0){
        swal('error','房间号码不能为空','error');
        return;
    }
    
    $.post(
        './check_room.do',
        {room_id:room_id},
        function (data) {
            if(data==1){
                window.location.href = './getHotelService.htm?room_id='+room_id;
            }else {
                swal('error',room_id+'房间没有入住客人','error');
            }
        }
    )
}