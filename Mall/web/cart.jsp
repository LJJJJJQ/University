<%--
  Created by IntelliJ IDEA.
  User: uncled
  Date: 2022/6/3
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>购物车</title>
    <link rel="stylesheet" href="/css/cart.css">
    <script>
        var num = 0;    //数量
        var price = 0.0;    //价格
    </script>
</head>
<body>
<article>
        <h1>购物车</h1>
    <table>
        <tr>
            <th>商品名</th>
            <th>价格</th>
            <th>数量</th>
            <th></th>
        </tr>
    <c:forEach var="com" items="${sessionScope.cartCommodities}" >
        <c:if test="${com.num != 0}">
            <tr>
                <td>${com.commodityName}</td>
                <td class="price">¥${com.price}</td>
                <td>
                  ${com.num}
                </td>
                <td>
                    <a href="/cartDel?param1=${com.commodityID}"><img src="/img/icon/delete.png"></a>
                </td>
                <script>
                    price += (${com.price} * ${com.num});
                    num += ${com.num}
                </script>
            </tr>
        </c:if>
    </c:forEach>
    </table>
    <span>

        <p>
        <p id="price">总计：¥</p>
        <p id="num">共  件商品</p>
        </p>

        <p>
        <a href="/buy"><button>支付</button></a>
        <a href="/display.jsp"><button>返回商品页</button></a>
        </p>

    </span>
</article>
    <script>
        window.onload = function (){
            console.log(price);
            console.log(num);
            document.getElementById("price").innerText = "总计：¥" + price.toFixed(2);
            document.getElementById("num").innerText = "共 " + num + " 件商品";
        }
    </script>
</body>
</html>
