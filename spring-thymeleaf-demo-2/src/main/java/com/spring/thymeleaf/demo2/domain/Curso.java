package com.spring.thymeleaf.demo2.domain;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Curso")
public class Curso extends Entidad {

	private BigInteger idCurso;
	private String nombre;
	private String descripcion;
	private String uuid;
	private String urlImagen;
	private String moneda;
	private BigDecimal precio;
	
	public Curso() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public BigInteger getIdCurso() {
		return idCurso;
	}
	
	public void setIdCurso(BigInteger idCurso) {
		this.idCurso = idCurso;
	}
	
	@NotEmpty
	@Column(name = "nombre", length = 100)
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Column(name = "descripcion", length = 600)
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@NotEmpty
	@Column(name = "uuid", length = 255, unique = true, insertable = true, updatable = false)
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	@NotEmpty
	@Column(name = "urlImagen", length = 1000)
	public String getUrlImagen() {
		return urlImagen;
	}
	
	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}
	
	@NotEmpty
	@Column(name = "moneda", length = 20)
	public String getMoneda() {
		return moneda;
	}
	
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	
	@Column(name = "precio")
	@NotNull
	public BigDecimal getPrecio() {
		return precio;
	}
	
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
}
