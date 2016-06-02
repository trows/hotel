var room_id = '';
function rent(){

    var indent = eval('({})');
    var num = $("#num").val();

    if(num == 0){
        swal('error','入住人数不能为0','error');
        return;
    }
    var room_type = $("#room_type").val();
    if(room_type == 1){
        swal('error','请选择房间类型','error');
        return;
    }
    var input = $('.roomInput');
    for(var i = 0;i<input.length;i++){
        var val = $(input[i]).val();
        // console.log(val.length);
        if(val.length == 0) {
            swal('error','订单信息不能为空','error');
            return;
        }
        var name = $(input[i]).attr('id');
        indent[name] = val;
    }
    indent['num'] = num;

    if(room_id == 'empty'){
        swal('error','未找到合适的房间','error');
        return;
    }else {
        if(room_id == ''){
            getEmptyRoom();
        }
    }

    indent['room_id'] = room_id;
    indent['indent_state'] = 'check_in';
    $.post(
        './initIndent.do',
        {
            flag:getFlag(),
            indent:JSON.stringify(indent)
        },
        function (data) {
            if(data == 1){
                swal('success','入住成功','success');
                setTimeout('window.location.reload()',2000);
            }else {
                swal('error','入住失败','error');
            }
        }
    );
}

function getEmptyRoom(element) {
    var room_type = $('#room_type').val();
    if(room_type == 1){
        swal('error','请选择房间类型','error');
        $('#end_time').val('');
        return;
    }
    var start_time = $('#start_time').val();
    if(start_time.length == 0){
        swal('error','请先选择入住时间','error');
        $('#end_time').val('');
        return;
    }
    if(!checkTime()) return;
    $.post('getEmptyRoom.do',
        {
            room_type:room_type,
            flag:getFlag()
        },
        function (data) {
            if(data == 'empty'){
                swal('error','该时段'+room_type+'已定满','error');
            }else {
                room_id = data;
                $("#room_id").text(data);
            }
        }
    );

}

function checkTime() {
    var now = new Date();
    var day = now.getUTCDate();
    var month = now.getUTCMonth()+1;
    var year = now.getUTCFullYear();
    var start_time = $('#start_time').val();
    var end_time = $('#end_time').val();
    var dateStr = start_time.split('-');
    var endStr = end_time.split('-');
    console.log(year+'--'+month+'--'+day);
    if(parseInt(dateStr[0])!=year || parseInt(endStr[0])!=year || parseInt(dateStr[1])!=month || parseInt(endStr[1])!=month){
        swal('error','酒店房间只能当月预定','error');
        return false;
    }
    if(parseInt(endStr[2])-day>=7){
        swal('error','酒店房间只能提前7天预定','error');
        return false;
    }

    if(parseInt(dateStr[2])-day<0){
        swal('error','入住时间至少为当日','error');
        return false;
    }

    if(parseInt(dateStr[2])>parseInt(endStr[2])){
        swal('error','退房时间早于入住时间','error');
        return false;
    }

    return true;
}

function getFlag() {
    var now = new Date();
    var day = now.getUTCDate();
    var start_time = $('#start_time').val();
    var end_time = $('#end_time').val();
    var dateStr = start_time.split('-');
    var endStr = end_time.split('-');

    var st = dateStr[2] - day;
    var et = endStr[2]-dateStr[2];
    var flag = '';
    for(var i = 0;i<7;i++){
        if(i>=st && i<st+et){
            flag+='1';
        } else {
            flag+='0';
        }
    }
    return flag;

}

function getDaysInOneMonth(year, month){
    month = parseInt(month, 10);
    var d= new Date(year, month, 0);
    return d.getDate();
}