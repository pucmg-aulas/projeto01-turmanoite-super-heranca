package views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class RelatorioFinanceiro extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtDataInicio;
    private JTextField txtDataFim;
    private JTable tabRelatorio;
    private JButton btnBuscar;
    private JLabel lblFormatoData;
    private JLabel lblValorTotalRecebido;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
    private JLabel lblValorRecebido;
    private JLabel lbl14Dias;
    private JLabel lbl30Dias;
    private JLabel lblValorTotal;

    public RelatorioFinanceiro() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 627, 636);
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
        setLocationRelativeTo(null);
        
        JLabel lblNewLabel = new JLabel("Valor total");
        
        lblValorTotal = new JLabel("R$0,00");
        
        lblValorTotalRecebido = new JLabel("Valor recebido");
        
        lblNewLabel_2 = new JLabel("em 14 dias");
        
        lblNewLabel_3 = new JLabel("em 30 dias");
        
        lblValorRecebido = new JLabel("R$0,00");
        
        lbl14Dias = new JLabel("R$0,00");
        
        lbl30Dias = new JLabel("R$0,00");

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
        						.addGroup(gl_contentPane.createSequentialGroup()
        							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        								.addComponent(lblDataInicio)
        								.addComponent(txtDataInicio, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
        							.addGap(30)
        							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        								.addGroup(gl_contentPane.createSequentialGroup()
        									.addComponent(txtDataFim, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
        									.addPreferredGap(ComponentPlacement.RELATED, 176, Short.MAX_VALUE)
        									.addComponent(btnBuscar))
        								.addComponent(lblDataFim)))
        						.addComponent(lblFormatoData))
        					.addContainerGap())
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        						.addComponent(lblNewLabel)
        						.addComponent(lblValorTotal))
        					.addGap(36)
        					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        						.addComponent(lblValorRecebido, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblValorTotalRecebido, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        						.addComponent(lbl14Dias, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
        					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        						.addComponent(lbl30Dias, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
        					.addGap(77))))
        );
        gl_contentPane.setVerticalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblDataInicio)
        				.addComponent(lblDataFim))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txtDataInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(txtDataFim, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btnBuscar))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(lblFormatoData)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 423, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
        					.addGroup(gl_contentPane.createSequentialGroup()
        						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
        							.addComponent(lblNewLabel)
        							.addComponent(lblValorTotalRecebido))
        						.addPreferredGap(ComponentPlacement.RELATED)
        						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
        							.addComponent(lblValorTotal)
        							.addComponent(lblValorRecebido)))
        					.addGroup(gl_contentPane.createSequentialGroup()
        						.addComponent(lblNewLabel_3)
        						.addPreferredGap(ComponentPlacement.RELATED)
        						.addComponent(lbl30Dias)))
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addComponent(lblNewLabel_2)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(lbl14Dias)))
        			.addContainerGap(40, Short.MAX_VALUE))
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
    
    public JLabel getLblValorTotal() {
        return lblValorTotal;
    }
    public JLabel getLblValorRecebido() {
        return lblValorRecebido;
    }
    public JLabel getLbl14Dias() {
        return lbl14Dias;
    }
    public JLabel getLbl30Dias() {
        return lbl30Dias;
    }
}
