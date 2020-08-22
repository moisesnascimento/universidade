package com.github.moisesnascimento.universidade.application;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Moises
 */
@Entity
public class Aluno extends Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double notaPeriodo1;
	private double notaPeriodo2;
	private double notaPeriodo3;
	private final static int numTotalNotas = 3;
	
	public Aluno() {
	  
	}

	public Aluno(String nome, int idade, double notaPeriodo1, double notaPeriodo2, double notaPeriodo3) {
		super(nome, idade);
		setNotaPeriodo1(notaPeriodo1);
		setNotaPeriodo2(notaPeriodo2);
		setNotaPeriodo3(notaPeriodo3);
	}

	public void setNotaPeriodo1(double notaPeriodo1) {
		this.notaPeriodo1 = notaPeriodo1;
	}

	public double getNotaPeriodo1() {
		return notaPeriodo1;
	}

	public void setNotaPeriodo2(double notaPeriodo2) {

		this.notaPeriodo2 = notaPeriodo2;
	}

	public double getNotaPeriodo2() {
		return notaPeriodo2;
	}

	public void setNotaPeriodo3(double notaPeriodo3) {
		this.notaPeriodo3 = notaPeriodo3;
	}

	public double getNotaPeriodo3() {
		return notaPeriodo3;
	}
	
	public int getId() {
		return this.id;
	}

	public String calcularMedia() {
		BigDecimal media = new BigDecimal(
				String.valueOf((getNotaPeriodo1() + getNotaPeriodo2() + getNotaPeriodo3()) / numTotalNotas));
		return String.format("Media: %s", media.toString());
	}

	public String toString() {
		return String.format("Nome: %s, Idade: %d, Nota 1: %.2f, Nota 2: %.2f, Nota 3: %.2f", getNome(), getIdade(),
				getNotaPeriodo1(), getNotaPeriodo2(), getNotaPeriodo3());
	}
}
