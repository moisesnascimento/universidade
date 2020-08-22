package com.github.moisesnascimento.models;

/**
 * @author Moises
 */
import java.util.ArrayList;

import com.github.moisesnascimento.universidade.application.Aluno;

public class Turma {

	ArrayList<Aluno> listaAlunos = new ArrayList<>();
	private Professor professor;
	private final int totalAlunosPorTurma = 3;

	public void adicionarAluno(Aluno aluno) {
		if (listaAlunos.size() > totalAlunosPorTurma) {
			throw new IndexOutOfBoundsException("Turma cheia");
		}
		this.listaAlunos.add(aluno);
	}

	public void retornarAlunos() {
		listaAlunos.forEach(aluno -> System.out.println(aluno));
	}

	public boolean contemAluno(String nome) {
		for (Aluno aluno : listaAlunos) {
			if (aluno.getNome().equalsIgnoreCase(nome)) {
				return true;
			}
		}
		return false;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public String informacoesTurma() {
		return String.format("Professor da Turma: %s%n Alunos: %s%n", professor.getNome(), listaAlunos);
	}
}