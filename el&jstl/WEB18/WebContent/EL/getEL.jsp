<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
		/*
			该jsp展示了以下几个知识点
				1.加！可以作为成员变量使用
				2.在jsp代码中获取header的UserArgent 并将它打印
		*/
	%>
	
	
	<%!
		List<String> ls = new ArrayList<>();
	%>
	
	
	<%
		String s =request.getHeader("User-Agent");
		if(ls.contains(s)){
				
		}else{
			ls.add(s);	
		}
		
		for(String l :ls){
			out.write(l+"<br>");
		}
		 
	%>
</body>
</html>