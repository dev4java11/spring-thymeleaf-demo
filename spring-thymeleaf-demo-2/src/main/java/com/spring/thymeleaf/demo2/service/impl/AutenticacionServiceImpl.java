package com.spring.thymeleaf.demo2.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.thymeleaf.demo2.domain.QUsuarioRol;
import com.spring.thymeleaf.demo2.domain.Usuario;
import com.spring.thymeleaf.demo2.domain.UsuarioRol;
import com.spring.thymeleaf.demo2.repository.UsuarioRepository;
import com.spring.thymeleaf.demo2.repository.UsuarioRolRepository;
import com.spring.thymeleaf.demo2.util.AplicacionUtil;
import com.spring.thymeleaf.demo2.util.Constantes;
import com.spring.thymeleaf.demo2.util.MensajeUtil;
import com.spring.thymeleaf.demo2.util.ValidacionUtil;

@Service
@Transactional(readOnly = false)
public class AutenticacionServiceImpl implements AuthenticationProvider {
	
	private UsuarioRepository usuarioRepository;
	
	private UsuarioRolRepository usuarioRolRepository;
	
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	@Autowired
	public void setUsuarioRolRepository(UsuarioRolRepository usuarioRolRepository) {
		this.usuarioRolRepository = usuarioRolRepository;
	}
	
	@Autowired
	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getPrincipal().toString();
		String password = authentication.getCredentials().toString();
		
		if(ValidacionUtil.esVacio(username)){
			throw new UsernameNotFoundException(MensajeUtil.getMensaje("mensaje.usuario.no.encontrado"));
		}
		
		Usuario usuario = usuarioRepository.findOne(username);
		if(ValidacionUtil.esNulo(usuario)){
			throw new UsernameNotFoundException(MensajeUtil.getMensaje("mensaje.usuario.no.encontrado", username));
		}
		
		if(ValidacionUtil.esMayorACero(usuario.getEstado())
				&& usuario.getEstado().compareTo(Constantes.USUARIO_ESTADO_ACTIVO) != 0){
			throw new DisabledException(MensajeUtil.getMensaje("mensaje.usuario.inactivo", username));
		}
		
		if(ValidacionUtil.esVacio(password) || ValidacionUtil.esVacio(usuario.getClave())
				|| passwordEncoder.matches(password, usuario.getClave())){
			throw new BadCredentialsException(MensajeUtil.getMensaje("mensaje.usuario.clave.incorrecta", username));
		}
		
		Iterable<UsuarioRol> it = usuarioRolRepository.findAll(QUsuarioRol.usuarioRol.id.usuario.eq(username));
		if(ValidacionUtil.esVacio(it)){
			throw new AuthenticationServiceException(MensajeUtil.getMensaje("mensaje.usuario.roles.no.encontrados", username));
		}
		
		List<GrantedAuthority> roles = AplicacionUtil.newArrayList();
		for(UsuarioRol rol : it){
			roles.add(new SimpleGrantedAuthority(rol.getId().getRol()));
		}
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(usuario, password, roles);
		return token;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

}
