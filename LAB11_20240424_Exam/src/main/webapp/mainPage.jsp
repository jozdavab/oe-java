<%@ page import="oe.lab11.lab11_20240424_exam.model.Student" %>
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