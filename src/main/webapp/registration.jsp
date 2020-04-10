<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 08.04.2020
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form method="post" action="/registration">
    <input type="text" name="name" placeholder="your name">
    <input type="text" name="password" placeholder="your password">
    <input type="email" name="email" placeholder="your email">
    <input type="submit" value="registration">
</form>
<form action="index.jsp">
    <input type="submit" value="return">
</form>
</body>
</html>
