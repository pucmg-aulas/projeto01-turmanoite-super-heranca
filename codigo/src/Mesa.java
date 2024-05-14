import java.util.LinkedList;
import java.util.List;

public class Mesa {
    // Capacidade de pessoas que a mesa pode acomodar
    private int capacidade;
    // Disponibilidade da mesa (true = disponível, false = ocupada)
    private boolean disponibilidade;
    // Lista de produtos pedidos na mesa
    private List<Produto> pedidos;

    // Construtor que inicializa a mesa com capacidade e disponibilidade
    public Mesa(int capacidade, boolean disponibilidade) {
        this.capacidade = capacidade;
        this.disponibilidade = disponibilidade;
        this.pedidos = new LinkedList<>();
    }

    // Método para obter a capacidade da mesa
    public int getCapacidade() {
        return capacidade;
    }

    // Método para verificar a disponibilidade da mesa
    public boolean verificarDisponibilidade() {
        return disponibilidade;
    }

    // Método para definir a disponibilidade da mesa
    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    // Método para verificar se a mesa pode acomodar um determinado número de pessoas
    public boolean verificarCapacidade(int pessoas) {
        return pessoas <= capacidade;
    }

    // Método para adicionar um produto (pedido) à lista de pedidos da mesa
    public void adicionarPedido(Produto produto) {
        pedidos.add(produto);
    }

    // Método para calcular o total dos pedidos na mesa
    public double calcularTotal() {
        double total = 0;
        for (Produto pedido : pedidos) {
            total += pedido.getPreco();
        }
        return total;
    }

    // Método para calcular o total dos pedidos com a taxa de serviço de 10%
    public double calcularTotalComTaxa() {
        double total = calcularTotal();
        return total + (total * 0.10); // taxa de serviço de 10%
    }

    // Método para desocupar a mesa (definir disponibilidade como true)
    public void desocuparMesa() {
        disponibilidade = true;
    }

    // Método para ocupar a mesa (definir disponibilidade como false)
    public void ocuparMesa() {
        disponibilidade = false;
    }

    // Método para calcular o valor total por pessoa, incluindo a taxa de serviço
    public double calcularValorPorPessoa() {
        return calcularTotalComTaxa() / capacidade;
    }

    // Método para fechar a conta da mesa, exibir o resumo e liberar a mesa
    public void fecharConta() {
        double total = calcularTotal();
        double totalComTaxa = calcularTotalComTaxa();
        double valorPorPessoa = calcularValorPorPessoa();

        System.out.println("---------- Conta ----------");
        for (Produto pedido : pedidos) {
            System.out.println(pedido.getNome() + " - R$" + pedido.getPreco());
        }
        System.out.println("---------------------------");
        System.out.println("Total: R$" + total);
        System.out.println("Taxa de serviço (10%): R$" + (total * 0.10));
        System.out.println("Total com taxa: R$" + totalComTaxa);
        System.out.println("Valor por pessoa: R$" + valorPorPessoa);
        System.out.println("---------------------------");

        // Limpa os pedidos e libera a mesa
        pedidos.clear();
        setDisponibilidade(true);
    }

    // Método para exibir os pedidos realizados na mesa
    public void exibirPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido realizado ainda.");
        } else {
            System.out.println("---------- Pedidos ----------");
            for (Produto pedido : pedidos) {
                System.out.println(pedido.getNome() + " - R$" + pedido.getPreco());
            }
            System.out.println("-----------------------------");
        }
    }

    // Método para exibir a capacidade da mesa
    public int exibirCapacidade() {
        return capacidade;
    }
}
