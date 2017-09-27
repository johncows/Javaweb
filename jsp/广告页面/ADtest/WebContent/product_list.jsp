<%@page import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>
<%@page import="java.util.List"%>
<%@page import="domain.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>会员登录</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="css/style.css" type="text/css" />

<style>
body {
	margin-top: 20px;
	margin: 0 auto;
	width: 100%;
}

.carousel-inner .item img {
	width: 100%;
	height: 300px;
}
</style>
</head>

<body>


	<!-- 引入header.jsp -->
	<jsp:include page="/header.jsp"></jsp:include>


	<div class="row" style="width: 1210px; margin: 0 auto;">
		<div class="col-md-12">
			<ol class="breadcrumb">
				<li><a href="#">首页</a></li>
			</ol>
		</div>
		
	<%
		
			
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
			else{
				response.setStatus(302);
				response.setHeader("location", "http://localhost/ADtest/productListServlet");
			}
		%>		
		
	
	

	



	<!-- 引入footer.jsp -->
	<jsp:include page="/footer.jsp"></jsp:include>

</body>

</html>