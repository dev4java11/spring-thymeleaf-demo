package com.spring.thymeleaf.demo2.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.spring.thymeleaf.demo2.domain.Usuario;
import com.spring.thymeleaf.demo2.repository.UsuarioRepository;

@Component
public class IniciarDataUsuario implements CommandLineRunner {
	
	private PasswordEncoder encoder;
	
	private UsuarioRepository repository;
	
	
	@Autowired
	public void setEncoder(PasswordEncoder encoder) {
		this.encoder = encoder;
	}
	
	@Autowired
	public void setRepository(UsuarioRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run(String... args) throws Exception {
		Usuario admin = new Usuario();
		admin.setUsuario("admin");
		admin.setClave(encoder.encode("1"));
		admin.setEstado(1);
		admin.setIdPersona(0);
		
		Usuario usuario1 = new Usuario();
		usuario1.setUsuario("usuario1");
		usuario1.setClave(encoder.encode("1"));
		usuario1.setEstado(1);
		usuario1.setIdPersona(1);
		
		Usuario usuario2 = new Usuario();
		usuario2.setUsuario("usuario2");
		usuario2.setClave(encoder.encode("1"));
		usuario2.setEstado(1);
		usuario2.setIdPersona(2);
		
		Usuario usuario3 = new Usuario();
		usuario3.setUsuario("usuario3");
		usuario3.setClave(encoder.encode("1"));
		usuario3.setEstado(1);
		usuario3.setIdPersona(3);
		
		Usuario usuario4 = new Usuario();
		usuario4.setUsuario("usuario4");
		usuario4.setClave(encoder.encode("1"));
		usuario4.setEstado(0);
		usuario4.setIdPersona(4);
		
		
		repository.save(admin);
		repository.save(usuario1);
		repository.save(usuario2);
		repository.save(usuario3);
		repository.save(usuario4);
	}

}
