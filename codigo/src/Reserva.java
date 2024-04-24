import java.time.LocalDateTime;

public class Reserva {
    private LocalDateTime horaChegada;
    private LocalDateTime horaSaida;
    private PropietarioReserva propietarioReserva;
    private Mesa mesa;

    public Reserva(PropietarioReserva propietarioReserva, Mesa mesa){
        this.propietarioReserva = propietarioReserva;
        this.mesa = mesa;
    }

    public void fazerReserva() {
        this.mesa.ocuparMesa();
        this.horaChegada = LocalDateTime.now();
    }

    public void encerrarReserva() {
        this.horaSaida = LocalDateTime.now();
    }
}
