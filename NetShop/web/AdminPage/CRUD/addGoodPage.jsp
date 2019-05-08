<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 03.05.2019
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add goods</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div>
    <form id="add_goods" action="/addGood" method="post">
        Name <input type="text" name="name">
        Description <input type="text" name="description">
        Price <input type="number" name="price">
    </form>
</div>
<div class="button">
    <input type="submit" form="add_goods" value="Add">
</div>
</body>
</html>
