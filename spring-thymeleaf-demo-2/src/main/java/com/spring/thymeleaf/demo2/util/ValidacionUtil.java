package com.spring.thymeleaf.demo2.util;

public class ValidacionUtil {

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
}
