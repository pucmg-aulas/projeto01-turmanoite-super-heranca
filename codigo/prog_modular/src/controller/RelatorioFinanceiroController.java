package controller;

import Dao.ReservasFinalizadas;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Reserva;
import views.RelatorioFinanceiro;

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
            CalcularTotal();
            calcularTotalRecebido(reservasFiltradas);
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

    public void CalcularTotal() {
        double valorTotal = 0;
        for (int i = 0; i < this.view.getTableRel().getRowCount(); i++) {
            valorTotal += Double.parseDouble(this.view.getTableRel().getValueAt(i, 3).toString());
        }
        this.view.getLblValorTotal().setText(String.format("%.2f", valorTotal));
    }

    public void calcularTotalRecebido(List<Reserva> reservas){
        double[] totalRecebido = {0};
        double[] total14Dias = {0};
        double[] total30Dias = {0};
        LocalDateTime dataAtual = LocalDateTime.now();

        reservas.forEach(reserva -> {
            if (reserva.getComanda().getFormaPag().equals("Pix")) {
                totalRecebido[0] += calcularTotalComDesconto(reserva);
            } else if (reserva.getComanda().getFormaPag().equals("Dinheiro")) {
                totalRecebido[0] += reserva.getComanda().calcularTotalComTaxa();
            }else if (reserva.getComanda().getFormaPag().equals("Débito")) {
                total14Dias[0] += reserva.getComanda().calcularTotalComTaxa();
            } else if (reserva.getComanda().getFormaPag().equals("Crédito")) {
                total30Dias[0] += reserva.getComanda().calcularTotalComTaxa();
            } else {
                totalRecebido[0] += calcularTotalComDesconto(reserva);
            }
        });

        this.view.getLblValorRecebido().setText(String.format("%.2f", totalRecebido[0]));
        this.view.getLbl14Dias().setText(String.format("%.2f", total14Dias[0]));
        this.view.getLbl30Dias().setText(String.format("%.2f", total30Dias[0]));
    }

    public double calcularTotalComDesconto(Reserva reserva){
        return reserva.getComanda().calcularTotalComTaxa();
    }
}
