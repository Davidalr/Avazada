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
public class Materia {
    private int id;
    private String nombre;


    public Materia() {
    }
    public Materia(HashMap<String, Object> data) {
       
        this.id = (int) data.get("codigo");
        this.nombre = (String) data.get("nombre");
       

    
    }
    public void materiaUpdate(HashMap<String, Object> data){
        this.id = (int) data.get("codigo");
        this.nombre = (String) data.get("nombre");
        
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
