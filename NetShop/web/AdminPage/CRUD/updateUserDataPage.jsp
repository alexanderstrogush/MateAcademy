<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 03.05.2019
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>
        <form action="/updateUser" method="post">
            <input type="hidden" name="user_id" value="${param.user_id}"> <br>
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
    </div>
</body>
</html>
