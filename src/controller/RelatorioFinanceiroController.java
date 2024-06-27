package controller;

import Dao.ReservasFinalizadas;
import model.Reserva;
import views.RelatorioFinanceiro;

import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class RelatorioFinanceiroController {

    private RelatorioFinanceiro view;
    private ReservasFinalizadas reservasfinalizadas;

    public RelatorioFinanceiroController() {
        this.reservasfinalizadas = ReservasFinalizadas.getInstance();
        this.view = new RelatorioFinanceiro();
        this.view.setVisible(true);
        initController();
    }

    private void initController() {
        this.view.getBtnBuscar().addActionListener(e -> buscarRelatorio());
    }

    private void buscarRelatorio() {
        String dataInicioStr = this.view.getTxtDataInicio().getText();
        String dataFimStr = this.view.getTxtDataFim().getText();

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        formatter.setLenient(false);
        try {
            Date dataInicio = formatter.parse(dataInicioStr);
            Date dataFim = formatter.parse(dataFimStr);

            if (dataInicio.after(dataFim)) {
                JOptionPane.showMessageDialog(view, "Data Início não pode ser após Data Final.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            List<Reserva> reservasFiltradas = reservasfinalizadas.getReservasFinalizadas().stream()
                .filter(reserva -> !reserva.getDataHora().toLocalDate().isBefore(dataInicio.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate()) &&
                                   !reserva.getDataHora().toLocalDate().isAfter(dataFim.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate()))
                .collect(Collectors.toList());

            imprimirDados(reservasFiltradas);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(view, "Formato de data inválido. Use dd/MM/yyyy.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void imprimirDados(List<Reserva> reservas) {
        String[] columnNames = {"Nome do Cliente", "Mesa", "Data/Hora", "Valor Total"};

        DefaultTableModel tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableModel.setColumnIdentifiers(columnNames);
        reservas.forEach(reserva -> {
            tableModel.addRow(new Object[]{
                reserva.getProprietario().getNome(),
                reserva.getMesa().getId(),
                reserva.getDataHora().toString(),
                String.format("%.2f", reserva.getComanda().calcularTotalComTaxa())
            });
        });

        this.view.getTableRel().setModel(tableModel);
    }
}
