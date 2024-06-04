package controller;

import java.util.List;
import model.Conta;
import model.Pedido;

public class ContaController {
    public Conta gerarConta(Pedido pedido, int numeroDePessoas) {
        return new Conta((List<Pedido>) pedido, numeroDePessoas);
    }
}
