<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Login</title>
</head>
<body>
<h1>Login</h1>
<form action="LoginServlet" method="post">
    <%-- We could use divs instead for formatting --%>
    Username:<br/>
    <input type="text" name="username" value="test"/><br/> <%-- value parameter is used for easy testing. --%>
    Password:<br/>
    <input type="password" name="pass" value="test"/><br/> <%-- value parameter is used for easy testing. --%>
    <input type="submit" value="Login"/>
</form>
</body>
</html>