import java.util.ArrayList;
import java.util.List;

public class Produto {
    // Variáveis de instância para armazenar o nome, preço e descrição do produto
    private String nome;
    private double preco;
    private String descricao;

    // Lista estática para armazenar todos os produtos
    private static List<Produto> produtos = new ArrayList<>();

    // Construtor da classe Produto
    // Inicializa as variáveis de instância com os valores fornecidos
    public Produto(String nome, double preco, String descricao) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
    }

    // Método getter para obter o nome do produto
    public String getNome() {
        return nome;
    }

    // Método getter para obter o preço do produto
    public double getPreco() {
        return preco;
    }

    // Método getter para obter a descrição do produto
    public String getDescricao() {
        return descricao;
    }

    // Método para adicionar um produto à lista de produtos
    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    // Método para remover um produto da lista de produtos
    public void removerProduto(Produto produto) {
        // Tenta remover o produto da lista
        if (produtos.remove(produto)) {
            // Se o produto foi removido com sucesso, imprime uma mensagem de sucesso
            System.out.println("Produto removido com sucesso");
        } else {
            // Se o produto não foi encontrado na lista, imprime uma mensagem de erro
            System.out.println("Produto não encontrado");
        }
    }
}
