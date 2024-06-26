package Dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import model.ClienteListaEspera;

public class ListaEspera extends AbstractDAO implements Serializable {

    private List<ClienteListaEspera> clientes;
    private static ListaEspera instance;

    private final String localArquivo = "./src/data/ListaEspera.dat";

    private ListaEspera() {
        this.clientes = new ArrayList<>();
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
        grava();
    }

    public void removerClientePorIndex(int index) {
        this.clientes.remove(index);
        grava();
    }

    public List<ClienteListaEspera> getClientes() {
        return this.clientes;
    }

    private void grava() {
        super.grava(localArquivo, clientes);
    }

    private void carregaClientes() {
        List<ClienteListaEspera> loadedClientes = super.leitura(localArquivo);
        if (loadedClientes != null) {
            this.clientes = loadedClientes;
        }
    }
}
