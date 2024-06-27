package views;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Font;

public class ListaEsperaView extends JFrame {
    private JTextField txtNomeCliente;
    private JTextField txtTelefone;
    private JTextField txtQtdPessoas;
    private JButton btnAdicionar;
    private JButton btnRemover;
    private JTable tableClientes;

    public ListaEsperaView() {
        initialize();
    }

    private void initialize() {
        setBounds(100, 100, 450, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblNomeCliente = new JLabel("Nome do Cliente");
        lblNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNomeCliente.setBounds(10, 10, 120, 25);
        getContentPane().add(lblNomeCliente);

        txtNomeCliente = new JTextField();
        txtNomeCliente.setBounds(140, 10, 280, 25);
        getContentPane().add(txtNomeCliente);
        txtNomeCliente.setColumns(10);

        JLabel lblTelefone = new JLabel("Telefone");
        lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblTelefone.setBounds(10, 45, 120, 25);
        getContentPane().add(lblTelefone);

        txtTelefone = new JTextField();
        txtTelefone.setBounds(140, 45, 280, 25);
        getContentPane().add(txtTelefone);
        txtTelefone.setColumns(10);

        JLabel lblQtdPessoas = new JLabel("Quantidade de Pessoas");
        lblQtdPessoas.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblQtdPessoas.setBounds(10, 80, 160, 25);
        getContentPane().add(lblQtdPessoas);

        txtQtdPessoas = new JTextField();
        txtQtdPessoas.setBounds(180, 80, 240, 25);
        getContentPane().add(txtQtdPessoas);
        txtQtdPessoas.setColumns(10);

        btnAdicionar = new JButton("Adicionar");
        btnAdicionar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnAdicionar.setBounds(10, 120, 200, 35);
        getContentPane().add(btnAdicionar);

        btnRemover = new JButton("Remover");
        btnRemover.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnRemover.setBounds(220, 120, 200, 35);
        getContentPane().add(btnRemover);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 170, 410, 280);
        getContentPane().add(scrollPane);

        tableClientes = new JTable();
        tableClientes.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] { "Nome", "Telefone", "Quantidade de Pessoas", "Data/Hora de Entrada" }
        ));
        scrollPane.setViewportView(tableClientes);
    }

    public JTextField getTxtNomeCliente() {
        return txtNomeCliente;
    }

    public JTextField getTxtTelefone() {
        return txtTelefone;
    }

    public JTextField getTxtQtdPessoas() {
        return txtQtdPessoas;
    }

    public JButton getBtnAdicionar() {
        return btnAdicionar;
    }

    public JButton getBtnRemover() {
        return btnRemover;
    }

    public JTable getTableClientes() {
        return tableClientes;
    }
}
