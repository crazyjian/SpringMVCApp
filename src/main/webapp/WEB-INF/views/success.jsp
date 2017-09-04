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
	<title>Home</title>
</head>
<body>
Welcome!  <shiro:principal/>  
    <br><br>  
      
    <shiro:hasPermission name="user">  
        <a href="<%=path %>/user">User Page</a>  
    </shiro:hasPermission>  
      
    <br><br>  
      
    <shiro:hasAnyRoles name="admin">  
        <a href="<%=path %>/admin">Admin Page</a>  
    </shiro:hasAnyRoles>  
       
</body>
</html>
