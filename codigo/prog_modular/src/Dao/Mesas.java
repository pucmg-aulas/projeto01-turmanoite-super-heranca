package Dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import model.Mesa;

public class Mesas extends AbstractDAO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private List<Mesa> mesas;
    private static Mesas instance;

    private final String localArquivo = "./src/data/Mesas.dat";

    private Mesas() {
        this.mesas = new ArrayList<>();
        carregaMesas();
    }

    public static Mesas getInstance() {
        if (instance == null) {
            instance = new Mesas();
        }
        return instance;
    }

    public void addMesas(Mesa mesa) {
        this.mesas.add(mesa);
        grava();
    }

    public List<Mesa> getAllMesas() {
        return this.mesas;
    }

    public Mesa getMesaById(int id) {
        for (Mesa mesa : mesas) {
            if (mesa.getId() == id) {
                return mesa;
            }
        }
        return null;
    }

    public void removeMesaById(int id) {
        mesas.removeIf(mesa -> mesa.getId() == id);
        grava();
    }

    public int getNextId() {
        return mesas.size() + 1;
    }

    public void grava() {
        super.grava(localArquivo, mesas);
    }

    private void carregaMesas() {
        this.mesas = super.leitura(localArquivo);
    }
}
