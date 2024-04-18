<%@ page import="oe.lab12.lab12_20240501_examspring.model.Student" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Page</title>
</head>
<body>
<% List<Student> students = (List<Student>) session.getAttribute("students"); %>

<table>
    <tr>
        <th>Neptun</th>
        <th>Name</th>
        <th>Password</th>
        <th>Action</th>
    </tr>
    <% for (Student student : students) { %>
    <tr>
        <td><%=student.getNeptunCode()%></td>
        <td><%=student.getName()%></td>
        <td><%=student.getPassword()%></td>
        <td><a href="delete?neptun=<%=student.getNeptunCode()%>">Delete</a></td>
    </tr>
    <% } %>
</table>
</body>
</html>