<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 23.04.19
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Welcome</title>


  <link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Open+Sans:600'>

  <link rel="stylesheet" href="css/style.css">


</head>

<body>

<div class="login-wrap">
  <div class="login-html">
    <input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">Sign In</label>
    <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">Sign Up</label>
    <div class="login-form">
      <form action="SignIn" method="post">
        <div class="sign-in-htm">
          <div class="group">
            <label for="user" class="label">Username</label>
            <input id="user" type="text" name="username" class="input">
          </div>
          <div class="group">
            <label for="pass" class="label">Password</label>
            <input id="pass" type="password" name="password" class="input" data-type="password">
          </div>
          <div class="group">
            <input type="submit" class="button" name="type" value="Login">
          </div>
          <div class="hr"></div>
          <div class="foot-lnk">
            <a href="#forgot">Forgot Password?</a>
          </div>
        </div>
      </form>
      <form action="SignUp" method="post">
        <div class="sign-up-htm">
          <div class="group">
            <label for="user" class="label">First Name</label>
            <input id="user" type="text" name="firstName" class="input">
          </div>
          <div class="group">
            <label for="user" class="label">Last Name</label>
            <input id="user" type="text" name="lastName" class="input">
          </div>
          <div class="group">
            <label for="user" class="label">Username</label>
            <input id="user" type="text" name="username" class="input">
          </div>
          <div class="group">
            <label for="pass" class="label">Email Address</label>
            <input id="pass" type="text" name="email" class="input">
          </div>
          <div class="group">
            <label for="pass" class="label">Password</label>
            <input id="pass" type="password" name="password" class="input" data-type="password">
          </div>
          <div class="group">
            <label for="pass" class="label">Repeat Password</label>
            <input id="pass" type="password" name="repeatPassword" class="input" data-type="password">
          </div>

          <div class="group">
            <input type="submit" class="button" name="type" value="SignUp">
          </div>
          <div class="hr"></div>
          <div class="foot-lnk">
            <label for="tab-1">Already Member?</a>
          </div>
        </div>
      </form>
    </div>
  </div>
</div>
</body>

</html>
