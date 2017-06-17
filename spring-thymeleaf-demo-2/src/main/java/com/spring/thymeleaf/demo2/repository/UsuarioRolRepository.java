package com.spring.thymeleaf.demo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.thymeleaf.demo2.domain.UsuarioRol;
import com.spring.thymeleaf.demo2.domain.UsuarioRolPK;

public interface UsuarioRolRepository extends JpaRepository<UsuarioRol, UsuarioRolPK> {

}
