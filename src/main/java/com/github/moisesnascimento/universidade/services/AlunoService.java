package com.github.moisesnascimento.universidade.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
		Optional<Aluno> alunoOptional = alunoRepository.findById(id);
		if (alunoOptional.isEmpty()) {
			throw new AlunoNaoEncontradoExeption(id);
		}
		Aluno aluno = alunoOptional.get();
		return (aluno.getNotaPeriodo1() + aluno.getNotaPeriodo2() + aluno.getNotaPeriodo3()) / 3;
	}

	public void deletarAluno(int id) throws AlunoNaoEncontradoExeption {
		if (!alunoRepository.existsById(id)) {
			throw new AlunoNaoEncontradoExeption(id);
		}
		alunoRepository.deleteById(id);
	}

	public void atualizarAluno(int id, Aluno aluno) throws AlunoNaoEncontradoExeption {
		Optional<Aluno> alunoOptional = alunoRepository.findById(id);
		if (alunoOptional.isEmpty()) {
			throw new AlunoNaoEncontradoExeption(id);
		}
		Aluno alun = alunoOptional.get();
		alun.setNome(aluno.getNome());
		alun.setIdade(aluno.getIdade());
		alun.setNotaPeriodo1(aluno.getNotaPeriodo1());
		alun.setNotaPeriodo2(aluno.getNotaPeriodo2());
		alun.setNotaPeriodo3(aluno.getNotaPeriodo3());
		alunoRepository.save(alun);
	}

	public Aluno retornaAluno(int id) throws AlunoNaoEncontradoExeption {
		Optional<Aluno> alunoOptional = alunoRepository.findById(id);
		if (alunoOptional.isEmpty()) {
			throw new AlunoNaoEncontradoExeption(id);
		}
		Aluno aluno = alunoOptional.get();
		return aluno;
	}

	public void alterarMome(int id, String nome) throws AlunoNaoEncontradoExeption {
		Optional<Aluno> alunoOptional = alunoRepository.findById(id);
		if (alunoOptional.isEmpty()) {
			throw new AlunoNaoEncontradoExeption(id);
		}
		Aluno aluno = alunoOptional.get();
		aluno.setNome(nome);
		alunoRepository.save(aluno);
	}
}
