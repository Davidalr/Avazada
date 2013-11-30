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
public class MateriaController {

    private static MateriaController INSTANCE = null;
    private static ArrayList<Materia> materiaArray = new ArrayList();
    public static int id=0;
    public static MateriaController getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MateriaController();
            INSTANCE.llenar();
        }
        return INSTANCE;
    }

    private void llenar() {

        List<HashMap<String, Object>> materias = MateriaDB.mgr.allItem();

        for (int i = 0; i < materias.size(); i++) {
            materiaArray.add(new Materia(materias.get(i)));
            if (materias.size() - 1 == i) {
                MateriaController.id = (int) materias.get(i).get("codigo");
            }
        }

    }

    public void llenarMateria(HashMap<String, Object> data) {
        data.put("codigo", MateriaController.id+1);
        Materia materia = new Materia(data);
        materiaArray.add(materia);
        MateriaDB.mgr.save(materia, true);
    }

    public void actualizarMateria(Materia materia, HashMap<String, Object> data) {
        materia.materiaUpdate(data);
        MateriaDB.mgr.save(materia, false);
    }

    public void eliminarMateria(Materia materia) {
        materiaArray.remove(materia);
        MateriaDB.mgr.delete(materia);
    
    }

    public ArrayList<Materia> getMateriaArray() {
        return materiaArray;
    }
}
