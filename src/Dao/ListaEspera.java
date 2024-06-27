package Dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import model.ClienteListaEspera;
import model.Reserva;

public class ListaEspera extends AbstractDAO implements Serializable {

    private List<ClienteListaEspera> clientes;
    private List<Reserva> reservas;
    private static ListaEspera instance;

    private final String localArquivo = "./src/data/ListaEspera.dat";
    private final String reservasArquivo = "./src/data/Reservas.dat";

    private ListaEspera() {
        this.clientes = new ArrayList<>();
        this.reservas = new ArrayList<>();
        carregaClientes();
    }

    public static ListaEspera getInstance() {
        if (instance == null) {
            instance = new ListaEspera();
        }
        return instance;
    }

    public void adicionarCliente(ClienteListaEspera cliente) {
        this.clientes.add(cliente);
        gravaClientes();
    }

    public void removerClientePorIndex(int index) {
        this.clientes.remove(index);
        gravaClientes();
    }

    public List<ClienteListaEspera> getClientes() {
        return this.clientes;
    }

    public void adicionarReserva(Reserva reserva) {
        this.reservas.add(reserva);
        gravaReservas();
    }

    public List<Reserva> getReservas() {
        return this.reservas;
    }

    protected void gravaClientes() {
        super.grava(localArquivo, clientes);
    }

    protected void gravaReservas() {
        super.grava(reservasArquivo, reservas);
    }

    private void carregaClientes() {
        List<ClienteListaEspera> loadedClientes = super.leitura(localArquivo);
        if (loadedClientes != null) {
            this.clientes = loadedClientes;
        }
        List<Reserva> loadedReservas = super.leitura(reservasArquivo);
        if (loadedReservas != null) {
            this.reservas = loadedReservas;
        }
    }
}
