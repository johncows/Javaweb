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
		pageContext.setAttribute("name", "jack",pageContext.APPLICATION_SCOPE);
		pageContext.setAttribute("name", "jack",pageContext.PAGE_SCOPE );
		pageContext.setAttribute("name", "jack", pageContext.REQUEST_SCOPE);
		
		
		
		pageContext.getAttribute("name",pageContext.PAGE_SCOPE);
		pageContext.findAttribute("name");//从小到大查询该key对应的值
		
	%>
</body>
</html>