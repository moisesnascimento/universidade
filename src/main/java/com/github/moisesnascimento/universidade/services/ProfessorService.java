package com.github.moisesnascimento.universidade.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.github.moisesnascimento.universidade.models.Professor;
import com.github.moisesnascimento.universidade.repository.ProfessorRepository;

@Service
public class ProfessorService {

	@Autowired
	ProfessorRepository professorRepository;

	public void salvarProfessor(Professor professor) {
		professorRepository.save(professor);
	}

	public Iterable<Professor> mostrarProfessor() {
		return professorRepository.findAll();
	}


	public ResponseEntity<Integer> deletarProfessor(int id) {
		if (!professorRepository.existsById(id)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id);
		}
		professorRepository.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
