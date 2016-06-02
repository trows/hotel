/**
 * Created by Throws_exception on 2016/6/2.
 */
var other_price;

function settleAccount() {
    countAccount();
    var indent_id = $("#indent_id").text();
    $.post(
        './settleAccount.do',
        {
            indent_id:indent_id,
            other_price:other_price
        },
        function (data) {
            if(data == 'success'){
                swal('success','退房成功','success');
                setTimeout('window.location.href="./check_out.html"',1500);
            }else {
                swal('error','退房失败','error');
            }
        }
    );
}

function countAccount() {
     other_price = $("#other_price").val();
    if(other_price.length>0){
        if(isNaN(other_price)){
            other_price = other_price.substring(1);
        }
        if(isNaN(other_price)){
            swal('error','其它消费金额填写有误','error');
        }else {
            $('#count').val('￥'+(parseFloat($("#storeCount").val())+parseFloat(other_price)));
        }
    }else {
        $('#count').val('￥'+$("#storeCount").val());
    }
   
}