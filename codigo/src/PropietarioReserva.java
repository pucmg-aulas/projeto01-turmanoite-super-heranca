public class PropietarioReserva {
    private String nome;
    private String telefone;
    private int totalPessoas;
    private String cpf;

    // Construtor
    public PropietarioReserva(String nome, String telefone, int totalPessoas, String cpf) {
        this.nome = nome;
        this.telefone = telefone;
        this.totalPessoas = totalPessoas;
        this.cpf = cpf;
    }

    // Método para atualizar o nome do cliente
    public void setNome(String novoNome) {
        this.nome = novoNome;
    }

    // Método para atualizar o telefone do cliente
    public void setTelefone(String novoTelefone) {
        this.telefone = novoTelefone;
    }

    // Método para atualizar o CPF do cliente
    public void setCpf(String novoCpf) {
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

    public String getTelefone() {
        return this.telefone;
    }

    public int getTotalPessoas() {
        return this.totalPessoas;
    }

    public String getCpf() {
        return this.cpf;
    }
}
