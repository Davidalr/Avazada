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
public class TipoCliente {
    
    private int id;
    private String nombre;

    public TipoCliente() {
    }
    public TipoCliente(HashMap<String, Object> data) {
       
        this.id = (int) data.get("codigo");
        this.nombre = (String) data.get("nombre");

    }

    public TipoCliente(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return getNombre(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
