package Header;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.jmx.snmp.Enumerated;

public class GetHeader extends HttpServlet {
	private static final long serialVersionUID = 1L;
      

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得指定header值
		System.out.println("浏览器版本为 "+request.getHeader("User-Agent"));
		//获取所有header的name值 并将其全部打印
		Enumeration<String> headname = request.getHeaderNames();
		while(headname.hasMoreElements()) {
			System.out.println(headname.nextElement()+" "+request.getHeader(headname.nextElement()));
		}		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
