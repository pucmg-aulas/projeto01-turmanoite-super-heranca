import java.time.LocalDateTime;

public class Reserva {
    private LocalDateTime horaChegada;
    private LocalDateTime horaSaida;
    private PropietarioReserva propietarioReserva;
    private Mesa mesa;

    public void fazerReserva(PropietarioReserva propietarioReserva, Mesa mesa) {
        this.horaChegada = LocalDateTime.now();
        this.propietarioReserva = propietarioReserva;
        this.mesa = mesa;
    }
    public void encerrarReserva() {
        this.horaSaida = LocalDateTime.now();
    }
}
