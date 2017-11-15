package com.kk.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * Servlet Filter implementation class UpRequestFilter
 */
public class UpRequestFilter implements Filter {

    /**
     * Default constructor. 
     */
    public UpRequestFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		ExhanceRequest requ = new ExhanceRequest(req);
		response.setContentType("text/html;charset=UTF-8");
		chain.doFilter(requ, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	
	class ExhanceRequest extends HttpServletRequestWrapper{

		private HttpServletRequest request;

		public ExhanceRequest(HttpServletRequest request) {
			super(request);
			this.request = request;
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public String getParameter(String name) {
			String name1 = request.getParameter("name");
			try {
				 name1 = new String(name1.getBytes("iso8859-1"), "utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return name1;
		}
		
	}
}
