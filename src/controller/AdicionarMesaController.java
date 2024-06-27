package controller;

import Dao.Mesas;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Mesa;
import views.AdicionarMesa;

public class AdicionarMesaController {

    private AdicionarMesa view;
    private Mesas mesas;

    public AdicionarMesaController() {
        this.mesas = Mesas.getInstance();
        this.view = new AdicionarMesa();
        this.view.setVisible(true);

        this.view.getBtnSalvar().addActionListener((e) -> {
            addMesa();
        });
        this.view.getBtnExcluir().addActionListener((e) -> {
            excluirMesa();
        });

        carregarMesasNaTabela();
    }

    public void addMesa() {
        int numAssento = Integer.parseInt(view.getNumAssentos().getText());
        String descricao = view.getTxtDescricao().getText();

        Mesa m = new Mesa(mesas.getNextId(), numAssento, descricao);

        this.mesas.addMesas(m);

        JOptionPane.showMessageDialog(view, "Mesa salva com sucesso!");

        limparTela();
        carregarMesasNaTabela();
    }

    private void limparTela() {
        this.view.getNumAssentos().setText("");
        this.view.getTxtDescricao().setText("");
    }

    private void carregarMesasNaTabela() {
        DefaultTableModel tableModel = (DefaultTableModel) this.view.getTableMesas().getModel();
        tableModel.setRowCount(0); // Limpa a tabela

        for (Mesa mesa : mesas.getAllMesas()) {
            String status = mesa.isDisponivel() ? "Desocupada" : "Ocupada";
            Object[] row = { mesa.getId(), mesa.getCapacidade(), mesa.getDescricao(), status };
            tableModel.addRow(row);
        }
    }

    private void excluirMesa() {
        int selectedRow = this.view.getTableMesas().getSelectedRow();
        if (selectedRow >= 0) {
            int mesaId = (int) this.view.getTableMesas().getValueAt(selectedRow, 0);
            mesas.removeMesaById(mesaId);

            JOptionPane.showMessageDialog(view, "Mesa excluída com sucesso!");
            carregarMesasNaTabela();
        } else {
            JOptionPane.showMessageDialog(view, "Por favor, selecione uma mesa para excluir.");
        }
    }
}
