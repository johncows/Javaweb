package request_content;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetContent
 */
public class GetContent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Enumeration<String> parameterNames;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetContent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得单个字段的值
		String name = request.getParameter("name");
		System.out.println("name is "+ name);
		
		//获得单个字段的多值
		String[] hobbys = request.getParameterValues("hobby");
		System.out.print("hobby: ");
		for(String hobby:hobbys) {
			System.out.print(hobby+" ");
			}
		
		//该方法无法获得到date password 和多选框的
		System.out.println("\n-------------------------------------------------------");
		Enumeration<String> parameterNames = request.getParameterNames();
		while(parameterNames.hasMoreElements()) {
			System.out.println(parameterNames.nextElement()+":"+request.getParameter(parameterNames.nextElement()));
		 }
		 
		
		//利用此方法将保存的所有文件以键值对的方式存入，并利用Map.Entry<String, String[]>通过foreach循环来完成所有的取值
		Map<String, String[]> maps = request.getParameterMap();
		System.out.println("\n-------------------------------------------------------");

		for(Map.Entry<String, String[]> map:maps.entrySet()) {
			System.out.print(map.getKey()+": ");
			for(String st :map.getValue()) {
				System.out.print(st+" ");
			}
			System.out.println();
		}
		
		 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
