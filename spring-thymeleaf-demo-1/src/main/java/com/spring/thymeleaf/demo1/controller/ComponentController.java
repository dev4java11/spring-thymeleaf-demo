package com.spring.thymeleaf.demo1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ComponentController {

	@GetMapping(value = {"/components"})
	public String components(){
		return "demo/components";
	}	
}
