
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
    <head>
        <jsp:include page="/WEB-INF/partials/head.jsp">
            <jsp:param name="title" value="Your Profile" />
        </jsp:include>
        <%--<jsp:include page="/WEB-INF/partials/scripts.jsp" >> MAKE scripts.js file/>--%>
    </head>


    <body>
        <jsp:include page="/WEB-INF/partials/navbar.jsp" />
        <form method="post" action="editAd">
            <div class="form-group">
                <label for="title">Title</label>
                <input id="title" value="${ad.title}" name="title" class="form-control" type="text">
            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <input id="description" value="${ad.description}" name="description" class="form-control" type="text">
            </div>
            <button name="id" value="${ad.id}">Update</button>
        </form>
         <!-- container -->


    </body>
</html>