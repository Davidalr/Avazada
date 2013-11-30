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
    public static int id;
    
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
            if(clientes.size()- 1 == i){
                ClienteController.id = (int) clientes.get(i).get("codigo");
            }
            

        }
    }

    public void llenarCLiente(HashMap<String, Object> data,Boolean b) {
        
        int codigo_tipo = (int) data.get("codigo_tipo_clientes");
        
        Cliente cliente = ClienteFactory.crearCliente(codigo_tipo, data);        
        clientesArray.add(cliente);
        if (b){
            ClienteDB.mgr.save(cliente, true,codigo_tipo);
        }
        
    }
    public void actualizarCliente(Cliente cliente, HashMap<String, Object> data,int claseHash){
        int claseCliente = ("class Negocio.Normales".equals(cliente.getClass().toString())) ? 1 : ("class  Negocio.Normales".equals(cliente.getClass().toString())) ? 2 : 3;
        
        
        if(claseHash == claseCliente){
           cliente.clienteUpdate(data);
            
        }else{
            ClienteController.clientesArray.remove(cliente);
            llenarCLiente(data,false);
        }
        ClienteDB.mgr.save(cliente, false,claseHash);
        
        
    }
    public void eliminar(Cliente cliente){
        ClienteController.clientesArray.remove(cliente);
        ClienteDB.mgr.delete(cliente);
    }

    public  ArrayList<Cliente> getClientesArray() {
        return clientesArray;
    }
    
    
}
