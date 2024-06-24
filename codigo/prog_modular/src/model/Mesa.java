package model;

public class Mesa {
	private int id;
	private int capacidade;
	private boolean disponibilidade;
	private String descricao;
	
	public Mesa(int id, int capacidade, String descricao) {
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
	public int getId() {
		return this.id;
	}

}
