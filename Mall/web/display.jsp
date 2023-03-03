<%--
  Created by IntelliJ IDEA.
  User: uncled
  Date: 2022/6/2
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>展示</title>
<%--    <link rel="stylesheet" href="css/display.css"/>--%>
    <link rel="stylesheet" type="text/css" href="css/display3.css">
</head>
<body>
    <nav>
    <h1>Ultraman Mall</h1>
        <div id="icon">
          <span>
            <a href="/cart.jsp?param1=${sessionScope.user.username}">
                <img src="/img/icon/cart.png" alt="购物车" title="购物车">
<%--                <img src="img/icon/购物车.png" alt="">--%>
            </a>
        </span>
            <span>
            <a href="index.jsp">
                <img src="/img/icon/home.png" alt="主页" title="主页">
<%--                <img src="img/icon/登录.png" alt="">--%>
            </a>
        </span>
        </div>
    </nav>
    <article>
        <div id="all">
            <c:forEach var="c" items="${requestScope.commodities}">
                <div class="good">
                   <a href="/consumption?param1=${c.cname}">
                    <img src="img/good/${c.cname}.jpeg" alt="">
                   </a>
                    <div id="buy">
                        <h3>${c.cname}</h3>
                        <span>价格：${c.price}￥</span>
                    </div>
                </div>
            </c:forEach>
        </div>
    </article>







<%--    <h1>商品</h1>--%>
<%--    <ul>--%>
<%--    <c:forEach var="com" items="${requestScope.commodities}">--%>
<%--        <li>--%>
<%--            <a href="/consumption?param1=${com.cname}">--%>
<%--                <img src="img/${com.cname}.jpeg" alt="${com.cname}">--%>
<%--            </a>--%>
<%--            <br>--%>
<%--            <p> ${com.cname}          ¥${com.price}<br>库存:${com.num}</p>--%>
<%--        </li>--%>
<%--    </c:forEach>--%>
<%--    </ul>--%>
</body>
</html>
