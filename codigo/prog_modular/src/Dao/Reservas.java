package Dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import model.Reserva;

public class Reservas extends AbstractDAO implements Serializable {

    private List<Reserva> reservas;
    private static Reservas instance;

    private final String localArquivo = "./src/data/Reservas.dat";

    private Reservas() {
        this.reservas = new ArrayList<>();
        carregaReservas();
    }

    public static Reservas getInstance() {
        if (instance == null) {
            instance = new Reservas();
        }
        return instance;
    }

    public void addReserva(Reserva reserva) {
        this.reservas.add(reserva);
        grava();
    }

    public void removeReserva(Reserva reserva) {
        this.reservas.remove(reserva);
        grava();
    }

    public Reserva getReservaPorNomeCliente(String nomeCliente) {
        for (Reserva reserva : reservas) {
            if (reserva.getProprietario().getNome().equals(nomeCliente)) {
                return reserva;
            }
        }
        return null;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void grava() {
        super.grava(localArquivo, reservas);
    }

    private void carregaReservas() {
        List<Reserva> loadedReservas = super.leitura(localArquivo);
        if (loadedReservas != null) {
            this.reservas = loadedReservas;
        }
    }
}
