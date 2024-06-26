package Dao;

import model.Reserva;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Reservas extends AbstractDAO implements Serializable {
    private static final long serialVersionUID = 1L;
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

    public List<Reserva> getAllReservas() {
        return this.reservas;
    }

    private void grava() {
        super.grava(localArquivo, reservas);
    }

    private void carregaReservas() {
        this.reservas = super.leitura(localArquivo);
    }
}
