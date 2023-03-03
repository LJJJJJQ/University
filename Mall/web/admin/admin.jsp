<%--
  Created by IntelliJ IDEA.
  User: uncled
  Date: 2022/6/3
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>管理员</title>
    <link rel="stylesheet" href="css/admin.css">
</head>
<body>
    <nav>
        <p>Admin</p>
        <span class="list">补货</span>
        <span class="list">删除商品</span>
        <span class="list">添加商品</span>
        <span class="list">用户管理</span>
        <h3><a href="/index.jsp"><img src="/img/icon/exit.png"></a></h3>
<%--        <a href="/adminUser"><button>用户管理</button></a>--%>
<%--        <a href="/adminCommodity"><button>商品管理</button></a>--%>
    </nav>
    <article>
            <div class="main">

                <%--补货--%>

                <form id="addCommodities" method="post" action="/adminUpdate">
                    <table>
                        <tr>
                            <th>商品序列号</th>
                            <th>商品名</th>
                            <th>价格</th>
                            <th>库存</th>
                        </tr>
                        <c:forEach var="commodity" items="${sessionScope.commodities}">
                            <tr>
                                <td>${commodity.cid}</td>
                                <td>${commodity.cname}</td>
                                <td>${commodity.price}</td>
                                <td>${commodity.num}</td>
                            </tr>
                        </c:forEach>
                    </table>
                    <div>
                        商品名称：<select name="cname">
                            <c:forEach var="commodity" items="${sessionScope.commodities}">
                                <option>${commodity.cname}</option>
                            </c:forEach>
                        </select>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        数量：<input type="number" name="num" min="0" value="0">
                        &nbsp;&nbsp;&nbsp;
                        <input type="submit" value="补货">
                    </div>
                </form>

                <%--    删除--%>
                <form method="post" action="/adminDelete">
                    商品名称：<select name="cname">
                    <c:forEach var="commodity" items="${sessionScope.commodities}">
                        <option>${commodity.cname}</option>
                    </c:forEach>
                </select>
                    &nbsp;&nbsp;&nbsp;
                    <input type="submit" value="移除该商品">
                </form>

                <%--    添加商品--%>
                <form method="post" action="/adminAddCommodity" enctype="multipart/form-data">
                    商品名称：<input type="text" name="cname" value="null"><br>
                    商品图片：<input type="file" name="picture" value="null"><br>
                    商品价格：<input type="text" name="price" value="-1"><br>
                    商品数量：<input type="number" name="num" value="-1"><br>
                    <input type="submit" value="添加商品">
                </form>

                <%--用户管理--%>
                <form>
                    <table>
                        <tr>
                            <th>用户</th>
                            <th>用户名</th>
                        </tr>
                    <c:forEach var="user" items="${sessionScope.users}">
                        <tr>
                            <td>${user.uid}</td>
                            <td>${user.username}</td>
                        </tr>
                    </c:forEach>
                    </table>
                </form>
            </div>
    </article>


</body>
    <script>
        let list = document.querySelectorAll(".list");
        let main = document.querySelector(".main");
        for(let i = 0; i< list.length;i++){
            list[i].addEventListener("click",() =>{
                main.style.left = i * -100 + "%";
                });
        }

    </script>
</html>
