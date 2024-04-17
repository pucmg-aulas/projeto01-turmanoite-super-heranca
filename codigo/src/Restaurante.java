import java.util.LinkedList;

public class Restaurante {
    private LinkedList<String> lsitaDeEspera;
    private LinkedList<Reserva> reservas;
    public void addClienteListaEspera(String cliente) {
        this.lsitaDeEspera.add(cliente);
    }

    public void removerClienteListaEspera(String cliente){
        this.lsitaDeEspera.remove(cliente);
    }

}
