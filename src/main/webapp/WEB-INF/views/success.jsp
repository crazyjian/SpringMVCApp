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
      
    <shiro:hasRole name="admin">  
        <a href="<%=path %>/user">User Page（有admin角色才能看到此处，有user:add权限才能点击进入）</a>  
    </shiro:hasRole>  
    <br><br>  
      
<%--     <shiro:hasPermission name="user:add">   
        <a href="<%=path %>/admin">User Page（有admin角色才能看到此处）</a>  
     </shiro:hasPermission>   
    <br><br>   --%>
    <a href="<%=path %>/user">User Page（有user:add权限才能点击进入）</a>  
    <br><br>  
    <a href="<%=path %>/logout">退出</a> 
       
</body>
</html>
