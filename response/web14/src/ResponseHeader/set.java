package ResponseHeader;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class set extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//设置状态码 常用的(404,302,200,505)
		response.setStatus(302);
		
		
		/*
		 * 设置响应头 响应头一般以键值对存在 可以自定义响应头 
		 * 列举下 比较特定的响应头
		 * 		refresh 定时刷新
		 * 		location 重定向的主页 
		 * 		
		 */
		response.setIntHeader("age", 25);
		response.addIntHeader("age", 15);
		
		
		
	
		
	}

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
