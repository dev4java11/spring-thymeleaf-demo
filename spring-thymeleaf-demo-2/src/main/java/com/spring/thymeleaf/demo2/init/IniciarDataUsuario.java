package com.spring.thymeleaf.demo2.init;

import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.spring.thymeleaf.demo2.domain.Persona;
import com.spring.thymeleaf.demo2.domain.Usuario;
import com.spring.thymeleaf.demo2.repository.PersonaRepository;
import com.spring.thymeleaf.demo2.repository.UsuarioRepository;

@Component
public class IniciarDataUsuario implements CommandLineRunner {
	
	private PasswordEncoder encoder;
	
	private UsuarioRepository repository;
	
	private PersonaRepository personaRepository;
	
	
	@Autowired
	public void setEncoder(PasswordEncoder encoder) {
		this.encoder = encoder;
	}
	
	@Autowired
	public void setRepository(UsuarioRepository repository) {
		this.repository = repository;
	}
	
	@Autowired
	public void setPersonaRepository(PersonaRepository personaRepository) {
		this.personaRepository = personaRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		Persona persona1 = new Persona();
		persona1.setNombre("Nilo Hernán");
		persona1.setApPaterno("Rosas");
		persona1.setApMaterno("Nutz");
		persona1.setGenero("M");
		persona1.setUuid(UUID.randomUUID().toString());
		persona1.setFechaNacimiento(new DateTime(1991, 3, 14, 0, 0).toDate());
		persona1.setDocumento("72617278");
		persona1.setEmail("hrosasnutz.1991@gmail.com");
		
		persona1 = personaRepository.save(persona1);
		
		
		Usuario admin = new Usuario();
		admin.setUsuario("admin");
		admin.setClave(encoder.encode("1"));
		admin.setEstado(1);
		admin.setUuid(UUID.randomUUID().toString());
		admin.setIdPersona(persona1.getIdPersona());
//		
//		Usuario usuario1 = new Usuario();
//		usuario1.setUsuario("usuario1");
//		usuario1.setClave(encoder.encode("1"));
//		usuario1.setEstado(1);
//		usuario1.setIdPersona(1);
//		
//		Usuario usuario2 = new Usuario();
//		usuario2.setUsuario("usuario2");
//		usuario2.setClave(encoder.encode("1"));
//		usuario2.setEstado(1);
//		usuario2.setIdPersona(2);
//		
//		Usuario usuario3 = new Usuario();
//		usuario3.setUsuario("usuario3");
//		usuario3.setClave(encoder.encode("1"));
//		usuario3.setEstado(1);
//		usuario3.setIdPersona(3);
//		
//		Usuario usuario4 = new Usuario();
//		usuario4.setUsuario("usuario4");
//		usuario4.setClave(encoder.encode("1"));
//		usuario4.setEstado(0);
//		usuario4.setIdPersona(4);
		
		
		repository.save(admin);
//		repository.save(usuario1);
//		repository.save(usuario2);
//		repository.save(usuario3);
//		repository.save(usuario4);
	}

}
