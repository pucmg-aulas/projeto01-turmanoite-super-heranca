import java.io.IOException;
import java.util.Scanner;
//===============================================================
public class Menu {
    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
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
                    //Chamada para o código de criação para a nova reserva.
                    break;
                case 2:
                    System.out.println("Disponibilidade da mesa");
                    //Chamada para realizar a validação da disponibilidade
                    break;
                case 3:
                    System.out.println("Remover reserva");
                    //Chamada para remover 
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
//===============================================================
//Este procedimento abaixo tem o intuito de limpar todo o terminal de acordo com o que é escolhido
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
}
//===============================================================