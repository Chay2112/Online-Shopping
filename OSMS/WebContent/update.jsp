
<%@page import="com.model.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>update</title>
<script type="text/javascript" src="validation.js"></script>
</head>
<body>
<%Product p=(Product)request.getAttribute("p"); %>
<%@include file="header.html"%>
<div>
<table width = "100%">
<tr>
<td align="center" style = "color:red">AboutUS</td>
<td align="center" style = "color:red">ContactUS</td>
<td class = "column" style = "color:red" align="center">AnyQueries</td>
</tr>
<tr>
<td align = "right" colspan = "4">
welcome 
<%=
request.getSession().getAttribute("user")
%></tr></table></div>
<div>
<table align="left">
<tr>
<td>&nbsp;</td></tr>
<tr><td>&nbsp;</td><tr>
<tr><td>&nbsp;</td><tr>
<tr><td>&nbsp;</td></tr>
<tr><td>&nbsp;</td></tr>
<tr>
<td align = "left">
<a href = "<%=request.getContextPath()%>/addProduct.jsp">Add Product</a><br>
<a href = "<%=request.getContextPath()%>/productDetails.jsp">Product Details</a><br>
<a href = "<%=request.getContextPath()%>/main.jsp">Home</a>
</td>
</tr>
</table></div>
<div><form action = "<%=request.getContextPath() %>/Controller" method = "post" onsubmit = "return validateUpdate()">
<table align = "center">
<tr><td colspan= "2"><h1>PRODUCT DETAILS</h1>
<tr>

<td>ProductName</td>
<td><input type = "text" disabled="disabled" name = "productname" value="<%=p.getProductname() %>">
</td>
</tr>
<tr>
<td>Description</td>
<td><textArea rows = "5" cols = "20" disabled="disabled" name="description"><%=p.getDesription() %></textArea>
</td>
</tr>
<tr>

<td>Category</td>
<td><input type="text" disabled="disabled" name="category" value="<%=p.getCategory() %>">
</td>
</tr>
<tr>
<td>Price/Quantity</td>
<td><input type = "text" name = "price" id="price" value="<%=p.getPriceperquantity() %>">
</td><td><font color="red" id="price_err"></font></td>
</tr>
<tr>
<td>Total Quantity</td>
<td><input type = "text" name = "totalquantity" id="qty" value="<%=p.getTotalquantity() %>">
</td><td><font color="red" id="qty_err"></font></td>
</tr>
<tr>
<tr>
<td>status</td>
<td><input type = "radio" name = "status" value = "open">open
<input type = "radio" name = "status" value = "close">close</td>
</tr>
<tr>
<td align = "right">
<input type = "submit" name = "action" value = "UPDATE">
<input type="hidden" name="productid" value="<%=p.getProductId() %>">
</td>
<td align = "center">
<input type = "reset" name = "submit" value = "RESET" >
</td></table>
</form></div>

<%@include file="footer.html"%>
</body>
</html>

</body>
</html>



