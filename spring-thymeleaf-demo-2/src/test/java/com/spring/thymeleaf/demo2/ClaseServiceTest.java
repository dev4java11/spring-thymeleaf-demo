package com.spring.thymeleaf.demo2;

import java.math.BigInteger;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.thymeleaf.demo2.domain.Clase;
import com.spring.thymeleaf.demo2.domain.Curso;
import com.spring.thymeleaf.demo2.domain.Persona;
import com.spring.thymeleaf.demo2.domain.Usuario;
import com.spring.thymeleaf.demo2.service.ClaseService;

public class ClaseServiceTest extends SpringThymeleafDemo2ApplicationTests {
	
	@Autowired
	private ClaseService claseService;

	@Test
	public void test1(){
		Clase filtro = new Clase();
		filtro.setIdCurso(BigInteger.ONE);
		filtro.setConsulta("CONSULTA_DEFAULT");
		filtro.setCurso(new Curso());
		filtro.getCurso().setNombre("ALGORITMICA 1");
		filtro.setEstado(1);
		filtro.setDocente(new Usuario());
		filtro.getDocente().setUsuario("ADMIN");
		filtro.getDocente().setPersona(new Persona());
		
		List<Clase> list = claseService.listar(filtro);
		System.out.println(list.size());
	}
}
