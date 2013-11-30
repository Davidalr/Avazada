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
public class LibroController {

    private static LibroController INSTANCE = null;
    private static ArrayList<Libro> libroArray = new ArrayList();
    public static int id = 0;

    public static LibroController getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LibroController();
            INSTANCE.llenar();
        }
        return INSTANCE;
    }

    public void llenar() {

        List<HashMap<String, Object>> libros = LibroDB.mgr.allItem();
        for (int i = 0; i < libros.size(); i++) {

            int idAutor = (int) libros.get(i).get("codigo_autor");
            int idMateria = (int) libros.get(i).get("codigo_materia");
            libros.get(i).put("autor", getAutor(idAutor));
            libros.get(i).put("materia", getMateria(idMateria));
            libroArray.add(new Libro(libros.get(i)));
            if (libros.size() - 1 == i) {
                LibroController.id = (int) libros.get(i).get("codigo");
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
        data.put("codigo", LibroController.id + 1);
        Libro libro = new Libro(data);
        libroArray.add(libro);
        LibroDB.mgr.save(libro, Boolean.TRUE);

    }

    public ArrayList<Libro> getLibroArray() {
        return libroArray;
    }

}
