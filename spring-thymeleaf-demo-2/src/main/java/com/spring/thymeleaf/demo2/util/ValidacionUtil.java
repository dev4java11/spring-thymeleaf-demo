package com.spring.thymeleaf.demo2.util;

import java.util.Iterator;
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
	
	public static <T> boolean esVacio(Iterable<T> iterable){
		if(esNulo(iterable)){
			return true;
		}
		Iterator<T> iterator = iterable.iterator();
		boolean existe = !iterator.hasNext();
		return existe;
	}
	
	public static <T> boolean noEsVacio(Iterable<T> iterable){
		return !esVacio(iterable);
	}
	
	public static boolean esEmail(String value){
		return esVacio(value) ? false : PATRON_EMAIL.matcher(value).matches() ? true : false;
	}
	
	public static boolean noEsEmail(String value){
		return !esEmail(value);
	}
	
	public static int compararNumeros(Number number1, Number number2){
		if(esNulo(number1)){
			return Integer.MIN_VALUE;
		}else if(esNulo(number2)){
			return Integer.MAX_VALUE;
		}
		
		double dbl1 = number1.doubleValue();
		double dbl2 = number2.doubleValue();
		if(dbl1 > dbl2){
			return -1;
		}else if(dbl1 == dbl2){
			return 0;
		}else{
			return 1;
		}
	}
	
	public static boolean esMayorACero(Number number){
		return esNulo(number) ? false: number.doubleValue() > 0 ? true : false;
	}
	
	public static boolean esMayorIgualACero(Number number){
		return esNulo(number) ? false: number.doubleValue() >= 0 ? true : false;
	}
	
	public static boolean esMenorACero(Number number){
		return esNulo(number) ? false: number.doubleValue() < 0 ? true : false;
	}
	
	public static boolean esMenorIgualACero(Number number){
		return esNulo(number) ? false: number.doubleValue() <= 0 ? true : false;
	}
}
