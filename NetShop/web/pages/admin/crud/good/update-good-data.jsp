<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Updating good's data</title>
</head>
<body>
    <div>
        <form id="good_update" action="/admin/good/update" method="post">
            <input type="hidden" name="good_id" value="${good.goodId}"> <br>
            Name <input type="text" name="name" value="${good.name}"> <br>
            Description <input type="text" name="description" value="${good.description}"> <br>
            Price <input type="number" name="price" value="${good.price}"> <br>
        </form>
    </div>
    <div class="button">
        <input type="submit" form="good_update" value="Update">
    </div>
</body>
</html>
