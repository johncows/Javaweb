package ResponseHeader;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class refresh
 */
public class refresh extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	
	/*
	 *设置响应头 参数 refresh 的值为5秒后自动刷新 
	 *值得注意的是 地址栏中跳转的地址应该是发布在Tomcat中的地址 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("refresh", "5,/web14/loca.html");

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
