package com.spring.thymeleaf.demo2.domain;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Clase")
public class Clase extends Entidad {

	private BigInteger idClase;
	private String uuid;
	private Integer estado;
	private String idDocente;
	private BigInteger idCurso;
	private Date fechaApertura;
	private Date fechaCierre;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public BigInteger getIdClase() {
		return idClase;
	}
	public void setIdClase(BigInteger idClase) {
		this.idClase = idClase;
	}
	@Column(unique = true, updatable = false, nullable = false)
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	@Column(name = "docente", nullable = false)
	public String getIdDocente() {
		return idDocente;
	}
	public void setIdDocente(String idDocente) {
		this.idDocente = idDocente;
	}
	@Column(name = "idCurso", nullable = false)
	public BigInteger getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(BigInteger idCurso) {
		this.idCurso = idCurso;
	}
	public Date getFechaApertura() {
		return fechaApertura;
	}
	public void setFechaApertura(Date fechaApertura) {
		this.fechaApertura = fechaApertura;
	}
	public Date getFechaCierre() {
		return fechaCierre;
	}
	public void setFechaCierre(Date fechaCierre) {
		this.fechaCierre = fechaCierre;
	}
	
	private Usuario docente;
	
	@OneToOne
	@JoinColumn(name = "idDocente", referencedColumnName = "usuario", updatable = false, insertable = false, nullable = false)
	public Usuario getDocente() {
		return docente;
	}
	
	public void setDocente(Usuario docente) {
		this.docente = docente;
	}
	
	private Curso curso;
	
	@OneToOne
	@JoinColumn(name = "idCurso", insertable = false, updatable = false, nullable = false)
	public Curso getCurso() {
		return curso;
	}
	
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	private List<ClaseDetalle> detalles;
	
	@OneToMany
	@JoinColumn(name = "idClase", updatable = false, insertable = false)
	public List<ClaseDetalle> getDetalles() {
		return detalles;
	}
	
	public void setDetalles(List<ClaseDetalle> detalles) {
		this.detalles = detalles;
	}
}
