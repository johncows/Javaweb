<font size = 3 face="楷体">
<h2>监听事件</h2>

一 监听器 Listener

监听器的组成 事件源 监听器 注册监听器 响应行为

着重介绍监听器的种类

|  监听器对象  |  request域    |httpsession域 | servletContext域 |
|-------------|-------------|-----------|-------------|
|  监听域对象的创建与销毁和创建  | ServletRequestListener    |   HttpSessionListener    | ServletContextListener |
| 监听三大域对象的属性变化   |  ServletRequestAriibuteListenr    |  HttpSessionAttributeListener     |    ServletContextAttibuteListener   |
|   对象感知监听器  |   HttpSessionBindingListener  |  HttpSessionActivationListener  |  监听是否绑定与钝活化        |


<h4>测试代码</h4>
代码见 com.kk.Listener 与 com.kk.servlet

<h5>对于属性变化 下面显示的通用方法</h5>

```
@Override
public void attributeAdded(ServletContextAttributeEvent scab) {
  该方法 会监听 添加 的行为
}

@Override
public void attributeRemoved(ServletContextAttributeEvent scab) {
  该方法 会监听删除的数据 并且可以获得被删除的数据
}

@Override
public void attributeReplaced(ServletContextAttributeEvent scab) {
  该方法监听修改的方法
  同时获取的键值是未修改之前的值
}
```
- 对对象设置监听器 监听的是session的存放
- 对于session的钝化 需要使用到配置文件context.html 和 对象类所需实现的接口 implement  Serializable,HttpSessionActivationListener

context.xml代码如下
```
<Context>
 <!-- maxIdleSwap:session中的对象多长时间不使用就钝化 -->
 <!-- directory:钝化后的对象的文件写到磁盘的哪个目录下  配置钝化的对象文件在work/catalina/localhost/钝化文件 -->
 <Manager className="org.apache.catalina.session.PersistentManager" 	maxIdleSwap="1">
  <Store className="org.apache.catalina.session.FileStore" directory="ppap" />
 </Manager>
</Context>
```
放置位置位于webcontent目录下的meta-inf下
<h3>未测试出如何活化! </h3>

****
<h3>邮箱的收发</h3>

1. 邮箱服务器的安装 小概念:邮件服务器的协议 接受：POP3   IMAP 发送: SMTP 邮件的服务器是自行安装的 在这里我安装的是视频所提供的 MaliServer

2. 服务器的配置过程中由于是在主机上进行收发 因此配置的域名应当选择localhost

3.接下来便是对j2ee中的收发文件的API 做一个学习

  开发步骤 ：通过监听类 开启任务调度 某个时间段进行数据查询 发现今天是生日的 发送祝福邮件
  注意 查询数据库用户的生日时 使用的是模糊查询！


在web测试中并未完成生日的数据库查询,但思路还是比较清晰，个人感觉可以完成！

**发送邮件的工具位于WEB23目录下的util包中.**
