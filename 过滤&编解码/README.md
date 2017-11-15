<h3>编码与解码</h3>

**编码** 将一个字符进行编码 例如 王小康 根据对于的字符表映射成一串基础字节码进行传输

**解码** 将一串字节码通过码表进行查询 生成字符！

根据 eclipse的初始化配置 描述下j2ee在web提交方面的运作方式
初始化条件
- eclipse默认解析为 utf-8
- 浏览器发送方式默认 iso8859-1

过程 : 当点击提交时 中文根据编码表(iso8859-1) 将字符串映射成一串字符,进行传输
注意这个时候 出现了2个问题 get 与 post 方式
- get方式 该方式在于浏览器即使设置pageEncode为utf-8,但在发送数据时是通过url发送,即发
送以iso8859-1的方式发送,故此接受数据时应当进行先使用码表 iso8859-1进行解码,再用utf-8编码成中文。
```
  String name = request.getParameter("name");
  String name1 = new String(name.getBytes("iso8859-1"), "utf-8");
```
- post方式 post方式是基于将发送的数据放入请求体,并根据网页的编码设置进行编码

例如jsp中
```
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
```

这句作用就是设置编码方式,当用utf-8传到服务器时 服务器(也可以暂时看成eclipse)会按照
它设定的解析方式解析,因此当页面设置为 UTF-8编码时,post方法在此种解析方式下是可以直接读取的


这样又提出了一个新的问题：当读入String类中的正确中文后,String有是怎么存储的呢？(待解)


<h3>案例</h3>

**问题** 当遇到输入不同的编码方式,每一次都需要那么多繁杂的步骤吗? 解码编码 get还是post 最让人疯狂的还有 每一个servlet都需要转换,怎么解决这些问题了,要求满足代码尽量精简,可读性强

**解决方案** 利用filet拦截所有的request,利用装饰者方法进行增强,强化方法getparamter() 方法,让它返回正确的值


知识点 即便在jsp中设置了返回形式是UTF-8解码，但servlet返回的默认为iso8859，仍然需要进行设置
> response.setContentType("text/html;charset=UTF-8");
