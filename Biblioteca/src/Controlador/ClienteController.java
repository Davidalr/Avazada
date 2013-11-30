/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import BDClases.ClienteDB;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import Negocio.*;

/**
 *
 * @author juan2ramos
 */
public class ClienteController {
    private static ClienteController INSTANCE = null;
    private static ArrayList<Cliente> clientesArray = new ArrayList();
    
    public static ClienteController getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ClienteController();
            INSTANCE.llenarClientes();
        }
        return INSTANCE;
    }
    private void llenarClientes() {
        List<HashMap<String, Object>> clientes = ClienteDB.mgr.allItem();
        for (int i = 0; i < clientes.size(); i++) {
            int tipo = (int) clientes.get(i).get("codigo_tipo_clientes");
            Cliente cliente = ClienteFactory.crearCliente(tipo, clientes.get(i));
            clientesArray.add(cliente);

        }
    }

    public String llenarCLiente(HashMap<String, Object> data) {
        
        int codigo_tipo = (int) data.get("codigo_tipo_clientes");
        System.out.print(codigo_tipo);
        Cliente cliente = ClienteFactory.crearCliente(codigo_tipo, data);
        clientesArray.add(cliente);
        return "Se agrego cliente";
    }
}
