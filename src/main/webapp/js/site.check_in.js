function checkIn(){

    var indent_id = $('#room_id').val();

    if(indent_id.length!=8 || isNaN(indent_id)){
        swal('error','请填写正确的订单号','error');
    }else{
        window.location.href = './check_in.htm?id='+indent_id;
    }
}