package view;

import controller.ReservaController;
import controller.MesaController;
import model.Mesa;
import model.Reserva;

import java.util.Scanner;

public class ReservaView {
    private ReservaController reservaController;
    private MesaController mesaController;
    private Scanner scanner;

    public ReservaView(ReservaController reservaController, MesaController mesaController) {
        this.reservaController = reservaController;
        this.mesaController = mesaController;
        this.scanner = new Scanner(System.in);
    }

    public void novaReserva() {
        System.out.print("Nome do Cliente: ");
        String nomeCliente = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Número de Pessoas: ");
        int numPessoas = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        Mesa mesaDisponivel = null;
        for (Mesa mesa : mesaController.getMesas()) {
            if (mesa.isDisponivel() && mesa.getCapacidade() >= numPessoas) {
                mesaDisponivel = mesa;
                break;
            }
        }

        if (mesaDisponivel != null) {
            reservaController.adicionarReserva(nomeCliente, cpf, telefone, numPessoas, mesaDisponivel);
            System.out.println("Reserva feita com sucesso!");
        } else {
            reservaController.adicionarAListaDeEspera(nomeCliente, cpf, telefone, numPessoas);
            System.out.println("Mesa não disponível. Adicionado à lista de espera.");
        }
    }

    public void verDisponibilidadeMesas() {
        for (Mesa mesa : mesaController.getMesas()) {
            System.out.println("Mesa ID: " + mesa.getId() + ", Capacidade: " + mesa.getCapacidade() + ", Disponível: " + mesa.isDisponivel());
        }
    }

    public void verListaDeEspera() {
        for (Reserva reserva : reservaController.getListaDeEspera()) {
            System.out.println("Cliente: " + reserva.getNomeCliente() + ", CPF: " + reserva.getCpf() + ", Telefone: " + reserva.getTelefone() + ", Número de Pessoas: " + reserva.getNumPessoas());
        }
    }

    public void removerReserva() {
        System.out.print("CPF do Cliente para remover a reserva: ");
        String cpf = scanner.nextLine();
        Reserva reservaParaRemover = null;
        for (Reserva reserva : reservaController.getReservas()) {
            if (reserva.getCpf().equals(cpf)) {
                reservaParaRemover = reserva;
                break;
            }
        }

        if (reservaParaRemover != null) {
            reservaController.removerReserva(reservaParaRemover);
            System.out.println("Reserva removida com sucesso!");
        } else {
            System.out.println("Reserva não encontrada.");
        }
    }
}
