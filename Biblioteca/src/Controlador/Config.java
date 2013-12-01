/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Negocio.Cliente;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author juan2ramos
 */
public class Config {
    private static Config INSTANCE = null;
    private static HashMap<String, Object> prestamoCliente = new  HashMap<String, Object>();
    private HashMap<String, Object> especiales = new  HashMap<String, Object>();
    private   HashMap<String, Object> normales = new  HashMap<String, Object>() ;
    private  HashMap<String, Object> ocacionales = new  HashMap<String, Object>() ;
    public static Config getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Config();
            INSTANCE.init();
        }
        return INSTANCE;
    }

    private void init() { 
        
        especiales.put("dias", 15);
        especiales.put("libros",5);
        prestamoCliente.put("class Negocio.Especiales", especiales);
        
        
        normales.put("dias",8);
        normales.put("libros",3);
        prestamoCliente.put("class Negocio.Normales", normales);
        
        
        ocacionales.put("dias",1);
        ocacionales.put("libros",1);
        prestamoCliente.put("class Negocio.Ocacionales", ocacionales);
    }

    public  HashMap<String, Object> getPrestamoCliente() {
        return prestamoCliente;
    }
    
    
}
