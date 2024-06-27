package controller;

import Dao.Mesas;
import Dao.Reservas;
import model.Reserva;
import model.Mesa;
import model.Prato;
import model.Bebida;
import views.GerenciarReservaView;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GerenciarReservaController {
    private GerenciarReservaView view;
    private Reservas reservas;
    private Mesas mesas;

    public GerenciarReservaController() {
        this.view = new GerenciarReservaView();
        this.reservas = Reservas.getInstance();
        this.mesas = Mesas.getInstance();
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

            String[] pratos = {"Moqueca de Tilápia", "Falafel Assado", "Salada Primavera com Macarrão Konjac", "Escondidinho de Frango", "Strogonoff", "Caçarola de carne com legumes"};
            double[] precos = {45.00, 30.00, 25.00, 35.00, 40.00, 50.00};
            String pratoEscolhido = (String) JOptionPane.showInputDialog(view, "Escolha o prato:", "Adicionar Prato", JOptionPane.QUESTION_MESSAGE, null, pratos, pratos[0]);

            if (pratoEscolhido != null) {
                for (int i = 0; i < pratos.length; i++) {
                    if (pratoEscolhido.equals(pratos[i])) {
                        Prato prato = new Prato(pratoEscolhido, precos[i]);
                        reserva.getComanda().addPrato(prato);
                        break;
                    }
                }
            }

            carregarItensDaReserva();
            reservas.grava();
        } else {
            JOptionPane.showMessageDialog(view, "Por favor, selecione uma reserva primeiro.");
        }
    }

    private void adicionarBebida() {
        int selectedRow = this.view.getTableReservas().getSelectedRow();
        if (selectedRow >= 0) {
            String nomeCliente = (String) this.view.getTableReservas().getValueAt(selectedRow, 0);
            Reserva reserva = reservas.getReservaPorNomeCliente(nomeCliente);

            String[] bebidas = {"Água", "Suco", "Refrigerante", "Cerveja", "Taça de vinho"};
            double[] precos = {5.00, 10.00, 7.00, 12.00, 15.00};
            String bebidaEscolhida = (String) JOptionPane.showInputDialog(view, "Escolha a bebida:", "Adicionar Bebida", JOptionPane.QUESTION_MESSAGE, null, bebidas, bebidas[0]);

            if (bebidaEscolhida != null) {
                for (int i = 0; i < bebidas.length; i++) {
                    if (bebidaEscolhida.equals(bebidas[i])) {
                        Bebida bebida = new Bebida(bebidaEscolhida, precos[i]);
                        reserva.getComanda().addBebida(bebida);
                        break;
                    }
                }
            }

            carregarItensDaReserva();
            reservas.grava();
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
                reserva.getComanda().removePrato(itemNome);
            } else if (itemTipo.equals("Bebida")) {
                reserva.getComanda().removeBebida(itemNome);
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

            mesa.setDisponivel(true); // Marca a mesa como desocupada

            // Calcula o total da comanda com taxa de serviço
            double total = reserva.getComanda().calcularTotal();
            double totalComTaxa = reserva.getComanda().calcularTotalComTaxa();
            double valorPorPessoa = totalComTaxa / reserva.getProprietario().getQtdPessoas();

            // Remove a reserva e grava as alterações
            reservas.removeReserva(reserva);
            mesas.grava();

            // Limpa a tabela de itens
            DefaultTableModel model = (DefaultTableModel) this.view.getTableItens().getModel();
            model.setRowCount(0);

            // Exibe a mensagem com os valores calculados
            JOptionPane.showMessageDialog(view, String.format(
                "Reserva finalizada com sucesso!\n\nTotal: R$ %.2f\nTotal com taxa de serviço: R$ %.2f\nValor por pessoa: R$ %.2f",
                total, totalComTaxa, valorPorPessoa
            ));

            carregarReservasNaTabela();
        } else {
            JOptionPane.showMessageDialog(view, "Por favor, selecione uma reserva para finalizar.");
        }
    }
}
