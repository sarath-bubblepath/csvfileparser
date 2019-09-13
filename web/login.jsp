<%--
  Created by IntelliJ IDEA.
  User: cb-sarath
  Date: 2019-09-12
  Time: 23:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h1>Welcome, please login:</h1>
    <form action="/login" method="post">
        <div>
            <label for="username">Username</label>
            <input type="text" id="username"/>
            <label for="password">Password</label>
            <input type="password" id="password"/>
            <input type="submit" value="Login"/>
        </div>
    </form>
</body>
</html>
