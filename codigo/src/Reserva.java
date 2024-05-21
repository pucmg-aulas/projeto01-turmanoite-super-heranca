import java.time.LocalDateTime;

public class Reserva {
    // Variáveis de instância para armazenar a hora de chegada, hora de saída, proprietário da reserva e mesa associada
    private LocalDateTime horaChegada;
    private LocalDateTime horaSaida;
    private PropietarioReserva propietarioReserva;
    private Mesa mesa;

    // Construtor da classe Reserva
    // Inicializa as variáveis de instância com os valores fornecidos e define a hora de chegada como o momento atual
    public Reserva(PropietarioReserva propietarioReserva, Mesa mesa) {
        this.propietarioReserva = propietarioReserva;
        this.mesa = mesa;
        this.horaChegada = LocalDateTime.now(); // Define a hora de chegada como o momento atual
    }

    // Método para encerrar a reserva
    // Desocupa a mesa e define a hora de saída como o momento atual
    public void encerrar() {
        this.mesa.desocuparMesa(); // Desocupa a mesa
        this.horaSaida = LocalDateTime.now(); // Define a hora de saída como o momento atual
    }

    // Método getter para obter a hora de chegada
    public LocalDateTime getHoraEntrada() {
        return this.horaChegada;
    }

    // Método getter para obter a hora de saída
    public LocalDateTime getHoraSaida() {
        return this.horaSaida;
    }

    // Método para obter o nome do proprietário da reserva
    public String getNomePropietario() {
        return this.propietarioReserva.getNome();
    }

    // Método para obter a capacidade da mesa associada à reserva
    public int getCapacidadeMesa() {
        return this.mesa.exibirCapacidade();
    }

    // Método getter para obter o proprietário da reserva
    public PropietarioReserva getPropietarioReserva() {
        return this.propietarioReserva;
    }
}
