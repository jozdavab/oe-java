<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<!--You may have to create webapp folder manually-->
<head>
    <title>Index</title>
</head>
<body>
<h1>Pizza Paradise - create your favorite pizza!</h1>
<form action="neworder" method="post">
    <fieldset style="display:inline"><legend>Select size:</legend>
        <!--Radio button names are the same!-->
        <input type="radio" name="size" value="24"/>24 cm<br/>
        <input type="radio" name="size" value="32" checked="checked"/>32 cm<br/>
        <input type="radio" name="size" value="45"/>45 cm
    </fieldset><br/>
    <input type="submit" value="Next"/>
</form>
</body>
</html>