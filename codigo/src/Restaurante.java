import java.util.LinkedList;

public class Restaurante {
    private LinkedList<String> lsitaDeEspera;
    private LinkedList<Reserva> reservas;
    public LinkedList<Mesa> mesas;

    public Restaurante(LinkedList<String> lsitaDeEspera, LinkedList<Reserva> reservas, LinkedList<Mesa> mesas) {
        this.lsitaDeEspera = lsitaDeEspera;
        this.reservas = reservas;
        this.mesas = mesas;
    }

    public void addProprietarioReservaListaEspera(String proprietarioReserva) {
        this.lsitaDeEspera.add(proprietarioReserva);
    }
    public void removerProprietarioReservaListaEspera(String proprietarioReserva){
        this.lsitaDeEspera.remove(proprietarioReserva);
    }
    public void addMesa(Mesa mesa) {
        this.mesas.add(mesa);
    }
    public void verificarDisponibilidade(){
        for (Mesa mesa : this.mesas) {
            if(mesa.verificarDisponibilidade()){
                System.out.println("A mesa com " + mesa.exibirCapacidade() + ": Disponivel");
            } else {
                System.out.println("A mesa com " + mesa.exibirCapacidade() + ": Ocupada");
            }
        }
    }

}
