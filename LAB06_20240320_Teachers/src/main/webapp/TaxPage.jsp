<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tax Calculation Results</title>
</head>
<body>
<% request.setCharacterEncoding("UTF-8");
    String name = request.getParameter("name");
    if (name.isEmpty()) {
        name = "Unknown User";
    }
%>
<h1>Hello <%=name%>!</h1>

<%
    String salstring = request.getParameter("salary");
    if (!salstring.isEmpty()) {
        int sal = Integer.parseInt(salstring);
        int yearlysal = 12 * sal;
        int yearlytax = Math.round(yearlysal * 0.15f);
%>
<table border="1">
    <tr>
        <td>Monthly salary:</td>
        <td><%=sal%> HUF</td>
    </tr>
    <tr>
        <td>Yearly salary:</td>
        <td><%=yearlysal%> HUF</td>
    </tr>
    <tr>
        <td>Yearly income tax:</td>
        <td><%=yearlytax%> HUF</td>
    </tr>
</table>

<% } else { %>
<p>Salary unknown, tax calculation failed.</p>
<% } %>

<a href="index.jsp">Back to the calculator</a>
</body>
</html>
