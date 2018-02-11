package com.spring.thymeleaf.demo2.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.domain.Page;

import com.spring.thymeleaf.demo2.domain.Clase;

public interface ClaseService {

	public Clase obtenerPorId(BigInteger id);
	
	public List<Clase> listar(Clase filtro);
	
	public Page<Clase> listarPaginado(Clase filtro);
}
