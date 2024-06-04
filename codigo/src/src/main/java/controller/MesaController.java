package controller;

import dao.MesaDAO;
import model.Mesa;

import java.util.List;

public class MesaController {
    private MesaDAO mesaDAO;
    private List<Mesa> mesas;

    public MesaController() {
        this.mesaDAO = new MesaDAO();
        this.mesas = mesaDAO.getMesas();
        if (mesas.isEmpty()) {
            inicializarMesas();
        }
    }

    private void inicializarMesas() {
        mesas.add(new Mesa(1, 4));
        mesas.add(new Mesa(2, 4));
        mesas.add(new Mesa(3, 6));
        mesas.add(new Mesa(4, 6));
        mesas.add(new Mesa(5, 8));
        mesas.add(new Mesa(6, 8));
        mesaDAO.salvarMesas(mesas);
    }

    public List<Mesa> getMesas() {
        return mesas;
    }

    public void adicionarMesa(Mesa mesa) {
        mesaDAO.adicionarMesa(mesa);
    }

    public void removerMesa(Mesa mesa) {
        mesaDAO.removerMesa(mesa);
    }

    public void atualizarMesa(Mesa mesa) {
        mesaDAO.atualizarMesa(mesa);
    }
}
