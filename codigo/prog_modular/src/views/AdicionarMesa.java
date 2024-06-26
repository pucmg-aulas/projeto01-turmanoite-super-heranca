package views;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

public class AdicionarMesa extends javax.swing.JFrame {
    private JButton btnSalvar;
    private JButton btnExcluir;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel txtTitle;
    private JTextField numAssentos;
    private JTextField txtDescricao;
    private JTable tableMesas;

    public AdicionarMesa() {
        initComponents();
    }

    public JButton getBtnSalvar() {
        return btnSalvar;
    }

    public void setBtnSalvar(JButton btnSalvar) {
        this.btnSalvar = btnSalvar;
    }

    public JButton getBtnExcluir() {
        return btnExcluir;
    }

    public JTextField getNumAssentos() {
        return numAssentos;
    }

    public void setNumAssentos(JTextField numAssentos) {
        this.numAssentos = numAssentos;
    }

    public JTextField getTxtDescricao() {
        return txtDescricao;
    }

    public void setTxtDescricao(JTextField txtDescricao) {
        this.txtDescricao = txtDescricao;
    }

    public JLabel getTxtTitle() {
        return txtTitle;
    }

    public void setTxtTitle(JLabel txtTitle) {
        this.txtTitle = txtTitle;
    }

    public JTable getTableMesas() {
        return tableMesas;
    }

    private void initComponents() {
        txtTitle = new JLabel("Adicionar Mesa");
        txtTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
        
        jLabel2 = new JLabel("Número de assentos");
        jLabel2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        jLabel3 = new JLabel("Descrição");
        jLabel3.setFont(new Font("Tahoma", Font.PLAIN, 14));

        numAssentos = new JTextField();
        numAssentos.setFont(new Font("Tahoma", Font.PLAIN, 14));
        numAssentos.setColumns(10);
        
        txtDescricao = new JTextField();
        txtDescricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtDescricao.setColumns(10);
        
        btnSalvar = new JButton("Salvar");
        btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        btnExcluir = new JButton("Excluir");
        btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 14));

        tableMesas = new JTable();
        tableMesas.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] {"ID", "Capacidade", "Descrição"}
        ));
        JScrollPane scrollPane = new JScrollPane(tableMesas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(Alignment.LEADING)
                        .addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                        .addComponent(txtDescricao, Alignment.TRAILING, 430, 430, 430)
                        .addComponent(numAssentos, Alignment.TRAILING, 430, 430, 430)
                        .addGroup(Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(txtTitle))
                            .addGap(0, 301, Short.MAX_VALUE))
                        .addGroup(Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(ComponentPlacement.UNRELATED)
                            .addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(txtTitle)
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addComponent(jLabel2)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(numAssentos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addComponent(jLabel3)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(txtDescricao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                    .addGap(18)
                    .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(btnSalvar)
                        .addComponent(btnExcluir))
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
    }
}
