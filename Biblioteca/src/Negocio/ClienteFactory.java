/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author juan2ramos
 */
public class ClienteFactory {
    
    public static Cliente crearCliente(int cliente,HashMap data){
        return (cliente == 1)?new Especiales(data):(cliente == 2)?new Normales(data):new Ocacionales(data);
   }
  
}
