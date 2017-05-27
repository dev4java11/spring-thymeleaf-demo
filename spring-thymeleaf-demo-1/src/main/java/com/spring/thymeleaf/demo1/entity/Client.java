package com.spring.thymeleaf.demo1.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Data
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String uuid;
	
	@NotNull
	private String firstName;
	
	@NotNull
	private String lastName;
	
	public Client() {
		
	}

	public Client(String uuid, String firstName, String lastName) {
		this.uuid = uuid;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	
}
