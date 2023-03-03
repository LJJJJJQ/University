<%--
  Created by IntelliJ IDEA.
  User: uncled
  Date: 2022/6/2
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购买</title>
    <link rel="stylesheet" href="css/consumption.css">
</head>
<body>
<div class="big">
    <div id="left">
        <img src="img/good/${sessionScope.commodity.cname}.jpeg"/>
    </div>
    <div id="right">
        <h1>${sessionScope.commodity.cname}</h1>
        <h2>
            价格:${sessionScope.commodity.price}¥
            &nbsp;&nbsp;
            库存:${sessionScope.commodity.num}
        </h2>
        <form action="/addCommodity" method="post">
            购买数量：<input type="number" name="number" value="0" min="1">
            <input type="submit" value="加入购物车">
        </form>
        <span>
<%--            <a href="#"><button>加入购物车</button></a>--%>
            <a href="/cart.jsp?param1=${sessionScope.user.username}"><button>购物车</button></a>
            <a href="/display.jsp"><button>返回</button></a>
        </span>
    </div>
</div>
</body>
</html>
