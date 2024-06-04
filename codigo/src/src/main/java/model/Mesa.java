package model;

import java.io.Serializable;

public class Mesa implements Serializable {
    private int id;
    private int capacidade;
    private boolean disponivel;

    public Mesa(int id, int capacidade) {
        this.id = id;
        this.capacidade = capacidade;
        this.disponivel = true;
    }

    public int getId() {
        return id;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public void setCapacidade(int capacidade) {
        if (capacidade > 0) {
            this.capacidade = capacidade;
        } else {
            throw new IllegalArgumentException("Capacidade deve ser maior que zero.");
        }
    }
}
