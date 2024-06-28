package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Comanda implements Serializable {
    private List<Prato> pratos;
    private List<Bebida> bebidas;
    private String formaPag;

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

    public List<Prato> getPratos() {
        return pratos;
    }

    public List<Bebida> getBebidas() {
        return bebidas;
    }

    public void removePrato(String nomePrato) {
        pratos.removeIf(prato -> prato.getNome().equalsIgnoreCase(nomePrato));
    }

    public void removeBebida(String nomeBebida) {
        bebidas.removeIf(bebida -> bebida.getNome().equalsIgnoreCase(nomeBebida));
    }

    public String getFormaPag(){
        return this.formaPag;
    }

    public void setFormaPag(String formaPag){
        this.formaPag = formaPag;
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
