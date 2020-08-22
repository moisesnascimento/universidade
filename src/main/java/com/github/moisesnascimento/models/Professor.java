package com.github.moisesnascimento.models;

import com.github.moisesnascimento.universidade.application.Pessoa;

/**
 * @author Moises
 */
public class Professor extends Pessoa {

	private double salario;
	private String cpf;
	private final static int idadeMIN = 18;

	public Professor(String nome, int idade, double salario, String cpf) {
		super(nome, idade);
		setSalario(salario);
		setCpf(cpf);
	}

	
	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		// valida o CPF
		if (!cpf.matches("[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{2}")) {
			throw new IllegalArgumentException("CPF Invalido");
		}
		this.cpf = cpf;
	}

	public void setIdade(int idade) {
		if (idade < idadeMIN) {
			throw new IllegalAccessError("Idade nao permitida");
		}
		super.setIdade(idade);
	}

	
	public String toString() {
		return String.format("Professor nome = %s, Idade = %d, Salario = %.2f ,CPF = %s", getNome(), getIdade(),
				getSalario(), getCpf());
	}
}