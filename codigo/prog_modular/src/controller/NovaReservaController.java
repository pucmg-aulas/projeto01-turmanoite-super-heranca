package controller;

import Dao.ListaEspera;
import views.NovaReserva;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ClienteListaEspera;
import model.Mesa;
import model.Reserva;
import model.ProprietarioReserva;
import Dao.Mesas;
import java.time.LocalDateTime;

public class NovaReservaController {

    private NovaReserva view;
    private Mesas mesas;
    private ListaEspera listaEspera;

    public NovaReservaController() {
        this.view = new NovaReserva();
        this.mesas = Mesas.getInstance();
        this.listaEspera = ListaEspera.getInstance();

        carregarMesas();

        this.view.getBtnVerificarDisponibilidade().addActionListener((e) -> {
            verificarDisponibilidade();
        });
        this.view.getBtnRealizarReserva().addActionListener((e) -> {
            criarNovaReserva();
        });

        this.view.frame.setVisible(true);
    }

    public void verificarDisponibilidade() {
        try {
            if (this.view.getTxtQtdPessoas().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha a quantidade de pessoas para buscar mesas", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int totalPessoas = Integer.parseInt(this.view.getTxtQtdPessoas().getText());
            LinkedList<Mesa> mesasDisponiveis = buscarMesasDisponiveis(totalPessoas);

            if (mesasDisponiveis.isEmpty()) {
                int option = JOptionPane.showConfirmDialog(null, "Não encontramos uma mesa para o cliente. Deseja adicionar à lista de espera?", "Mesas indisponíveis", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    adicionarClienteListaEspera();
                }
                return;
            }
            imprimirMesasDisponiveis(mesasDisponiveis);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar mesas.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void adicionarClienteListaEspera() {
        String nome = view.getTxtNomeCliente().getText();
        String telefone = view.getTxtTelefone().getText();
        int qtdPessoas = Integer.parseInt(view.getTxtQtdPessoas().getText());

        if (nome.isEmpty() || telefone.isEmpty() || qtdPessoas <= 0) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente para adicionar à lista de espera.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        ClienteListaEspera cliente = new ClienteListaEspera(nome, telefone, qtdPessoas);
        listaEspera.adicionarCliente(cliente);

        JOptionPane.showMessageDialog(null, "Cliente adicionado à lista de espera com sucesso!");
    }

    public LinkedList<Mesa> buscarMesasDisponiveis(int qtdPessoas) {
        LinkedList<Mesa> mesasDisponiveis = new LinkedList<>();
        this.mesas.getAllMesas().forEach(mesa -> {
            if (mesa.getCapacidade() >= qtdPessoas && mesa.isDisponivel()) {
                mesasDisponiveis.push(mesa);
            }
        });
        return mesasDisponiveis;
    }

    public void criarNovaReserva() {
        try {
            String nome = this.view.getTxtNomeCliente().getText();
            String telefone = this.view.getTxtTelefone().getText();
            int totalPessoas = Integer.parseInt(this.view.getTxtQtdPessoas().getText());
            String cpf = this.view.getTxtCpf().getText();
            int rowIndex = this.view.getTableMesasDisponiveis().getSelectedRow();

            if (nome.isEmpty() || telefone.isEmpty() || cpf.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos para seguir", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (rowIndex == -1) {
                JOptionPane.showMessageDialog(null, "Selecione uma mesa para efetuar a reserva", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int idMesa = Integer.parseInt((String) this.view.getTableMesasDisponiveis().getValueAt(rowIndex, 0));
            Mesa mesa = buscarMesaPorId(idMesa);
            mesa.setDisponivel(false); // Marca a mesa como ocupada
            mesa.setHoraEntrada(LocalDateTime.now());

            ProprietarioReserva proprietario = new ProprietarioReserva(nome, telefone, totalPessoas, cpf);
            Reserva reserva = new Reserva(proprietario, mesa);

            JOptionPane.showMessageDialog(null, "Reserva feita com sucesso", "Sucesso", JOptionPane.OK_OPTION);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar reserva, verifique os campos preenchidos e tente novamente", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void imprimirMesasDisponiveis(LinkedList<Mesa> mesasDisponiveis) {
        String[] columnNames = {"ID", "Qtd", "Desc"};

        DefaultTableModel tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableModel.setColumnIdentifiers(columnNames);
        mesasDisponiveis.forEach(mesa -> {
            tableModel.addRow(new String[]{String.valueOf(mesa.getId()), String.valueOf(mesa.getCapacidade()), mesa.getDescricao()});
        });

        this.view.getTableMesasDisponiveis().setModel(tableModel);
    }

    public Mesa buscarMesaPorId(int id) {
        return this.mesas.getMesaById(id);
    }

    public void carregarMesas() {
        // Mesas estão sendo carregadas a partir do DAO
    }
}
