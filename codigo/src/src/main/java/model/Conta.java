package model;

import java.io.Serializable;
import java.util.List;

public class Conta implements Serializable {
    private List<Pedido> pedidos;
    private double valorTotal;
    private double valorPorPessoa;
    private double taxaServico;
    private double valorFinal;

    public Conta(List<Pedido> pedidos, int numeroDePessoas) {
        this.pedidos = pedidos;
        this.valorTotal = calcularValorTotal();
        this.taxaServico = valorTotal * 0.10;
        this.valorFinal = valorTotal + taxaServico;
        this.valorPorPessoa = valorFinal / numeroDePessoas;
    }

    private double calcularValorTotal() {
        return pedidos.stream().mapToDouble(Pedido::getValor).sum();
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public double getValorPorPessoa() {
        return valorPorPessoa;
    }

    public double getTaxaServico() {
        return taxaServico;
    }

    public double getValorFinal() {
        return valorFinal;
    }
}
