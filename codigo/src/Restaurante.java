import java.util.LinkedList;

public class Restaurante {
    // Listas para gerenciar as reservas, mesas, produtos e lista de espera
    private LinkedList<PropietarioReserva> listaDeEspera;
    private LinkedList<Reserva> reservas;
    public LinkedList<Mesa> mesas;
    public LinkedList<Produto> produtos;

    // Construtor da classe Restaurante que inicializa as listas
    public Restaurante(LinkedList<PropietarioReserva> listaDeEspera, LinkedList<Reserva> reservas, LinkedList<Mesa> mesas, LinkedList<Produto> produtos) {
        this.listaDeEspera = listaDeEspera;
        this.reservas = reservas;
        this.mesas = mesas;
        this.produtos = produtos;
    }

    // Adiciona um proprietário de reserva à lista de espera
    public void addProprietarioReservaListaEspera(PropietarioReserva proprietarioReserva) {
        this.listaDeEspera.add(proprietarioReserva);
    }

    // Remove um proprietário de reserva da lista de espera
    public void removerProprietarioReservaListaEspera(PropietarioReserva proprietarioReserva) {
        this.listaDeEspera.remove(proprietarioReserva);
    }

    // Adiciona uma mesa à lista de mesas
    public void addMesa(Mesa mesa) {
        this.mesas.add(mesa);
    }

    // Adiciona um produto ao cardápio
    public void addProduto(Produto produto) {
        this.produtos.add(produto);
    }

    // Remove um produto do cardápio
    public void removerProduto(Produto produto) {
        this.produtos.remove(produto);
    }

    // Adiciona uma reserva à lista de reservas e ocupa a mesa
    public void addReserva(PropietarioReserva propietarioReserva, Mesa mesa) {
        this.reservas.add(new Reserva(propietarioReserva, mesa));
        mesa.ocuparMesa();
    }

    // Retorna a quantidade de reservas atuais
    public int qtdReservasAtuais() {
        return this.reservas.size();
    }

    // Retorna uma reserva específica pelo índice
    public Reserva getReserva(int indiceReserva) {
        return this.reservas.get(indiceReserva);
    }

    // Encerra uma reserva, desocupando a mesa e removendo a reserva da lista
    public void encerrarReserva(Reserva reserva) {
        reserva.encerrar();
        this.reservas.remove(reserva);
    }

    // Exibe todas as reservas atuais com índice, nome do proprietário e capacidade da mesa
    public void exibirReservas() {
        int indice = 1;
        for (Reserva res : this.reservas) {
            System.out.println(indice + " - Reserva: " + res.getNomePropietario() + " - " + res.getCapacidadeMesa() + " lugares");
            indice++;
        }
    }

    // Exibe a lista de espera com índice, nome e telefone do cliente
    public void exibirListaDeEspera() {
        int indice = 1;
        for (PropietarioReserva cliente : this.listaDeEspera) {
            System.out.println(indice + " - Cliente: " + cliente.getNome() + " - Telefone: " + cliente.getTelefone());
            indice++;
        }
    }

    // Verifica e exibe a disponibilidade de todas as mesas
    public void verificarDisponibilidade() {
        for (Mesa mesa : this.mesas) {
            if (mesa.verificarDisponibilidade()) {
                System.out.println("A mesa com " + mesa.exibirCapacidade() + ": Disponível");
            } else {
                System.out.println("A mesa com " + mesa.exibirCapacidade() + ": Ocupada");
            }
        }
    }

    // Exibe todas as mesas com índice, capacidade e disponibilidade
    public void exibirMesas() {
        int indice = 1;
        for (Mesa mesa : mesas) {
            System.out.println(indice + " - " + mesa.exibirCapacidade() + " - " + (mesa.verificarDisponibilidade() ? "Disponível" : "Ocupada"));
            indice++;
        }
    }

    // Retorna a lista de mesas
    public LinkedList<Mesa> getMesas() {
        return mesas;
    }

    // Retorna a lista de produtos
    public LinkedList<Produto> getProdutos() {
        return produtos;
    }

    // Retorna um produto específico pelo índice
    public Produto getProduto(int indice) {
        return produtos.get(indice);
    }
}
