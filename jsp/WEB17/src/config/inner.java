package config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class inner
 */
public class inner extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inner() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		ServletContext servletContext = this.getServletContext();
		servletContext.setAttribute("age","5" );
		writer.write( servletContext.getAttribute("age").toString());
		
		writer.write(servletContext.getInitParameter("hobby")+"\n");      
		writer.write(servletContext.getContextPath());
		writer.write(servletContext.getRealPath("WEB17/inner")+"\n");
		
		writer.write("---------------------------------------------\n");
		ServletConfig servletConfig = this.getServletConfig();
		writer.write(servletConfig.getServletName()+"\n");
		writer.write(servletConfig.toString());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
