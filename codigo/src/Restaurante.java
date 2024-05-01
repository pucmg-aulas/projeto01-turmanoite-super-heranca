import java.util.LinkedList;

public class Restaurante {
    private LinkedList<PropietarioReserva> lsitaDeEspera;
    private LinkedList<Reserva> reservas;
    public LinkedList<Mesa> mesas;

    public Restaurante(LinkedList<PropietarioReserva> lsitaDeEspera, LinkedList<Reserva> reservas, LinkedList<Mesa> mesas) {
        this.lsitaDeEspera = lsitaDeEspera;
        this.reservas = reservas;
        this.mesas = mesas;
    }

    public void addProprietarioReservaListaEspera(PropietarioReserva proprietarioReserva) {
        this.lsitaDeEspera.add(proprietarioReserva);
    }

    public void removerProprietarioReservaListaEspera(PropietarioReserva proprietarioReserva){
        this.lsitaDeEspera.remove(proprietarioReserva);
    }

    public void addMesa(Mesa mesa) {
        this.mesas.add(mesa);
    }

    public void addReserva(PropietarioReserva propietarioReserva, Mesa mesa) {
        this.reservas.add( new Reserva(propietarioReserva, mesa));
        mesa.ocuparMesa();
    }

    public int qtdReservasAtuais(){
        return this.reservas.size();
    }
    public Reserva getReserva(int indiceReserva){
        return this.reservas.get(indiceReserva);
    }
    public void encerrarReserva(Reserva reserva){
        reserva.encerrar();
        this.reservas.remove(reserva);
    }

    public void exibirReservas(){
        int indice = 1;
        for(Reserva res : this.reservas){
            System.out.println(indice + " - Reserva: " + res.getNomePropietario() + " - " + res.getCapacidadeMesa() + " lugares");
            indice++;
        }
    }
    public void exibirListaDeEspera(){
        int indice = 1;
        for(PropietarioReserva cliente : this.lsitaDeEspera){
            System.out.println(indice + " - Cliente: " + cliente.getNome() + " - Telefone: " + cliente.getTelefone());
            indice++;
        }
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
