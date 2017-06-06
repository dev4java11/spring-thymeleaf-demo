package com.spring.thymeleaf.demo2.util;

import java.util.regex.Pattern;

public class ValidacionUtil {
	
	private static final String EMAIL_PATTERN = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
	
	private static final Pattern PATRON_EMAIL =  Pattern.compile(EMAIL_PATTERN);
	

	public static boolean esNulo(Object obj){
		return obj == null ? true : false;
	}
	
	public static boolean noEsNulo(Object obj){
		return !esNulo(obj);
	}
	
	public static boolean esVacio(String value){
		return value == null || value.trim().isEmpty() ? true : false;
	}
	
	public static boolean noEsVacio(String value){
		return !esVacio(value);
	}
	
	public static boolean esEmail(String value){
		return esVacio(value) ? false : PATRON_EMAIL.matcher(value).matches() ? true : false;
	}
	
	public static boolean noEsEmail(String value){
		return !esEmail(value);
	}
}
