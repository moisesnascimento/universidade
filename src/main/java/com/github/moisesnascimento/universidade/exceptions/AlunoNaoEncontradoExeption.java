package com.github.moisesnascimento.universidade.exceptions;

@SuppressWarnings("serial")
public class AlunoNaoEncontradoExeption extends Exception {

	public AlunoNaoEncontradoExeption(int id) {
		System.out.println("Aluno nao encontrado " + id);
	}
}
