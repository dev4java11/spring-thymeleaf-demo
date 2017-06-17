package com.spring.thymeleaf.demo2.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Usuario")
public class Usuario extends Entidad {

	private String usuario;
	private String clave;
	private String uuid;
	private Integer estado;
	private Integer idPersona;
	
	private Persona persona;
	
	public Usuario() {
		
	}
	
	@Id
	@Column(name = "usuario", length = 20)
	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	@Column(name = "clave", length = 80)
	@NotEmpty
	public String getClave() {
		return clave;
	}
	
	public void setClave(String clave) {
		this.clave = clave;
	}
	
	@Column(unique = true, nullable = false)
	@Size(max = 60)
	public String getUuid() {
		return uuid;
	}
	
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	@Column(name  = "estado")
	public Integer getEstado() {
		return estado;
	}
	
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	
	@Column(name = "idPersona")
	public Integer getIdPersona() {
		return idPersona;
	}
	
	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}
	
	@OneToOne
	@JoinColumn(name = "idPersona", referencedColumnName = "idPersona", nullable = true, insertable = false, updatable = false)
	public Persona getPersona() {
		return persona;
	}
	
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
}
