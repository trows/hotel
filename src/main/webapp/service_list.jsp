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
    <title>客房服务</title>

    <!-- For-Mobile-Apps -->
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <!-- //For-Mobile-Apps -->

    <!-- Style -->
    <link rel="stylesheet" href="css/style.css" type="text/css" media="all"/>
    <link href="assert/css/sweetalert.css" rel="stylesheet">
    <link href="/css/site.input_base.css" rel="stylesheet">
    <link href="/css/site.service_list.css" rel="stylesheet">
</head>
<body>

<h1>客房服务<a class="ret" href="index.html">返回首页</a></h1>

<div class="hotel">

    <ul class="menu">
        <li class="item1">
            <a href="#" ><span id="room_id">${room_id}</span>号房的服务<i class="menu-down"><img src="images/down.png" alt=""/></i> </a>
            <ul class="cute">
                <c:forEach items="${list}" var="service">
                    <li class="subitem1"><a onclick="setService(this)"  class="myClick">${service.service_name}</a></li>
                </c:forEach>
                <br>
                <li class="subitem1"><a onclick="subService()"  class="myClick">结账</a></li>
                <li class="subitem1"><a onclick="resetService()"  class="myClick">重置订单</a></li>
            </ul>
        </li>
    </ul>

</div>

<div class="footer">
    <p></p>
</div>
<script type="text/javascript" src="assert/js/jquery-2.2.3.min.js"></script>
<script src="assert/js/bootstrap.min.js"></script>
<script src="assert/js/sweetalert.min.js"></script>
<script src="js/site.service_list.js"></script>
</body>
</html>