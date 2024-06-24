/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.LinkedList;
import model.Mesa;

/**
 *
 * @author Felipe
 */
public class AdicionarMesaController {
    
    private AdicionarMesaController view;
    private LinkedList<Mesa> mesas;
    
    public adicionarMesaController {
        this.mesas = Carros.getInstance();
        this.view = new AdicionarMesa();
        
        this.view.getBtnSalvar().addActionListener((e) -> {
            addMesa();
        
        this.view.getBtnCancelar().addActionListener((e) -> {
            cancelar();
        });
        
        this.view.setTxtTitle("Cadastrar Mesa");
      
        });
}
    
    public void addMesa(){
        
        int numAssento = Integer.parseInt(view.getNumAssentos().getText());
        String descricao = view.getTxtDescricao().getText();
        
        Mesa m = new Mesa(numAssento, descricao);
        
        mesa.addMesa(m);
        
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
