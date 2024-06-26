package views;

import controller.AdicionarMesaController;
import controller.ListaEsperaController;
import controller.NovaReservaController;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Menu window = new Menu();
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
    public Menu() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[]{0, 0};
        gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
        gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gbl_panel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 1.0};
        panel.setLayout(gbl_panel);
        
        JButton btnReserva = new JButton("Reserva");
        btnReserva.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnReserva.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new NovaReservaController();
            }
        });
        GridBagConstraints gbc_btnReserva = new GridBagConstraints();
        gbc_btnReserva.insets = new Insets(10, 10, 5, 10);
        gbc_btnReserva.gridx = 0;
        gbc_btnReserva.gridy = 1;
        gbc_btnReserva.fill = GridBagConstraints.HORIZONTAL;
        panel.add(btnReserva, gbc_btnReserva);
        
        JButton btnListaEspera = new JButton("Lista de Espera");
        btnListaEspera.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnListaEspera.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ListaEsperaController();
            }
        });
        GridBagConstraints gbc_btnListaEspera = new GridBagConstraints();
        gbc_btnListaEspera.insets = new Insets(5, 10, 5, 10);
        gbc_btnListaEspera.gridx = 0;
        gbc_btnListaEspera.gridy = 2;
        gbc_btnListaEspera.fill = GridBagConstraints.HORIZONTAL;
        panel.add(btnListaEspera, gbc_btnListaEspera);
        
        JButton btnProdutos = new JButton("Produtos");
        btnProdutos.setFont(new Font("Tahoma", Font.PLAIN, 14));
        GridBagConstraints gbc_btnProdutos = new GridBagConstraints();
        gbc_btnProdutos.insets = new Insets(5, 10, 5, 10);
        gbc_btnProdutos.gridx = 0;
        gbc_btnProdutos.gridy = 3;
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
        gbc_btnMesas.gridy = 4;
        gbc_btnMesas.fill = GridBagConstraints.HORIZONTAL;
        panel.add(btnMesas, gbc_btnMesas);
        
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
        gbc_btnSair.gridy = 5;
        gbc_btnSair.fill = GridBagConstraints.HORIZONTAL;
        panel.add(btnSair, gbc_btnSair);
    }
}

