package com.spring.thymeleaf.demo2.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.spring.thymeleaf.demo2.domain.Clase;
import com.spring.thymeleaf.demo2.domain.Entidad;
import com.spring.thymeleaf.demo2.domain.QClase;
import com.spring.thymeleaf.demo2.repository.ClaseRepository;
import com.spring.thymeleaf.demo2.service.ClaseService;
import com.spring.thymeleaf.demo2.util.AplicacionUtil;
import com.spring.thymeleaf.demo2.util.ValidacionUtil;

@Service
@Transactional(readOnly = true)
public class ClaseServiceImpl extends AbstractServiceImpl<Clase, QClase> implements ClaseService {
	
	private ClaseRepository claseRepository;
	
	@Autowired
	public void setClaseRepository(ClaseRepository claseRepository) {
		this.claseRepository = claseRepository;
	}

	@Override
	public Clase obtenerPorId(BigInteger id) {
		return claseRepository.findOne(id);
	}

	@Override
	public List<Clase> listar(Clase filtro) {
		Iterable<Clase> iterable = claseRepository.findAll(filtrar(filtro, QClase.clase));
		List<Clase> clases = IterableUtils.toList(iterable);
		return clases;
	}

	@Override
	public Page<Clase> listarPaginado(Clase filtro) {
		Page<Clase> page = claseRepository.findAll(filtrar(filtro, QClase.clase), filtro.getPageable());
		return page;
	}

	
	@Override
	public Predicate filtrar(Clase entidad, QClase query) {
		BooleanBuilder builder = getNewInstance();
		if(entidad.getConsulta().equalsIgnoreCase("CONSULTA_DEFAULT")){
			if(ValidacionUtil.esMayorIgualACero(entidad.getIdCurso())){
				builder.and(query.idCurso.eq(entidad.getIdCurso()));
			}
			if(ValidacionUtil.noEsVacio(entidad.getIdDocente())){
				builder.and(query.idDocente.eq(entidad.getIdDocente()));
			}
			if(ValidacionUtil.esMayorIgualACero(entidad.getEstado())){
				builder.and(query.estado.eq(entidad.getEstado()));
			}
			if(ValidacionUtil.noEsNulo(entidad.getCurso())){
				if(ValidacionUtil.noEsVacio(entidad.getCurso().getNombre())){
					builder.and(query.curso.nombre.containsIgnoreCase(entidad.getCurso().getNombre()));
				}
				if(ValidacionUtil.noEsVacio(entidad.getCurso().getDescripcion())){
					builder.and(query.curso.descripcion.containsIgnoreCase(entidad.getCurso().getDescripcion()));
				}
			}
			if(ValidacionUtil.noEsNulo(entidad.getDocente())){
				if(ValidacionUtil.noEsVacio(entidad.getDocente().getUsuario())){
					builder.and(query.docente.usuario.eq(entidad.getDocente().getUsuario()));
				}
				if(ValidacionUtil.noEsNulo(entidad.getDocente().getPersona())){
					if(ValidacionUtil.noEsVacio(entidad.getDocente().getPersona().getApPaterno())){
						
					}
				}
			}
		}
		return builder;
	}
}
