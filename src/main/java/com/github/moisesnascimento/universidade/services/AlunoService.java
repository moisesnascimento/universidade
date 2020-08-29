package com.github.moisesnascimento.universidade.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.moisesnascimento.universidade.models.Aluno;
import com.github.moisesnascimento.universidade.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	AlunoRepository alunoRepository;

	public void salvarAluno(Aluno aluno) {
		alunoRepository.save(aluno);
	}

	public Iterable<Aluno> retornarAlunos() {
		return alunoRepository.findAll();
	}
}
