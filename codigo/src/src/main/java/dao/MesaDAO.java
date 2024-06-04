package dao;

import model.Mesa;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MesaDAO {
    private static final String FILE_PATH_MESAS = "data/mesas.ser";
    private List<Mesa> mesas;

    public MesaDAO() {
        this.mesas = new ArrayList<>();
        carregarMesas();
    }

    public void salvarMesas(List<Mesa> mesas) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH_MESAS))) {
            oos.writeObject(mesas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void carregarMesas() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH_MESAS))) {
            mesas = (List<Mesa>) ois.readObject();
        } catch (FileNotFoundException e) {
            mesas = new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            mesas = new ArrayList<>();
        }
    }

    public List<Mesa> getMesas() {
        return mesas;
    }

    public void adicionarMesa(Mesa mesa) {
        mesas.add(mesa);
        salvarMesas(mesas);
    }

    public void removerMesa(Mesa mesa) {
        mesas.remove(mesa);
        salvarMesas(mesas);
    }

    public void atualizarMesa(Mesa mesa) {
        for (int i = 0; i < mesas.size(); i++) {
            if (mesas.get(i).getId() == mesa.getId()) {
                mesas.set(i, mesa);
                break;
            }
        }
        salvarMesas(mesas);
    }
}
