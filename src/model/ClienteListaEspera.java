package model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ClienteListaEspera implements Serializable {
    private String nome;
    private String telefone;
    private int qtdPessoas;
    private LocalDateTime dataHoraEntrada;

    public ClienteListaEspera(String nome, String telefone, int qtdPessoas) {
        this.nome = nome;
        this.telefone = telefone;
        this.qtdPessoas = qtdPessoas;
        this.dataHoraEntrada = LocalDateTime.now();
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public int getQtdPessoas() {
        return qtdPessoas;
    }

    public LocalDateTime getDataHoraEntrada() {
        return dataHoraEntrada;
    }
}
