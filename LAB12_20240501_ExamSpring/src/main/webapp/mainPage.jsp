<%@ page import="oe.lab12.lab12_20240501_examspring.model.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main Page</title>
</head>
<body>
<% Student student = (Student) session.getAttribute("student");%>
<p1>Welcome <%=student.getName()%>!</p1>
</body>
</html>