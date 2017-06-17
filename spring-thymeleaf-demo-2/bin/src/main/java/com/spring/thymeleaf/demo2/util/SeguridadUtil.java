package com.spring.thymeleaf.demo2.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SeguridadUtil {

	public static Authentication getAuthentication(){
		return SecurityContextHolder.getContext().getAuthentication();
	}
	
	public static String getUsername(){
		Authentication auth = getAuthentication();
		return auth == null ? "": auth.getName();
	}
}
