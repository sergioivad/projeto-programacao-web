package com.ufab.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipotrabalhoconclusao")
public class TipoTrabalhoConclusao {
	
	@Id
	@GeneratedValue
	private int cod;
	private String nome;
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
