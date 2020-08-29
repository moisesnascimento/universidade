package com.github.moisesnascimento.universidade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.moisesnascimento.universidade.models.Aluno;
import com.github.moisesnascimento.universidade.services.AlunoService;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

	@Autowired
	private AlunoService alunoService;

	@PostMapping(path = "/cadastrar_aluno")
	public ResponseEntity<Aluno> cadastrarAluno(@RequestBody Aluno aluno) {
		alunoService.salvarAluno(aluno);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@GetMapping(path = "/listar_alunos")
	public Iterable<Aluno> retornarAlunos() {
		return alunoService.retornarAlunos();
	}
}
