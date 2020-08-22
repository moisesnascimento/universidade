package com.github.moisesnascimento.universidade.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/turma")
public class AlunoController {

	@Autowired
	private AlunoRepository alunoRepository;
	
	@PostMapping(path = "/cadastrar_aluno")
	public @ResponseBody Aluno cadastrarAluno (@RequestParam(name = "nome") String nome,
			@RequestParam(value = "idade") int idade,
			@RequestParam(value = "nota1") double nota1,
			@RequestParam(value = "nota2") double nota2,
			@RequestParam(value = "nota3") double nota3) {
		Aluno aluno = new Aluno(nome,idade,nota1,nota2,nota3);
		alunoRepository.save(aluno);
		return aluno;
	}
}

