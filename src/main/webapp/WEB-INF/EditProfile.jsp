<%--
  Created by IntelliJ IDEA.
  User: luisrobles
  Date: 2019-04-25
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post" action="update?user=${sessionScope.user.username}">
    <input type="text" name="username" value="${sessionScope.user.username}">
    <input type="email" name="email" value="${sessionScope.user.email}">
    <input type="password" name="password" value="${sessionScope.user.password}">
    <input type="submit" value="Submit Changes">
</form>

</body>
</html>
