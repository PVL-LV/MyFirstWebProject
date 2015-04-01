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

    <%--link to log out from app--%>
    <h3><a href="http://localhost:8080/login.jsp">Log out</a></h3>

<%
        //allow access only if session exists
    String user = null;
    if(session.getAttribute("username") == null){
        response.sendRedirect("login.html");
    }else user = (String) session.getAttribute("username");
    String userName = null;
    String sessionID = null;
    Cookie[] cookies = request.getCookies();
    if(cookies !=null){
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("username")) userName = cookie.getValue();
            if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
        }
    }
%>

    <%--show users name on top of page--%>
<h2>  Hello <%= userName %> </h2>

    <%-- to insert text--%>
<%--<form method="POST">--%>

<%--<br><br>--%>
    <%--Insert your text: <br>--%>
<%--<textarea name="message" rows="10" cols="50">--%>
<%--Type your text here.--%>
<%--</textarea>--%>
    <%--<br>--%>
    <%--<input type="submit" value="Submit">--%>
<%--</form>--%>

    <%--to upload file  --%>
<br><br>

<% Object taskDone = null;
    taskDone = session.getAttribute("taskDone");
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
    <h4> <%= session.getAttribute("message")%> </h4>
<% }
%>


    <%--to set minimal value of word--%>
<br/>

<% Boolean setMinTaskDone = null;
    setMinTaskDone = (Boolean)session.getAttribute("setMinTaskDone");

%>

<% if (setMinTaskDone == null) {
%>


<form action="MinCharSetServlet.do" method="post">
    Minimum char in the word: <input type="text" name="minValue"><br>
    <input type="submit" value="Submit">
</form>

<% } else if (setMinTaskDone){
%>

    <h4> <%=  session.getAttribute("minValMessage") %> </h4>

<% } else {
%>

    <h4> <%=  session.getAttribute("minValMessage2") %> </h4>

    <form action="MinCharSetServlet.do" method="post">
        Minimum char in the word: <input type="text" name="minValue"><br>
        <input type="submit" value="Submit">
    </form>

<%  }
%>

    <%-- button "start counting words"--%>
    <br/>
<form action="StartCountingServlet" method="post">

    <input type="submit" value="Start Counting">
</form>


</body>
</html>