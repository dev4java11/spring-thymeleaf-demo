package com.spring.thymeleaf.demo1.initializer;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

@Component
public class JsonpAdvice extends AbstractJsonpResponseBodyAdvice {

	public JsonpAdvice() {
		super("callback");
	}
}
