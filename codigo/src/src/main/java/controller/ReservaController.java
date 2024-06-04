package controller;

import dao.ReservaDAO;
import model.Mesa;
import model.Reserva;

import java.util.ArrayList;
import java.util.List;

public class ReservaController {
    private List<Reserva> reservas;
    private List<Reserva> listaDeEspera;
    private ReservaDAO reservaDAO;

    public ReservaController() {
        this.reservas = new ArrayList<>();
        this.listaDeEspera = new ArrayList<>();
        this.reservaDAO = new ReservaDAO(reservas, listaDeEspera);
    }

    public boolean adicionarReserva(String nomeCliente, String cpf, String telefone, int numPessoas, Mesa mesa) {
        if (mesa == null || !mesa.isDisponivel() || mesa.getCapacidade() < numPessoas) {
            return false;
        }
        Reserva reserva = new Reserva(nomeCliente, cpf, telefone, numPessoas, mesa);
        reservas.add(reserva);
        mesa.setDisponivel(false);
        reservaDAO.salvarReservas(reservas, listaDeEspera);
        return true;
    }

    public void adicionarAListaDeEspera(String nomeCliente, String cpf, String telefone, int numPessoas) {
        Reserva reserva = new Reserva(nomeCliente, cpf, telefone, numPessoas, null);
        listaDeEspera.add(reserva);
        reservaDAO.salvarReservas(reservas, listaDeEspera);
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public List<Reserva> getListaDeEspera() {
        return listaDeEspera;
    }

    public void removerReserva(Reserva reserva) {
        reservas.remove(reserva);
        if (reserva.getMesa() != null) {
            reserva.getMesa().setDisponivel(true);
        }
        reservaDAO.salvarReservas(reservas, listaDeEspera);
    }
}
