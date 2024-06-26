package model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Reserva implements Serializable {
    private static final long serialVersionUID = 1L; // Adicione um serialVersionUID

    private ProprietarioReserva proprietario;
    private Mesa mesa;
    private Comanda comanda;
    private LocalDateTime dataHoraReserva;

    public Reserva(ProprietarioReserva proprietario, Mesa mesa) {
        this.proprietario = proprietario;
        this.mesa = mesa;
        this.comanda = new Comanda();
        this.dataHoraReserva = LocalDateTime.now();
    }

    public ProprietarioReserva getProprietario() {
        return proprietario;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public Comanda getComanda() {
        return comanda;
    }

    public LocalDateTime getDataHoraReserva() {
        return dataHoraReserva;
    }
}
