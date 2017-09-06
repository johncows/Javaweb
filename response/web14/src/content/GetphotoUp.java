package content;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class GetphotoUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 需求分析:由于浏览器会根据文件是否可以解析来判断文件是在浏览器上打开还是下载
		 * 1.这个类旨在将任何文件都只能下载 而不是打开
		 * 2.有一定的扩展性 根据get方法传入参数来下载文件
		 * 	 
		 */
		
		
		//获取文件的绝对路径
		String filename= request.getParameter("filename");
		
		//设置文件类型-----客服端通过文件的mime类型去区分类型 (规范开发需要去书写)
		response.setContentType(this.getServletContext().getMimeType(filename));

		
		//告诉客服端该文件不要解析,以附件模式打开
		response.setHeader("Content-Disposition", "attachment;filename="+filename);
		
		//通过web应用的相对地址来获得磁盘上的绝对路径
		String path = this.getServletContext().getRealPath("/folder1/"+filename);
		
		
		//读入
		ServletOutputStream out = response.getOutputStream();
		
		InputStream in = new FileInputStream(path);
		
		int len = 0;
		byte[] by = new byte[1024];
		while((len = in.read(by))>0) {
			out.write(by, 0, len);
		}
		
		in.close();
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
