package content;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class GetPhoto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获得response的字节输入流
		ServletOutputStream out =response.getOutputStream();
		
		//获得web资源下的某个资源的绝对地址
		String realpath = this.getServletContext().getRealPath("a.jpg");
		
		//获得服务器上的资源的字节码文件
		InputStream in = new FileInputStream(realpath);
		
		//缓冲区写入文件通式
		int len = 0;
		byte[] buffer = new byte[1024];
		while((len=in.read(buffer))>0) {
			out.write(buffer,0,len);
		}
		
		in.close();  //实际开发中一般是不写 out.close() 因为 out流不是new出来的，tomcat服务器会自动检测 并关闭
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
