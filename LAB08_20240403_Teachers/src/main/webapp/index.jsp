<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Pizza Paradise - create your favorite pizza!</title>
</head>
<body>
<form action="neworder" method="post">
    <!--Radio button names are the same!-->
    <input type="radio" name="size" value="24"/>24 cm<br/>
    <input type="radio" name="size" value="32" checked="checked"/>32 cm<br/>
    <input type="radio" name="size" value="45"/>45 cm
    <input type="submit" value="Next"/>
</form>
</body>
</html>