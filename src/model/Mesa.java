package model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Mesa implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int id;
    private int capacidade;
    private String descricao;
    private boolean disponivel;
    private LocalDateTime horaEntrada;

    public Mesa(int id, int capacidade, String descricao) {
        this.id = id;
        this.capacidade = capacidade;
        this.descricao = descricao;
        this.disponivel = true;
    }

    public int getId() {
        return id;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalDateTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }
}
