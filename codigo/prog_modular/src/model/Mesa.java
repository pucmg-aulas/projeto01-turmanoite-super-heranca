package model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Mesa implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int id;
    private int capacidade;
    private boolean disponibilidade;
    private String descricao;
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSaida;

    public Mesa(int id, int capacidade, String descricao) {
        this.id = id;
        this.capacidade = capacidade;
        this.disponibilidade = true; // inicialmente a mesa está disponível
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public boolean isDisponivel() {
        return disponibilidade;
    }

    public void setDisponivel(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
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

    public LocalDateTime getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(LocalDateTime horaSaida) {
        this.horaSaida = horaSaida;
    }

    public String getDisponibilidade() {
        return disponibilidade ? "Desocupada" : "Ocupada";
    }
}
