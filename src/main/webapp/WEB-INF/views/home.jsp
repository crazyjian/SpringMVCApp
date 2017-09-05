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
	<script src="${rc.contextPath}/js/jquery.js"></script>
	<link rel="stylesheet" href="${rc.contextPath}/css/login.css">
	<%-- <link rel="stylesheet" href="${rc.contextPath}/css/htmleaf-demo.css">
	<link rel="stylesheet" href="${rc.contextPath}/css/normalize.css"> --%>
	
	<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<style type="text/css">
	body {
		background-color: #2ea48e;
	}
</style>
</head>
<body>
<div class="container">
    <div class="row">
    	<P>${serverTime}. </P>
        <div class="col-md-offset-3 col-md-6">
            <form class="form-horizontal" action="<%=path%>/auth" method="post">
                <span class="heading">用户登录</span>
                <div class="form-group">
                    <input type="text" class="form-control" id="inputEmail3" placeholder="用户名">
                    <i class="fa fa-user"></i>
                </div>
                <div class="form-group help">
                    <input type="password" class="form-control" id="inputPassword3" placeholder="密　码">
                    <i class="fa fa-lock"></i>
                    <a href="#" class="fa fa-question-circle"></a>
                </div>
                <div class="form-group">
                    <div class="main-checkbox">
                        <input type="checkbox" value="None" id="checkbox1" name="check"/>
                        <label for="checkbox1"></label>
                    </div>
                    <span class="text">Remember me</span>
                    <button type="submit" class="btn btn-default">登录</button>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- <button onclick="deleteById()">删除</button> -->


<script type="text/javascript">
	<%-- function deleteById() {
		var id = ${user.id};
		$.ajax({
			url: '<%=basePath%>' + 'user/'+id,
			type: 'DELETE',
			dataType: 'json',
			success:function(data){
				console.log(data);
		        alert(data.msg);
		    },  
	        error:function(e) {
	        	alert("删除失败");
	        } 
		});
	} --%>
</script>

</body>
</html>
