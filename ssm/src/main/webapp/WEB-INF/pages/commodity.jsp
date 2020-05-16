<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2020/5/12
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>商品页面</title>
</head>
<body>
<center>
<h2>请添加商品</h2>
<form action="/product/commodityAdd" method="post">
   商品名称:<input type="text" name="name"/><br/>
   商品所属目录:<input type="text" name="Catalog"/><br/>
<input type="submit" value="提交"/>
</form><br/>
    <h2>查询目录</h2>
    <form action="/product/commodityInquiry" method="get">
        查询目录:<input type="text" name="Catalog"/><br/>
        <input type="submit" value="提交"/>
        <c:forEach items="${merchandisest}" var="product">
            <h4>商品名称：${product.productName}</h4>
            <h4>商品所属：${product.catalog}</h4>
            <h5>商品ID：${product.ID}</h5><br/>
        </c:forEach>
    </form>
</center>
</body>
</html>
