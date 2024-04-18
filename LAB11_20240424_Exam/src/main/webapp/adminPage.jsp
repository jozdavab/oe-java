<%@ page import="oe.lab11.lab11_20240424_exam.model.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="oe.lab11.lab11_20240424_exam.model.StudentRepository" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin page</title>
</head>
<body>
<%
    List<Student> students = StudentRepository
            .getInstance()
            .getStudents()
            .stream()
            .filter(s -> !s.getNeptunCode().equals("admin"))
            .toList();
%>

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