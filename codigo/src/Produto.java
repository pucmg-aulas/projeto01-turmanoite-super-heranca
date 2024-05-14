import java.util.ArrayList;
import java.util.List;

public class Produto {
    private String nome;
    private double preco;
    private String descricao;
    private static List<Produto> produtos = new ArrayList<>();

    // Construtor
    public Produto(String nome, double preco, String descricao) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removerProduto(Produto produto) {
        if (produtos.remove(produto)) {
            System.out.println("Produto removido com sucesso");
        } else {
            System.out.println("Produto não encontrado");
        }
    }
}

