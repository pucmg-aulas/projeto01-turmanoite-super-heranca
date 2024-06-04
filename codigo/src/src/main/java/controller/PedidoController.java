package controller;

import dao.PedidoDAO;
import model.Mesa;
import model.Pedido;

import java.util.List;

public class PedidoController {
    private PedidoDAO pedidoDAO;
    private List<Pedido> pedidos;

    public PedidoController() {
        this.pedidoDAO = new PedidoDAO();
        this.pedidos = pedidoDAO.getPedidos();
    }

    public void adicionarPedido(String nomeCliente, Mesa mesa, String item, double valor) {
        Pedido pedido = new Pedido(nomeCliente, mesa, item, valor);
        pedidos.add(pedido);
        pedidoDAO.salvarPedido(pedidos);
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void removerPedido(Pedido pedido) {
        pedidos.remove(pedido);
        pedidoDAO.salvarPedido(pedidos);
    }

    public double calcularTotalPedidos() {
        return pedidos.stream().mapToDouble(Pedido::getValor).sum();
    }
}
