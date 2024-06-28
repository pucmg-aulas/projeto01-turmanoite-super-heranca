package views;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout.Alignment;

public class GerenciarMesaView extends JFrame {
    private JTable tableMesas;
    private JButton btnGerenciar;

    public GerenciarMesaView() {
        setTitle("Gerenciar Mesas");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 400);
        setLocationRelativeTo(null);

        JLabel lblTitulo = new JLabel("Gerenciar Mesas");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));

        tableMesas = new JTable();
        tableMesas.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] { "ID", "Capacidade", "Descrição", "Disponibilidade" }
        ));
        JScrollPane scrollPane = new JScrollPane(tableMesas);

        btnGerenciar = new JButton("Gerenciar");
        btnGerenciar.setFont(new Font("Tahoma", Font.PLAIN, 14));

        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                        .addComponent(lblTitulo)
                        .addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
                            .addGap(0, 354, Short.MAX_VALUE)
                            .addComponent(btnGerenciar, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap())
        );
        groupLayout.setVerticalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblTitulo)
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addComponent(btnGerenciar)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        getContentPane().setLayout(groupLayout);
    }

    public JTable getTableMesas() {
        return tableMesas;
    }

    public JButton getBtnGerenciar() {
        return btnGerenciar;
    }
}
