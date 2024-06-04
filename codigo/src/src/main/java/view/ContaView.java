package view;

import controller.ContaController;
import model.Conta;
import model.Pedido;

import java.util.List;
import java.util.Scanner;

public class ContaView {
    private ContaController contaController;

    public ContaView(ContaController contaController) {
        this.contaController = contaController;
    }

    public void exibirConta(List<Pedido> pedidos, int numeroDePessoas) {
        Conta conta = contaController.gerarConta((Pedido) pedidos, numeroDePessoas);
        System.out.println("Valor total: " + conta.getValorTotal());
        System.out.println("Valor por pessoa: " + conta.getValorPorPessoa());
    }
}
