package controller;

import Dao.Mesas;
import Dao.Reservas;
import model.Mesa;
import model.Reserva;
import views.GerenciarReservaView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GerenciarReservaController {
    private GerenciarReservaView view;
    private Mesas mesas;
    private Reservas reservas;

    public GerenciarReservaController() {
        this.mesas = Mesas.getInstance();
        this.reservas = Reservas.getInstance();
        this.view = new GerenciarReservaView();
        this.view.setVisible(true);

        carregarMesasNaTabela();

        this.view.getBtnSelecionar().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selecionarMesa();
            }
        });

        this.view.getBtnAddPrato().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adicionarPrato();
            }
        });

        this.view.getBtnAddBebida().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adicionarBebida();
            }
        });

        this.view.getBtnEncerrar().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                encerrarPedido();
            }
        });
    }

    private void carregarMesasNaTabela() {
        DefaultTableModel tableModel = (DefaultTableModel) this.view.getTableMesas().getModel();
        tableModel.setRowCount(0); // Limpa a tabela

        for (Mesa mesa : mesas.getAllMesas()) {
            if (!mesa.isDisponivel()) { // Mostra apenas mesas ocupadas
                Object[] row = { mesa.getId(), mesa.getCapacidade(), mesa.getDescricao(), "Ocupada" };
                tableModel.addRow(row);
            }
        }
    }

    private void selecionarMesa() {
        int selectedRow = this.view.getTableMesas().getSelectedRow();
        if (selectedRow >= 0) {
            int mesaId = (int) this.view.getTableMesas().getValueAt(selectedRow, 0);
            Mesa mesa = mesas.getMesaById(mesaId);
            this.view.setMesaSelecionada(mesa);
            JOptionPane.showMessageDialog(view, "Mesa " + mesaId + " selecionada.");
        } else {
            JOptionPane.showMessageDialog(view, "Por favor, selecione uma mesa.");
        }
    }

    private void adicionarPrato() {
        Mesa mesaSelecionada = this.view.getMesaSelecionada();
        if (mesaSelecionada != null) {
            String prato = JOptionPane.showInputDialog("Digite o nome do prato:");
            // Adicione o prato à comanda da reserva
        } else {
            JOptionPane.showMessageDialog(view, "Por favor, selecione uma mesa primeiro.");
        }
    }

    private void adicionarBebida() {
        Mesa mesaSelecionada = this.view.getMesaSelecionada();
        if (mesaSelecionada != null) {
            String bebida = JOptionPane.showInputDialog("Digite o nome da bebida:");
            // Adicione a bebida à comanda da reserva
        } else {
            JOptionPane.showMessageDialog(view, "Por favor, selecione uma mesa primeiro.");
        }
    }

    private void encerrarPedido() {
        Mesa mesaSelecionada = this.view.getMesaSelecionada();
        if (mesaSelecionada != null) {
            // Calcular o total com taxa e mostrar a mensagem
            mesaSelecionada.setDisponivel(true); // Marca a mesa como desocupada
            mesas.grava(); // Atualiza o estado das mesas
            carregarMesasNaTabela(); // Atualiza a tabela
            JOptionPane.showMessageDialog(view, "Pedido encerrado e mesa desocupada.");
        } else {
            JOptionPane.showMessageDialog(view, "Por favor, selecione uma mesa primeiro.");
        }
    }
}
