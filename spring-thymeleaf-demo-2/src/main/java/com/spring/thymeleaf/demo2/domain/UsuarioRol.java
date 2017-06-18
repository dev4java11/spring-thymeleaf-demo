package com.spring.thymeleaf.demo2.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "UsuarioRol")
public class UsuarioRol extends Entidad {

	@EmbeddedId
	private UsuarioRolPK id;
	private Date fechaAsignacion;
	
//	private Usuario usuarioEntidad;
//	private Rol rolEntidad;
	
	public UsuarioRol() {
		id = new UsuarioRolPK();
	}
	
	public UsuarioRolPK getId() {
		return id;
	}
	
	public void setId(UsuarioRolPK id) {
		this.id = id;
	}
	
	@Column(name = "fechaAsignacion", nullable = false)
	public Date getFechaAsignacion() {
		return fechaAsignacion;
	}
	
	public void setFechaAsignacion(Date fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}
	
//	@ManyToOne
//	@JoinColumn(name = "usuario", referencedColumnName = "usuario", nullable = false, insertable = false, updatable = false)
//	public Usuario getUsuarioEntidad() {
//		return usuarioEntidad;
//	}
//	
//	public void setUsuarioEntidad(Usuario usuarioEntidad) {
//		this.usuarioEntidad = usuarioEntidad;
//	}
	
//	@OneToOne
//	@JoinColumn(name = "rol", referencedColumnName = "rol", nullable = false, insertable = false, updatable = false)
//	public Rol getRol() {
//		return rol;
//	}
//	
//	public void setRol(Rol rol) {
//		this.rol = rol;
//	}
}
