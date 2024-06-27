package model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Mesa implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private boolean disponivel;
    private int capacidade;
    private String descricao;
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

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalDateTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }
}
