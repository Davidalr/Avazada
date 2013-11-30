/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import BDClases.*;
import Negocio.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author juan2ramos
 */
public class AutorController {

    private static AutorController INSTANCE = null;
    private static ArrayList<Autor> autorArray = new ArrayList();
    public static int id;
    public static AutorController getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AutorController();
            INSTANCE.llenar();
        }
        return INSTANCE;
    }

    private void llenar() {

        List<HashMap<String, Object>> autores = AutorDB.mgr.allItem();

        for (int i = 0; i < autores.size(); i++) {
            autorArray.add(new Autor(autores.get(i)));
            if (autores.size() - 1 == i) {
                AutorController.id = (int) autores.get(i).get("codigo");
            }
        }

    }

    public void llenarAutor(HashMap<String, Object> data) {
        autorArray.add(new Autor(data));
        AutorDB.mgr.save(data, true, AutorController.id);
    }

    public void actualizarAutor(Autor autor, HashMap<String, Object> data) {
        autor.autorUpdate(data);
    }

    public void eliminarAutor(Autor autor) {
        autorArray.remove(autor);
    }

    public ArrayList<Autor> getAutorArray() {
        return autorArray;
    }
}
