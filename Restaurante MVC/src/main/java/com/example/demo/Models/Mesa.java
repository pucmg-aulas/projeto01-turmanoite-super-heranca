package com.example.demo.Models;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import jakarta.persistence.*;

@Entity
@Table(name = "Mesa")
public class Mesa {

@Max(value = 8, message = "ERRO: A capacidade máxima da mesa é 8")
@Min(value = 4, message = "ERRO: A capacidade mínima da mesa é 4")
@Column(name = "capacidade")
private int capacidade;

@Column(name = "disponibilidade")
private boolean disponibilidade;

public Mesa(int capacidade, boolean disponibilidade) {
        this.capacidade = capacidade;
        this.disponibilidade = disponibilidade;
    }


    public int getCapacidade() {
        return this.capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public boolean isDisponibilidade() {
        return this.disponibilidade;
    }

    public boolean getDisponibilidade() {
        return this.disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

}
