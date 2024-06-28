package controller;

import Dao.Cardapio;
import Dao.Mesas;
import Dao.Reservas;
import Dao.ReservasFinalizadas;
import java.util.Iterator;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.Bebida;
import model.Mesa;
import model.Prato;
import model.Reserva;
import views.GerenciarReservaView;

public class GerenciarReservaController {
    private GerenciarReservaView view;
    private Reservas reservas;
    private ReservasFinalizadas reservasfinalizadas;
    private Mesas mesas;
    private Cardapio cardapio;

    public GerenciarReservaController() {
        this.view = new GerenciarReservaView();
        this.reservas = Reservas.getInstance();
        this.mesas = Mesas.getInstance();
        this.cardapio = Cardapio.getInstance();
        this.reservasfinalizadas = ReservasFinalizadas.getInstance();
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
            for (Prato prato : reserva.getComanda().getPratos()) {
                model.addRow(new Object[]{prato.getNome(), "Prato", prato.getPreco()});
            }
            for (Bebida bebida : reserva.getComanda().getBebidas()) {
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
            
            JList<String> listaPratos = new JList<>(opcoes);
            listaPratos.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
            JOptionPane.showMessageDialog(view, new JScrollPane(listaPratos), "Selecione os pratos", JOptionPane.PLAIN_MESSAGE);

            List<String> pratosSelecionados = listaPratos.getSelectedValuesList();
            if (!pratosSelecionados.isEmpty()) {
                for (String pratoSelecionado : pratosSelecionados) {
                    Prato prato = pratosDisponiveis.stream().filter(p -> p.getNome().equals(pratoSelecionado)).findFirst().orElse(null);
                    if (prato != null) {
                        String quantidadeStr = JOptionPane.showInputDialog(view, "Digite a quantidade para " + pratoSelecionado, "Quantidade", JOptionPane.PLAIN_MESSAGE);
                        if (quantidadeStr != null && !quantidadeStr.isEmpty()) {
                            try {
                                int quantidade = Integer.parseInt(quantidadeStr);
                                for (int i = 0; i < quantidade; i++) {
                                    reserva.getComanda().addPrato(prato);
                                }
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(view, "Quantidade inválida para " + pratoSelecionado, "Erro", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                }
                carregarItensDaReserva();
                reservas.grava();
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

            JList<String> listaBebidas = new JList<>(opcoes);
            listaBebidas.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
            JOptionPane.showMessageDialog(view, new JScrollPane(listaBebidas), "Selecione as bebidas", JOptionPane.PLAIN_MESSAGE);

            List<String> bebidasSelecionadas = listaBebidas.getSelectedValuesList();
            if (!bebidasSelecionadas.isEmpty()) {
                for (String bebidaSelecionada : bebidasSelecionadas) {
                    Bebida bebida = bebidasDisponiveis.stream().filter(b -> b.getNome().equals(bebidaSelecionada)).findFirst().orElse(null);
                    if (bebida != null) {
                        String quantidadeStr = JOptionPane.showInputDialog(view, "Digite a quantidade para " + bebidaSelecionada, "Quantidade", JOptionPane.PLAIN_MESSAGE);
                        if (quantidadeStr != null && !quantidadeStr.isEmpty()) {
                            try {
                                int quantidade = Integer.parseInt(quantidadeStr);
                                for (int i = 0; i < quantidade; i++) {
                                    reserva.getComanda().addBebida(bebida);
                                }
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(view, "Quantidade inválida para " + bebidaSelecionada, "Erro", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                }
                carregarItensDaReserva();
                reservas.grava();
            }
        } else {
            JOptionPane.showMessageDialog(view, "Por favor, selecione uma reserva primeiro.");
        }
    }

    private void removerItem() {
        int selectedRow = this.view.getTableItens().getSelectedRow();
        if (selectedRow >= 0) {
            int reservaRow = this.view.getTableReservas().getSelectedRow();
            String nomeCliente = (String) this.view.getTableReservas().getValueAt(reservaRow, 0);
            Reserva reserva = reservas.getReservaPorNomeCliente(nomeCliente);
            String nomeItem = (String) this.view.getTableItens().getValueAt(selectedRow, 0);
            String itemTipo = (String) this.view.getTableItens().getValueAt(selectedRow, 1);

            if (itemTipo.equals("Prato")) {
                Iterator<Prato> iterator = reserva.getComanda().getPratos().iterator();
                while (iterator.hasNext()) {
                    Prato prato = iterator.next();
                    if (prato.getNome().equals(nomeItem)) {
                        iterator.remove();
                        break;
                    }
                }
            } else if (itemTipo.equals("Bebida")) {
                Iterator<Bebida> iterator = reserva.getComanda().getBebidas().iterator();
                while (iterator.hasNext()) {
                    Bebida bebida = iterator.next();
                    if (bebida.getNome().equals(nomeItem)) {
                        iterator.remove();
                        break;
                    }
                }
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

            String [] opcoesPagemento = {"Crédito", "Débito", "Pix", "Dinheiro"};
            String formadePagamento = (String) JOptionPane.showInputDialog(view, "Selecione uma forma de pagamento", "Forma de pagamento", JOptionPane.PLAIN_MESSAGE, null, opcoesPagemento, opcoesPagemento[0]);
            reserva.getComanda().setFormaPag(formadePagamento);

            JOptionPane.showMessageDialog(view, String.format("Valor total: R$ %.2f\nValor por pessoa: R$ %.2f", total, totalPorPessoa));
            reservasfinalizadas.addReserva(reserva);

            mesa.setDisponivel(true); 
            reservas.removeReserva(reserva);
            mesas.grava(); 
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
