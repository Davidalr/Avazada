/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BDClases;

import Servicios.DBManager;
import Negocio.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDB extends DBManager {

    public static ClienteDB mgr = new ClienteDB();

    private ClienteDB() {
    }

    protected void addObject(Vector v, ResultSet rs) {
        //v.add( new Cliente( rs ) );
    }

    public List<HashMap<String, Object>>  allItem() {
         
        
        return executeQuery("select * from \"clientes\" ");
    }

    public Cliente getItem(String id) {
        /*Vector<Cliente> v = executeQuery( "select * from \"clientes\" where id=" + id + " " );
         if ( v.size() > 0 ) {
         return v.get( 0 );
         }*/

        // return new Cliente();
        return null;
    }

    public void save(Cliente m_data, Boolean valor) {
        /* if( valor ){
         mgr.execute( "insert into \"Clientes\"( id, nombre, direccion, telefono) values( " +
         m_data.id + ", '" +
         m_data.nombre + "', '" +
         m_data.direccion + "', '" +
         m_data.telefono + "' )" );
         } else  {
         mgr.execute( "update Cliente set direccion= '" + m_data.direccion +
         "', telefono= '" + m_data.telefono +
         "', nombre= '" + m_data.nombre +
         "' where id = " + m_data.id + "" );
         }*/
    }

    public void delete(Cliente m_data) {
        // mgr.execute("delete from Cliente WHERE id = " + m_data.id + "" );
    }
    /*public Vector<Cliente> getCliente() {
     Vector<Cliente> v = executeQuery( "select id, nombre, direccion, telefono from \"Clientes\"" );
     return v;
     }*/

}
