<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<h1>New user</h1>
<form action="AddUserServlet" method="post">
    <%--We could use divs instead for formatting--%>
    Username:<br/>
    <input type="text" name="username" value="<%=request.getParameter("username")%>"/><br/>
    Password:<br/>
    <input type="password" name="pass" value="<%=request.getParameter("pass")%>"/><br/>
    Full name:<br/>
    <input type="text" name="fullname"/><br/>
    Address<br/>
    <input type="text" name="address"/><br/>
    <input type="submit" value="Registration"/>
</form>
</body>
</html>