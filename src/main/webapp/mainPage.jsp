<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MainPage</title>
</head>
<style>
    h3{
        text-align: right;
    }
</style>

<body>
<form method="POST">
    <h3><a href="http://localhost:8080/login.jsp">Log out</a></h3>

    Hello <%= request.getAttribute("username") %>
    <br><br>

    Insert your text: <br>
 <textarea name="message" rows="10" cols="50">
Type your text here.
</textarea>
    <br>
    <input type="submit" value="Submit">
</form>
<br><br>

<form action="UploadDownloadFileServlet" method="post" enctype="multipart/form-data">
    Select File to Upload:<input type="file" name="fileName">
    <br>
    <input type="submit" value="Upload">

</form>

<form action="minValueOfWord" method="post">
    Minimum char in the word: <input type="text" name="minValue"><br>
  <input type="submit" value="Submit">
</form>

</body>
</html>
