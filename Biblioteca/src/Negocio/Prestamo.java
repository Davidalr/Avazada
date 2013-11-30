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
public class Prestamo {
    private int id;
    private String fecha ;
    private Libro libro;
    private Cliente cliente;

    public Prestamo() {
    }
    public Prestamo(HashMap<String, Object> data) {
        autorUpdate(data);
    }
    public void autorUpdate(HashMap<String, Object> data){
        this.id = (int) data.get("codigo");
        this.fecha = (String) data.get("fecha");
        this.libro = (Libro) data.get("codigo_libro");
        this.cliente = (Cliente) data.get("codigo_cliente");
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getFecha() {
        return fecha;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    @Override
    public String toString() {
        return getLibro()+" - "+getCliente(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
