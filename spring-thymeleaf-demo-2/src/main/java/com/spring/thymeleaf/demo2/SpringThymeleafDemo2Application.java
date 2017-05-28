package com.spring.thymeleaf.demo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@SpringBootApplication
public class SpringThymeleafDemo2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringThymeleafDemo2Application.class, args);
	}
}
