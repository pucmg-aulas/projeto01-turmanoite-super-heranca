package model;

import java.io.Serializable;

public class Mesa implements Serializable {
	private int capacidade;
	private boolean disponibilidade;
	private String descricao;
	
	public Mesa(int capacidade, String descricao) {
		this.capacidade = capacidade;
		this.disponibilidade = false;
		this.descricao = descricao;
	}
	
	public int getCapacidade() {
		return this.capacidade;
	}
	
	public boolean getDisponibilidade() {
		return this.disponibilidade;
	}
	
	public String getDescricao() {
		return this.descricao;
	}

}
