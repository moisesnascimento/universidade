package com.github.moisesnascimento.universidade.administracao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.github.moisesnascimento.universidade.controller.AlunoController;
import com.github.moisesnascimento.universidade.services.AlunoService;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

@WebMvcTest
public class AlunoControllerTest {

	@Autowired
	AlunoController alunoController;
	
	
	@MockBean
	AlunoService alunoService;
	
	//Esse metodo faz o spring testar apenas AlunoController
	//eu que informo oque precisa ser injetado
	@BeforeEach
	public void setup() {
		RestAssuredMockMvc.standaloneSetup(this.alunoController);
	}
	
	@Test
	void contextLoads() {
	}
}
