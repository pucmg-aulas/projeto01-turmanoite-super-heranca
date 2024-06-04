package com.mycompany.restaurantealaclasse;

import controller.MesaController;
import controller.PedidoController;
import controller.ReservaController;
import view.MesaView;
import view.PedidoView;
import view.ReservaView;

import java.util.Scanner;

public class RestauranteALaClasse  {
    public static void main(String[] args) {
        ReservaController reservaController = new ReservaController();
        MesaController mesaController = new MesaController();
        PedidoController pedidoController = new PedidoController();
        ReservaView reservaView = new ReservaView(reservaController, mesaController);
        MesaView mesaView = new MesaView(mesaController);
        PedidoView pedidoView = new PedidoView(pedidoController, mesaController);

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("1. Nova Reserva");
            System.out.println("2. Ver Disponibilidade das Mesas");
            System.out.println("3. Ver Lista de Espera");
            System.out.println("4. Remover Reserva");
            System.out.println("5. Adicionar Pedido");
            System.out.println("6. Ver Pedidos");
            System.out.println("7. Calcular Total de Pedidos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (opcao) {
                case 1:
                    reservaView.novaReserva();
                    break;
                case 2:
                    reservaView.verDisponibilidadeMesas();
                    break;
                case 3:
                    reservaView.verListaDeEspera();
                    break;
                case 4:
                    reservaView.removerReserva();
                    break;
                case 5:
                    pedidoView.adicionarPedido();
                    break;
                case 6:
                    pedidoView.listarPedidos();
                    break;
                case 7:
                    double total = pedidoController.calcularTotalPedidos();
                    System.out.println("Total dos Pedidos: R$ " + total);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 0);
    }
}
