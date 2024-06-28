package Dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDAO {

    protected void grava(String local, List lista) {
        try {
            FileOutputStream fo = new FileOutputStream(local);
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(lista);
            oo.close();
            System.out.println("Dados gravados com sucesso");
        } catch (Exception e) {
            System.err.println("Erro ao serializar " + e.getMessage());
        }
    }

    protected List leitura(String local) {
        List retorno = new ArrayList();
        try {
            File arq = new File(local);
            FileInputStream fi = new FileInputStream(arq.getAbsolutePath());
            ObjectInputStream oi = new ObjectInputStream(fi);
            retorno = (List) oi.readObject();
            oi.close();
            return retorno;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return retorno;
        }
    }
}