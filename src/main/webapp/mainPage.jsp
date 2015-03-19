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

    <h3><a href="http://localhost:8080/login.jsp">Log out</a></h3>

<% String username = (String) request.getAttribute("username");
%>
    Hello <%= username %>

<form method="POST">

<br><br>
    Insert your text: <br>
<textarea name="message" rows="10" cols="50">
Type your text here.
</textarea>
    <br>
    <input type="submit" value="Submit">
</form>

<br/>

<% Object taskDone = null;
    taskDone = request.getAttribute("taskDone");
%>

<% if(taskDone == null)  {
%>

<form action="UploadServlet" method="post" enctype="multipart/form-data">
    Select File to Upload:<input type="file" name="fileName">
    <br>
    <input type="submit" value="Upload">
</form>

<% } else {
%>

<h2> <%= request.getAttribute("message")%> </h2>

 <% }
 %>

<br/>

<form action="minValueOfWord" method="post">
    Minimum char in the word: <input type="text" name="minValue"><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>