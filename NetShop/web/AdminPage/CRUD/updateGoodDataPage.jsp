<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 03.05.2019
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update good</title>
</head>
<body>
<div>
    <form id="good_update" action="/goodUpdate" method="post">
        <input type="hidden" name="good_id" value="${param.good_id}"> <br>
        Name <input type="text" name="name" value="${requestScope.name}"> <br>
        Description <input type="text" name="description" value="${requestScope.description}"> <br>
        Price <input type="text" name="price" value="${requestScope.price}"> <br>
    </form>
</div>
    <div class="button">
        <input type="submit" form="good_update" value="Update">
    </div>
</body>
</html>
