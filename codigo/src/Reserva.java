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

    public void registrarEntrada() {
        this.horaChegada = LocalDateTime.now();
    }

    public void registrarSaida() {
        this.horaSaida = LocalDateTime.now();
    }

    public LocalDateTime getHoraEntrada() {
        return this.horaChegada;
    }

    public LocalDateTime getHoraSaida() {
        return this.horaSaida;
    }
}
