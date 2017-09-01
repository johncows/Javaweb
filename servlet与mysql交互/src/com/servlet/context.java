package com.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.descriptor.web.ContextService;

public class context extends HttpServlet {
	
	
	
	public void init() {
		int count = 0;
		this.getServletContext().setAttribute("time", count);
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		/*
		 *   利用getServletContext()获得对象 利用初始化配置方法getInitParameter(key)获得对应的value  
		 */
  		ServletContext servletContext = this.getServletContext();
 		String va = servletContext.getInitParameter("name config");
 		response.getWriter().write(va);
 		
		
		/*
		 *  利用getRealPath来   从发布到tomcat上的WEB应用程序 键入相对地址  获得绝对文件位置
		 *  只能获得发布在web端的文件位置 即webContent
		 * 	
		 * 
		 * 或者使用下列的语法获得地址    
		 *	String path = context.class.getClassLoader().getResource("c3p0-config.xml").getPath();
		 *	获得的是这个类的加载器
		 */
 		String realPath = servletContext.getRealPath("/login.html");
 		response.getWriter().write(realPath);
 		
		
		/*
		 * 域对象 作为servlet中间的共同变量  可以利用init()初始化加载 ，没执行一次提交便自加1
		 */
		
		int count = (int) this.getServletContext().getAttribute("time");
		System.out.println("this is "+ (++count) + "   login");
		
		this.getServletContext().setAttribute("time", count);

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
