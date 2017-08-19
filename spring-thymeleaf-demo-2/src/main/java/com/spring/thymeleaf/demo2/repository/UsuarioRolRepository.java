package com.spring.thymeleaf.demo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.spring.thymeleaf.demo2.domain.UsuarioRol;
import com.spring.thymeleaf.demo2.domain.UsuarioRolPK;

public interface UsuarioRolRepository extends JpaRepository<UsuarioRol, UsuarioRolPK>, QueryDslPredicateExecutor<UsuarioRol> {

}
