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
public class Especiales extends Cliente{

    public Especiales(int id, String nombre, String apellido, String telefono, String fechaNacimeinto) {
        super(id, nombre, apellido, telefono, fechaNacimeinto);
    }
    public Especiales(HashMap data){
        super(data);
    };
    
    
    
}
