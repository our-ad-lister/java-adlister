<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
    <script src="//static.filestackapi.com/filestack-js/2.x.x/filestack.min.js"></script>

</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>Here Are all the ads!</h1>

    <c:forEach var="ad" items="${ads}">
        <div class="col-md-6">
            <c:if test="${ad.img_url.length() > 0}">
            <img src="${ad.img_url}" alt="picture" width="300" height="300">
            </c:if>
            <h2>${ad.title}</h2>
            <p>${ad.description}</p>

                <a href="/ads/show?id=${ad.id}">More Information</a>
        </div>
    </c:forEach>
</div>
<script>
    let client = filestack.init("AEWKiu5qYTtif6jqXiYivz")
    let options = {
        "cache": false,
        "output": {
            "secure": true
        }
    }
    client.transform("g8fLXNCRT4K3TJSUFrRW", options);
</script>
</body>
</html>
