<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
    <head>
        <jsp:include page="/WEB-INF/partials/head.jsp">
            <jsp:param name="title" value="Your Profile" />
        </jsp:include>
    </head>

    <body>
        <jsp:include page="/WEB-INF/partials/navbar.jsp" />
        <div class="container">
            <h1>Welcome, ${sessionScope.user.username}!</h1>
        </div>
        <h1>Your ads: </h1>
        <c:forEach var="ad" items="${user_ad}">
            <div class="col-md-6">
                <h2>${ad.title}</h2>
                <p>${ad.description}</p>
                <a href="/ads/show?id=${ad.id}">More Information</a>

                <form action="deleteAd?selectedAdDelete=${ad.id}" method="post">
                    <input type="submit"  name="selectedAdDelete" value="Delete Ad">
                </form>

                <form action="editAd?selectedAdEdit=${ad.id}" method="post">
                    <input type="submit"  name="selectedAdEdit" value="Edit Ad">
                </form>

            </div>
        </c:forEach>
    </body>
</html>
Collapse



