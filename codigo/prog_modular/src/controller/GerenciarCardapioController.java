package controller;

import Dao.Cardapio;
import model.Bebida;
import model.Prato;
import views.GerenciarCardapioView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GerenciarCardapioController {
    private GerenciarCardapioView view;
    private Cardapio cardapio;

    public GerenciarCardapioController() {
        this.view = new GerenciarCardapioView();
        this.cardapio = Cardapio.getInstance();
        initController();
        carregarCardapio();
    }

    private void initController() {
        this.view.getBtnAdicionarPrato().addActionListener(e -> adicionarPrato());
        this.view.getBtnRemoverPrato().addActionListener(e -> removerPrato());
        this.view.getBtnAdicionarBebida().addActionListener(e -> adicionarBebida());
        this.view.getBtnRemoverBebida().addActionListener(e -> removerBebida());
        this.view.setVisible(true);
    }

    private void carregarCardapio() {
        carregarPratos();
        carregarBebidas();
    }

    private void carregarPratos() {
        DefaultTableModel model = (DefaultTableModel) this.view.getTablePratos().getModel();
        model.setRowCount(0); // Limpa a tabela
        for (Prato prato : cardapio.getPratos()) {
            model.addRow(new Object[]{prato.getNome(), prato.getPreco()});
        }
    }

    private void carregarBebidas() {
        DefaultTableModel model = (DefaultTableModel) this.view.getTableBebidas().getModel();
        model.setRowCount(0); // Limpa a tabela
        for (Bebida bebida : cardapio.getBebidas()) {
            model.addRow(new Object[]{bebida.getNome(), bebida.getPreco()});
        }
    }

    private void adicionarPrato() {
        String nome = JOptionPane.showInputDialog("Nome do Prato:");
        if (nome == null || nome.trim().isEmpty()) {
            return;
        }

        String precoStr = JOptionPane.showInputDialog("Preço do Prato:");
        if (precoStr == null || precoStr.trim().isEmpty()) {
            return;
        }

        double preco;
        try {
            preco = Double.parseDouble(precoStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view, "Preço inválido.");
            return;
        }

        Prato prato = new Prato(nome, preco);
        cardapio.adicionarPrato(prato);
        cardapio.gravaCardapio();
        carregarPratos();
    }

    private void removerPrato() {
        int selectedRow = this.view.getTablePratos().getSelectedRow();
        if (selectedRow >= 0) {
            String nomePrato = (String) this.view.getTablePratos().getValueAt(selectedRow, 0);
            cardapio.removerPrato(nomePrato);
            cardapio.gravaCardapio();
            carregarPratos();
        } else {
            JOptionPane.showMessageDialog(view, "Por favor, selecione um prato para remover.");
        }
    }

    private void adicionarBebida() {
        String nome = JOptionPane.showInputDialog("Nome da Bebida:");
        if (nome == null || nome.trim().isEmpty()) {
            return;
        }

        String precoStr = JOptionPane.showInputDialog("Preço da Bebida:");
        if (precoStr == null || precoStr.trim().isEmpty()) {
            return;
        }

        double preco;
        try {
            preco = Double.parseDouble(precoStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view, "Preço inválido.");
            return;
        }

        Bebida bebida = new Bebida(nome, preco);
        cardapio.adicionarBebida(bebida);
        cardapio.gravaCardapio();
        carregarBebidas();
    }

    private void removerBebida() {
        int selectedRow = this.view.getTableBebidas().getSelectedRow();
        if (selectedRow >= 0) {
            String nomeBebida = (String) this.view.getTableBebidas().getValueAt(selectedRow, 0);
            cardapio.removerBebida(nomeBebida);
            cardapio.gravaCardapio();
            carregarBebidas();
        } else {
            JOptionPane.showMessageDialog(view, "Por favor, selecione uma bebida para remover.");
        }
    }
}
