<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page session="false" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
	<meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>Home</title>
	<script src="${rc.contextPath}/js/jquery.js"></script>
	<script type="text/javascript">
	var count = 0;
	$(function () {
        window.setInterval(function () {
        	count = count + 1;
        	$("#frame").attr("src", "<%=path %>/chat/chat?timed=" + new Date().getTime()+"&count="+count);
        	$("#logs").append("[data: " + $($("#frame").get(0).contentDocument).find("body").text() + " ]<br/>");
            // 延迟1秒再重新请求
            window.setTimeout(function () {
                window.frames["polling"].location.reload();
            }, 1000);
        }, 5000);
    });
	</script>
</head>
<body>
聊天页面<br>
Welcome!  <shiro:principal/> <br>
iframe长轮询<br>
	<iframe id="frame" name="polling" style="display: none;"></iframe>
	<div id="logs"></div>
</body>
</html>
