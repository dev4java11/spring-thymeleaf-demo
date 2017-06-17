package com.spring.thymeleaf.demo2.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Persona")
public class Persona extends Entidad{

	private Integer idPersona;
	private String uuid;
	private String nombre;
	private String apPaterno;
	private String apMaterno;
	private String genero;
	private Date fechaNacimiento;
	private String documento;
	private String email;
	private String cuentaFacebook;
	private String cuentaTwitter;
	private String cuentaGooglePlus;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}
	
	@Column(unique = true, nullable = false)
	@Size(max = 60)
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	@NotEmpty
	@Size(max = 80)
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@NotEmpty
	@Size(max = 80)
	public String getApPaterno() {
		return apPaterno;
	}
	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}
	
	@NotEmpty
	@Size(max = 80)
	public String getApMaterno() {
		return apMaterno;
	}
	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}
	
	@NotEmpty
	@Size(max = 1)
	public String getGenero() {
		return genero;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	@Size(max = 30)
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	
	@NotEmpty
	@Email
	@Size(max = 100)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Size(max = 100)
	public String getCuentaFacebook() {
		return cuentaFacebook;
	}
	public void setCuentaFacebook(String cuentaFacebook) {
		this.cuentaFacebook = cuentaFacebook;
	}
	
	@Size(max = 100)
	public String getCuentaTwitter() {
		return cuentaTwitter;
	}
	public void setCuentaTwitter(String cuentaTwitter) {
		this.cuentaTwitter = cuentaTwitter;
	}
	
	@Size(max = 100)
	public String getCuentaGooglePlus() {
		return cuentaGooglePlus;
	}
	public void setCuentaGooglePlus(String cuentaGooglePlus) {
		this.cuentaGooglePlus = cuentaGooglePlus;
	}
	
	
}
