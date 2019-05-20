<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Updating user's data</title>
</head>
<body>
    <div>
        <form action="/admin/user/update" method="post">
            <input type="hidden" name="user_id" value="${user.userId}"> <br>
            Username <input type="text" name="username" value="${user.username}"> <br>
            First Name <input type="text" name="firstName" value="${user.firstName}"> <br>
            Last Name <input type="text" name="lastName" value="${user.lastName}"> <br>
            Email <input type="text" name="email" value="${user.email}"> <br>
            Role <br>
            <input type="checkbox" name="is_admin" value="true">Admin <br>
            <input type="checkbox" name="is_user" value="true" checked>User <br>
            <input type="submit" value="Update">
        </form>
    </div>
</body>
</html>
