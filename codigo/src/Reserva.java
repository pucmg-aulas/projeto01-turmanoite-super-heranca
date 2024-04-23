import java.time.LocalDateTime;

public class Reserva {
    private LocalDateTime horaChegada;
    private LocalDateTime horaSaida;
    private PropietarioReserva propietarioReserva;
    private Mesa mesa;

    public Reserva(LocalDateTime horaChegada, LocalDateTime horaSaida, PropietarioReserva propietarioReserva, Mesa mesa){
        this.horaChegada = LocalDateTime;
        this.horaSaida = LocalDateTime;
        this.proprietarioReserva = proprietarioReserva;
        this.mesa = mesa;
    }

    public void fazerReserva(PropietarioReserva propietarioReserva, Mesa mesa) {
        this.horaChegada = LocalDateTime.now();
        this.propietarioReserva = propietarioReserva;
        this.mesa = mesa;
    }
    public void encerrarReserva() {
        this.horaSaida = LocalDateTime.now();
    }
}
