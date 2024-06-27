package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import java.awt.Color;
import java.awt.Font;

public class NovaReserva {

    public JFrame frame;
    private JTextField txtNomeCliente;
    private JTextField txtTelefone;
    private JTextField txtCpf;
    private JTextField txtQtdPessoas;
    private JButton btnVerificarDisponibilidade;
    private JButton btnFazerReserva;
    private JTable tabMesasDisponiveis;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    NovaReserva window = new NovaReserva();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public NovaReserva() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);

        JLabel lblNomeCliente = new JLabel("Nome do Cliente");
        lblNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNomeCliente.setBounds(10, 10, 130, 25);
        frame.getContentPane().add(lblNomeCliente);

        txtNomeCliente = new JTextField();
        txtNomeCliente.setBounds(150, 10, 280, 25);
        frame.getContentPane().add(txtNomeCliente);
        txtNomeCliente.setColumns(10);

        JLabel lblTelefone = new JLabel("Telefone");
        lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblTelefone.setBounds(10, 50, 130, 25);
        frame.getContentPane().add(lblTelefone);

        txtTelefone = new JTextField();
        txtTelefone.setBounds(150, 50, 280, 25);
        frame.getContentPane().add(txtTelefone);
        txtTelefone.setColumns(10);

        JLabel lblCpf = new JLabel("CPF");
        lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblCpf.setBounds(10, 90, 130, 25);
        frame.getContentPane().add(lblCpf);

        txtCpf = new JTextField();
        txtCpf.setBounds(150, 90, 280, 25);
        frame.getContentPane().add(txtCpf);
        txtCpf.setColumns(10);

        JLabel lblQtdPessoas = new JLabel("Quantidade de Pessoas");
        lblQtdPessoas.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblQtdPessoas.setBounds(10, 130, 180, 25);
        frame.getContentPane().add(lblQtdPessoas);

        txtQtdPessoas = new JTextField();
        txtQtdPessoas.setBounds(200, 130, 230, 25);
        frame.getContentPane().add(txtQtdPessoas);
        txtQtdPessoas.setColumns(10);

        btnVerificarDisponibilidade = new JButton("Verificar Disponibilidade");
        btnVerificarDisponibilidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnVerificarDisponibilidade.setBounds(10, 170, 200, 35);
        frame.getContentPane().add(btnVerificarDisponibilidade);

        btnFazerReserva = new JButton("Realizar Reserva");
        btnFazerReserva.setForeground(new Color(0, 128, 0));
        btnFazerReserva.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnFazerReserva.setBounds(220, 170, 200, 35);
        frame.getContentPane().add(btnFazerReserva);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 220, 410, 250);
        frame.getContentPane().add(scrollPane);

        tabMesasDisponiveis = new JTable();
        tabMesasDisponiveis.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabMesasDisponiveis.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] {"ID", "Qtd", "Desc"}
        ));
        scrollPane.setViewportView(tabMesasDisponiveis);

        JLabel lblLegendaTabela = new JLabel("Selecione a mesa que deseja reservar");
        lblLegendaTabela.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblLegendaTabela.setForeground(new Color(120, 2, 4));
        lblLegendaTabela.setBounds(10, 480, 410, 25);
        frame.getContentPane().add(lblLegendaTabela);
    }

    public JButton getBtnVerificarDisponibilidade() {
        return btnVerificarDisponibilidade;
    }
    public JButton getBtnRealizarReserva() {
        return btnFazerReserva;
    }
    public JTextField getTxtNomeCliente() {
        return txtNomeCliente;
    }
    public JTextField getTxtTelefone() {
        return txtTelefone;
    }
    public JTextField getTxtCpf() {
        return txtCpf;
    }
    public JTextField getTxtQtdPessoas() {
        return txtQtdPessoas;
    }
    public JTable getTableMesasDisponiveis() {
        return tabMesasDisponiveis;
    }
}
