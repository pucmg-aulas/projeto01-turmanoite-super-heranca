import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
//===============================================================
public class Menu {
    public static Restaurante restaurante = new Restaurante(new LinkedList<String>(), new LinkedList<Reserva>(), new LinkedList<Mesa>());

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
            System.out.println("4) Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            limparTela();

            switch (opcao) {
                case 1:
                    System.out.println("Nova reserva");
                    realizarNovaReserva(restaurante.mesas.get(0));
                    break;
                case 2:
                    System.out.println("Disponibilidade da mesa");
                    restaurante.verificarDisponibilidade();
                    break;
                case 3:
                    System.out.println("Remover reserva");

                    break;
                case 4:
                    System.out.println("Finalizando o expediente, até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        } while (opcao != 4);

        scanner.close();
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

    public static void realizarNovaReserva(Mesa mesa){
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

        Reserva reserva = new Reserva(propietarioReserva, mesa);
        reserva.fazerReserva();
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