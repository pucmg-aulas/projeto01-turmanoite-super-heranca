package model;

import java.io.Serializable;

public class Pedido implements Serializable {
    private String nomeCliente;
    private Mesa mesa;
    private String item;
    private double valor;

    public Pedido(String nomeCliente, Mesa mesa, String item, double valor) {
        this.nomeCliente = nomeCliente;
        this.mesa = mesa;
        this.item = item;
        this.valor = valor;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public String getItem() {
        return item;
    }

    public double getValor() {
        return valor;
    }

    public int getId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
