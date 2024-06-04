package dao;

import model.Reserva;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO {
    private static final String FILE_PATH_RESERVAS = "data/reservas.ser";
    private static final String FILE_PATH_LISTA_DE_ESPERA = "data/lista_espera.ser";
    private List<Reserva> reservas;
    private List<Reserva> listaDeEspera;

    public ReservaDAO(List<Reserva> reservas, List<Reserva> listaDeEspera) {
        this.reservas = reservas;
        this.listaDeEspera = listaDeEspera;
        carregarReservas();
    }

    public void salvarReservas(List<Reserva> reservas, List<Reserva> listaDeEspera) {
        salvarLista(reservas, FILE_PATH_RESERVAS);
        salvarLista(listaDeEspera, FILE_PATH_LISTA_DE_ESPERA);
    }

    private void salvarLista(List<?> lista, String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void carregarReservas() {
        reservas = carregarLista(FILE_PATH_RESERVAS);
        listaDeEspera = carregarLista(FILE_PATH_LISTA_DE_ESPERA);
    }

    private <T> List<T> carregarLista(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (List<T>) ois.readObject();
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
