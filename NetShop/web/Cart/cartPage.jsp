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
            <c:forEach items="${goods}" var="good">
                <tr>
                    <td>${good.goodId}</td>
                    <td>${good.name}</td>
                    <td>${goodsMap.get(good)}</td>
                    <td>${good.price} $</td>
                    <td>
                        <script>
                            var p = ${good.price};
                            var a = ${goodsMap.get(good)}
                            document.write((p * a) + " $")
                        </script>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div>
        <h3>${price}</h3>
    </div>
    <div>
        <a href="/buy">Buy</a>
    </div>
    <div>
        <a href="/user">Go to home</a>
    </div>
</body>
</html>
