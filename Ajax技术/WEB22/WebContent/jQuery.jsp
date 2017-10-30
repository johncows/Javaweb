<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="jquery-1.11.3.min.js"></script>
<script type="text/javascript">
		function fun1(){
			$.get(
				"/WEB22/jqAjax",
				{"name":"张三","age":25}, //请求参数
				function(data){ //执行成功后的回调函数
					//{\"name\":\"tom\",\"age\":21}
					alert(data.name);
				},
				"json"
			);
		}
		function fun2(){
			$.post(
				"/WEB22/jqAjax",
				{"name":"李四","age":25}, //请求参数
				function(data){ //执行成功后的回调函数
					//{\"name\":\"tom\",\"age\":21}
					alert(data.name);
				},
				"json"
			);
		}
		
		function fun3(){
			$.ajax({
				url:"/WEB22/jqAjax",
				async:true, 
				type:"POST",
				data:{"name":"lucy","age":18},
				success:function(data){
					alert(data.name);
				},
				error:function(){
					alert("请求失败");
				},
				dataType:"json"
			});
		}
</script>

<title>Insert title here</title>
</head>
<body>
	<button onclick= "fun1()">get点我</button><br>
	<button onclick= "fun2()">post点我</button><br>
	<button onclick="fun3()">$.ajax()方式</button>
</body>
</html>