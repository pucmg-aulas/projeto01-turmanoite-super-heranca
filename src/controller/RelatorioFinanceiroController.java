package controller;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.table.DefaultTableModel;

import Dao.Reservas;
import model.Reserva;
import views.NovaReserva;
import views.RelatorioFinanceiro;
import Dao.ReservasFinalizadas;

public class RelatorioFinanceiroController {
	
	
	private RelatorioFinanceiro view;
	private ReservasFinalizadas reservasfinalizadas;
	
	public RelatorioFinanceiroController() {
		this.reservasfinalizadas = ReservasFinalizadas.getInstance();
		this.view = new RelatorioFinanceiro();
		this.view.setVisible(true);
		preencherDados();
	}
	
	private void preencherDados() {
		imprimirDados(this.reservasfinalizadas.getReservasFinalizadas());
	}
	
	public void imprimirDados(List<Reserva> reservas) {
        String[] columnNames = {"Id", "Data Inicio", "Data Fim", "Valor"};

        DefaultTableModel tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableModel.setColumnIdentifiers(columnNames);
        reservas.forEach(reserva -> {
            tableModel.addRow(new String[]{String.valueOf(reserva.getProprietario().getNome()), String.valueOf(reserva.getProprietario().getNome()), reserva.getProprietario().getNome(), 
            		reserva.getProprietario().getNome()});
        });

        this.view.getTableRel().setModel(tableModel);
    }
	
	public static void calcularRecebimentos(List<Reserva> reservas, LocalDateTime data) {
        double totalVendas = 0;
        double totalReceberImediato = 0;
        double totalReceberFuturo14 = 0;
        double totalReceberFuturo30 = 0;

        List<Reserva> reservasPeriodo = reservas.stream().filter(reserva -> reserva.getDataHora().equals(data))
                .collect(Collectors.toList());

        reservasPeriodo.forEach(reserva -> {
            totalVendas = reserva.getComanda().calcularTotalComTaxa();
            double valorComanda = reserva.getComanda().calcularTotalComTaxa();
            double valorRecebido = 0;
            int prazo = 0;

            switch (reserva.getComanda().getFormaPag().toLowerCase()) {
                case "dinheiro" -> {
                    valorRecebido = valorComanda;
                    prazo = 0;
                }
                case "pix" -> {
                    valorRecebido = valorComanda * 0.9855;
                    if (valorRecebido > valorComanda - 10) {
                        valorRecebido = valorComanda - 10;
                    }
                    prazo = 0;
                }
                case "débito" -> {
                    valorRecebido = valorComanda * 0.986;
                    prazo = 14;
                }
                case "crédito" -> {
                    valorRecebido = valorComanda * 0.969;
                    prazo = 30;
                }
            }

            if (prazo == 0) {
                // totalReceberImediato += valorRecebido;
            } else {
                // totalReceberFuturo += valorRecebido;
            }
        });
    }
}
