package views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class GerenciarCardapioView extends JFrame {
    private JTable tablePratos;
    private JTable tableBebidas;
    private JButton btnAdicionarPrato;
    private JButton btnAdicionarBebida;
    private JButton btnRemoverPrato;
    private JButton btnRemoverBebida;

    public GerenciarCardapioView() {
        setTitle("Gerenciar Cardápio");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel lblPratos = new JLabel("Pratos");
        lblPratos.setFont(new Font("Tahoma", Font.BOLD, 14));

        JScrollPane scrollPanePratos = new JScrollPane();
        tablePratos = new JTable();
        tablePratos.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Nome", "Preço"}
        ));
        scrollPanePratos.setViewportView(tablePratos);

        btnAdicionarPrato = new JButton("Adicionar Prato");
        btnRemoverPrato = new JButton("Remover Prato");

        JLabel lblBebidas = new JLabel("Bebidas");
        lblBebidas.setFont(new Font("Tahoma", Font.BOLD, 14));

        JScrollPane scrollPaneBebidas = new JScrollPane();
        tableBebidas = new JTable();
        tableBebidas.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Nome", "Preço"}
        ));
        scrollPaneBebidas.setViewportView(tableBebidas);

        btnAdicionarBebida = new JButton("Adicionar Bebida");
        btnRemoverBebida = new JButton("Remover Bebida");

        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(lblPratos)
                                        .addComponent(scrollPanePratos, GroupLayout.PREFERRED_SIZE, 760, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addComponent(btnAdicionarPrato)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnRemoverPrato)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(groupLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(lblBebidas)
                                        .addComponent(scrollPaneBebidas, GroupLayout.PREFERRED_SIZE, 760, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addComponent(btnAdicionarBebida)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnRemoverBebida)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblPratos)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scrollPanePratos, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnAdicionarPrato)
                                        .addComponent(btnRemoverPrato))
                                .addGap(18)
                                .addComponent(lblBebidas)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scrollPaneBebidas, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnAdicionarBebida)
                                        .addComponent(btnRemoverBebida))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        getContentPane().setLayout(groupLayout);

        pack();
    }

    public JTable getTablePratos() {
        return tablePratos;
    }

    public JTable getTableBebidas() {
        return tableBebidas;
    }

    public JButton getBtnAdicionarPrato() {
        return btnAdicionarPrato;
    }

    public JButton getBtnRemoverPrato() {
        return btnRemoverPrato;
    }

    public JButton getBtnAdicionarBebida() {
        return btnAdicionarBebida;
    }

    public JButton getBtnRemoverBebida() {
        return btnRemoverBebida;
    }
}
