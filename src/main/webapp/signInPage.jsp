<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 08.04.2020
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SignIn</title>
</head>
<body>
<form action="/signIn"  method="get">
    <input type="email" name="email" placeholder="your email">
    <input type="password" name="password" placeholder="your password">
    <input type="submit" value="enter">
</form>

${error}
<form action="index.jsp">
    <input type="submit" value="return">
</form>
</body>
</html>
