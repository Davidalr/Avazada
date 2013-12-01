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
    private String fechaDevolucion ;
    private Libro libro;
    private Cliente cliente;
//
    public Prestamo() {
    }
    public Prestamo(HashMap<String, Object> data) {
        update(data);
    }
    public void prestamoUpdate(HashMap<String, Object> data){
        System.out.print("/"+data.get("codigo")+"/");;
        update(data);
    }
    private void update(HashMap<String, Object> data){
        this.id = (int) data.get("codigo");
        this.fecha = (String) data.get("fecha");
        this.fechaDevolucion = (String) data.get("fecha_devolucion");
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

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
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
