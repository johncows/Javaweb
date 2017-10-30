<font face="楷体" size= '3'>
<h1>Ajax技术</h1>



<h2>Ajax概述</h2>


- 同步:*客户端发送请求到服务器端,当服务器返回响应之前,客户端都处于等待卡死状态*


- 异步:*客户端发送请求到服务器端,无论服务器是否返回响应,客户端都可以随意做其他事情,不会被卡死*


- js修改html代码 本质是修改在客户端内存里的代码 使用开发者工具进行查看

----
<h2>js构造ajax(原生)</h2>
实现内容包括同步 异步之间的差距 同时加载一个弹出框来查看是否异步

#JavaScript
```
    function fun1(){
      //建立一个ajax引擎对象
      var xmlHttp = new XMLHttpRequest();
      //开启一个监听对象 监听事件
      xmlHttp.onreadystatechange = function(){
        //通过监听时不断的返回值来确定是否将ajax的数据提交给客户端
        if(xmlHttp.readyState==4&&xmlHttp.status==200){
          var res = xmlHttp.responseText;
          document.getElementById("span1").innerHTML = res
        }
      }
      //确立提交方式,url与是否异步 一般情况下都是异步(该步骤旨在封装数据)
      xmlHttp.open("GET","/WEB22/ajaxServlet?name=zhangsan",true);
      //发送
      xmlHttp.send();
    }
```
<h6>注意事项</h6>
1.  利用ajax提交的post/get方法都能被正确的解析成原有字符(测试为jsp文件类型)
2.  可以看出前几步操作都是对数据的一次封装 <font color = "yellow">对于servlet来说是没有区别的<font>

----
<h2>json数据格式</h2>
简介 json是一种与语言无关的数据交换的格式
1. 使用ajax进行前后台数据交换
2. 移动端与服务端的数据交换

json具有2种格式
  1. 对象格式：{"key1":obj,"key2":obj,"key3":obj...}
  2. 数组/集合格式：[obj,obj,obj...]

<h5>测试代码</h5>
```
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
```
注意事项
1. 这个demo实现的页面加载时间
2. json取值都是按这个套路来 注意数组与对象相互嵌套
3. 弹窗书写错误 <font color= "red">正确写法为 alert 不是 alter

----
<h3>jQuery框架下的ajax与json数据交互</h3>
在jQuery框架下ajax的使用被进行了封装，使用方式也变得更加简单

三种方法(前两种较为简单 后面的较为*复杂*)
1. get

  ```
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
  ```
2. post
  ```
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
  ```

3. $.ajax () 方式较前两种 要显得更底层 可控制元素更多


  ```
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
  ```





  注意事项:
  - url：代表请求的服务器端地址
  - data：代表请求服务器端的数据（可以是key=value形式也可以是json格式）
  - callback：表示服务器端成功响应所触发的函数（只有正常成功返回才执行）
  - type：表示服务器端返回的数据类型（jquery会根据指定的类型自动类型转换）
  常用的返回类型：text、json、html等

*json对象必须保持原格式 返回String类型时,必须有""表键值对 用\ 进行转义
  同样是测试该文件 又发现中文自动被解析*

-------
<h3></h3>
