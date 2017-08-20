package com.spring.thymeleaf.demo2;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.thymeleaf.demo2.domain.QUsuarioRol;
import com.spring.thymeleaf.demo2.domain.UsuarioRol;
import com.spring.thymeleaf.demo2.repository.UsuarioRolRepository;
import com.spring.thymeleaf.demo2.util.ValidacionUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringThymeleafDemo2ApplicationTests {
	
	@Autowired
	private UsuarioRolRepository repository;
	
	@Before
	public void before(){
		System.out.println("===============================================================================");
	}
	
	@After
	public void after(){
		System.out.println("===============================================================================");
	}

	@Test
	@Ignore
	public void contextLoads() {
		Iterable<UsuarioRol> it = repository.findAll(QUsuarioRol.usuarioRol.id.usuario.eq("admin"));
		if(ValidacionUtil.noEsVacio(it)){
			for(UsuarioRol rol : it){
				System.out.println(rol.getUuid()+" - "+rol.getRol().getRol());
			}
		}
	}

}
