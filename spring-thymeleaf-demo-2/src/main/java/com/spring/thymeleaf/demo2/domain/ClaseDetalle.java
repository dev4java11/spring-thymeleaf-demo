package com.spring.thymeleaf.demo2.domain;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ClaseDetalle")
public class ClaseDetalle extends Entidad {

	@EmbeddedId
	private ClaseDetallePK id;
	private String uuid;
	private String idAlumno;
	private Date fechaInscripcion;
	
	@Column(updatable = false, nullable = false, unique = true)
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getIdAlumno() {
		return idAlumno;
	}
	public void setIdAlumno(String idAlumno) {
		this.idAlumno = idAlumno;
	}
	@Temporal(TemporalType.TIMESTAMP)
	public Date getFechaInscripcion() {
		return fechaInscripcion;
	}
	public void setFechaInscripcion(Date fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}
	
	@OneToOne
	@JoinColumn(name = "idClase", insertable = false, updatable = false)
	private Clase clase;
	
	public Clase getClase() {
		return clase;
	}
	
	public void setClase(Clase clase) {
		this.clase = clase;
	}
	
	@OneToOne
	@JoinColumn(name = "idAlumno", referencedColumnName = "usuario", insertable = false, updatable = false)
	private Usuario alumno;
	
	public Usuario getAlumno() {
		return alumno;
	}
	
	public void setAlumno(Usuario alumno) {
		this.alumno = alumno;
	}
}
