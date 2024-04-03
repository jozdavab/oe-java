<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Scopes Example</title>
</head>
<body>
<%
    // Notice the difference between parameter and attribute. (Scope is the same for both)
    if (request.getParameter("requestAttr") != null) {
        request.setAttribute("requestAttrName", "Bill");
    }
    if (request.getParameter("sessionAttr") != null) {
        session.setAttribute("sessionName", "Igor");
    }
    if (request.getParameter("appAttr") != null) {
        // Ignore error on below line. Build will be fine.
        getServletContext().setAttribute("appName", "John");
    }
%>
<p>Request parameter:
    <!--Ternary operator for null safety-->
    <%= request.getParameter("requestParamName") != null ? request.getParameter("requestParamName") : "-" %>
</p>
<p>Request attribute:
    <!--Ternary operator for null safety-->
    <%= request.getAttribute("requestAttrName") != null ? request.getAttribute("requestAttrName") : "-" %>
</p>
<p>Session attribute:
    <!--Ternary operator for null safety-->
    <%= session.getAttribute("sessionName") != null ? session.getAttribute("sessionName") : "-" %>
</p>
<p>Application (context) attribute:
    <!--Ternary operator for null safety-->
    <!--Ignore error on below line. Build will be fine-->
    <%= getServletContext().getAttribute("appName") != null ? getServletContext().getAttribute("appName") : "-" %>
</p>
<hr/>
<!--Action is undefined, so request will "come back"-->
<form method="post">
    Request parameter: <input type="text" name="requestParamName"/><br/>
    <input type="checkbox" name="requestAttr"/> Set Request attribute<br/>
    <input type="checkbox" name="sessionAttr"/> Set Session attribute<br/>
    <input type="checkbox" name="appAttr"/> Set App context attribute<br/>
    <input type="submit" value="Apply"/>
</form>
</body>
</html>