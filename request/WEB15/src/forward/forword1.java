package forward;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class forword1
 */
public class forword1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public forword1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		/*这段demo含有2个知识点
		 * 1 网页的自动转发(与重定向不同的地方在于重定向进行的2次此网络访问 而网页转发在服务器内部进行的只有一次)
		 * 2 承接上一个知识点 重定向由于进行了2次网络访问 导致request的域对象无法共享 但转发可以共享 
		 * 
		 */
		request.setAttribute("name", "tom");
		
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/forward2");
		requestDispatcher.forward(request, response);
		
		
		
		
// 		重定向方式 不共享request的域对象		
//		response.setStatus(302);
//		response.setHeader("location", "/WEB15/forward2");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
