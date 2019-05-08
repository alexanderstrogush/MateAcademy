<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hi, admin)</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="users">
        <a href="AdminPage/CRUD/addUserPage.jsp">Add user</a>
        <div>
            <h1>Users</h1>
        </div>
        <table>
            <caption>Users</caption>
            <tr>
                <th>ID</th>
                <th>Username</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Password</th>
                <th>Role</th>
            </tr>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td> <c:out value="${user.getUser_id()}"/> </td>
                    <td> <c:out value="${user.getUsername()}"/> </td>
                    <td> <c:out value="${user.getFirstName()}"/> </td>
                    <td> <c:out value="${user.getLastName()}"/> </td>
                    <td> <c:out value="${user.getEmail()}"/> </td>
                    <td> <c:out value="${user.getPassword()}"/> </td>
                    <td> <c:out value="${user.getRole().name()}"/> </td>
                    <td> <a href="/AdminPage/CRUD/updateUserDataPage.jsp?user_id=${user.getUser_id()}">Edit</a> </td>
                    <td> <a href="/deleteUser?user_id=${user.getUser_id()}">Delete</a> </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <a href="/AdminPage/CRUD/addGoodPage.jsp">Add good</a>
    <div class="goods">
        <table>
        <caption>Goods</caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
        </tr>
        <c:forEach items="${goods}" var="good">
            <tr>
                <td> <c:out value="${good.goodId}"/> </td>
                <td> <c:out value="${good.name}"/> </td>
                <td> <c:out value="${good.description}"/> </td>
                <td> <c:out value="${good.price}"/> </td>
                <td> <a href="/AdminPage/CRUD/updateGoodDataPage.jsp?good_id=${good.goodId}">Edit</a> </td>
                <td> <a href="/deleteGood?good_id=${good.goodId}">Delete</a> </td>
            </tr>
            </c:forEach>
        </table>
    </div>
    <div>
        <a href="/signOut">Sign Out</a> <br>
    </div>
</body>
</html>