package model;

import java.io.Serializable;

public class Prato implements Serializable {
    private static final long serialVersionUID = 1L; // Corrigido para 1

    private String nome;
    private double preco;

    public Prato(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}
