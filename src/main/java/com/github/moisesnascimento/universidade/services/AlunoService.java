package com.github.moisesnascimento.universidade.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.github.moisesnascimento.universidade.exceptions.AlunoNaoEncontradoExeption;
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

	public double calcularMedia(int id) throws AlunoNaoEncontradoExeption {
		Optional<Aluno> a = alunoRepository.findById(id);
		if (a.isEmpty()) {
			throw new AlunoNaoEncontradoExeption(id);
		}
		Aluno aluno = a.get();
		return (aluno.getNotaPeriodo1() + aluno.getNotaPeriodo2() +
				aluno.getNotaPeriodo3()) / 3;
		
		
	}

	public ResponseEntity<Integer> deletarAluno(int id) {
		if (alunoRepository.existsById(id)) {
			alunoRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id);
	}
	
	
}
