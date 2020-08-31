package com.github.moisesnascimento.universidade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.moisesnascimento.universidade.models.Professor;
import com.github.moisesnascimento.universidade.services.ProfessorService;

@RestController
@RequestMapping(path = "/professor")
public class ProfessorController {

	@Autowired
	ProfessorService professorService;

	@PostMapping(path = "/inserir_professor")
	public ResponseEntity<Professor> cadastrarProfessor(Professor professor) {
		professorService.salvarProfessor(professor);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@GetMapping(path = "/mostrar_professor")
	public Iterable<Professor> listarProfessor() {
		return professorService.mostrarProfessor();
	}
}
