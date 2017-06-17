package com.spring.thymeleaf.demo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.thymeleaf.demo2.domain.Rol;

public interface RolRepository extends JpaRepository<Rol, String> {

}
