<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 09.04.2020
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Chat</title>
</head>
<body>
Name:${user.name}
<form action="/chat" method="post" >
    <input type="text" name="message">
    <input type="hidden" name="user" value="${user}">
    <input type="submit" name="send message">
</form>
<form action="index.jsp">
    <input type="submit" value="return">
</form>

<c:forEach var="message" items="${listMessage}">
    <p>${message.text}</p>
</c:forEach>
</body>
</html>
