package content;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class china extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String filename= request.getParameter("filename");
		
		response.setContentType(this.getServletContext().getMimeType(filename));

		
		
		response.setHeader("Content-Disposition", "attachment;filename="+filename);
		
		
		String path = this.getServletContext().getRealPath("/folder1/"+filename);
		
		

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
