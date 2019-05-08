<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order confirmation</title>
</head>
<body>
    <div>
        <h2>Enter code</h2>
    </div>
    <div>
        <form action="/confirm" method="post">
            <input type="text" name="code">
            <input type="submit" value="Enter">
        </form>
    </div>
</body>
</html>
