<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="registration-form">
    <form id="sign_up" action="registration" method="post">
        UserName <input type="text" name="username"> <br>
        First Name <input type="text" name="firstName"> <br>
        Last Name <input type="text" name="lastName"> <br>
        Email <input type="text" name="email"> <br>
        Password <input type="password" name="password"> <br>
        Repeat Password <input type="password" name="repeatPassword"> <br>
    </form>
</div>
<div class="button">
    <input type="submit" form="sign_up" value="Sign Up">
</div>
</body>
</html>
