/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import model.Mesa;


/**
 *
 * @author Felipe
 */
public class Mesas extends AbstractDAO implements Serializable {

    private List<Mesa> mesas;
    // Atributo da própria classe, estático, para implementar o Singleton
    private static Mesas instance;
    
    //Endereço do arquivo serializado que contém a coleção de mesas
    private final String localArquivo = "./src/data/Mesas.dat";

    // Construtor privado, pois não podemos permitir mais de uma instância desta classe
    // que controla a coleção de mesas do sistema (Singleton)
    private Mesas() {
        this.mesas = new ArrayList<>(); // Inicializando com ArrayList
        carregaMesas();
    }
    
    // Método para recuperar a única instância de Mesas
    public static Mesas getInstance() {
        if (instance == null) {
            instance = new Mesas();
        }
        return instance;
    }
    
    public void addMesas(Mesa mesa) {
        this.mesas.add(mesa);
        grava();
    }

    private void grava() {
        super.grava(localArquivo, mesas);
    }

    private void carregaMesas(){
        
        this.mesas = super.leitura(localArquivo);
    }
    
}
