package com.spring.thymeleaf.demo2.service.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.thymeleaf.demo2.domain.Persona;
import com.spring.thymeleaf.demo2.domain.Rol;
import com.spring.thymeleaf.demo2.domain.Usuario;
import com.spring.thymeleaf.demo2.domain.UsuarioRol;
import com.spring.thymeleaf.demo2.repository.PersonaRepository;
import com.spring.thymeleaf.demo2.repository.RolRepository;
import com.spring.thymeleaf.demo2.repository.UsuarioRepository;
import com.spring.thymeleaf.demo2.repository.UsuarioRolRepository;
import com.spring.thymeleaf.demo2.service.UsuarioService;
import com.spring.thymeleaf.demo2.util.AplicacionUtil;
import com.spring.thymeleaf.demo2.util.Constantes;
import com.spring.thymeleaf.demo2.util.ValidacionUtil;
import com.spring.thymeleaf.demo2.util.exception.UsuarioExisteException;

@Service
@Transactional(readOnly = true)
public class UsuarioServiceImpl implements UsuarioService {
	
	private UsuarioRepository usuarioRepository;
	
	private PersonaRepository personaRepository;
	
	private RolRepository rolRepository;
	
	private UsuarioRolRepository usuarioRolRepository;
	
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	@Autowired
	public void setPersonaRepository(PersonaRepository personaRepository) {
		this.personaRepository = personaRepository;
	}
	
	@Autowired
	public void setRolRepository(RolRepository rolRepository) {
		this.rolRepository = rolRepository;
	}
	
	@Autowired
	public void setUsuarioRolRepository(UsuarioRolRepository usuarioRolRepository) {
		this.usuarioRolRepository = usuarioRolRepository;
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
		if(ValidacionUtil.noEsNulo(usuarioDB)){
			throw new UsuarioExisteException(usuario);
		}
		
		Persona persona = usuario.getPersona();
		persona.setUuid(AplicacionUtil.newUUID());
		persona = personaRepository.save(persona);
		
		String claveEncriptada = passwordEncoder.encode(usuario.getClave());
		usuario.setClave(claveEncriptada);
		usuario.setUuid(AplicacionUtil.newUUID());
		usuario.setEstado(Constantes.USUARIO_ESTADO_ACTIVO);
		usuario.setIdPersona(persona.getIdPersona());
		
		usuario = usuarioRepository.save(usuario);
		
		return usuario;
	}

	@Transactional(readOnly = false)
	@Override
	public Usuario actualizarUsuario(Usuario usuario) {
		Persona persona = usuario.getPersona();
		persona = personaRepository.save(persona);
		
		Usuario usuarioDB = usuarioRepository.findOne(usuario.getUsuario());
		if(ValidacionUtil.esNulo(usuarioDB)){
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
	
	@Transactional(readOnly = false)
	@Override
	public Usuario registrarUsuarioConRol(Usuario usuario, String idRol) {
		usuario = crearUsuario(usuario);
		
		Rol rol = rolRepository.findOne(idRol);
		if(ValidacionUtil.esNulo(rol)){
			throw new NullPointerException("Rol no existe: "+rol.getRol());
		}
		
		UsuarioRol usuarioRol = new UsuarioRol();
		usuarioRol.getId().setUsuario(usuario.getUsuario());
		usuarioRol.getId().setRol(rol.getRol());
		usuarioRol.setFechaAsignacion(AplicacionUtil.getDateNow());
		usuarioRol.setUuid(AplicacionUtil.newUUID());
		
		usuarioRol = usuarioRolRepository.save(usuarioRol);
		
		return usuario;
	}
}
