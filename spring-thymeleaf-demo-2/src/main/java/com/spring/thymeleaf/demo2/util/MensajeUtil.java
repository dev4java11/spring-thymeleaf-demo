package com.spring.thymeleaf.demo2.util;

import java.util.Locale;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class MensajeUtil {

	private static MensajeUtil instance;
	
	private MessageSource messageSource;
	
	@Autowired
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	@PostConstruct
	public void init(){
		instance = this;
	}
	
	public static String getMensaje(String keyMessage){
		return getMensaje(keyMessage, "", null);
	}
	
	public static String getMensaje(String keyMessage, Locale locale){
		return getMensaje(keyMessage, "", null);
	}
	
	public static String getMensaje(String keyMessage, Object ... values){
		return getMensaje(keyMessage, "", null, values);
	}
	
	public static String getMensaje(String keyMessage, Locale locale, Object ... values){
		return getMensaje(keyMessage, "", locale, values);
	}
	
	public static String getMensaje(String keyMessage, String defaultMessage, Locale locale, Object ... values){
		return instance.messageSource.getMessage(keyMessage, values, defaultMessage, locale);
	}
}
