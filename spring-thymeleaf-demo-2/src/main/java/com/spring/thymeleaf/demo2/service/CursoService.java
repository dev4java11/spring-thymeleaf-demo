package com.spring.thymeleaf.demo2.service;

import org.springframework.data.domain.Page;

import com.spring.thymeleaf.demo2.domain.Curso;

public interface CursoService {

	public Curso obtenerPorId(Long id);
	
	public Page<Curso> buscarPaginado(Curso filtro);
}
