<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order confirmation</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div>
    <h2>Enter code</h2>
</div>
<div>
    <form action="/user/orders/confirmation" method="post">
        <input type="text" name="code">
        <input type="submit" value="Enter">
    </form>
</div>
</body>
</html>