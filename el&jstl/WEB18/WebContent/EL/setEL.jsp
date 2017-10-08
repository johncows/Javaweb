<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>setEL</title>
</head>
<body>
	<%
		request.setAttribute("requ", "request");
		session.setAttribute("sess", "session");
		pageContext.setAttribute("page", "pageContext");
		application.setAttribute("appli", "servletContext");
	%>
		${requestScope.requ}<hr>
		${sessionScope.sess}<hr>
		${pageScope.page}<hr>
		${applicationScope.appli}<hr>
</body>
</html>