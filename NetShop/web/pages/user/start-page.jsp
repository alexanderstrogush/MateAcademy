<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Hello ;)</title>
</head>
<body>
    <div>
        <a href="/user/cart">Cart</a> <br>
        <a href="/user/orders">Orders</a>
    </div>
    <div class="goods">
        <table>
            <caption>Goods</caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Description</th>
                <th>Price</th>
                <th>Amount</th>
            </tr>
            <c:forEach items="${goods}" var="good">
                <tr>
                    <td>${good.goodId}</td>
                    <td>${good.name}</td>
                    <td>${good.description}</td>
                    <td>${good.price}</td>
                    <td> <input type="text" name="amount" id="amount${good.goodId}" value="1"> </td>
                    <td>
                        <script type="text/javascript">
                            function goToAdd(x) {
                                var amount = document.getElementById("amount" + x).value;
                                document.location.href = "/user/cart/add-good?good_id=" + x + "&amount=" + amount;
                            }

                            function goToBuy(x) {
                                var amount = document.getElementById("amount" + x).value;
                                document.location.href = "/user/buy-in-one-click?good_id=" + x + "&amount=" + amount;
                            }
                        </script>
                        <a href="javascript: goToAdd(${good.goodId})">Add to cart</a>
                    </td>
                    <td> <a href="javascript: goToBuy(${good.goodId})">Buy</a> </td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div>
        <a href="/sign-out">Sign Out</a> <br>
    </div>
</body>
</html>
