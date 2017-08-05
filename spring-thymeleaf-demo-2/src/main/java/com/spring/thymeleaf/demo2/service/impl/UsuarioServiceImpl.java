package com.spring.thymeleaf.demo2.service.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.thymeleaf.demo2.domain.Persona;
import com.spring.thymeleaf.demo2.domain.Usuario;
import com.spring.thymeleaf.demo2.repository.PersonaRepository;
import com.spring.thymeleaf.demo2.repository.UsuarioRepository;
import com.spring.thymeleaf.demo2.service.UsuarioService;
import com.spring.thymeleaf.demo2.util.exception.UsuarioExisteException;

@Service
@Transactional(readOnly = true)
public class UsuarioServiceImpl implements UsuarioService {
	
	private UsuarioRepository usuarioRepository;
	
	private PersonaRepository personaRepository;
	
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	@Autowired
	public void setPersonaRepository(PersonaRepository personaRepository) {
		this.personaRepository = personaRepository;
	}
	
	@Autowired(required = false)
	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	
	@PostConstruct
	public void init(){
		passwordEncoder = passwordEncoder == null ? NoOpPasswordEncoder.getInstance(): passwordEncoder; 
	}

	@Override
	public Usuario obtenerPorId(String idUsuario) {
		return usuarioRepository.findOne(idUsuario);
	}
	
	@Transactional(readOnly = false)
	@Override
	public Usuario crearUsuario(Usuario usuario) {
		Usuario usuarioDB = usuarioRepository.findOne(usuario.getUsuario());
		if(usuarioDB != null){
			throw new UsuarioExisteException(usuario.getUsuario());
		}
		
		Persona persona = usuario.getPersona();
		persona = personaRepository.save(persona);
		
		String claveEncriptada = passwordEncoder.encode(usuario.getClave());
		usuario.setClave(claveEncriptada);
		
		usuario = usuarioRepository.save(usuario);
		
		return usuario;
	}

	@Transactional(readOnly = false)
	@Override
	public Usuario actualizarUsuario(Usuario usuario) {
		Persona persona = usuario.getPersona();
		persona = personaRepository.save(persona);
		
		Usuario usuarioDB = usuarioRepository.findOne(usuario.getUsuario());
		if(usuarioDB == null){
			throw new NullPointerException("Usuario no existe; "+usuario.getUsuario());
		}
		
		if(!usuario.getClave().equals(usuarioDB.getClave())){
			usuarioDB.setClave(passwordEncoder.encode(usuario.getClave()));
		}
		usuarioDB.setEstado(usuario.getEstado());
		usuarioDB.setIdPersona(persona.getIdPersona());
		
		usuarioDB = usuarioRepository.save(usuarioDB);
		
		return usuarioDB;
	}
}
