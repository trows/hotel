var service_list = eval('({})');

function setService(element) {
    var service_name = $(element).text();
    if(service_list[service_name]==null){
        service_list[service_name] = 1;
    }else {
        service_list[service_name] = parseInt(service_list[service_name])+1;
    }
    swal('success','已添加一份'+service_name,'success');
}

function subService() {
    var st = '';
    for(var service_name in service_list){
        st+=service_name+' '+service_list[service_name]+'份\n';
    }
    if(st.length == 0){
        swal('error','您未选择服务','error');
        return;
    }
    swal({
        title: '提交订单',
        text: st,
        type: "warning",
        showCancelButton: true,
        confirmButtonColor: "#DD6B55",
        confirmButtonText: "确认提交",
        cancelButtonText: "放弃提交",
        closeOnConfirm: false
    }, function () {

        $.post(
            './subService.do',
            {
                service:JSON.stringify(service_list),
                room_id:$("#room_id").text()
            },
            function (data) {
                if(data ==1){
                    swal('success','服务订单已提交成功','success');
                    service_list = eval('({})');
                }else {
                    swal('error','服务订单提交失败','error')
                }
            }
        )

    });
}

function resetService(){
    service_list = eval('({})');
    swal('success','服务单已经重置','success');
}