import java.time.LocalDateTime;

public class Reserva {
    private LocalDateTime horaChegada;
    private LocalDateTime horaSaida;
    private PropietarioReserva propietarioReserva;
    private Mesa mesa;

    public Reserva(PropietarioReserva propietarioReserva, Mesa mesa){
        this.propietarioReserva = propietarioReserva;
        this.mesa = mesa;
        this.horaChegada = LocalDateTime.now();
    }

    public void encerrar() {
        this.mesa.desocuparMesa();
        this.horaSaida = LocalDateTime.now();
    }

    public LocalDateTime getHoraEntrada() {
        return this.horaChegada;
    }

    public LocalDateTime getHoraSaida() {
        return this.horaSaida;
    }

    public String getNomePropietario(){
        return this.propietarioReserva.getNome();
    }

    public int getCapacidadeMesa(){
        return this.mesa.exibirCapacidade();
    }
}
