/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Felipe
 */
public class Mesas extends AbstractDAO implements Serializable{

    private List<Mesas> mesas;
    // Atributo da própria classe, estático, para implementar o Singleton
    private static Mesas instance;
    
    //Endereço do arquivo serializado que contém a coleção de carros
    private final String localArquivo = "./src/main/java/data/Mesas.dat";

    //Construtor privado, pois não podemos permitir mais de uma instância desta classe
    //que controla a coleção de carros do sistema (Singleton)
    private Mesas() {
        this.mesas = new ArrayList<>();
        carregaMesas();
    }
}
