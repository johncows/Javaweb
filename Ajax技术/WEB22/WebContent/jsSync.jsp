<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<script type="text/javascript">
	function fun1(){
		var xmlHttp = new XMLHttpRequest();
		xmlHttp.onreadystatechange = function(){
			if(xmlHttp.readyState==4&&xmlHttp.status==200){
				var res = xmlHttp.responseText;
				document.getElementById("span1").innerHTML = res
			}
		}
		xmlHttp.open("GET","/WEB22/ajaxServlet?name=老王",true);
		xmlHttp.send();
	}
		
	function fun2(){
		var xmlHttp = new XMLHttpRequest();
		xmlHttp.onreadystatechange = function(){
			if(xmlHttp.readyState==4&&xmlHttp.status==200){
				var res = xmlHttp.responseText;
				document.getElementById("span2").innerHTML = res
			}
		}
		xmlHttp.open("post","/WEB22/ajaxServlet?name=老李",false);
		xmlHttp.send();
	}
</script>

<title>Insert title here</title>
</head>
<body>
	<button onclick="fun1()">异步产生随机数</button><span id="span1"></span><br>
	<button onclick="fun2()">同步产生随机数</button><span id ="span2"></span><br>
	<button onclick="alert()">测试按钮</button><br>
	
</body>
</html>