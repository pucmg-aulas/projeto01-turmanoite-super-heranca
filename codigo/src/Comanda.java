import java.util.ArrayList;
import java.util.List;

public class Comanda {
    // Lista de produtos pedidos na comanda
    private List<Produto> produtos;

    // Reserva associada à comanda
    private Reserva reserva;

    // Construtor que inicializa a comanda com uma reserva e uma lista de produtos vazia
    public Comanda(Reserva reserva) {
        this.reserva = reserva;
        this.produtos = new ArrayList<>();
    }

    // Método para adicionar um produto à comanda
    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    // Método para remover um produto da comanda
    public void removerProduto(Produto produto) {
        produtos.remove(produto);
    }

    // Método para calcular o total da comanda, incluindo a taxa de serviço de 10%
    public double calcularTotal() {
        double subtotal = 0.0;
        for (Produto produto : produtos) {
            subtotal += produto.getPreco(); // Soma o preço de cada produto
        }
        double taxaServico = subtotal * 0.10; // Calcula a taxa de serviço (10% do subtotal)
        return subtotal + taxaServico; // Retorna o total incluindo a taxa de serviço
    }

    // Método para dividir o total da conta pelo número de pessoas na reserva
    public double dividirConta() {
        double total = calcularTotal();
        return total / reserva.getPropietarioReserva().getTotalPessoas(); // Divide o total pelo número de pessoas na reserva
    }

    // Método para exibir a conta detalhada no console
    public void exibirConta() {
        System.out.println("Conta da reserva de " + reserva.getNomePropietario() + " com capacidade para " + reserva.getPropietarioReserva().getTotalPessoas() + " pessoas:");
        for (Produto produto : produtos) {
            System.out.println(produto.getNome() + " - R$" + produto.getPreco()); // Exibe cada produto com seu preço
        }
        double subtotal = calcularTotal() - (calcularTotal() / 1.10);
        double taxaServico = calcularTotal() - subtotal;
        double total = calcularTotal();
        System.out.println("Subtotal: R$" + String.format("%.2f", subtotal));
        System.out.println("Taxa de serviço (10%): R$" + String.format("%.2f", taxaServico));
        System.out.println("Total: R$" + String.format("%.2f", total));
        System.out.println("Valor por pessoa: R$" + String.format("%.2f", dividirConta()));
    }

    // Getters e Setters
    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
}
