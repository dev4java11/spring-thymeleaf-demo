package com.spring.thymeleaf.demo1.initializer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.spring.thymeleaf.demo1.entity.Client;
import com.spring.thymeleaf.demo1.repository.ClientRepository;

@Component
public class InitializerClientData implements CommandLineRunner {

	private ClientRepository repo;
	
	@Autowired
	public void setRepo(ClientRepository repo) {
		this.repo = repo;
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		List<Client> clients = new ArrayList<Client>();
		clients.add(new Client(UUID.randomUUID().toString(), "Jhon", "Doe"));
		clients.add(new Client(UUID.randomUUID().toString(), "Peter", "Brown"));
		clients.add(new Client(UUID.randomUUID().toString(), "Sally", "Simpson"));
		clients.add(new Client(UUID.randomUUID().toString(), "Robert", "Brooks"));
		clients.add(new Client(UUID.randomUUID().toString(), "Junior", "Smith"));
		clients.add(new Client(UUID.randomUUID().toString(), "Hayley", "Williams"));
		clients.add(new Client(UUID.randomUUID().toString(), "Paul", "Jones"));
		clients.add(new Client(UUID.randomUUID().toString(), "Edward", "Miller"));
		clients.add(new Client(UUID.randomUUID().toString(), "Jhon", "Taylor"));
		clients.add(new Client(UUID.randomUUID().toString(), "Brian", "Thompson"));

		
		repo.save(clients);
	}

}
