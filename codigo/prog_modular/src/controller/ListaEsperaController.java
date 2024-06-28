package controller;

import Dao.ListaEspera;
import model.ClienteListaEspera;
import views.ListaEsperaView;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ListaEsperaController {

    private ListaEsperaView view;
    private ListaEspera listaEspera;

    public ListaEsperaController() {
        this.listaEspera = ListaEspera.getInstance();
        this.view = new ListaEsperaView();
        this.view.setVisible(true);

        this.view.getBtnAdicionar().addActionListener((e) -> {
            adicionarCliente();
        });
        this.view.getBtnRemover().addActionListener((e) -> {
            removerCliente();
        });

        carregarClientesNaTabela();
    }

    public void adicionarCliente() {
        String nome = view.getTxtNomeCliente().getText();
        String telefone = view.getTxtTelefone().getText();
        int qtdPessoas = Integer.parseInt(view.getTxtQtdPessoas().getText());

        ClienteListaEspera cliente = new ClienteListaEspera(nome, telefone, qtdPessoas);

        this.listaEspera.adicionarCliente(cliente);

        JOptionPane.showMessageDialog(view, "Cliente adicionado à lista de espera com sucesso!");

        limparTela();
        carregarClientesNaTabela();
    }

    private void removerCliente() {
        int selectedRow = this.view.getTableClientes().getSelectedRow();
        if (selectedRow >= 0) {
            listaEspera.removerClientePorIndex(selectedRow);

            JOptionPane.showMessageDialog(view, "Cliente removido da lista de espera com sucesso!");
            carregarClientesNaTabela();
        } else {
            JOptionPane.showMessageDialog(view, "Por favor, selecione um cliente para remover.");
        }
    }

    private void limparTela() {
        this.view.getTxtNomeCliente().setText("");
        this.view.getTxtTelefone().setText("");
        this.view.getTxtQtdPessoas().setText("");
    }

    private void carregarClientesNaTabela() {
        DefaultTableModel tableModel = (DefaultTableModel) this.view.getTableClientes().getModel();
        tableModel.setRowCount(0); // Limpa a tabela

        for (ClienteListaEspera cliente : listaEspera.getClientes()) {
            Object[] row = { cliente.getNome(), cliente.getTelefone(), cliente.getQtdPessoas(), cliente.getDataHoraEntrada().toString() };
            tableModel.addRow(row);
        }
    }
}
