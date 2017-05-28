package com.spring.thymeleaf.demo2.controller.sbadmin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/sbadmin")
public class IndexController {

	@GetMapping("/index")
	public String index(@RequestParam(name = "notify", defaultValue = "false", required = false)String notify , Model model){
		model.addAttribute("notify", notify);
		return "sbadmin/index";
	}
}
