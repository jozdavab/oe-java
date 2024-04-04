<%@ page import="oe.lab09.lab09_20240410_teachers.Model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main Page</title>
</head>
<body>
<%
    // We must import the User from our own package!
    User user = (User) session.getAttribute("user");
%>
<h1>Hello ${user.fullName}!</h1>
<p>${user.username} - ${user.address}</p>
</body>
</html>