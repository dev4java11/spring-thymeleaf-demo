package com.spring.thymeleaf.demo2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;

public class TestGeneral extends SpringThymeleafDemo2ApplicationTests {
	
	@Autowired
	@Qualifier("iniciarDataUsuario")
	private CommandLineRunner commandLine;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test1() throws Exception {
		commandLine.run("a", "b");
	}

}
