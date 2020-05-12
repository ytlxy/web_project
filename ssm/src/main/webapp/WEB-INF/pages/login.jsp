<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2020/5/10
  Time: 0:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
</head>
<body>
<center>
<form action="/user/login" method="post">
    <h1>用户登陆</h1><br/>
    账户：<input type="text" name="Userid"><br/>
    密码：<input type="password" name="Productid"><br/>
    <h1>  </h1><br/>
    <input type="submit" value="提交">
</form>
    <a href="user/registered">注册</a>
</center>
</body>
</html>
