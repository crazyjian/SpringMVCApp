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
        
        (function longPolling() {
        	count = count + 1;
        	$.ajax({
                url: "<%=path %>/chat/chat",
                data: {
                	"timed": new Date().getTime(),
                	"count": count
                },
                dataType: "text",
                timeout: 5000,
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    $("#logs").append("[state: " + textStatus + ", error: " + errorThrown + " ]<br/>");
                    if (textStatus == "timeout") { // 请求超时
                            longPolling(); // 递归调用
                        // 其他错误，如网络错误等
                        } else { 
                            longPolling();
                        }
                    },
                success: function (data, textStatus) {
                    $("#logs").append("[state: " + textStatus + ", data: { " + data + "} ]<br/>");
                    
                    if (textStatus == "success") { // 请求成功
                        longPolling();
                    }
                }
            });
        })();
        
    });
	</script>
</head>
<body>
聊天页面<br>
Welcome!  <shiro:principal/> <br>
ajax长连接<br>
	<div id="logs"></div>
</body>
</html>
