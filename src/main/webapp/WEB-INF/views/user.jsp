<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
	<title>Home</title>
</head>
<body>
用户页面<br>
	<c:forEach items="${userList}" var="user" varStatus="status">
	     姓名：${user.realName } <br>
	</c:forEach>
</body>
</html>
