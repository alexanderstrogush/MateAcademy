<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Panel</title>
</head>
<body>
<h3>Welcome admin ${username})</h3>
<div>
    <h1>Users</h1>
    <a href="CRUDPage/AddUser.jsp">Add User</a>
    <br>
    <table>
        <c:forEach items="${users}" var="user">
            <tr>
                <td> <c:out value="${user.getUser_id()}"/> </td>
                <td> <c:out value="${user.getUsername()}"/> </td>
                <td> <c:out value="${user.getFirstName()}"/> </td>
                <td> <c:out value="${user.getLastName()}"/> </td>
                <td> <c:out value="${user.getEmail()}"/> </td>
                <td> <c:out value="${user.getPassword()}"/> </td>
                <td> <c:out value="${user.getRole().name()}"/> </td>
                <td> <a href="CRUDPage/UpdateUserInfo.jsp?userId=${user.getUser_id()}">Edit</a> </td>
                <td> <a href="/DeleteUser?userId=${user.getUser_id()}">Delete</a> </td>
            </tr>
        </c:forEach>
    </table>
</div>

<style>
    table {
        border-collapse: collapse;
        border: 3px solid black;
    }

    td {
        border-bottom: 2px solid lightgray;
        border-left: 2px solid lightgray;
    }
</style>

</body>
</html>
