<%--
  Created by IntelliJ IDEA.
  User: uncled
  Date: 2022/6/2
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>登陆页</title>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
  </head>
  <body>
  <h1>M78星云</h1>
<%--    <img src="img/good/奥特曼战队.jpg">--%>
    <form  action="/login" method="post">
      <input type="text" name="username" value="" id="account">
      <input type="password" name="password" value="" id="password">
      <a href="/register.jsp">没有账号？点击注册</a>
      <input type="submit" id="login" value="立即登陆">

    </form>
  </body>
</html>
