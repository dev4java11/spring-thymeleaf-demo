package com.spring.thymeleaf.demo2.util.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.spring.thymeleaf.demo2.domain.Usuario;
import com.spring.thymeleaf.demo2.util.ValidacionUtil;

@Component
public class UsuarioValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Usuario.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Usuario usuario = (Usuario) target;
		if(ValidacionUtil.esNulo(usuario)){
			errors.reject("perfil.validacion.usuario.nulo");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "usuario", "mensaje.validacion.usuario.usuario.vacio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "clave", "mensaje.validacion.usuario.clave.vacio");
		if(ValidacionUtil.esNulo(usuario.getPersona())){
			errors.reject("mensaje.validacion.usuario.persona.nulo");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "persona.nombre", "mensaje.validacion.usuario.persona.nombre.vacio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "persona.apPaterno", "mensaje.validacion.usuario.persona.apellido.paterno.vacio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "persona.apMaterno", "mensaje.validacion.usuario.persona.apellido.materno.vacio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "persona.genero", "mensaje.validacion.usuario.persona.genero.vacio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "persona.fechaNacimiento", "mensaje.validacion.usuario.persona.fechaNacimiento.vacio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "persona.documento", "mensaje.validacion.usuario.persona.documento.vacio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "persona.email", "mensaje.validacion.usuario.persona.email.vacio");
		if(ValidacionUtil.noEsEmail(usuario.getPersona().getEmail())){
			errors.rejectValue("persona.email", "mensaje.validacion.usuario.persona.email.vacio");
		}
		
//		ValidationUtils.rejectIfEmpty(errors, "persona.cuentaFacebook", "mensaje.validacion.usuario.persona.cuenta.facebook");
//		ValidationUtils.rejectIfEmpty(errors, "persona.cuentaTwitter", "mensaje.validacion.usuario.persona.cuenta.twitter");
//		ValidationUtils.rejectIfEmpty(errors, "persona.cuentaGooglePlus", "mensaje.validacion.usuario.persona.cuenta.googleplus");

	}

}
