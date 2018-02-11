package com.spring.thymeleaf.demo2.service.impl;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.spring.thymeleaf.demo2.domain.Entidad;

public abstract class AbstractServiceImpl <E extends Entidad, Q extends EntityPathBase<E>>{
	
	public abstract Predicate filtrar(E entidad, Q query);
	
	public BooleanBuilder getNewInstance(){
		return new BooleanBuilder();
	}
}
