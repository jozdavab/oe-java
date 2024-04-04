<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<h1>Register</h1>

<!--Special spring form with nice features. Taglib declaration is needed.-->
<form:form method="post" action="adduser" modelAttribute="user">
    Username: <form:input path="username"/><br/>
    Password: <form:password path="password"/><br/>
    Full name: <form:input path="fullName"/><br/>
    Address: <form:input path="address"/><br/>
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>