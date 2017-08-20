package com.spring.thymeleaf.demo2.domain;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

public class Entidad {

	private Pageable pageable;
	
	private String consulta;
	
	public Pageable buildPageable(int page, int pageSize){
		Pageable pageable = buildPageable(page, pageSize, null);
		return pageable;
	}
	
	public Pageable buildPageable(int page, int pageSize, Sort sort){
		pageable = new PageRequest(page, pageSize, sort);
		return pageable;
	}
	
	public Pageable buildPageable(int page, int pageSize, Direction direction, String ... properties){
		pageable = new PageRequest(page, pageSize, direction, properties);
		return pageable;
	}
	
	public Pageable getPageable() {
		return pageable;
	}
	
	public void setPageable(Pageable pageable) {
		this.pageable = pageable;
	}
	
	public String getConsulta() {
		return consulta;
	}
	
	public void setConsulta(String consulta) {
		this.consulta = consulta;
	}
}
