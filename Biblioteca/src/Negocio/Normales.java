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
public class Normales extends Cliente{

    public Normales(int id, String nombre, String apellido, String telefono, String fechaNacimeinto) {
        super(id, nombre, apellido, telefono, fechaNacimeinto);
    }
    public Normales(HashMap data){
        super(data);
    };
    
}
