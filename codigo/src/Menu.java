import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
//===============================================================
public class Menu {
    public static Restaurante restaurante = new Restaurante(new LinkedList<PropietarioReserva>(), new LinkedList<Reserva>(), new LinkedList<Mesa>());

    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        criarMesas();
        int opcao;


        //Separação de ações para o restaurante dentro de um menu do software
        do {
            System.out.println("--- Menu ---");
            System.out.println("1) Nova reserva");
            System.out.println("2) Disponibilidade da mesa");
            System.out.println("3) Remover reserva");
            System.out.println("4) Lista de espera");
            System.out.println("5) Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            limparTela();

            switch (opcao) {
                case 1:
                    System.out.println("Nova reserva");
                    novaReserva();
                    break;
                case 2:
                    System.out.println("Disponibilidade da mesa");
                    restaurante.verificarDisponibilidade();
                    break;
                case 3:
                    System.out.println("Remover reserva");
                    encerrarReserva();
                    break;
                case 4:
                    System.out.println("Lista de espera");
                    exibirListaDeEspera();
                    break;
                case 5:
                System.out.println("Finalizando o expediente, até logo!");
                break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        } while (opcao != 5);

        scanner.close();
    }

    public void exibirListaDeEspera() {
        restaurante.exibirListaDeEspera();
        System.out.println("\n\n");
    }

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

    public static void novaReserva(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do cliente");
        String nome = scanner.nextLine();

        System.out.println("Digite o CPF do cliente");
        String cpf = scanner.nextLine();

        System.out.println("Digite o telefone do cliente");
        String telefone = scanner.nextLine();

        System.out.println("Digite o numero de pessoas");
        int numPessoas = scanner.nextInt();

        PropietarioReserva propietarioReserva = new PropietarioReserva(nome, telefone,numPessoas,cpf);
        LinkedList<Mesa> mesasDisponiveis = verificarMesasDisponiveis(numPessoas);

        if(!mesasDisponiveis.isEmpty()){
            System.out.println("Mesas disponiveis:");
            for (int i = 0; i < mesasDisponiveis.size(); i++) {
                System.out.println(i+1 + " - mesa com: " + mesasDisponiveis.get(i).exibirCapacidade());
            }
            int mesaSelecionada = scanner.nextInt();
            restaurante.addReserva(propietarioReserva, mesasDisponiveis.get(mesaSelecionada-1));

            System.out.println("Reserva feita com sucesso!");

        } else {
            System.out.println("Nao temos mesas disponiveis no momento");
            addListaDeEspera(propietarioReserva);
        }

    }

    public static void encerrarReserva(){
        if(restaurante.qtdReservasAtuais() > 0) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("\nSelecione qual reserva sera encerrada:\n");

            System.out.println("------Reservas------");
            restaurante.exibirReservas();

            int opcao = scanner.nextInt();

            Reserva reservaEncerrada = restaurante.getReserva(opcao-1);

            restaurante.encerrarReserva(reservaEncerrada);

            System.out.println("Reserva encerrada com sucesso!");
            System.out.println("Hora de chegada: " + reservaEncerrada.getHoraEntrada());
            System.out.println("Hora de saída: " + reservaEncerrada.getHoraSaida());

        } else {
            System.out.println("Nao temos nenhuma reserva no momento");
        }
    }

    public static void addListaDeEspera(PropietarioReserva propietarioReserva){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Gostaria de adicinoar a lista de espera?");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");
        String opcao = scanner.nextLine();

        if(opcao.equals("1")){
            restaurante.addProprietarioReservaListaEspera(propietarioReserva);
            System.out.println("Cliente adicionado com sucesso!");
        }

    }

    public static LinkedList<Mesa> verificarMesasDisponiveis(int totalDePessoas){
        LinkedList<Mesa> mesasDisponiveis = new LinkedList<>();
        restaurante.mesas.forEach(mesa -> {
            if(mesa.verificarCapacidade(totalDePessoas) && mesa.verificarDisponibilidade()){
                mesasDisponiveis.add(mesa);
            }
        });
        return mesasDisponiveis;
    }

    public static void criarMesas(){
        restaurante.addMesa(new Mesa(4,true));
        restaurante.addMesa(new Mesa(4,true));
        restaurante.addMesa(new Mesa(4,true));
        restaurante.addMesa(new Mesa(4,true));
        restaurante.addMesa(new Mesa(6,true));
        restaurante.addMesa(new Mesa(6,true));
        restaurante.addMesa(new Mesa(6,true));
        restaurante.addMesa(new Mesa(6,true));
        restaurante.addMesa(new Mesa(8,true));
        restaurante.addMesa(new Mesa(8,true));
    }
}