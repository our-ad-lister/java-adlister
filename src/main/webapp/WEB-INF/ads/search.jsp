<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Search Results" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
<h1>Search results: </h1>

<c:forEach var="ad" items="${search}">

    <div class="col-md-6">

        <h2>${ad.title}</h2>
        <p>${ad.description}</p>

    </div>
</c:forEach>

</div>
</body>
</html>
