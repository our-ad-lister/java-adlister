
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
    <head>
        <jsp:include page="/WEB-INF/partials/head.jsp">
            <jsp:param name="title" value="Your Profile" />
        </jsp:include>
    </head>


    <body>
        <jsp:include page="/WEB-INF/partials/navbar.jsp" />

        <div class="container">
            <div class="text-center grid">
                <div class="width-1-1">
                    <div class="card card-secondary card-body">

                        <form action="" method="POST">
                            <div class="width-1-2">
                                <div class="width-xlarge margin-medium-bottom">
                                    <input class="input form-width-large" type="text" name="title" placeholder="${sessionScope.adEdit.title}">
                                    <div class="uk-width-1-1">
                                        <button type="submit" class="button button-default margin-small-top">Submit</button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>  <!-- container -->


    </body>
</html>