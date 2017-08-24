package com.spring.thymeleaf.demo2.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.UUID;

import org.joda.time.DateTime;

public class AplicacionUtil {

	public static String newUUID(){
		return UUID.randomUUID().toString();
	}
	
	public static String newUUID(String name){
		return UUID.fromString(name).toString();
	}
	
	public static Date getDateNow(){
		return DateTime.now().toDate();
	}
	
	public static <T> ArrayList<T> newArrayList(){
		return new ArrayList<T>();
	}
	
	public static <T> LinkedHashSet<T> newLinkedHashSet(){
		return new LinkedHashSet<T>();
	}
	
	public static <T> HashSet<T> newHashSet(){
		return new HashSet<T>();
	}
	
	public static <K, V> LinkedHashMap<K, V> newLinkedHashMap(){
		return new LinkedHashMap<K, V>();
	}
	
	public static <K, V> HashMap<K, V> newHashMap(){
		return new HashMap<K, V>();
	}
}
