<%--
  Created by IntelliJ IDEA.
  User: luisrobles
  Date: 2019-04-25
  Time: 12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="${seller.username}" />
    </jsp:include>
</head>
<body>

    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <h1>${seller.username}</h1>
    <h2>${seller.email}</h2>

</body>
</html>
