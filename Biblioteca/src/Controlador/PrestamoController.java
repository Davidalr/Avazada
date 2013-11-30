/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import BDClases.*;
import Negocio.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author juan2ramos
 */
public class PrestamoController {

    private static PrestamoController INSTANCE = null;
    private static ArrayList<Prestamo> prestamoArray = new ArrayList();
    public static int id = 0;

    public static PrestamoController getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PrestamoController();
            INSTANCE.llenar();
        }
        return INSTANCE;
    }

    public void llenar() {

        List<HashMap<String, Object>> prestamos = PrestamoDB.mgr.allItem();
        for (int i = 0; i < prestamos.size(); i++) {

            int idlibro = (int) prestamos.get(i).get("codigo_libro");
            int idCliente = (int) prestamos.get(i).get("codigo_cliente");
            libros.get(i).put("codigo_libro", getAutor(idlibro));
            libros.get(i).put("materia", getMateria(idMateria));
            libroArray.add(new Libro(libros.get(i)));
            if (libros.size() - 1 == i) {
                PrestamoController.id = (int) libros.get(i).get("codigo");
            }
        }
    }

    private Autor getAutor(int idAutor) {
        ArrayList<Autor> autores = AutorController.getInstance().getAutorArray();
        Iterator it = autores.iterator();
        while (it.hasNext()) {
            Autor autor = (Autor) it.next();
            if (idAutor == autor.getId()) {
                return autor;
            }
        }
        return null;
    }

    private Materia getMateria(int idMateria) {
        ArrayList<Materia> materias = MateriaController.getInstance().getMateriaArray();
        Iterator it = materias.iterator();
        while (it.hasNext()) {
            Materia materia = (Materia) it.next();
            if (idMateria == materia.getId()) {
                return materia;
            }
        }
        return null;
    }

    public void actualizarLibro(Libro libro, HashMap<String, Object> data) {
        libro.libroUpdate(data);
        LibroDB.mgr.save(libro, false);
    }

    public ArrayList<Materia> materias() {
        return MateriaController.getInstance().getMateriaArray();
    }

    public ArrayList<Autor> autores() {
        return AutorController.getInstance().getAutorArray();
    }

    public void llenarLibro(HashMap<String, Object> data) {
        data.put("codigo", PrestamoController.id + 1);
        Libro libro = new Libro(data);
        libroArray.add(libro);
        LibroDB.mgr.save(libro, Boolean.TRUE);

    }

    public ArrayList<Libro> getLibroArray() {
        return libroArray;
    }

}
