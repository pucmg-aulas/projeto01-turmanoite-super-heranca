package views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class GerenciarReservaView extends JFrame {
    private JTable tableReservas;
    private JTable tableItens;
    private JButton btnAdicionarPrato;
    private JButton btnAdicionarBebida;
    private JButton btnRemoverItem;
    private JButton btnFinalizarReserva;

    public GerenciarReservaView() {
        setTitle("Gerenciar Reservas");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel lblReservas = new JLabel("Reservas");
        lblReservas.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        JScrollPane scrollPaneReservas = new JScrollPane();
        tableReservas = new JTable();
        tableReservas.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] { "Cliente", "Mesa", "Data/Hora" }
        ));
        scrollPaneReservas.setViewportView(tableReservas);

        JLabel lblItens = new JLabel("Itens da Reserva");
        lblItens.setFont(new Font("Tahoma", Font.BOLD, 14));

        JScrollPane scrollPaneItens = new JScrollPane();
        tableItens = new JTable();
        tableItens.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] { "Nome", "Tipo", "Preço" }
        ));
        scrollPaneItens.setViewportView(tableItens);

        btnAdicionarPrato = new JButton("Adicionar Prato");
        btnAdicionarBebida = new JButton("Adicionar Bebida");
        btnRemoverItem = new JButton("Remover Item");
        btnFinalizarReserva = new JButton("Finalizar Reserva");

        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
            groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(lblReservas)
                        .addComponent(scrollPaneReservas, GroupLayout.PREFERRED_SIZE, 560, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblItens)
                        .addComponent(scrollPaneItens, GroupLayout.PREFERRED_SIZE, 560, GroupLayout.PREFERRED_SIZE)
                        .addGroup(groupLayout.createSequentialGroup()
                            .addComponent(btnAdicionarPrato)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnAdicionarBebida)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnRemoverItem)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnFinalizarReserva)))
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
            groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblReservas)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(scrollPaneReservas, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(lblItens)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(scrollPaneItens, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAdicionarPrato)
                        .addComponent(btnAdicionarBebida)
                        .addComponent(btnRemoverItem)
                        .addComponent(btnFinalizarReserva))
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        getContentPane().setLayout(groupLayout);

        pack();
    }

    public JTable getTableReservas() {
        return tableReservas;
    }

    public JTable getTableItens() {
        return tableItens;
    }

    public JButton getBtnAdicionarPrato() {
        return btnAdicionarPrato;
    }

    public JButton getBtnAdicionarBebida() {
        return btnAdicionarBebida;
    }

    public JButton getBtnRemoverItem() {
        return btnRemoverItem;
    }

    public JButton getBtnFinalizarReserva() {
        return btnFinalizarReserva;
    }
}
