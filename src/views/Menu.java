package views;

import controller.AdicionarMesaController;
import controller.GerenciarReservaController;
import controller.ListaEsperaController;
import controller.NovaReservaController;
import controller.RelatorioFinanceiroController;
import controller.GerenciarCardapioController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {

    private JFrame frame;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Menu window = new Menu();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Menu() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[]{0, 0};
        gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
        gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        panel.setLayout(gbl_panel);

        JButton btnReserva = new JButton("Realizar Reserva");
        btnReserva.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnReserva.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new NovaReservaController();
            }
        });
        GridBagConstraints gbc_btnReserva = new GridBagConstraints();
        gbc_btnReserva.insets = new Insets(10, 10, 5, 10);
        gbc_btnReserva.gridx = 0;
        gbc_btnReserva.gridy = 0;
        gbc_btnReserva.fill = GridBagConstraints.HORIZONTAL;
        panel.add(btnReserva, gbc_btnReserva);

        JButton btnListaEspera = new JButton("Gerenciar Lista de Espera");
        btnListaEspera.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnListaEspera.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ListaEsperaController();
            }
        });
        GridBagConstraints gbc_btnListaEspera = new GridBagConstraints();
        gbc_btnListaEspera.insets = new Insets(5, 10, 5, 10);
        gbc_btnListaEspera.gridx = 0;
        gbc_btnListaEspera.gridy = 1;
        gbc_btnListaEspera.fill = GridBagConstraints.HORIZONTAL;
        panel.add(btnListaEspera, gbc_btnListaEspera);

        JButton btnProdutos = new JButton("Gerenciar Cardápio");
        btnProdutos.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnProdutos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new GerenciarCardapioController();
            }
        });
        GridBagConstraints gbc_btnProdutos = new GridBagConstraints();
        gbc_btnProdutos.insets = new Insets(5, 10, 5, 10);
        gbc_btnProdutos.gridx = 0;
        gbc_btnProdutos.gridy = 2;
        gbc_btnProdutos.fill = GridBagConstraints.HORIZONTAL;
        panel.add(btnProdutos, gbc_btnProdutos);

        JButton btnMesas = new JButton("Gerenciar Mesas");
        btnMesas.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnMesas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AdicionarMesaController();
            }
        });
        GridBagConstraints gbc_btnMesas = new GridBagConstraints();
        gbc_btnMesas.insets = new Insets(5, 10, 5, 10);
        gbc_btnMesas.gridx = 0;
        gbc_btnMesas.gridy = 3;
        gbc_btnMesas.fill = GridBagConstraints.HORIZONTAL;
        panel.add(btnMesas, gbc_btnMesas);

        JButton btnGerenciarReservas = new JButton("Gerenciar Reservas");
        btnGerenciarReservas.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnGerenciarReservas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new GerenciarReservaController();
            }
        });
        GridBagConstraints gbc_btnGerenciarReservas = new GridBagConstraints();
        gbc_btnGerenciarReservas.insets = new Insets(5, 10, 5, 10);
        gbc_btnGerenciarReservas.gridx = 0;
        gbc_btnGerenciarReservas.gridy = 4;
        gbc_btnGerenciarReservas.fill = GridBagConstraints.HORIZONTAL;
        panel.add(btnGerenciarReservas, gbc_btnGerenciarReservas);

        JButton btnRelatorio = new JButton("Relatório Financeiro");
        btnRelatorio.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnRelatorio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new RelatorioFinanceiroController();
            }
        });
        GridBagConstraints gbc_btnRelatorio = new GridBagConstraints();
        gbc_btnRelatorio.insets = new Insets(5, 10, 5, 10);
        gbc_btnRelatorio.gridx = 0;
        gbc_btnRelatorio.gridy = 5;
        gbc_btnRelatorio.fill = GridBagConstraints.HORIZONTAL;
        panel.add(btnRelatorio, gbc_btnRelatorio);

        JButton btnSair = new JButton("Sair");
        btnSair.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        GridBagConstraints gbc_btnSair = new GridBagConstraints();
        gbc_btnSair.insets = new Insets(5, 10, 10, 10);
        gbc_btnSair.gridx = 0;
        gbc_btnSair.gridy = 6;
        gbc_btnSair.fill = GridBagConstraints.HORIZONTAL;
        panel.add(btnSair, gbc_btnSair);
    }
}
