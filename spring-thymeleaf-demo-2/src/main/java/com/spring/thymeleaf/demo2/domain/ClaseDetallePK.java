package com.spring.thymeleaf.demo2.domain;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Embeddable
public class ClaseDetallePK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private BigInteger idClaseDetalle;
	private BigInteger idClase;
	
	public ClaseDetallePK() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public BigInteger getIdClaseDetalle() {
		return idClaseDetalle;
	}
	public void setIdClaseDetalle(BigInteger idClaseDetalle) {
		this.idClaseDetalle = idClaseDetalle;
	}
	
	@Id
	public BigInteger getIdClase() {
		return idClase;
	}
	public void setIdClase(BigInteger idClase) {
		this.idClase = idClase;
	}
}
