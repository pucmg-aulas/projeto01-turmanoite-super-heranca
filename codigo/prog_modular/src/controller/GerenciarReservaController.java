package controller;

import Dao.Cardapio;
import Dao.Mesas;
import Dao.Reservas;
import model.Reserva;
import model.Mesa;
import views.GerenciarReservaView;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import model.Bebida;
import model.Prato;

public class GerenciarReservaController {
    private GerenciarReservaView view;
    private Reservas reservas;
    private Mesas mesas;
    private Cardapio cardapio;

    public GerenciarReservaController() {
        this.view = new GerenciarReservaView();
        this.reservas = Reservas.getInstance();
        this.mesas = Mesas.getInstance();
        this.cardapio = Cardapio.getInstance();
        initController();
        carregarReservasNaTabela();
    }

    private void initController() {
        this.view.getBtnAdicionarPrato().addActionListener(e -> adicionarPrato());
        this.view.getBtnAdicionarBebida().addActionListener(e -> adicionarBebida());
        this.view.getBtnRemoverItem().addActionListener(e -> removerItem());
        this.view.getBtnFinalizarReserva().addActionListener(e -> finalizarReserva());
        this.view.getTableReservas().getSelectionModel().addListSelectionListener(e -> carregarItensDaReserva());
        this.view.setVisible(true);
    }

    private void carregarReservasNaTabela() {
        DefaultTableModel model = (DefaultTableModel) this.view.getTableReservas().getModel();
        model.setRowCount(0); // Limpa a tabela
        for (Reserva reserva : reservas.getReservas()) {
            if (!reserva.getMesa().isDisponivel()) {
                model.addRow(new Object[]{
                    reserva.getProprietario().getNome(),
                    reserva.getMesa().getId(),
                    reserva.getDataHora().toString()
                });
            }
        }
    }

    private void carregarItensDaReserva() {
        int selectedRow = this.view.getTableReservas().getSelectedRow();
        if (selectedRow >= 0) {
            String nomeCliente = (String) this.view.getTableReservas().getValueAt(selectedRow, 0);
            Reserva reserva = reservas.getReservaPorNomeCliente(nomeCliente);
            DefaultTableModel model = (DefaultTableModel) this.view.getTableItens().getModel();
            model.setRowCount(0); // Limpa a tabela
            for (var prato : reserva.getComanda().getPratos()) {
                model.addRow(new Object[]{prato.getNome(), "Prato", prato.getPreco()});
            }
            for (var bebida : reserva.getComanda().getBebidas()) {
                model.addRow(new Object[]{bebida.getNome(), "Bebida", bebida.getPreco()});
            }
        }
    }

    private void adicionarPrato() {
        int selectedRow = this.view.getTableReservas().getSelectedRow();
        if (selectedRow >= 0) {
            String nomeCliente = (String) this.view.getTableReservas().getValueAt(selectedRow, 0);
            Reserva reserva = reservas.getReservaPorNomeCliente(nomeCliente);

            List<Prato> pratosDisponiveis = cardapio.getPratos();
            String[] opcoes = pratosDisponiveis.stream().map(Prato::getNome).toArray(String[]::new);
            String pratoSelecionado = (String) JOptionPane.showInputDialog(view, "Selecione um prato", "Adicionar Prato", JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

            if (pratoSelecionado != null) {
                Prato prato = pratosDisponiveis.stream().filter(p -> p.getNome().equals(pratoSelecionado)).findFirst().orElse(null);
                if (prato != null) {
                    reserva.getComanda().addPrato(prato);
                    carregarItensDaReserva();
                    reservas.grava();
                }
            }
        } else {
            JOptionPane.showMessageDialog(view, "Por favor, selecione uma reserva primeiro.");
        }
    }

    private void adicionarBebida() {
        int selectedRow = this.view.getTableReservas().getSelectedRow();
        if (selectedRow >= 0) {
            String nomeCliente = (String) this.view.getTableReservas().getValueAt(selectedRow, 0);
            Reserva reserva = reservas.getReservaPorNomeCliente(nomeCliente);

            List<Bebida> bebidasDisponiveis = cardapio.getBebidas();
            String[] opcoes = bebidasDisponiveis.stream().map(Bebida::getNome).toArray(String[]::new);
            String bebidaSelecionada = (String) JOptionPane.showInputDialog(view, "Selecione uma bebida", "Adicionar Bebida", JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

            if (bebidaSelecionada != null) {
                Bebida bebida = bebidasDisponiveis.stream().filter(b -> b.getNome().equals(bebidaSelecionada)).findFirst().orElse(null);
                if (bebida != null) {
                    reserva.getComanda().addBebida(bebida);
                    carregarItensDaReserva();
                    reservas.grava();
                }
            }
        } else {
            JOptionPane.showMessageDialog(view, "Por favor, selecione uma reserva primeiro.");
        }
    }

    private void removerItem() {
        int selectedRow = this.view.getTableItens().getSelectedRow();
        if (selectedRow >= 0) {
            String itemNome = (String) this.view.getTableItens().getValueAt(selectedRow, 0);
            String itemTipo = (String) this.view.getTableItens().getValueAt(selectedRow, 1);
            int reservaRow = this.view.getTableReservas().getSelectedRow();
            String nomeCliente = (String) this.view.getTableReservas().getValueAt(reservaRow, 0);
            Reserva reserva = reservas.getReservaPorNomeCliente(nomeCliente);

            if (itemTipo.equals("Prato")) {
                reserva.getComanda().getPratos().removeIf(prato -> prato.getNome().equals(itemNome));
            } else if (itemTipo.equals("Bebida")) {
                reserva.getComanda().getBebidas().removeIf(bebida -> bebida.getNome().equals(itemNome));
            }

            carregarItensDaReserva();
            reservas.grava();
        } else {
            JOptionPane.showMessageDialog(view, "Por favor, selecione um item para remover.");
        }
    }

    private void finalizarReserva() {
        int selectedRow = this.view.getTableReservas().getSelectedRow();
        if (selectedRow >= 0) {
            String nomeCliente = (String) this.view.getTableReservas().getValueAt(selectedRow, 0);
            Reserva reserva = reservas.getReservaPorNomeCliente(nomeCliente);
            Mesa mesa = reserva.getMesa();

            double total = reserva.getComanda().calcularTotalComTaxa();
            int numPessoas = reserva.getProprietario().getQtdPessoas();
            double totalPorPessoa = total / numPessoas;

            JOptionPane.showMessageDialog(view, String.format("Valor total: R$ %.2f\nValor por pessoa: R$ %.2f", total, totalPorPessoa));

            mesa.setDisponivel(true); // Marca a mesa como desocupada
            reservas.removeReserva(reserva);
            mesas.grava(); // Grava o estado das mesas

            JOptionPane.showMessageDialog(view, "Reserva finalizada com sucesso!");
            carregarReservasNaTabela();
            limparTabelaItens();
        } else {
            JOptionPane.showMessageDialog(view, "Por favor, selecione uma reserva para finalizar.");
        }
    }

    private void limparTabelaItens() {
        DefaultTableModel model = (DefaultTableModel) this.view.getTableItens().getModel();
        model.setRowCount(0);
    }
}
