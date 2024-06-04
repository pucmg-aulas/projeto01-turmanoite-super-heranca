package model;

import java.io.Serializable;
import java.util.Date;

public class Reserva implements Serializable {
    private String nomeCliente;
    private String cpf;
    private String telefone;
    private int numPessoas;
    private Mesa mesa;
    private Date dataReserva;

    public Reserva(String nomeCliente, String cpf, String telefone, int numPessoas, Mesa mesa) {
        this.nomeCliente = nomeCliente;
        this.cpf = cpf;
        this.telefone = telefone;
        this.numPessoas = numPessoas;
        this.mesa = mesa;
        this.dataReserva = new Date();
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public int getNumPessoas() {
        return numPessoas;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public Date getDataReserva() {
        return dataReserva;
    }
}
