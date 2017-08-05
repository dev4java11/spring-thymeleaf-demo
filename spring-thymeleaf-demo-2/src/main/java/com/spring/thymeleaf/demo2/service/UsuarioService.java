package com.spring.thymeleaf.demo2.service;

import com.spring.thymeleaf.demo2.domain.Usuario;

public interface UsuarioService {

	public Usuario obtenerPorId(String idUsuario);
	
	public Usuario crearUsuario(Usuario usuario);
	
	public Usuario actualizarUsuario(Usuario usuario);
}
