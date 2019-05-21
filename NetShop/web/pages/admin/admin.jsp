<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Hi, <c:out value="${sessionScope.user.username}"/></title>
</head>
<body>
    <div class="users">
        <a href="/pages/admin/crud/user/add-new-user.jsp">Add user</a>
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
                <th>Role</th>
            </tr>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td> <c:out value="${user.userId}"/> </td>
                    <td> <c:out value="${user.username}"/> </td>
                    <td> <c:out value="${user.firstName}"/> </td>
                    <td> <c:out value="${user.lastName}"/> </td>
                    <td> <c:out value="${user.email}"/> </td>
                    <td>
                        <c:forEach items="${user.roles}" var="role">
                            <c:out value="${role.name}"/> <br>
                        </c:forEach>
                    </td>
                    <td> <a href="/pages/admin/crud/user/update-user-data.jsp?user_id=${user.getUser_id()}">Edit</a> </td>
                    <td> <a href="/admin/user/delete?user_id=${user.getUser_id()}">Delete</a> </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <a href="/pages/admin/crud/good/add-new-good.jsp">Add good</a>
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
                    <td> <a href="/pages/admin/crud/good/update-good-data.jsp?good_id=${good.goodId}">Edit</a> </td>
                    <td> <a href="/admin/good/delete?good_id=${good.goodId}">Delete</a> </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div>
        <a href="/sign-out">Sign Out</a> <br>
    </div>
</body>
</html>
