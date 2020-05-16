<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2020/5/7
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<center>
<h3>
<%--<form action="/user/inquiry" method="post">--%>
<%--    <input type="submit" value="查看所有用户信息"><br/>--%>
<%--    <c:forEach items="${home}" var="transaction">--%>
<%--        <h4>账户：${transaction.userid}</h4>--%>
<%--        <h4>密码：${transaction.productid}</h4><br/>--%>
<%--    </c:forEach>--%>
<%--</form>--%>
    <form action="/user/inquiryassign" method="post">
        <h1>指定查询</h1><br/>
        账户：<input type="text" name="Userid"><br/>
        密码：<input type="text" name="Productid"><br/>
        <h1>  </h1><br/>
        <input type="submit" value="提交">
        <c:forEach items="${msg}" var="transaction">
            <h4>账户：${transaction.userid}</h4>
            <h4>密码：${transaction.productid}</h4>
            <h5>ID：${transaction.ID}</h5><br/>
        </c:forEach>
    </form>
</h3>
    <a href="/user/commodity">前往商品页面</a>
</center>
</body>
</html>
