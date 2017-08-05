package com.spring.thymeleaf.demo2.util.exception;

public class UsuarioExisteException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String idUsuario;
	
	public UsuarioExisteException(String idUsuario){
		super();
		this.idUsuario = idUsuario;
	}
	
	public UsuarioExisteException(String idUsuario, String message){
		super(message);
		this.idUsuario = idUsuario;
	}

	public UsuarioExisteException(String idUsuario, String message, Throwable error) {
		super(message, error);
		this.idUsuario = idUsuario;
	}
	
	public String getIdUsuario() {
		return idUsuario;
	}
	
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
}
