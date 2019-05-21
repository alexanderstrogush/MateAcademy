<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart</title>
</head>
<body>
<div>
    <table>
        <caption>Goods</caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Amount</th>
            <th>Price</th>
            <th>To pay</th>
        </tr>
        <c:forEach items="${cart.items}" var="item">
            <tr>
                <td>${item.good.goodId}</td>
                <td>${item.good.name}</td>
                <td>${item.amount}</td>
                <td>${item.good.price} $</td>
                <td>
                    <script>
                        var p = Number(${item.good.price});
                        var a = Number(${item.amount});
                            document.write((p * a) + " $")
                    </script>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<div>
    <h3>${cart.price}</h3>
</div>
<div>
    <a href="/cart/buy">Buy</a>
</div>
<div>
    <a href="/user">Go to home</a>
</div>
</body>
</html>
