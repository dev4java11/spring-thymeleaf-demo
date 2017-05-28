package com.spring.thymeleaf.demo2.util.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.spring.thymeleaf.demo2.domain.Usuario;
import com.spring.thymeleaf.demo2.util.ValidacionUtil;

public class UsuarioValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Usuario.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(ValidacionUtil.esNulo(target)){
//			errors.reje
		}
	}

}
