<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="registration-form">
        <form id="sign_up" action="/registration" method="post">
            UserName <input type="text" name="username">
            First Name <input type="text" name="firstName">
            Last Name <input type="text" name="lastName">
            Email <input type="text" name="email">
            Password <input type="password" name="password">
            Repeat Password <input type="password" name="repeatPassword">
        </form>
    </div>
    <div class="button">
        <input type="submit" form="sign_up" value="Sign Up">
    </div>
</body>
</html>
