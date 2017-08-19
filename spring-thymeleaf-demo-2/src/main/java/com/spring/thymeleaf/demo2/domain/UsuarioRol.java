package com.spring.thymeleaf.demo2.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "UsuarioRol")
public class UsuarioRol extends Entidad {

	@EmbeddedId
	private UsuarioRolPK id;
	private Date fechaAsignacion;
	private String uuid;
	
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

	@NotNull
	public String getUuid() {
		return uuid;
	}
	
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	@OneToOne
	@JoinColumn(name = "rol", insertable = false, updatable = false, nullable = false)
	private Rol rol;
	
	public Rol getRol() {
		return rol;
	}
	
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
}
