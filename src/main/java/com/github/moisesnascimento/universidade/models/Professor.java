package com.github.moisesnascimento.universidade.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Moises
 */
@Entity
public class Professor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private int idade;
	private double salario;
	private String cpf;

	public Professor(String nome, int idade, double salario, String cpf) {
		setNome(nome);
		setIdade(idade);
		setSalario(salario);
		setCpf(cpf);
	}
	
	public Professor(){
		
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
		this.cpf = cpf;
	}

	public String toString() {
		return String.format("Professor nome = %s, Idade = %d, Salario = %.2f ,CPF = %s", getNome(), getIdade(),
				getSalario(), getCpf());
	}
}