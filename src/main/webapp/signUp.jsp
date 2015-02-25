<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up Page</title>
</head>
<body>
<form method="POST"
      action="Registration.do">

    Your name:<br>
    <input type="text" name="name" required="required">
    <br>
    Email:<br>
    <input type="text" name="email" required="required">
    <br>
    Create a password:<br>
    <input type="password" name="psw" required="required">
    <br>
    Confirm your password:<br>
    <input type="password" name="psw2" required="required">
    <br><br>
    <input type="submit" value="Sign up">

</form>

</body>
</html>
