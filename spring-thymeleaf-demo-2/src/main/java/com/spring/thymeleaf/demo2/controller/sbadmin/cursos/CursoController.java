package com.spring.thymeleaf.demo2.controller.sbadmin.cursos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.thymeleaf.demo2.domain.Clase;
import com.spring.thymeleaf.demo2.service.ClaseService;

@Controller
@RequestMapping("/curso")
public class CursoController {
	
	private ClaseService claseService;
	
	@Autowired
	public void setClaseService(ClaseService claseService) {
		this.claseService = claseService;
	}
	
	@GetMapping("/")
	public String obtenerCursos(Model model, @PageableDefault Pageable pageable){
		Clase filtro = new Clase();
		filtro.setConsulta("CONSULTA_DEFAULT");
		filtro.setEstado(1);
		filtro.setPageable(pageable);
		
		Page<Clase> page = claseService.listarPaginado(filtro);
		model.addAttribute("page", page);
		
		return "sbadmin/curso/cursos";
	}

	@GetMapping("/filtro")
	public String obtenerCursos(Model model, @ModelAttribute(name = "filtro") Clase filtro, @PageableDefault Pageable pageable){
		filtro.setPageable(pageable);
		Page<Clase> page = claseService.listarPaginado(filtro);
		model.addAttribute("page", page);
		return "sbadmin/curso/cursos";
	}
	
	@GetMapping("/alumno")
	@PreAuthorize("isAuthenticated()")
	public String obtenerMisCursos(Authentication authentication){
		return "sbadmin/curso/cursos";
	}
}
