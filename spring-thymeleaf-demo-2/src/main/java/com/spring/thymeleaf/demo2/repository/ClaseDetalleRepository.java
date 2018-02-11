package com.spring.thymeleaf.demo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.spring.thymeleaf.demo2.domain.ClaseDetalle;
import com.spring.thymeleaf.demo2.domain.ClaseDetallePK;

public interface ClaseDetalleRepository extends JpaRepository<ClaseDetalle, ClaseDetallePK>, QueryDslPredicateExecutor<ClaseDetalle> {

}
