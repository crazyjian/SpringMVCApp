<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<script src="${rc.contextPath}/js/vue.min.js"></script>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<P>  姓名：${user.name}</P>
<P>  密码：${user.password}</P>
<div id="app">
  <p>{{ message }}</p>
</div>
<div id="app-2">
  <span v-bind:title="message">
    鼠标悬停几秒钟查看此处动态绑定的提示信息！
  </span>
</div>
<div id="app-3">
  <p v-if="seen">现在你看到我了</p>
</div>
<div id="app-4">
  <ol>
    <li v-for="todo in todos">
      {{ todo.text }}
    </li>
  </ol>
</div>

<script>
var app1 = new Vue({
  el: '#app',
  data: {
    message: 'Hello Vue.js!'
  }
});

var app2 = new Vue({
	  el: '#app-2',
	  data: {
	    message: '页面加载于 ' + new Date()
	  }
	});
	
var app3 = new Vue({
	  el: '#app-3',
	  data: {
	    seen: true
	  }
	});
var app4 = new Vue({
	  el: '#app-4',
	  data: {
	    todos: [
	      { text: '学习 JavaScript' },
	      { text: '学习 Vue' },
	      { text: '整个牛项目' }
	    ]
	  }
	});
</script>

</body>
</html>
