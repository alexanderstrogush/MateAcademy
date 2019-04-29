<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 26.04.2019
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update User Data</title>
</head>
<body>
    <form action="/updateUser" method="post">
        <input type="hidden" name="user_id" value="${param.user_id}"> <br>
        Username <input type="text" name="username"> <br>
        First Name <input type="text" name="firstName"> <br>
        Last Name <input type="text" name="lastName"> <br>
        Email <input type="text" name="email"> <br>
        Password <input type="text" name="password"> <br>
        <input type="submit" value="Update">
    </form>
</body>
</html>
