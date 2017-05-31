package com.spring.thymeleaf.demo2.controller.sbadmin.configuracion;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.thymeleaf.demo2.domain.Usuario;
import com.spring.thymeleaf.demo2.service.PersonaService;
import com.spring.thymeleaf.demo2.service.UsuarioService;
import com.spring.thymeleaf.demo2.util.SeguridadUtil;
import com.spring.thymeleaf.demo2.util.ValidacionUtil;
import com.spring.thymeleaf.demo2.util.validation.UsuarioValidator;

@Controller
@RequestMapping("/sbadmin")
public class PerfilController {

	private UsuarioService usuarioService;
	
	private PersonaService personaService;
	
	private UsuarioValidator usuarioValidator;
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.addValidators(usuarioValidator);
	}
	
	@Autowired
	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@Autowired
	public void setPersonaService(PersonaService personaService) {
		this.personaService = personaService;
	}
	
	@Autowired
	public void setUsuarioValidator(UsuarioValidator usuarioValidator) {
		this.usuarioValidator = usuarioValidator;
	}
	
	@GetMapping("/perfil")
	public String perfil(Model model){
		Usuario usuario = usuarioService.obtenerPorId(SeguridadUtil.getUsername());
		if(ValidacionUtil.esNulo(usuario)){
			// LANZAR ERROR USUARIO NO EXISTE
		}
		model.addAttribute("usuario", usuario);
		return "sbadmin/configuracion/perfil";
	}
	
	
	@PostMapping("/perfil")
	public String guardarPerfil(@ModelAttribute("usuario") Usuario usuario, BindingResult result, Model model){
		usuarioValidator.validate(usuario, result);
		if(result.hasErrors()){
			model.addAttribute("usuario", usuario);
			return "sbadmin/configuracion/perfil";
		}
		
		model.addAttribute("usuario", usuario);
		return "sbadmin/configuracion/perfil";
	}
}
