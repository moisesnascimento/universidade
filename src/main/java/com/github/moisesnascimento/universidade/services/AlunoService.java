package com.github.moisesnascimento.universidade.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	public ResponseEntity<Integer> deletarAluno(int id) {
		if (alunoRepository.existsById(id)) {
			alunoRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id);
	}
}
