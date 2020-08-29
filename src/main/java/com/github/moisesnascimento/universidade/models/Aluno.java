package com.github.moisesnascimento.universidade.models;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * @author Moises
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Getter	@Setter	private String nome;
	@Getter	@Setter	private int idade;
	@Getter	@Setter	private double notaPeriodo1;
	@Getter	@Setter	private double notaPeriodo2;
	@Getter	@Setter	private double notaPeriodo3;
	private final static int numTotalNotas = 3;
	
	
	public String calcularMedia() {
		BigDecimal media = new BigDecimal(
				String.valueOf((this.notaPeriodo1 + this.notaPeriodo2 + this.notaPeriodo3) / numTotalNotas));
		return String.format("Media: %s", media.toString());
	}

	public String toString() {
		return String.format("Nome: %s, Idade: %d, Nota 1: %.2f, Nota 2: %.2f, Nota 3: %.2f", this.nome, this.idade,
				this.notaPeriodo1, this.notaPeriodo2, this.notaPeriodo3);
	}
}
