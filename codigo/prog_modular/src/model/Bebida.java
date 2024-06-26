package model;

import java.io.Serializable;

public class Bebida implements Serializable {
    private String nome;
    private double preco;

    public Bebida(String nome, double preco) {
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
