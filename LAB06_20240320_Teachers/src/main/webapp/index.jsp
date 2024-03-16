<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Tax calculator</title>
</head>
<body>
<h1>Income tax calculator</h1>
<!--<form action="hello-servlet">-->
<form action="TaxPage.jsp"> <!-- This form sends its data to the TaxPage.jsp -->
    Name: <input type="text" name="name"/><br/>
    Monthly salary: <input type="number" name="salary"/>
    <!-- Nicely aligned version using div: -->
    <!--<div style="display: inline-block">
        Name:<br/>
        Monthly salary:
    </div>
    <div style="display: inline-block">
        <input type="text" name="name"/><br/>
        <input type="number" name="salary"/>
    </div>-->
    <br/><input type="submit" value="Send"/>
</form>
</body>
</html>