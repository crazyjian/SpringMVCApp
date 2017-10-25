<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html>
<head>
	<title>Java后端WebSocket的Tomcat实现</title>
	<script src="${rc.contextPath}/js/jquery.js"></script>
</head>
<body>
	Welcome ${user.realName}<br/>
	<input id="text" type="text"/>
	<button onclick="send()">发送消息</button>
	<hr/>
	<button onclick="closeWebSocket()" id="operateWebSocket" value="close">关闭WebSocket连接</button>
	<hr/>
	<div id="message"></div>
</body>
<script type="text/javascript">
	var websocket = null;
	//判断当前浏览器是否支持WebSocket
	if ('WebSocket' in window) {
		websocket = new WebSocket("ws://localhost:8080/myapp/websocket");
	}else {
		alert('当前浏览器 Not support websocket')
	}
	//连接发生错误的回调方法
	websocket.onerror = function (event) {
		setMessageInnerHTML("WebSocket连接发生错误:"+event.data);
	};
	//连接成功建立的回调方法
	websocket.onopen = function (event) {
		setMessageInnerHTML("WebSocket连接成功");
	}
	//接收到消息的回调方法
	websocket.onmessage = function (event) {
		setMessageInnerHTML(event.data);
	}
	//连接关闭的回调方法
	websocket.onclose = function (event) {
		setMessageInnerHTML("WebSocket连接关闭");
	}
	//监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
	window.onbeforeunload = function (event) {
		websocket.close();
	}
	//将消息显示在网页上
	function setMessageInnerHTML(innerHTML) {
		document.getElementById('message').innerHTML += innerHTML + '<br/>';
	}
	//关闭WebSocket连接
	function closeWebSocket() {
		if($('#operateWebSocket').val() == 'close') {
			websocket.close();
			$('#operateWebSocket').val("open");
			$('#operateWebSocket').text("打开WebSocket连接");
		}else {
			websocket = new WebSocket("ws://localhost:8080/myapp/websocket");
			//连接成功建立的回调方法
			websocket.onopen = function (event) {
				setMessageInnerHTML("WebSocket连接成功");
			}
			//接收到消息的回调方法
			websocket.onmessage = function (event) {
				setMessageInnerHTML(event.data);
			}
			//连接关闭的回调方法
			websocket.onclose = function (event) {
				setMessageInnerHTML("WebSocket连接关闭");
			}
			//监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
			window.onbeforeunload = function (event) {
				websocket.close();
			}
			$('#operateWebSocket').val("close");
			$('#operateWebSocket').text("关闭WebSocket连接");
		}
	}
	//发送消息
	function send() {
		var message = document.getElementById('text').value;
		$("#text").val("");
		websocket.send("${user.realName}："+message);
		return false;
	}
</script>
</html> 