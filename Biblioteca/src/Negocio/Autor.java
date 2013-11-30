/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.util.HashMap;

/**
 *
 * @author juan2ramos
 */
public class Autor {
    private int id;
    private String nombre;
    private String pais;

    public Autor() {
    }
    public Autor(HashMap<String, Object> data) {
       
        this.id = (int) data.get("codigo");
        this.nombre = (String) data.get("nombre");
        this.pais = (String) data.get("pais");

    
    }
    public void autorUpdate(HashMap<String, Object> data){
        this.id = (int) data.get("codigo");
        this.nombre = (String) data.get("nombre");
        this.pais = (String) data.get("pais");
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return getNombre(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
