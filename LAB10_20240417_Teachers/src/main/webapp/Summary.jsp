<%@ page import="oe.lab10.lab10_20240417_teachers.model.Pizza" %>
<%@ page import="oe.lab10.lab10_20240417_teachers.model.Topping" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Pizza order summary</title>
</head>
<body>
<h1>Your order</h1>
<%
    request.setCharacterEncoding("UTF-8");
    Pizza pizza=(Pizza)session.getAttribute("pizza");
    String name=request.getParameter("name");
    String address=request.getParameter("address");
%>
<table border="1">
    <tr><td colspan="2" style="font-weight: bold">Order details</td></tr>
    <tr><td>Name:</td><td><%=name%></td></tr>
    <tr><td>Address:</td><td><%=address%></td></tr>
    <tr><td>Total:</td><td><%=pizza.totalPrice() %> HUF</td></tr>
    <tr><td colspan="2" style="font-weight: bold">Selected toppings</td></tr>
    <% for (Topping topping : pizza.getToppings()) { %>
    <tr>
        <td><%=topping.getName()%></td>
        <td><%=topping.getPrice()%> HUF</td>
    </tr>
    <% } %>
</table>
</body>
</html>