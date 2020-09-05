package com.github.moisesnascimento.universidade.exceptions;

import com.github.moisesnascimento.universidade.models.Professor;

@SuppressWarnings("serial")
public class NomeInvalidoException extends Exception {

	private Professor professor;

	public void validarNome(Professor professor) {
		if(!professor.getNome().matches("a-zA-Z")) {
			System.out.println(getMessage());
		}
	}

	public String getMessage() {
		return String.format("Nome invalido", professor.getNome());
	}
}
