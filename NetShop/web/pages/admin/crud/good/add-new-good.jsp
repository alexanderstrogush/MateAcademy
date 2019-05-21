<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Adding new good</title>
</head>
<body>
    <div>
        <form id="add_goods" action="/admin/good/add" method="post">
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
