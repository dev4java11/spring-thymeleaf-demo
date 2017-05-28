package com.spring.thymeleaf.demo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.thymeleaf.demo2.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

}
