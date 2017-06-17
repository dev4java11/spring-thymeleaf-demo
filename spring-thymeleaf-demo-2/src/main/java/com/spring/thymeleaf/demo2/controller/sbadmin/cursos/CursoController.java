package com.spring.thymeleaf.demo2.controller.sbadmin.cursos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cursos")
public class CursoController {

	@GetMapping("/")
	public String obtenerCursos(){
		return "cursos/cursos";
	}
}
