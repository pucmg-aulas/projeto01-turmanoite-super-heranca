package dao;

import model.Pedido;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO {
    private static final String FILE_PATH = "data/pedidos.ser";
    private List<Pedido> pedidos;

    public PedidoDAO() {
        this.pedidos = new ArrayList<>();
        carregarPedidos();
    }

    public void salvarPedido(List<Pedido> pedidos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(pedidos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    private void carregarPedidos() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            pedidos = (List<Pedido>) ois.readObject();
        } catch (FileNotFoundException e) {
            pedidos = new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
