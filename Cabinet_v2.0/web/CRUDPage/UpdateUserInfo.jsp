<%@ page contentType="text/html ;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update User Data</title>
</head>
<body>
    <form action="/updateUser" method="post">
        <input type="hidden" name="userId" value="${param.userId}"> <br>
        Username <input type="text" name="username" value="${requestScope.username}"> <br>
        First Name <input type="text" name="firstName" value="${requestScope.first_name}"> <br>
        Last Name <input type="text" name="lastName" value="${requestScope.last_name}"> <br>
        Email <input type="text" name="email" value="${requestScope.email}"> <br>
        Password <input type="text" name="password" value="${requestScope.password}"> <br>
        Role <br>
        <input type="radio" name="role" value="ADMIN">Admin <br>
        <input type="radio" name="role" value="USER" checked>User <br>
        <input type="submit" value="Update">
    </form>
</body>
</html>
