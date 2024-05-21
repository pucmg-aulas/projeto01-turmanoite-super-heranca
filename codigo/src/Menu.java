import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Menu {
    // Instância do restaurante com listas de reservas, mesas e produtos
    public static Restaurante restaurante = new Restaurante(new LinkedList<PropietarioReserva>(), new LinkedList<Reserva>(), new LinkedList<Mesa>(), new LinkedList<Produto>());

    // Método principal para exibir o menu e interagir com o usuário
    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        criarMesas();
        criarCardapio();
        int opcao;

        // Loop para exibir o menu até que o usuário escolha sair
        do {
            System.out.println("--- Menu ---");
            System.out.println("1) Nova reserva");
            System.out.println("2) Disponibilidade da mesa");
            System.out.println("3) Remover reserva");
            System.out.println("4) Lista de espera");
            System.out.println("5) Ver cardápio");
            System.out.println("6) Fazer pedido");
            System.out.println("7) Fechar conta da mesa");
            System.out.println("8) Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do scanner

            limparTela();

            // Switch para lidar com a opção escolhida pelo usuário
            switch (opcao) {
                case 1:
                    novaReserva();
                    break;
                case 2:
                    restaurante.verificarDisponibilidade();
                    break;
                case 3:
                    encerrarReserva();
                    break;
                case 4:
                    exibirListaDeEspera();
                    break;
                case 5:
                    exibirCardapio();
                    break;
                case 6:
                    fazerPedido();
                    break;
                case 7:
                    fecharConta();
                    break;
                case 8:
                    System.out.println("Finalizando o expediente, até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        } while (opcao != 8);

        scanner.close();
    }

    // Exibe a lista de espera
    public void exibirListaDeEspera() {
        restaurante.exibirListaDeEspera();
        System.out.println("\n\n");
    }

    // Método para limpar a tela do console
    public static void limparTela() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Erro ao limpar a tela: " + e.getMessage());
        }
    }

    // Exibe o cardápio do restaurante
    public void exibirCardapio() {
        System.out.println("---------- Cardápio ----------");
        for (int i = 0; i < restaurante.getProdutos().size(); i++) {
            Produto produto = restaurante.getProdutos().get(i);
            System.out.println((i + 1) + ") " + produto.getNome() + " - R$" + produto.getPreco() + " - " + produto.getDescricao());
        }
        System.out.println("------------------------------");
    }

    // Método para criar uma nova reserva
    public void novaReserva() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do cliente");
        String nome = scanner.nextLine();

        System.out.println("Digite o CPF do cliente");
        String cpf = scanner.nextLine();

        System.out.println("Digite o telefone do cliente");
        String telefone = scanner.nextLine();

        System.out.println("Digite o número de pessoas");
        int numPessoas = scanner.nextInt();

        PropietarioReserva propietarioReserva = new PropietarioReserva(nome, telefone, numPessoas, cpf);
        LinkedList<Mesa> mesasDisponiveis = verificarMesasDisponiveis(numPessoas);

        if (!mesasDisponiveis.isEmpty()) {
            System.out.println("Mesas disponíveis:");
            for (int i = 0; i < mesasDisponiveis.size(); i++) {
                System.out.println(i + 1 + " - mesa com: " + mesasDisponiveis.get(i).exibirCapacidade());
            }
            int mesaSelecionada = scanner.nextInt();
            restaurante.addReserva(propietarioReserva, mesasDisponiveis.get(mesaSelecionada - 1));

            System.out.println("Reserva feita com sucesso!");
        } else {
            System.out.println("Não temos mesas disponíveis no momento");
            addListaDeEspera(propietarioReserva);
        }
    }

    // Método para encerrar uma reserva
    public void encerrarReserva() {
        if (restaurante.qtdReservasAtuais() > 0) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("\nSelecione qual reserva será encerrada:\n");

            System.out.println("------Reservas------");
            restaurante.exibirReservas();

            int opcao = scanner.nextInt();

            Reserva reservaEncerrada = restaurante.getReserva(opcao - 1);

            restaurante.encerrarReserva(reservaEncerrada);

            System.out.println("Reserva encerrada com sucesso!");
            System.out.println("Hora de chegada: " + reservaEncerrada.getHoraEntrada());
            System.out.println("Hora de saída: " + reservaEncerrada.getHoraSaida());
        } else {
            System.out.println("Não temos nenhuma reserva no momento");
        }
    }

    // Adiciona um cliente à lista de espera
    public void addListaDeEspera(PropietarioReserva propietarioReserva) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Gostaria de adicionar à lista de espera?");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");
        String opcao = scanner.nextLine();

        if (opcao.equals("1")) {
            restaurante.addProprietarioReservaListaEspera(propietarioReserva);
            System.out.println("Cliente adicionado com sucesso!");
        }
    }

    // Verifica mesas disponíveis para a quantidade de pessoas
    public LinkedList<Mesa> verificarMesasDisponiveis(int totalDePessoas) {
        LinkedList<Mesa> mesasDisponiveis = new LinkedList<>();
        restaurante.getMesas().forEach(mesa -> {
            if (mesa.verificarDisponibilidade() && mesa.verificarCapacidade(totalDePessoas)) {
                mesasDisponiveis.add(mesa);
            }
        });
        return mesasDisponiveis;
    }

    // Cria o cardápio com produtos predefinidos
    public void criarCardapio() {
        restaurante.addProduto(new Produto("Moqueca de Tilápia", 25.0, "Um prato tradicional da culinária brasileira, preparado com tilápia fresca, pimentões, tomates, cebolas e leite de coco, cozidos lentamente em um delicioso molho aromático de dendê e temperos."));
        restaurante.addProduto(new Produto("Falafel Assado", 35.99, "Bolinhos de grão-de-bico temperados com ervas e especiarias, assados até ficarem dourados e crocantes por fora, enquanto mantêm um interior macio e saboroso."));
        restaurante.addProduto(new Produto("Salada Primavera com Macarrão Konjac", 40.0, "Uma mistura refrescante de vegetais da estação, como tomate, pepino, alface e cenoura, combinada com macarrão konjac de baixo teor calórico, regada com um molho leve de ervas e limão."));
        restaurante.addProduto(new Produto("Escondidinho de Frango", 15.40, "Uma confortante e saborosa combinação de frango desfiado, refogado com temperos aromáticos, coberto com purê de mandioca cremoso e gratinado no forno até dourar."));
        restaurante.addProduto(new Produto("Strogonoff", 28.90, "Uma clássica receita russa com um toque brasileiro, feita com tiras de carne macia refogadas em um molho cremoso de creme de leite, champignons e cebolas, servido com arroz branco soltinho."));
        restaurante.addProduto(new Produto("Caçarola de Carne com Legumes", 37.90, "Um prato reconfortante e nutritivo, preparado com carne suculenta cozida lentamente com uma variedade de legumes frescos, ervas aromáticas e caldo saboroso."));
        restaurante.addProduto(new Produto("Água", 10.00, "Água pura e refrescante, essencial para manter-se hidratado e saudável."));
        restaurante.addProduto(new Produto("Refrigerante", 12.00, "Uma variedade de refrigerantes gelados, perfeitos para acompanhar qualquer refeição e satisfazer a sede."));
        restaurante.addProduto(new Produto("Cerveja", 15.00, "Uma seleção de cervejas geladas, desde opções leves e refrescantes até variedades mais encorpadas e robustas, para todos os gostos."));
        restaurante.addProduto(new Produto("Taça de Vinho", 70.50, "Escolha entre nossa seleção de vinhos finos, cuidadosamente selecionados para complementar os sabores da sua refeição, proporcionando uma experiência gastronômica completa."));
    }

    // Cria mesas com capacidades predefinidas
    public void criarMesas() {
        restaurante.addMesa(new Mesa(4, true));
        restaurante.addMesa(new Mesa(4, true));
        restaurante.addMesa(new Mesa(4, true));
        restaurante.addMesa(new Mesa(4, true));
        restaurante.addMesa(new Mesa(6, true));
        restaurante.addMesa(new Mesa(6, true));
        restaurante.addMesa(new Mesa(6, true));
        restaurante.addMesa(new Mesa(6, true));
        restaurante.addMesa(new Mesa(8, true));
        restaurante.addMesa(new Mesa(8, true));
    }

    // Método para fazer um pedido para uma mesa
    public void fazerPedido() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selecione a mesa para fazer o pedido:");
        restaurante.exibirMesas();
        int indiceMesa = scanner.nextInt() - 1;
        Mesa mesaSelecionada = restaurante.getMesas().get(indiceMesa);

        if (!mesaSelecionada.verificarDisponibilidade()) {
            exibirCardapio();
            String opcao;
            do {
                System.out.println("Digite o número do produto que deseja adicionar ao pedido:");
                int indiceProduto = scanner.nextInt() - 1;
                Produto produtoSelecionado = restaurante.getProdutos().get(indiceProduto);
                mesaSelecionada.adicionarPedido(produtoSelecionado);

                System.out.println("Produto adicionado ao pedido.");
                System.out.println("Deseja adicionar mais um produto? (s/n)");
                opcao = scanner.next();
            } while (opcao.equalsIgnoreCase("s"));
        } else {
            System.out.println("Mesa não está reservada.");
        }
    }

    // Método para fechar a conta de uma mesa
    public void fecharConta() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selecione a mesa para fechar a conta:");
        restaurante.exibirMesas();
        int indiceMesa = scanner.nextInt() - 1;
        Mesa mesaSelecionada = restaurante.getMesas().get(indiceMesa);

        if (!mesaSelecionada.verificarDisponibilidade()) {
            mesaSelecionada.fecharConta();
        } else {
            System.out.println("Mesa não está reservada.");
        }
    }
}
