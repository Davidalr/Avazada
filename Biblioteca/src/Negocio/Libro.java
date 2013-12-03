/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio;

import java.util.HashMap;

/**
 *
 * @author juan2ramos
 */
public class Libro {
    
    private int id;
    private String titiulo;
    private String isbn;
    private Autor autor;
    private Materia materia;
    private int numeroEjemplares;
    private int numeroPrestamos;

    public Libro() {
    }
    
    public Libro(HashMap<String, Object> data) {
       
        update(data);
    }
    
    public void libroUpdate(HashMap<String, Object> data) {
       
        update(data);
    }
    private void update(HashMap<String, Object> data){
        this.id = (int) data.get("codigo");
        this.titiulo = (String) data.get("titulo");
        this.isbn = (String) data.get("isbn");
        this.autor =  (Autor) data.get("autor");
        this.materia = (Materia) data.get("materia");
        this.numeroEjemplares = (int) data.get("numero_ejemplares");
       
    }

    public Autor getAutor() {
        return autor;
    }

    public int getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public Materia getMateria() {
        return materia;
    }

    public int getNumeroEjemplares() {
        return numeroEjemplares;
    }

    public int getNumeroPrestamos() {
        return numeroPrestamos;
    }

    public String getTitiulo() {
        return titiulo;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public void setNumeroEjemplares(int numeroEjemplares) {
        this.numeroEjemplares = numeroEjemplares;
    }

    public void setNumeroPrestamos(int numeroPrestamos) {
        this.numeroPrestamos = numeroPrestamos;
    }

    public void setTitiulo(String titiulo) {
        this.titiulo = titiulo;
    }

    @Override
    public String toString() {
        return getTitiulo(); //To change body of generated methods, choose Tools | Templates.
    }
    
            
            
}
