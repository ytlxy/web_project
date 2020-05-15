<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2020/5/10
  Time: 0:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<center>
<form action="/user/out" method="post">
    <h1>用户注册</h1><br/>
    账户：<input type="text" name="Userid"><br/>
    密码：<input type="password" name="Productid"><br/>
    <br/>
    <input type="submit" value="提交">
    <a href="/user/tologin">返回登陆</a>
</form>
</center>
</body>
</html>
