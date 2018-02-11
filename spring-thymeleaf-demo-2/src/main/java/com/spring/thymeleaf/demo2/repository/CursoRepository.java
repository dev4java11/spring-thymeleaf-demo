package com.spring.thymeleaf.demo2.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.spring.thymeleaf.demo2.domain.Curso;

public interface CursoRepository extends JpaRepository<Curso, BigInteger>, QueryDslPredicateExecutor<Curso> {

}
