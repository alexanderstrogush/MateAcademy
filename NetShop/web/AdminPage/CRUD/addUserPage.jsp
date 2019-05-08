<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 03.05.2019
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Adding new user</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div>
        <form id="add_user" action="/addUser" method="post">
            UserName <input type="text" name="username">
            First Name <input type="text" name="firstName">
            Last Name <input type="text" name="lastName">
            Email <input type="text" name="email">
            Password <input type="password" name="password">
            Repeat Password <input type="password" name="repeatPassword">
            Role <br>
            <input type="radio" name="role" value="ADMIN"> Admin
            <input type="radio" name="role" value="USER" checked> User
        </form>
    </div>
    <div class="button">
        <input type="submit" form="add_user" value="Add">
    </div>
</body>
</html>
