package model;

import java.io.Serializable;
import java.util.UUID;

public class ItemVenda implements Serializable {
    
    public ItemVenda(Produto produto) {
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
