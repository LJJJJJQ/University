<%--
  Created by IntelliJ IDEA.
  User: uncled
  Date: 2022/6/2
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页</title>
    <link rel="stylesheet" href="/css/register.css">
</head>
<body>
<h1>注册</h1>
    <form id="fo" action="/register" method="post">
        账号：<input type="text" name="username"><br>
        密码：<input type="text" name="password"><br>
        <input type="submit" value="注册">
    </form>
</body>
</html>
