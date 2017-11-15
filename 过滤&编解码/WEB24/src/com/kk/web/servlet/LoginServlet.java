package com.kk.web.servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kk.domain.User;
import com.kk.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserService us = new UserService();
		User user = null;
		try {
			user = us.login(username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			 username = URLEncoder.encode(username, "utf-8");
		
			Cookie cook_name = new Cookie("username",username);
			Cookie cook_pass = new Cookie("password",password);
			
			cook_name.setMaxAge(60*60);
			cook_pass.setMaxAge(60*60);
			
			cook_name.setPath(request.getContextPath());
			cook_pass.setPath(request.getContextPath());
			
			response.addCookie(cook_name);
			response.addCookie(cook_pass);
		
		
		
			request.getSession().setAttribute("user", user);
			
			response.sendRedirect(request.getContextPath()+"/index.jsp"); //地址务必写全 不能输入一个项目名 来让他判断是否存在index文件
			
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
