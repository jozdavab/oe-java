<%@ page import="oe.lab10.lab10_20240417_teachers.model.Topping" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Pizza Creator</title>
</head>
<body>
<jsp:useBean id="availableToppings" class="oe.lab10.lab10_20240417_teachers.model.ToppingsRepository" scope="application" />
<jsp:useBean id="pizza" class="oe.lab10.lab10_20240417_teachers.model.Pizza" scope="session"/>
<h1>Choose your toppings!</h1>
<p>Available toppings</p>
<table border="1">
    <% for (Topping topping : availableToppings.getToppings()) { %>
    <tr>
        <td><%=topping.getName()%></td>
        <td><%=topping.getPrice()%> HUF</td>
        <td><a href="add?name=<%=topping.getName()%>">Add</a></td>
    </tr>
    <% } %>
</table>
<%
    if (request.getAttribute("message") != null) {
%>
<p style="font-weight: bold"><%=request.getAttribute("message")%></p>
<% } %>
<p>Selected toppings</p>
<table border="1">
    <% for (Topping topping : pizza.getToppings()) {%>
    <tr>
        <td><%=topping.getName()%></td>
        <td><%=topping.getPrice()%> HUF</td>
        <td><a href="remove?name=<%=topping.getName()%>">Remove</a></td>
    </tr>
    <% }%>
</table>
<p>Total price: <%=pizza.totalPrice()%> HUF</p>
<h2>Finalize your order</h2>
<form action="summary" method="post">
    Name:       <input type="text" name="name"/><br/>
    Address:    <input type="text" name="address"/><br/>
                <input type="submit" value="Order"/>
</form>
</body>
</html>