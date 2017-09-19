package request_source;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetSource extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//对请求协议信息提取
		System.out.println("Method:"+request.getMethod());
		System.out.println("ContentPath:"+request.getContextPath());
		System.out.println("RequestURI:"+request.getRequestURI());
		System.out.println("RequestURL:"+request.getRequestURL());
		System.out.println("QueryString:"+request.getQueryString());
		System.out.println("ip address is "+ request.getRemoteAddr());
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
