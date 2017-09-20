<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page session="false" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
            $.get("<%=path %>/chat/chat", 
                {"timed": new Date().getTime(),
            	"count": count}, 
                function (data) {
                    $("#logs").append("[data: " + data + " ]<br/>");
            });
        }, 3000);
        
    });
	</script>
</head>
<body>
聊天页面<br>
Welcome!  <shiro:principal/> <br>
ajax长轮询<br>
	<div id="logs"></div>
</body>
</html>
