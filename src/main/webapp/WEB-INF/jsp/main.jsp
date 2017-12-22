<%--
  Created by IntelliJ IDEA.
  User: lenvovo
  Date: 2017/12/21
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>主界面</title>
</head>
<body>
     显示所有的功能菜单！<br/>
     <c:forEach items="${list}" var="gn">
           <a href="${gn.url}">${gn.name}</a><br/>
     </c:forEach>
     <a href="/logout">退出</a>
</body>
</html>
