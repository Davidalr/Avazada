/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;
import Servicios.DBManager;
import com.sun.jmx.remote.internal.ClientCommunicatorAdmin;
import java.sql.SQLException;
import Vista.Principal;
/**
 *
 * @author juan2ramos
 */
public class Biblioteca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        
        new ClienteController().llenarClientes();
         new Principal().setVisible(true);
    }
    
}
