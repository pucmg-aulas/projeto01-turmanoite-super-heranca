package controller;

import views.NovaReserva;

import java.util.LinkedList;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Mesa;
import model.Reserva;
import model.ProprietarioReserva;

public class NovaReservaController {

	private NovaReserva view;
	private LinkedList<Mesa> mesas;
    
	public NovaReservaController() {
		this.view = new NovaReserva();
		this.mesas = new LinkedList<Mesa>();
		
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
			if(this.view.getTxtQtdPessoas().getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha a quantidade de pessoas para buscar mesas", "Erro", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			int totalPessoas = Integer.parseInt(this.view.getTxtQtdPessoas().getText());
			LinkedList<Mesa> mesasDisponiveis = buscarMesasDisponiveis(totalPessoas);
			
			if(mesasDisponiveis.isEmpty()) {
				int option = JOptionPane.showConfirmDialog(null, "Nao encontramos uma mesa para o cliente. Deseja adicionar a lista de espera?", "Mesas indisponiveis", JOptionPane.YES_NO_OPTION);
				return;
			}
			imprimirMesasDisponiveis(mesasDisponiveis);
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar mesas.", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public LinkedList<Mesa> buscarMesasDisponiveis(int qtdPessoas) {
		LinkedList<Mesa> mesasDisponiveis = new LinkedList<Mesa>();
		this.mesas.forEach(mesa -> {
			if(mesa.getCapacidade() >= qtdPessoas && !mesa.getDisponibilidade()) {
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
			
			if(nome.isEmpty() || telefone.isEmpty() || cpf.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos para seguir", "Erro", JOptionPane.ERROR_MESSAGE);
				return;
			}
			

			if (rowIndex == -1) {
				JOptionPane.showMessageDialog(null, "Selecione uma mesa para efetuar a reserva", "Erro", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			int idMesa = Integer.parseInt((String) this.view.getTableMesasDisponiveis().getValueAt(rowIndex, 0));
			ProprietarioReserva propietario = new ProprietarioReserva(nome, telefone, totalPessoas, cpf);	
			Reserva reserva = new Reserva(propietario, buscarMesaPorId(idMesa));
			
			JOptionPane.showMessageDialog(null, "Reserva feita com sucesso", "Sucesso", JOptionPane.OK_OPTION);
			
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao criar reserva, verifique os campos preenchdios e tente novamente", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void imprimirMesasDisponiveis(LinkedList<Mesa> mesasDisponiveis) {
        String[] columnNames = {"Quantidade", "Descricao"};

        DefaultTableModel tableModel = new DefaultTableModel() {
        	@Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableModel.setColumnIdentifiers(new String[] {"Qtd", "Desc"});
        mesasDisponiveis.forEach(mesa -> {
        	tableModel.addRow(new String[]{String.valueOf(mesa.getCapacidade()),mesa.getDescricao()});
        });
        
        JTable tabelaMesas = this.view.getTableMesasDisponiveis();
        tabelaMesas.setModel(tableModel);
	}
	
	public Mesa buscarMesaPorId(int id) {
        for (Mesa mesa : mesas) {
            if (mesa.getId() == id) {
                return mesa; 
            }
        }
        return null; 
    }
	
	public void carregarMesas() {
		this.mesas.push(new Mesa(1,4,"mesa simples"));
		this.mesas.push(new Mesa(2,4,"mesa de canto"));
		this.mesas.push(new Mesa(3,5,"mesa de varanda"));
		this.mesas.push(new Mesa(4,5,"mesa varanda"));
		this.mesas.push(new Mesa(5,5,"mesa varanda"));
		this.mesas.push(new Mesa(6,6,"mesa salao principal"));
		this.mesas.push(new Mesa(7,6,"mesa salao principal"));
		this.mesas.push(new Mesa(8,6,"mesa salao principal"));
		this.mesas.push(new Mesa(9,8,"mesa salao principal"));
		this.mesas.push(new Mesa(10,8,"mesa salao principal"));
		this.mesas.push(new Mesa(11,8,"mesa salao principal"));
		this.mesas.push(new Mesa(12,10,"mesa terraco"));
		this.mesas.push(new Mesa(13,10,"mesa terraco"));
		this.mesas.push(new Mesa(14,12,"mesa privada"));
		this.mesas.push(new Mesa(15,12,"mesa privada"));
		this.mesas.push(new Mesa(16,12,"mesa jardim"));
		
	}
	
    
}
