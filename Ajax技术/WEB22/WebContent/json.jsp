<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	 function test(){
		 var json = {
					"key1":"value1",
					"key2":{"firstname":"张","lastname":"三丰","age":100},
					"key3":[
		 		          	{"name":"小双","age":28,"addr":"扬州"},
		 		          	{"name":"建宁","age":18,"addr":"紫禁城"},
		 		          	{"name":"阿珂","age":10,"addr":"山西"},
		 		          ]
			 };
		 
		 alert(json.key2.firstname);
		 alert(json.key3[1].age);
		 alert(json.key3[2].addr);
	}
	window.onload = test;
</script>

</head>
<body>

</body>
</html>