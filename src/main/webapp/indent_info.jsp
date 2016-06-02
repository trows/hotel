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
    <title>房间预订</title>
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
<h1 class="book">订单号：${indent.indent_id}${indent.id_key}</h1>
<div class="reg">
    <h1>房间号码：<span id="room_id">${indent.room_id}</span></h1>
    <div class="members">
        <div class="adult">
            <h2>入住人数</h2>
            <div class="dropdown-button">
                <select class="dropdown" tabindex="10" id="num">
                    <option value="${indent.num}" selected>${indent.num}</option>
                </select>
            </div>
        </div>
        <div class="clear"></div>
    </div>

    <div class="suite">
        <div class="dropdown-button">
            <h2>房间类型</h2>
            <select class="dropdown" tabindex="10" id="room_type">
                <option value="${room.room_type}" selected>${room.room_type}</option>
            </select>
        </div>
    </div>

    <h2>&nbsp;姓名</h2>
    <input class="roomInput" type="text" id="user_name" value="${indent.user_name}" disabled="disabled">

    <h2>&nbsp;身份证号</h2>
    <input class="roomInput" type="text" id="id_card" value="${indent.id_card}" disabled="disabled">

    <h2>&nbsp;手机号</h2>
    <input class="roomInput" type="text" id="cellphone" value="${indent.cellphone}" disabled="disabled">

    <div class="book-pag">
        <h2>租住时间</h2>
        <div class="book-pag-frm1">
            <label>入住时间</label>
            <input  id="start_time" class="roomInput" value="${indent.start_time}" disabled="disabled">
        </div>
        <div class="book-pag-frm2">
            <label>退房时间</label>
            <input  id="end_time" class="roomInput" value="${indent.end_time}" disabled="disabled">
        </div>
        <div class="clear"></div>
    </div>

    <div class="book-pag-frm1">
        <input type="submit" class="book" value="确认入住" onclick="check_in()">
    </div>
    <div class="book-pag-frm2">
        <input type="submit" class="book" value="取消订单" onclick="del_indent()">
    </div>
</div>

<div class="reg-footer">
    <p></p>
</div>
<script type="text/javascript" src="assert/js/jquery-2.2.3.min.js"></script>
<script src="assert/js/bootstrap.min.js"></script>
<script src="assert/js/sweetalert.min.js"></script>
<script src="js/site.indent_info.js"></script>
</body>
</html>