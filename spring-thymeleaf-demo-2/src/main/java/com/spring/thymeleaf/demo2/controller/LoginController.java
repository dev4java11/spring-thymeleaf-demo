package com.spring.thymeleaf.demo2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.thymeleaf.demo2.domain.Persona;
import com.spring.thymeleaf.demo2.domain.Usuario;
import com.spring.thymeleaf.demo2.service.PersonaService;
import com.spring.thymeleaf.demo2.service.UsuarioService;
import com.spring.thymeleaf.demo2.util.Constantes;
import com.spring.thymeleaf.demo2.util.MensajeUtil;
import com.spring.thymeleaf.demo2.util.exception.UsuarioExisteException;
import com.spring.thymeleaf.demo2.util.validation.UsuarioValidator;

@Controller
@RequestMapping("/")
public class LoginController {
	
	private UsuarioService usuarioService;
	
	private PersonaService PersonaService;
	
	private UsuarioValidator usuarioValidator;
	
	@Autowired
	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@Autowired
	public void setPersonaService(PersonaService personaService) {
		PersonaService = personaService;
	}
	
	@Autowired
	public void setUsuarioValidator(UsuarioValidator usuarioValidator) {
		this.usuarioValidator = usuarioValidator;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.addValidators(usuarioValidator);
	}

	@GetMapping(value = {"", "login"})
	public String login(){
		return "login";
	}
	
	@GetMapping("register")
	public String register(Model model){
		Usuario usuario = new Usuario();
		Persona persona = new Persona();
		usuario.setPersona(persona);
		
		model.addAttribute("usuario", usuario);
		return "register";
	}
	
	@PostMapping("register")
	public String register(@ModelAttribute("usuario") Usuario usuario, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes){
		usuarioValidator.validate(usuario, bindingResult);
		if(bindingResult.hasErrors()){
			model.addAttribute("usuario", usuario);
			return "register";
		}
		
		usuario = usuarioService.crearUsuario(usuario);
		redirectAttributes.addAttribute("idUsuario", usuario.getUsuario());
		redirectAttributes.addFlashAttribute("mensajeRegistro", MensajeUtil.getMensaje("mensaje.crear.usuario.correcto"));
		return "redirect:login";
	}
	
	@ExceptionHandler(value = {UsuarioExisteException.class})
	public ModelAndView errorRegistrarUsuario(UsuarioExisteException exception){
		ModelAndView mav = new ModelAndView();
		String mensaje = MensajeUtil.getMensaje("mensaje.crear.usuario.error.existente", exception.getUsuario().getUsuario());
		mav.addObject(Constantes.MENSAJE_ERROR_NAME, mensaje);
		mav.addObject("usuario", exception.getUsuario());
		mav.setViewName("register");
		return mav;
	}

	@ExceptionHandler(value = {Exception.class})
	public ModelAndView errorRegistrarGenerico(Exception exception){
		ModelAndView mav = new ModelAndView();
		String mensaje = MensajeUtil.getMensaje("mensaje.crear.usuario.error");
		mav.addObject(Constantes.MENSAJE_ERROR_NAME, mensaje);
		mav.setViewName("register");
		return mav;
	}
}
