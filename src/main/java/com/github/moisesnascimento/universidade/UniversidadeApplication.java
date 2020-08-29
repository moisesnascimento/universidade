package com.github.moisesnascimento.universidade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@ComponentScan(basePackages = {
		// aqui estamos dizendo para o spring buscar os componentes nesse pacote
		"com.github.moisesnascimento.universidade.*",
})
@Profile("mysql")
public class UniversidadeApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniversidadeApplication.class, args);
	}
}
