package com.github.moisesnascimento.universidade.services;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public String mostrarProfessor() {
		return professorRepository.toString();
	}
}
