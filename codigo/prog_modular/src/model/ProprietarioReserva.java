package model;

public class ProprietarioReserva {
	private String nome;
	private String telefone;
	private int totalPessoas;
	private String cpf;
	
	public ProprietarioReserva(String nome, String telefone, int totalPessoas, String cpf) {
		this.nome = nome;
		this.telefone = telefone;
		this.totalPessoas = totalPessoas;
		this.cpf = cpf;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public int getQtdPessoas() {
		return totalPessoas;
	}
	
	public String getTelefone() {
		return this.telefone;
	}
	
	public String getCpf() {
		return this.cpf;
	}
	

}
