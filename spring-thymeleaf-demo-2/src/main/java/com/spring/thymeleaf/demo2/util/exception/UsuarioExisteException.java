package com.spring.thymeleaf.demo2.util.exception;

import com.spring.thymeleaf.demo2.domain.Usuario;

public class UsuarioExisteException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	
	public UsuarioExisteException(Usuario usuario){
		super();
		this.usuario = usuario;
	}
	
	public UsuarioExisteException(Usuario usuario, String message){
		super(message);
		this.usuario = usuario;
	}

	public UsuarioExisteException(Usuario usuario, String message, Throwable error) {
		super(message, error);
		this.usuario = usuario;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
