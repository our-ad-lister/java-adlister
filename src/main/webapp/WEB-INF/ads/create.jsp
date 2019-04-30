<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new ad" />
    </jsp:include>
    <script src="//static.filestackapi.com/filestack-js/2.x.x/filestack.min.js"></script>

</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

    <div class="container">
        <h1>Create a new Ad</h1>
        <form action="/ads/create" method="post">
            <div class="form-group">
                <label for="title">Title</label>
                <input id="title" name="title" class="form-control" type="text">
            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <textarea id="description" name="description" class="form-control" type="text"></textarea>
            </div>
            <input id="picture" type="button" class="btn btn-block btn-primary" name="picture" value="Upload Picture">
            <input id="img_url" name="img_url" type="text" style="visibility: hidden">
            <input type="submit" class="btn btn-block btn-primary">
        </form>
    </div>

<script>
    document.getElementById("picture").addEventListener("click", function () {
        var client = filestack.init('AEWKiu5qYTtif6jqXiYivz');
        client.picker({
            onFileUploadFinished: function(response){
               this.value ="https://cdn.filestackcontent.com/" + (response.handle);
               document.getElementById("img_url").value = this.value
            }
        }).open();
    })

</script>
</body>
</html>
