package view;

import controller.MesaController;
import controller.PedidoController;
import model.Mesa;
import model.Pedido;

import java.util.Scanner;

public class PedidoView {
    private PedidoController pedidoController;
    private MesaController mesaController;
    private Scanner scanner;

    public PedidoView(PedidoController pedidoController, MesaController mesaController) {
        this.pedidoController = pedidoController;
        this.mesaController = mesaController;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("---- Menu de Pedidos ----");
            System.out.println("1. Listar pedidos");
            System.out.println("2. Adicionar pedido");
            System.out.println("3. Remover pedido");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    listarPedidos();
                    break;
                case 2:
                    adicionarPedido();
                    break;
                case 3:
                    removerPedido();
                    break;
                case 0:
                    System.out.println("Saindo do menu de pedidos.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    public void listarPedidos() {
        System.out.println("---- Lista de Pedidos ----");
        for (Pedido pedido : pedidoController.getPedidos()) {
            System.out.println(pedido);
        }
    }

    public void adicionarPedido() {
        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = scanner.nextLine();
        System.out.print("Digite o ID da mesa: ");
        int idMesa = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        Mesa mesa = mesaController.getMesas().stream().filter(m -> m.getId() == idMesa).findFirst().orElse(null);
        if (mesa == null) {
            System.out.println("Mesa não encontrada.");
            return;
        }

        System.out.print("Digite o item: ");
        String item = scanner.nextLine();
        System.out.print("Digite o valor: ");
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Consumir nova linha

        pedidoController.adicionarPedido(nomeCliente, mesa, item, valor);
        System.out.println("Pedido adicionado com sucesso.");
    }

    public void removerPedido() {
        System.out.print("Digite o ID do pedido a ser removido: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        Pedido pedido = pedidoController.getPedidos().stream().filter(p -> p.getId() == id).findFirst().orElse(null);
        if (pedido == null) {
            System.out.println("Pedido não encontrado.");
            return;
        }

        pedidoController.removerPedido(pedido);
        System.out.println("Pedido removido com sucesso.");
    }
}
