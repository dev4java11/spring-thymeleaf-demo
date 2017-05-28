package com.spring.thymeleaf.demo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.thymeleaf.demo2.domain.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {

}
