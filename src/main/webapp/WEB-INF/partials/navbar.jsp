<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/ads">Adlister</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <c:if test= "${sessionScope.user == null}">
                <li><a href="/login">Login</a></li>
                <li><a href="/register">Register</a></li>
            </c:if>
            <c:if test= "${sessionScope.user != null}">
                <li><a href="/profile">View Profile</a></li>
                <li><a href="/update">Profile Settings</a></li>
                <li><a href="/ads/create">Create Ad</a></li>
                <li> <form class="form-inline my-2 my-lg-0" method="get" action="search">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="search">
                    <button class="btn my-2 my-sm-0" type="submit">Search</button>
                </form></li>
                <li><a href="/logout">Logout</a></li>

            </c:if>
        </ul>
    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
