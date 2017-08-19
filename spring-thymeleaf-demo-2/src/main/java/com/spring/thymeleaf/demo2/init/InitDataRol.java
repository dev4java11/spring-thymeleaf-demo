package com.spring.thymeleaf.demo2.init;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.spring.thymeleaf.demo2.domain.Rol;
import com.spring.thymeleaf.demo2.repository.RolRepository;
import com.spring.thymeleaf.demo2.util.Constantes;

@Component
@Order(1)
public class InitDataRol implements CommandLineRunner {
	
	private RolRepository rolRepository;
	
	@Autowired
	public void setRolRepository(RolRepository rolRepository) {
		this.rolRepository = rolRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		Rol rol1 = new Rol();
		rol1.setRol(Constantes.ROL_ADMINISTRADOR);
		rol1.setNombre("Administrador");
		rol1.setDescripcion("Administrador de la plataforma");
		rol1.setUuid(UUID.randomUUID().toString());
		
		
		Rol rol2 = new Rol();
		rol2.setRol(Constantes.ROL_ESTUDIANTE);
		rol2.setNombre("Estudiante");
		rol2.setDescripcion("Estudiante de la plataforma");
		rol2.setUuid(UUID.randomUUID().toString());
		
		Rol rol3 = new Rol();
		rol3.setRol(Constantes.ROL_DOCENTE);
		rol3.setNombre("Docente");
		rol3.setDescripcion("Docente de la plataforma");
		rol3.setUuid(UUID.randomUUID().toString());
		
		
		rolRepository.save(rol1);
		rolRepository.save(rol2);
		rolRepository.save(rol3);
	}

}
