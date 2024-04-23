import java.util.Date;

public class PropietarioReserva {
    private String nome;
    private int telefone;
    private int totalPessoas;
    private int cpf;

    // Construtor
    public PropietarioReserva(String nome, int telefone, int totalPessoas, int cpf) {
        this.nome = nome;
        this.telefone = telefone;
        this.totalPessoas = totalPessoas;
        this.cpf = cpf;
    }

    // Método para registrar a entrada do cliente
    public void registrarEntrada(Date dataEntrada) {
        // Registra a data e hora atual como a entrada do cliente
        Date dataEntrada = new Date();
        System.out.println("Entrada registrada para " + this.nome + " em " + dataEntrada);
    }

    // Método para registrar a saída do cliente
    public void registrarSaida(Date dataSaida) {
        // Registra a data e hora atual como a entrada do cliente
        Date dataEntrada = new Date();
        System.out.println("Entrada registrada para " + this.nome + " em " + dataEntrada);
    }

    // Método para atualizar o nome do cliente
    public void setNome(String novoNome) {
        this.nome = novoNome;
    }

    // Método para atualizar o telefone do cliente
    public void setTelefone(int novoTelefone) {
        this.telefone = novoTelefone;
    }

    // Método para atualizar o CPF do cliente
    public void setCpf(int novoCpf) {
        this.cpf = novoCpf;
    }
    
    // Método para atualizar o total de pessoas na reserva do cliente
    public void setTotalPessoas(int novoTotalPessoas) {
        this.totalPessoas = novoTotalPessoas;
    }

    // Métodos de acesso (getters)
    public String getNome() {
        return this.nome;
    }

    public int getTelefone() {
        return this.telefone;
    }

    public int getTotalPessoas() {
        return this.totalPessoas;
    }

    public int getCpf() {
        return this.cpf;
    }
}
