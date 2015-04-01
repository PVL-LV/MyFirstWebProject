<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>

</head>

<style>
    body{
        text-align:center;
        background-color:lightgrey;
    }
    h1 {
        color:#3c82ff;
        font-size :300% ;
    }
</style>

<body>

<h1>WordCounter</h1>

<h2 style="font-family:courier">We count every word!</h2>

<h5>Sign in with your WordCounter Account</h5>

    <%--form to input username and pass--%>
<form method="POST"
      action="Login.do">
    Name or email:<br>
    <input type="text" name="username" required="required">
    <br>
    User password:<br>
    <input type="password" name="pass" required="required">
    <br><br>
    <input type="submit" value="Log in">
</form>
<br>

    <%--link to page to sign up--%>

<a href="http://localhost:8080/signUp.jsp">Create an account</a>

</body>
</html>
