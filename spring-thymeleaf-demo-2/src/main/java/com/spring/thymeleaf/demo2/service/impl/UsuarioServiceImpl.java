package com.spring.thymeleaf.demo2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.thymeleaf.demo2.domain.Usuario;
import com.spring.thymeleaf.demo2.repository.UsuarioRepository;
import com.spring.thymeleaf.demo2.service.UsuarioService;

@Service
@Transactional(readOnly = true)
public class UsuarioServiceImpl implements UsuarioService {
	
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public Usuario obtenerPorId(String idUsuario) {
		return usuarioRepository.findOne(idUsuario);
	}

}
