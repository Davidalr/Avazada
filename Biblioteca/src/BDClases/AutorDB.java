/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BDClases;

import static BDClases.ClienteDB.mgr;
import Servicios.DBManager;
import Negocio.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AutorDB extends DBManager {

    public static AutorDB mgr = new AutorDB();

    private AutorDB() {
    }

    protected void addObject(Vector v, ResultSet rs) {
        //v.add( new Cliente( rs ) );
    }

    public List<HashMap<String, Object>>  allItem() {
         
        
        return executeQuery("select * from \"autor\" ");
    }

    public Cliente getItem(String id) {
        /*Vector<Cliente> v = executeQuery( "select * from \"clientes\" where id=" + id + " " );
         if ( v.size() > 0 ) {
         return v.get( 0 );
         }*/

        // return new Cliente();
        return null;
    }

    public void save(Autor m_data, Boolean valor,int codigo) {
         if( valor ){
         mgr.execute( "insert into  \"autor\" (  nombre, pais) values ("
                 + "'"+m_data.getNombre()+"',"
                 + "'"+m_data.getPais()+"',"
                 + "')");
         } else  {
         mgr.execute( "update \"autor\" set nombre= '" 
                 + m_data.getNombre() 
                 + "', pais= '" + m_data.getPais() 
                 + "' where codigo = " + m_data.getId() + "" );
         }
    }

    public void delete(Autor m_data) {
         mgr.execute("delete from \"autor\" WHERE codigo = " + m_data.getId() + "" );
    }
    /*public Vector<Cliente> getCliente() {
     Vector<Cliente> v = executeQuery( "select id, nombre, direccion, telefono from \"Clientes\"" );
     return v;
     }*/

}
