<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>update success</title>
<style>
p{
	align:center;
}
</style>
</head>
<body>
<%@include file="header.html"%>

<table cellspacing = "0" width = "100%">
<tr>
<td align="center" style = "color:red"><a href = "aboutUs.jsp">AboutUS</td>
<td align="center" style = "color:red">ContactUS</td>
<td class = "column" style = "color:red">AnyQueries</td>
</tr>
<tr>
<td align = "right" colspan = "4">
welcome 
<%=
request.getSession().getAttribute("user")
%></tr>

<tr><td>
<a href = "main.jsp">Home</a>
<br>
<a href = "addProduct.jsp">Add Product</a>
<br>
<a href = "<%=request.getContextPath()%>/Controller?action=productdetails">Product Details</a></td>
<td rowspan = "2" align = "center" style = "padding-left:'20';padding-right:'20'">
<p style = "color:red">failed to add product</p>
</td>
</tr>
</table>
<%@include file="footer.html"%>
</body>
</html>