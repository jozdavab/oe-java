<%@ page import="oe.lab07.lab07_20240327_teachers.Model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    User user = (User) session.getAttribute("user");     // User has to be imported!
%>
<h1>Hello <%=user.getFullName() %>!</h1>
</body>
</html>