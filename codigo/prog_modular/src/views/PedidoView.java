package views;

import model.Reserva;
import model.Prato;
import model.Bebida;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PedidoView extends JFrame {
    private Reserva reserva;
    private JTable tablePratos;
    private JTable tableBebidas;
    private JButton btnAdicionarPrato;
    private JButton btnAdicionarBebida;
    private JButton btnEncerrarPedido;

    public PedidoView(Reserva reserva) {
        this.reserva = reserva;
        initialize();
    }

    private void initialize() {
        setTitle("Pedido - Mesa " + reserva.getMesa().getId());
        setBounds(100, 100, 600, 536);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblPratos = new JLabel("Pratos");
        lblPratos.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblPratos.setBounds(10, 10, 120, 25);
        getContentPane().add(lblPratos);

        JScrollPane scrollPanePratos = new JScrollPane();
        scrollPanePratos.setBounds(10, 40, 260, 200);
        getContentPane().add(scrollPanePratos);

        tablePratos = new JTable();
        tablePratos.setModel(new DefaultTableModel(
                new Object[][] {},
                new String[] { "Nome", "Preço" }
        ));
        scrollPanePratos.setViewportView(tablePratos);

        btnAdicionarPrato = new JButton("Adicionar Prato");
        btnAdicionarPrato.setBounds(280, 40, 150, 25);
        getContentPane().add(btnAdicionarPrato);

        JLabel lblBebidas = new JLabel("Bebidas");
        lblBebidas.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblBebidas.setBounds(10, 250, 120, 25);
        getContentPane().add(lblBebidas);

        JScrollPane scrollPaneBebidas = new JScrollPane();
        scrollPaneBebidas.setBounds(10, 280, 260, 200);
        getContentPane().add(scrollPaneBebidas);

        tableBebidas = new JTable();
        tableBebidas.setModel(new DefaultTableModel(
                new Object[][] {},
                new String[] { "Nome", "Preço" }
        ));
        scrollPaneBebidas.setViewportView(tableBebidas);

        btnAdicionarBebida = new JButton("Adicionar Bebida");
        btnAdicionarBebida.setBounds(280, 280, 150, 25);
        getContentPane().add(btnAdicionarBebida);

        btnEncerrarPedido = new JButton("Encerrar Pedido");
        btnEncerrarPedido.setBounds(280, 320, 150, 25);
        getContentPane().add(btnEncerrarPedido);

        btnAdicionarPrato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarPrato();
            }
        });

        btnAdicionarBebida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarBebida();
            }
        });

        btnEncerrarPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                encerrarPedido();
            }
        });
    }

    private void adicionarPrato() {
        String[] pratos = { "Moqueca de Tilápia", "Falafel Assado", "Salada Primavera com Macarrão Konjac", "Escondidinho de Frango", "Strogonoff", "Caçarola de carne com legumes" };
        double[] precos = { 45.00, 30.00, 25.00, 35.00, 40.00, 50.00 };

        String pratoEscolhido = (String) JOptionPane.showInputDialog(this, "Escolha o prato:", "Adicionar Prato", JOptionPane.QUESTION_MESSAGE, null, pratos, pratos[0]);
        if (pratoEscolhido != null) {
            for (int i = 0; i < pratos.length; i++) {
                if (pratoEscolhido.equals(pratos[i])) {
                    Prato prato = new Prato(pratoEscolhido, precos[i]);
                    reserva.getComanda().addPrato(prato);
                    atualizarTabelaPratos();
                    break;
                }
            }
        }
    }

    private void adicionarBebida() {
        String[] bebidas = { "Água", "Suco", "Refrigerante", "Cerveja", "Taça de vinho" };
        double[] precos = { 5.00, 10.00, 7.00, 12.00, 15.00 };

        String bebidaEscolhida = (String) JOptionPane.showInputDialog(this, "Escolha a bebida:", "Adicionar Bebida", JOptionPane.QUESTION_MESSAGE, null, bebidas, bebidas[0]);
        if (bebidaEscolhida != null) {
            for (int i = 0; i < bebidas.length; i++) {
                if (bebidaEscolhida.equals(bebidas[i])) {
                    Bebida bebida = new Bebida(bebidaEscolhida, precos[i]);
                    reserva.getComanda().addBebida(bebida);
                    atualizarTabelaBebidas();
                    break;
                }
            }
        }
    }

    private void encerrarPedido() {
        double totalComTaxa = reserva.getComanda().calcularTotalComTaxa();
        double valorPorPessoa = totalComTaxa / reserva.getProprietario().getQtdPessoas();

        String mensagem = String.format("Valor Total: R$ %.2f\nValor por Pessoa: R$ %.2f", totalComTaxa, valorPorPessoa);
        JOptionPane.showMessageDialog(this, mensagem, "Encerramento do Pedido", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
    }

    private void atualizarTabelaPratos() {
        DefaultTableModel model = (DefaultTableModel) tablePratos.getModel();
        model.setRowCount(0);
        reserva.getComanda().getPratos().forEach(prato -> {
            model.addRow(new Object[] { prato.getNome(), prato.getPreco() });
        });
    }

    private void atualizarTabelaBebidas() {
        DefaultTableModel model = (DefaultTableModel) tableBebidas.getModel();
        model.setRowCount(0);
        reserva.getComanda().getBebidas().forEach(bebida -> {
            model.addRow(new Object[] { bebida.getNome(), bebida.getPreco() });
        });
    }
}
