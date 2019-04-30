<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add User</title>
</head>
<body>
    <form action="/addUser" method="post">
        Username <input type="text" name="username"> <br>
        First Name <input type="text" name="firstName"> <br>
        Last Name <input type="text" name="lastName"> <br>
        Email <input type="text" name="email"> <br>
        Password <input type="text" name="password"> <br>
        Repeat Password <input type="text" name="repeatPassword"> <br>
        Role <br>
        <input type="radio" name="role" value="ADMIN">Admin <br>
        <input type="radio" name="role" value="USER" checked>User <br>
        <input type="submit">
    </form>
</body>
</html>
