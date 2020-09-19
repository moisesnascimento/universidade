package com.github.moisesnascimento.universidade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.moisesnascimento.universidade.models.Aluno;
import com.github.moisesnascimento.universidade.services.AlunoService;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

	@Autowired
	private AlunoService alunoService;

	@PostMapping()
	public ResponseEntity<Aluno> cadastrarAluno(Aluno aluno) {
		alunoService.salvarAluno(aluno);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@GetMapping(path = "/alunos")
	public Iterable<Aluno> retornarAlunos() {
		return alunoService.retornarAlunos();
	}

	@DeleteMapping()
	@RequestMapping(path = "/{id}")
	public ResponseEntity<Aluno> removerAluno(@PathVariable("id") int id) {
		alunoService.deletarAluno(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@PutMapping()
	@RequestMapping(path = "/{id}/aluno")
	public ResponseEntity<Aluno> renomearAluno(@PathVariable("id") int id, @RequestParam("nome") String nome) {
		alunoService.renomearAluno(id, nome);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
