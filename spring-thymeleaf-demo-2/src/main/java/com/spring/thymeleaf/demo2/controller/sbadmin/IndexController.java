package com.spring.thymeleaf.demo2.controller.sbadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sbadmin")
public class IndexController {

	@GetMapping("/index")
	public String index(){
		return "sbadmin/index";
	}
}
