<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Map<String,String> map = new HashMap<String,String>();
		map.put("name","狗哥");
		map.put("age","25");
		map.put("tel","18019915762");
		map.put("id","12");
		
		
		request.setAttribute("map",map);
	%>


	
	<c:forEach items="${map}" var="entry">
		${entry.key }:${entry.value} <br>
	</c:forEach>
	
	
</body>
</html>