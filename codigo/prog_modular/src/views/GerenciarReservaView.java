package views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class GerenciarReservaView extends JFrame {
    private JTable tableMesas;
    private JButton btnSelecionar;
    private JButton btnAddPrato;
    private JButton btnAddBebida;
    private JButton btnEncerrar;

    public GerenciarReservaView() {
        setTitle("Gerenciar Reservas");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        getContentPane().add(panel);

        tableMesas = new JTable();
        tableMesas.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] { "ID", "Capacidade", "Descrição", "Status" }
        ));
        JScrollPane scrollPane = new JScrollPane(tableMesas);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        btnSelecionar = new JButton("Selecionar Mesa");
        buttonPanel.add(btnSelecionar);

        btnAddPrato = new JButton("Adicionar Prato");
        buttonPanel.add(btnAddPrato);

        btnAddBebida = new JButton("Adicionar Bebida");
        buttonPanel.add(btnAddBebida);

        btnEncerrar = new JButton("Encerrar Pedido");
        buttonPanel.add(btnEncerrar);

        panel.add(buttonPanel, BorderLayout.SOUTH);
    }

    public JTable getTableMesas() {
        return tableMesas;
    }

    public JButton getBtnSelecionar() {
        return btnSelecionar;
    }

    public JButton getBtnAddPrato() {
        return btnAddPrato;
    }

    public JButton getBtnAddBebida() {
        return btnAddBebida;
    }

    public JButton getBtnEncerrar() {
        return btnEncerrar;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                GerenciarReservaView frame = new GerenciarReservaView();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
