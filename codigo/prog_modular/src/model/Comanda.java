package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Comanda implements Serializable {
    private static final long serialVersionUID = 1L; // Adicione um serialVersionUID

    private List<Prato> pratos;
    private List<Bebida> bebidas;

    public Comanda() {
        this.pratos = new ArrayList<>();
        this.bebidas = new ArrayList<>();
    }

    public void addPrato(Prato prato) {
        pratos.add(prato);
    }

    public void addBebida(Bebida bebida) {
        bebidas.add(bebida);
    }

    public double calcularTotal() {
        double total = 0;
        for (Prato prato : pratos) {
            total += prato.getPreco();
        }
        for (Bebida bebida : bebidas) {
            total += bebida.getPreco();
        }
        return total;
    }

    public double calcularTotalComTaxa() {
        return calcularTotal() * 1.10; // 10% de taxa de serviço
    }
}
