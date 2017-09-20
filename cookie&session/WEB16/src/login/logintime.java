package login;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.security.auth.message.callback.SecretKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class logintime
 */
public class logintime extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logintime() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");  
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss");
		String currenttime = format.format(date);
		
		
		
		System.out.println(currenttime);
		Cookie cook = new Cookie("lasttime",currenttime);
		cook.setMaxAge(60*10);
		response.addCookie(cook);
		
		String time = getcookie(request);
		if(time!=null) {
			response.getWriter().write("上一次登陆的时间为 "+time);
		}
		else {
			response.getWriter().write("第一次登陆吧 现在时间 "+ currenttime);
		}
	}
	
		
		
		
		
		
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	
	public String getcookie(HttpServletRequest request) {
			Cookie[] cookies = request.getCookies();
			String time = null ;
			if(cookies!=null) {
				for(Cookie cook : cookies) {
					if(cook.getName().equals("lasttime")) {
						time = cook.getValue();
					}
				}
			}
			return time;
	}
}
