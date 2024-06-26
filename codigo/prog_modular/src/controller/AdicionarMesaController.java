/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Dao.Mesas;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Mesa;
import views.AdicionarMesa;

/**
 *
 * @author Felipe
 */
public class AdicionarMesaController {
    
    private AdicionarMesa view;
    private Mesas mesas;
    
    public AdicionarMesaController() {
        this.mesas = Mesas.getInstance();
        this.view = new AdicionarMesa();
        this.view.setVisible(true);
        
        this.view.getBtnSalvar().addActionListener((e) -> {
            addMesa();
        });
        this.view.getBtnCancelar().addActionListener((e) -> {
            cancelar();
        });
             
}
    
    public void addMesa(){
        
        int numAssento = Integer.parseInt(view.getNumAssentos().getText());
        String descricao = view.getTxtDescricao().getText();
        
        Mesa m = new Mesa(numAssento, descricao);
        
        this.mesas.addMesas(m);
        
        JOptionPane.showMessageDialog(view, "Mesa salva com sucesso!");
        
        //this.view.dispose();
        
        limparTela();
        
    }
    
        private void cancelar() {
        this.view.dispose();
    }
    
    private void limparTela(){
        
        this.view.getNumAssentos().setText("");
        this.view.getTxtDescricao().setText("");
    }
    
}
