<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Adding new user</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div>
        <form id="add_user" action="/admin/user/add" method="post">
            UserName <input type="text" name="username">
            First Name <input type="text" name="firstName">
            Last Name <input type="text" name="lastName">
            Email <input type="text" name="email">
            Password <input type="password" name="password">
            Repeat Password <input type="password" name="repeatPassword">
            Role <br>
            <input type="checkbox" name="is_admin" value="true">Admin <br>
            <input type="checkbox" name="is_user" value="true" checked>User <br>
        </form>
    </div>
    <div class="button">
        <input type="submit" form="add_user" value="Add">
    </div>
</body>
</html>
