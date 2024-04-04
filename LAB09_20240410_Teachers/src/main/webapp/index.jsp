<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<!--You may have to create webapp folder manually-->
<head>
    <title>Index</title>
</head>
<body>
<h1>Login</h1>
<form action="/login" method="post">
    Username:<br/>
    <input type="text" name="username" value="test"/><br/>
    Password:<br/>
    <input type="password" name="password" value="test"/><br/>
    <input type="submit" value="Login"/>
</form>
</body>
</html>