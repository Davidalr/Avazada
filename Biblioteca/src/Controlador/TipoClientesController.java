
        /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import BDClases.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import Negocio.*;

/**
 *
 * @author juan2ramos
 */
public class TipoClientesController {
    
    private static TipoClientesController INSTANCE = null;
    private static ArrayList<TipoCliente> tipoClientesArray = new ArrayList();

  

    public static TipoClientesController getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TipoClientesController();
            INSTANCE.llenar();
        }
        return INSTANCE;
    }

    private void llenar() {
   
        List<HashMap<String, Object>> tipoCliente = TipoClienteDB.mgr.allItem();
        
        for (int i = 0; i < tipoCliente.size(); i++) { 
            tipoClientesArray.add(new TipoCliente(tipoCliente.get(i)));         

        }
    }

    public  ArrayList<TipoCliente> getTipoClientesArray() {
        
        return tipoClientesArray;
    }
    

    
}
