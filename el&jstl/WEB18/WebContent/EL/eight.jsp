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
		// El 具有11个对象 下面将一一列举 （4个域对象 位置在 /WEB18/WebContent/EL/setEL.jsp）
		
		//先设置相关参数
		Cookie co = new Cookie("name","jack");
		response.addCookie(co);
	%>
	
	
	
	
	<b>header取值 </b> ${header["User-Agent"]}
	 <hr>
	 <!--
	 	下列语句 暂时不明白怎么使用 可能是用作迭代 
	 
	 -->
	 <b>header所有值</b>${headerValues}
	 <hr>
	 
	 <!-- 获得cookie name属性值 -->
	 <b>name = </b>${cookie.name}
	 <hr>
	 
	 <!-- 获得 请求体的属性 -->
	 <b>单一的name属性值</b>${param.name}
	 <hr>
	 <!-- 获得所有的请求体值 -->
	  <b>所有的属性值</b>${paramValues}
	  <hr>
	  <!-- 获得配置文件属性 -->
	  <b>context_config</b>${initParam.hello}
	  <hr>
	  
	        
	 
	 
	  
	 
	 
	 
	 
	 
		
	
	
	
	
</body>
</html>









