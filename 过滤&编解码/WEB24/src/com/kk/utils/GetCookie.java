package com.kk.utils;

import javax.servlet.http.Cookie;

public class GetCookie {
	public static String getCookie(Cookie[] cookies,String name) {		
		String value = null;
		for(Cookie cook :cookies) {
			if(cook.getName().equals(name)) {
				value = cook.getValue();
			}
		}
		return value;
	}
}
