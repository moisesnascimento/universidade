package com.github.moisesnascimento.universidade.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Moises
 */
@Entity
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private int idade;
	private double notaPeriodo1;
	private double notaPeriodo2;
	private double notaPeriodo3;

	public Aluno(String nome, int idade, double notaPeriodo1, double notaPeriodo2, double notaPeriodo3) {
		this.nome = nome;
		this.idade = idade;
		this.notaPeriodo1 = notaPeriodo1;
		this.notaPeriodo2 = notaPeriodo2;
		this.notaPeriodo3 = notaPeriodo3;
	}
	
	public Aluno() {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double getNotaPeriodo1() {
		return notaPeriodo1;
	}

	public void setNotaPeriodo1(double notaPeriodo1) {
		this.notaPeriodo1 = notaPeriodo1;
	}

	public double getNotaPeriodo2() {
		return notaPeriodo2;
	}

	public void setNotaPeriodo2(double notaPeriodo2) {
		this.notaPeriodo2 = notaPeriodo2;
	}

	public double getNotaPeriodo3() {
		return notaPeriodo3;
	}

	public void setNotaPeriodo3(double notaPeriodo3) {
		this.notaPeriodo3 = notaPeriodo3;
	}

	public String toString() {
		return String.format("Nome: %s, Idade: %d, Nota 1: %.2f, Nota 2: %.2f, Nota 3: %.2f", this.nome, this.idade,
				this.notaPeriodo1, this.notaPeriodo2, this.notaPeriodo3);
	}
}
