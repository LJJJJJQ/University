<%--
  Created by IntelliJ IDEA.
  User: uncled
  Date: 2022/6/2
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成功</title>
</head>
<body>
    <%--    ${sessionScope.commodity.cname}--%>
    <p>恭喜!支付成功!!!</p><br>
    <a href="display.jsp" ><button>继续购物</button></a>
    <a href="/cart.jsp?param1=${sessionScope.user.username}"><button>购物车</button></a>
</body>
</html>
