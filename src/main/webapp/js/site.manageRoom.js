/**
 * Created by Throws_exception on 2016/6/1.
 */
function insertRoom() {


    var room_id = $("#room_id").val();
    if(room_id.length==0){
        swal('error','房间编号不能为空','error');
        return;
    }
    var room_type = $("#room_type").val();
    if (room_type == 1){
        swal('error','房间类型不能为空','error');
        return;
    }
    var room_price = $("#room_price").val();
    if (room_price.length == 0 || isNaN(room_price)){
        swal('error','请填写正确的房间价格','error');
        return;
    }
    var room = eval('({})');
    room['room_id'] = room_id;
    room['room_type'] = room_type;
    room['room_price'] = room_price;

    $.post(
        './insertRoom.do',
        {room:JSON.stringify(room)},
        function (data) {
            if(data == 1){
                swal('success','房间添加成功！','success');
                setTimeout('window.location.reload()',1500);
            }else {
                swal('error','房间信息已存在！','error');
            }
        }
    );

}