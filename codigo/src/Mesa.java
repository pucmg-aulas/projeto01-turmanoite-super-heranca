public class Mesa {
    private int capacidade;
    private boolean disponibilidade;

    public Mesa(int capacidade, boolean disponibilidade) {
        this.capacidade = capacidade;
        this.disponibilidade = disponibilidade;
    }

    public boolean verificarCapacidade(int totalDePessoas){
        return totalDePessoas <= capacidade;
    }
    public boolean verificarDisponibilidade(){
        return disponibilidade;
    }

    public void ocuparMesa(){
        disponibilidade = false;
    }

    public void desocuparMesa(){
        disponibilidade = true;
    }

    public int exibirCapacidade(){ return this.capacidade;}
}
