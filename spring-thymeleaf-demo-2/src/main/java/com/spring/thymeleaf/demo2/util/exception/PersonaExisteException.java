package com.spring.thymeleaf.demo2.util.exception;

public class PersonaExisteException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private Integer idPersona;
	
	public PersonaExisteException(Integer idPersona){
		super();
		this.idPersona = idPersona;
	}
	
	public PersonaExisteException(Integer idPersona, String message){
		super(message);
		this.idPersona = idPersona;
	}
	
	public PersonaExisteException(Integer idPersona, String message, Throwable error){
		super(message, error);
		this.idPersona = idPersona;
	}
	
	public Integer getIdPersona() {
		return idPersona;
	}
	
	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}
}
