package view;

import controller.MesaController;
import model.Mesa;

import java.util.Scanner;

public class MesaView {
    private MesaController mesaController;
    private Scanner scanner;

    public MesaView(MesaController mesaController) {
        this.mesaController = mesaController;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("---- Menu de Mesas ----");
            System.out.println("1. Listar mesas");
            System.out.println("2. Adicionar mesa");
            System.out.println("3. Remover mesa");
            System.out.println("4. Atualizar mesa");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    listarMesas();
                    break;
                case 2:
                    adicionarMesa();
                    break;
                case 3:
                    removerMesa();
                    break;
                case 4:
                    atualizarMesa();
                    break;
                case 0:
                    System.out.println("Saindo do menu de mesas.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private void listarMesas() {
        System.out.println("---- Lista de Mesas ----");
        for (Mesa mesa : mesaController.getMesas()) {
            System.out.println(mesa);
        }
    }

    private void adicionarMesa() {
        System.out.print("Digite o ID da mesa: ");
        int id = scanner.nextInt();
        System.out.print("Digite a capacidade da mesa: ");
        int capacidade = scanner.nextInt();

        Mesa mesa = new Mesa(id, capacidade);
        mesaController.adicionarMesa(mesa);
        System.out.println("Mesa adicionada com sucesso.");
    }

    private void removerMesa() {
        System.out.print("Digite o ID da mesa a ser removida: ");
        int id = scanner.nextInt();

        Mesa mesa = null;
        for (Mesa m : mesaController.getMesas()) {
            if (m.getId() == id) {
                mesa = m;
                break;
            }
        }

        if (mesa != null) {
            mesaController.removerMesa(mesa);
            System.out.println("Mesa removida com sucesso.");
        } else {
            System.out.println("Mesa não encontrada.");
        }
    }

    private void atualizarMesa() {
        System.out.print("Digite o ID da mesa a ser atualizada: ");
        int id = scanner.nextInt();

        Mesa mesa = null;
        for (Mesa m : mesaController.getMesas()) {
            if (m.getId() == id) {
                mesa = m;
                break;
            }
        }

        if (mesa != null) {
            System.out.print("Digite a nova capacidade da mesa: ");
            int capacidade = scanner.nextInt();

            mesa.setCapacidade(capacidade);
            mesaController.atualizarMesa(mesa);
            System.out.println("Mesa atualizada com sucesso.");
        } else {
            System.out.println("Mesa não encontrada.");
        }
    }
}
