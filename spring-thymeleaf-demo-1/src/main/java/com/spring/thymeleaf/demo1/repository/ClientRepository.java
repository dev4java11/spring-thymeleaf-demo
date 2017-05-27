package com.spring.thymeleaf.demo1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.thymeleaf.demo1.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
