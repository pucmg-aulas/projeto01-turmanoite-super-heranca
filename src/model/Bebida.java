package model;

import java.io.Serializable;
import java.util.UUID;

public class Bebida implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nome;
    private double preco;
    private UUID id;

    public Bebida(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
        this.id = UUID.randomUUID();
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
    
    public UUID getId() {
    	return id;
    }
}
