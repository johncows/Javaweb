<%@page import="domain.Product"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<%
			out.write("hello");
			//获得集合List<Product>
			List<Product> productList = (List<Product>)request.getAttribute("products");
			if(productList!=null){
				for(Product product : productList){
					out.write("<div class='col-md-2' style='height:250px'>");
					out.write("<a href='product_info.htm'>");
					out.write("<img src='"+product.getPimage()+"' width='170' height='170' style='display: inline-block;'>");
					out.write("</a>");
					out.write("<p><a href='product_info.html' style='color: green'>"+product.getPname()+"</a></p>");
					out.write("<p><font color='#FF0000'>商城价：&yen;"+product.getShop_price()+"</font></p>");
					out.write("</div>");
				}
			}
		%>		
</body>
</html>