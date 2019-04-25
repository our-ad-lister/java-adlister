<%--
  Created by IntelliJ IDEA.
  User: luisrobles
  Date: 2019-04-23
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="${ad.title}" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<h1>${ad.title}</h1>
<h2>${ad.description}</h2>
<%--<h2>${ad.id}</h2>--%>
<h2>${ad.getUserId()}</h2>
<a href="/seller?profile=${ad.getUserId()}">Contact Seller</a>
</body>
</html>
