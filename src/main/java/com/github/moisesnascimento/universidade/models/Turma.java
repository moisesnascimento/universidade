package com.github.moisesnascimento.universidade.models;

/**
 * @author Moises
 */
import java.util.HashMap;

public class Turma {

	private HashMap<Professor, Aluno> turma = new HashMap<>();

	public HashMap<Professor, Aluno> getTurma() {
		return turma;
	}

	public void setTurma(HashMap<Professor, Aluno> turma) {
		this.turma = turma;
	}
}