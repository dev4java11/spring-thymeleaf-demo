package com.spring.thymeleaf.demo2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.thymeleaf.demo2.domain.Persona;
import com.spring.thymeleaf.demo2.repository.PersonaRepository;
import com.spring.thymeleaf.demo2.service.PersonaService;

@Service
@Transactional(readOnly = true)
public class PersonaServiceImpl implements PersonaService {
	
	private PersonaRepository personaRepository;
	
	@Autowired
	public void setPersonaRepository(PersonaRepository personaRepository) {
		this.personaRepository = personaRepository;
	}

	@Override
	public Persona obtenerPorId(Integer personaId) {
		return personaRepository.findOne(personaId);
	}

}
