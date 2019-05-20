<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Orders</title>
</head>
<body>
<div>
    <table>
        <caption>Orders</caption>
        <tr>
            <th>ID</th>
            <th>Goods</th>
            <th>Price</th>
            <th>Status</th>
        </tr>
        <c:forEach items="${orders}" var="order">
            <tr>
                <td>${order.orderId}</td>
                <td>
                    <c:forEach items="${order.goods.keySet()}" var="good">
                        <%--                        ${good.name} -- ${order.goods.get(good)} <br>--%>
                        <c:out value="${good.name}"/> -- <c:out value="${order.goods.get(good)}"/> <br>
                    </c:forEach>
                </td>
                <td>$${order.price}</td>
                <td>${order.status}</td>
                <c:if test="${order.status == 'NOT_PAID'}">
                    <td><a href="/orders/pay?order_id=${order.orderId}">Pay</a></td>
                </c:if>
            </tr>
        </c:forEach>
    </table>
</div>
<div>
    <a href="/user">Go to home</a>
</div>
</body>
</html>
