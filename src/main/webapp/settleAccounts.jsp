<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <title>结算</title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" href="css/style.css" type="text/css" media="all"/>
    <link rel="stylesheet" href="css/jquery-ui.css"/>
    <!--<link href="assert/css/bootstrap.min.css" rel="stylesheet">-->
    <link href="assert/css/font-awesome.min.css" rel="stylesheet">
    <link href="assert/css/sweetalert.css" rel="stylesheet">
    <link href="/css/site.input_base.css" rel="stylesheet">

</head>
<body>
<h1 class="book">订单编号：<span id="indent_id">${indent.indent_id}</span>${indent.id_key}<a class="ret" href="index.html">返回首页</a></h1>
<div class="reg">
    <h1>房间号码：<span id="room_id">${indent.room_id}</span>&nbsp;/&nbsp;住户：${indent.user_name}</h1>
    <h2>&nbsp;租住天数</h2>
    <input class="roomInput" type="text" id="day_num" value="${indent.num}天" disabled="disabled">
    <h2>&nbsp;房间单价</h2>
    <input class="roomInput" type="text" id="room_price" value="￥${indent.room_price}" disabled="disabled">
    <h2>&nbsp;基本消费</h2>
    <input class="roomInput" type="text" id="base_name" value="￥${indent.room_price*indent.num}" disabled="disabled">
    <h2>&nbsp;服务消费</h2>
    <input class="roomInput" type="text" id="service_price" value="￥${indent.service_price}" disabled="disabled">
    <h2>&nbsp;其它消费</h2>
    <input class="roomInput" type="text" id="other_price" value="" onblur="countAccount()">
    <h2>&nbsp;总计</h2>
    <input class="roomInput" type="text" id="count" value="￥${indent.room_price*indent.num+indent.other_price+indent.service_price}" disabled="disabled">
    <div class="submit" onclick="settleAccount()">
        <input type="submit" class="book" value="确认结账">
    </div>
<input type="hidden" id="storeCount" value="${indent.room_price*indent.num+indent.other_price+indent.service_price}">
</div>

<div class="reg-footer">
    <p></p>
</div>
<script type="text/javascript" src="assert/js/jquery-2.2.3.min.js"></script>
<script src="assert/js/bootstrap.min.js"></script>
<script src="assert/js/sweetalert.min.js"></script>
<script src="js/site.settleAccount.js"></script>
</body>
</html>