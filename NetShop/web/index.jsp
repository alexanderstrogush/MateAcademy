<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Welcome</title>
    <link rel="stylesheet" href="css/style.css">
  </head>
  <body>
    <div class="login-form">
      <form action="login" method="post" id="login">
        Username <input type="text" name="username"> <br>
        Password <input type="password" name="password"> <br>
      </form>
    </div>
    <div class="button">
      <input type="submit" form="login" name="type" value="Sign In">
    </div>
    <div class="button">
      <a href="sign_up.jsp">Not yet registered?</a>
    </div>
  </body>
</html>
