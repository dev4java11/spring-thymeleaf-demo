package com.spring.thymeleaf.demo2.domain;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

public class Entidad {

	public Pageable pageable;
	
	public void buildPageable(int page, int pageSize){
		buildPageable(page, pageSize, null);
	}
	
	public void buildPageable(int page, int pageSize, Sort sort){
		pageable = new PageRequest(page, pageSize, sort);
	}
	
	public void buildPageable(int page, int pageSize, Direction direction, String ... properties){
		pageable = new PageRequest(page, pageSize, direction, properties);
	}
}
