package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.ListSelectionModel;
import java.awt.Font;

public class NovaReserva {

	public JFrame frame;
	private JTextField txtNomeCliente;
	private JTextField txtTelefone;
	private JLabel lblCpf;
	private JTextField txtCpf;
	private JLabel lblQtdPessoas;
	private JTextField txtQtdPessoas;
	private JButton btnVerificarDisponibilidade;
	private JTable tabMesasDisponiveis;
	private JButton btnFazerReserva;

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
		frame.setVisible(true);
		frame.setBounds(100, 100, 386, 579);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JLabel lblNomeCliente = new JLabel("Nome do cliente");
		lblNomeCliente.setBounds(6, 6, 130, 16);
		frame.getContentPane().add(lblNomeCliente);
		
		txtNomeCliente = new JTextField();
		txtNomeCliente.setBounds(6, 23, 358, 26);
		frame.getContentPane().add(txtNomeCliente);
		txtNomeCliente.setColumns(10);
		
		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(6, 78, 175, 26);
		frame.getContentPane().add(txtTelefone);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(6, 61, 61, 16);
		frame.getContentPane().add(lblTelefone);
		
		lblCpf = new JLabel("CPF");
		lblCpf.setBounds(189, 61, 61, 16);
		frame.getContentPane().add(lblCpf);
		
		txtCpf = new JTextField();
		txtCpf.setColumns(10);
		txtCpf.setBounds(189, 78, 175, 26);
		frame.getContentPane().add(txtCpf);
		
		lblQtdPessoas = new JLabel("Quantidade de pessoas");
		lblQtdPessoas.setBounds(6, 116, 175, 16);
		frame.getContentPane().add(lblQtdPessoas);
		
		txtQtdPessoas = new JTextField();
		txtQtdPessoas.setColumns(10);
		txtQtdPessoas.setBounds(6, 133, 175, 26);
		frame.getContentPane().add(txtQtdPessoas);
		
		btnVerificarDisponibilidade = new JButton("Verificar disponibilidade");
		btnVerificarDisponibilidade.setBounds(182, 133, 182, 29);
		frame.getContentPane().add(btnVerificarDisponibilidade);
		
		tabMesasDisponiveis = new JTable();
		tabMesasDisponiveis.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabMesasDisponiveis.setBorder(new CompoundBorder());
		tabMesasDisponiveis.setBounds(6, 189, 363, 177);
		frame.getContentPane().add(tabMesasDisponiveis);
		
		btnFazerReserva = new JButton("Realizar reserva");
		btnFazerReserva.setForeground(new Color(1, 79, 0));
		btnFazerReserva.setBounds(57, 442, 252, 37);
		frame.getContentPane().add(btnFazerReserva);
		
		JLabel lblLegendaTabela = new JLabel("Selecione a mesa que deseja reservar");
		lblLegendaTabela.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblLegendaTabela.setForeground(new Color(120, 2, 4));
		lblLegendaTabela.setBounds(6, 367, 303, 16);
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
	public JTextField getTxtQtdPessoas() {
        return txtQtdPessoas;
    }
	public JTextField getTxtCpf() {
        return txtCpf;
    }
	public JTable getTableMesasDisponiveis() {
        return tabMesasDisponiveis;
    }
}
