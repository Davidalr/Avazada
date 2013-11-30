/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.sql.ResultSet;
import java.util.HashMap;

/**
 *
 * @author juan2ramos
 */
public abstract class Cliente {

    private int id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String fechaNacimeinto;

    public Cliente(int id, String nombre, String apellido, String telefono, String fechaNacimeinto) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.fechaNacimeinto = fechaNacimeinto;
    }

    public Cliente(HashMap<String, Object> data) {

        //this.id = (int) data.get("codigo");
        this.nombre = (String) data.get("nombre");
        this.apellido = (String) data.get("apellido");
        this.telefono = (String) data.get("telefono");
        this.fechaNacimeinto = (String) data.get("fecha_nacimeinto");

    }

    public Cliente() {
    }

    ;

    public String getApellido() {
        return apellido;
    }

    public String getFechaNacimeinto() {
        return fechaNacimeinto;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setFechaNacimeinto(String fechaNacimeinto) {
        this.fechaNacimeinto = fechaNacimeinto;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {

        return getNombre() + " " + getApellido(); //To change body of generated methods, choose Tools | Templates.
    }

}
