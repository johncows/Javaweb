package com.kk.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyRequestListener implements ServletRequestListener{

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		System.out.println("now the request is destory!");
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
	
		System.out.println("now the request create a item !");
		/**
		 * 	System.out.println( sre.getServletRequest().getAttribute("request"));
			该句无法取出里面存在的域值
		 */
		}

}
