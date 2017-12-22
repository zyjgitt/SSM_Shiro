<%--
  Created by IntelliJ IDEA.
  User: lenvovo
  Date: 2017/12/20
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <form action="/login" method="post">
       姓名：<input type="text" name="username"/><br/>
       密码：<input type="text" name="password"/><br/>
       <input type="submit" value="登录">
   </form>
</body>
</html>
