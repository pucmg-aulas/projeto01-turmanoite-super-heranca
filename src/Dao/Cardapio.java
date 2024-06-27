package Dao;

import model.Bebida;
import model.Prato;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cardapio extends AbstractDAO implements Serializable {

    private List<Prato> pratos;
    private List<Bebida> bebidas;
    private static Cardapio instance;

    private final String localArquivo = "./src/data/Cardapio.dat";

    private Cardapio() {
        this.pratos = new ArrayList<>();
        this.bebidas = new ArrayList<>();
        carregaCardapio();
    }

    public static Cardapio getInstance() {
        if (instance == null) {
            instance = new Cardapio();
        }
        return instance;
    }

    public void adicionarPrato(Prato prato) {
        this.pratos.add(prato);
    }

    public void removerPrato(String nomePrato) {
        pratos.removeIf(prato -> prato.getNome().equals(nomePrato));
    }

    public List<Prato> getPratos() {
        return pratos;
    }

    public void adicionarBebida(Bebida bebida) {
        this.bebidas.add(bebida);
    }

    public void removerBebida(String nomeBebida) {
        bebidas.removeIf(bebida -> bebida.getNome().equals(nomeBebida));
    }

    public List<Bebida> getBebidas() {
        return bebidas;
    }

    public void gravaCardapio() {
        List<Object> cardapio = new ArrayList<>();
        cardapio.addAll(pratos);
        cardapio.addAll(bebidas);
        super.grava(localArquivo, cardapio);
    }

    private void carregaCardapio() {
        List<Object> cardapio = super.leitura(localArquivo);
        if (cardapio != null) {
            for (Object obj : cardapio) {
                if (obj instanceof Prato) {
                    pratos.add((Prato) obj);
                } else if (obj instanceof Bebida) {
                    bebidas.add((Bebida) obj);
                }
            }
        }
    }
}
