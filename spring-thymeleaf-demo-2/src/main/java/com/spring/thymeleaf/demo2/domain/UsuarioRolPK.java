package com.spring.thymeleaf.demo2.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
public class UsuarioRolPK implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String usuario;
	private String rol;
	
	public UsuarioRolPK() {
		// TODO Auto-generated constructor stub
	}
	
	public UsuarioRolPK(String usuario, String rol){
		this.usuario = usuario;
		this.rol = rol;
	}
	
	@Id
	@Column(name = "usuario", length = 20)
	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	@Id
	@Column(name = "rol", length = 30)
	public String getRol() {
		return rol;
	}
	
	public void setRol(String rol) {
		this.rol = rol;
	}
}
