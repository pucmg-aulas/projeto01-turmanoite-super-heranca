package views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class RelatorioFinanceiro extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtDataInicio;
    private JTextField txtDataFim;
    private JTable tabRelatorio;
    private JButton btnBuscar;
    private JLabel lblFormatoData;

    public RelatorioFinanceiro() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 600, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblDataInicio = new JLabel("Data Início (dd/MM/yyyy):");
        txtDataInicio = new JTextField();
        txtDataInicio.setColumns(10);

        JLabel lblDataFim = new JLabel("Data Final (dd/MM/yyyy):");
        txtDataFim = new JTextField();
        txtDataFim.setColumns(10);

        btnBuscar = new JButton("Buscar");

        tabRelatorio = new JTable();
        JScrollPane scrollPane = new JScrollPane(tabRelatorio);

        lblFormatoData = new JLabel("Formato de data: dd/MM/yyyy");
        lblFormatoData.setForeground(Color.RED);

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
            gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(lblDataInicio)
                                .addComponent(txtDataInicio, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                            .addGap(30)
                            .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(gl_contentPane.createSequentialGroup()
                                    .addComponent(txtDataFim, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                                    .addComponent(btnBuscar))
                                .addComponent(lblDataFim)))
                        .addComponent(lblFormatoData))
                    .addContainerGap())
        );
        gl_contentPane.setVerticalGroup(
            gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblDataInicio)
                        .addComponent(lblDataFim))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDataInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDataFim, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscar))
                    .addGap(18)
                    .addComponent(lblFormatoData)
                    .addGap(18)
                    .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                    .addContainerGap())
        );
        contentPane.setLayout(gl_contentPane);
    }

    public JTextField getTxtDataInicio() {
        return txtDataInicio;
    }

    public JTextField getTxtDataFim() {
        return txtDataFim;
    }

    public JTable getTableRel() {
        return tabRelatorio;
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }
}
