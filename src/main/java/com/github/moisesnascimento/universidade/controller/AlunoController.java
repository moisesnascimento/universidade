package com.github.moisesnascimento.universidade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.github.moisesnascimento.universidade.exceptions.AlunoNaoEncontradoExeption;
import com.github.moisesnascimento.universidade.models.Aluno;
import com.github.moisesnascimento.universidade.services.AlunoService;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

	@Autowired
	private AlunoService alunoService;

	@GetMapping(path = "/alunos")
	public Iterable<Aluno> mostraAlunos() {
		return alunoService.retornarAlunos();
	}

	@GetMapping(path = "{id}/aluno")
	public ResponseEntity<Aluno> mostraAluno(@PathVariable(value = "id") int id) throws AlunoNaoEncontradoExeption  {
		
		if(id < 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		try{
			 alunoService.retornaAluno(id);		
			 return ResponseEntity.status(HttpStatus.OK).build();
		}catch(ResponseStatusException e){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	@PostMapping()
	public ResponseEntity<Aluno> cadastraAluno(Aluno aluno) {
		if(aluno.equals(null)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		alunoService.salvarAluno(aluno);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Aluno> removeAluno(@PathVariable("id") int id) throws AlunoNaoEncontradoExeption {
		
		if(id < 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		try{
			alunoService.deletarAluno(id);			
		}catch(ResponseStatusException e){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Aluno> atualizaAluno(@PathVariable("id") int id, @RequestBody Aluno aluno) throws AlunoNaoEncontradoExeption {
		
		if(id < 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		if(aluno.equals(null)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		alunoService.atualizarAluno(id, aluno);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<Aluno> alteraNome (@PathVariable("id") int id, @RequestParam String nome) throws AlunoNaoEncontradoExeption{
		
		if(id < 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		if(nome.equals(null)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		alunoService.alterarMome(id, nome);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
