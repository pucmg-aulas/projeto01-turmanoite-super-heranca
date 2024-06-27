package Dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import model.Reserva;

public class ReservasFinalizadas extends AbstractDAO implements Serializable {

    private List<Reserva> ReservasFinalizadas;
    private static ReservasFinalizadas instance;

    private final String localArquivo = "./src/data/ReservasFinalizadas.dat";

    private ReservasFinalizadas() {
        this.ReservasFinalizadas = new ArrayList<>();
        carregaReservasFinalizadas();
    }

    public static ReservasFinalizadas getInstance() {
        if (instance == null) {
            instance = new ReservasFinalizadas();
        }
        return instance;
    }

    public void addReserva(Reserva reserva) {
        this.ReservasFinalizadas.add(reserva);
        grava();
    }

    public void removeReserva(Reserva reserva) {
        this.ReservasFinalizadas.remove(reserva);
        grava();
    }

    public Reserva getReservaPorNomeCliente(String nomeCliente) {
        for (Reserva reserva : ReservasFinalizadas) {
            if (reserva.getProprietario().getNome().equals(nomeCliente)) {
                return reserva;
            }
        }
        return null;
    }

    public List<Reserva> getReservasFinalizadas() {
        return ReservasFinalizadas;
    }

    public void grava() {
        super.grava(localArquivo, ReservasFinalizadas);
    }

    private void carregaReservasFinalizadas() {
        List<Reserva> loadedReservasFinalizadas = super.leitura(localArquivo);
        if (loadedReservasFinalizadas != null) {
            this.ReservasFinalizadas = loadedReservasFinalizadas;
        }
    }
}
