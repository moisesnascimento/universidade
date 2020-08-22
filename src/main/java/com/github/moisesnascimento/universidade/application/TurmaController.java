package com.github.moisesnascimento.universidade.application;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.moisesnascimento.models.Professor;
import com.github.moisesnascimento.models.Turma;

@RestController
@RequestMapping(path = "/turma")
public class TurmaController {

	
	Turma turma = new Turma();
	@PostMapping(path = "/adicionar{aluno}")
	public HttpStatus adicionarAluno(@RequestParam(name = "nome") String nome,
			@RequestParam(value = "idade") int idade,
			@RequestParam(value = "nota1") double nota1,
			@RequestParam(value = "nota2") double nota2,
			@RequestParam(value = "nota3") double nota3) {
	    turma.adicionarAluno(new Aluno(nome, idade, nota1, nota2, nota3));
		return HttpStatus.ACCEPTED;
	}
	

	@PostMapping(path = "/adicionar_professor")
	public HttpStatus adicionarProfessor(@RequestParam(name = "nome") String nome,
			@RequestParam(value = "idade") int idade,
			@RequestParam(value = "cpf") String cpf,
			@RequestParam(value = "salario") double salario){
	    turma.setProfessor(new Professor(nome, idade, salario, cpf));
		return HttpStatus.ACCEPTED;
	}
	
	
	@GetMapping(path = "/turma_alunos")
	public String mostrarTurma() {
		return turma.informacoesTurma();
	}
}
