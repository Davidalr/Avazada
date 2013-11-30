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

public class MateriaDB extends DBManager {

    public static MateriaDB mgr = new MateriaDB();

    private MateriaDB() {
    }

    protected void addObject(Vector v, ResultSet rs) {
        //v.add( new Cliente( rs ) );
    }

    public List<HashMap<String, Object>>  allItem() {
         
        
        return executeQuery("select * from \"materia\" ");
    }

    public Cliente getItem(String id) {
        /*Vector<Cliente> v = executeQuery( "select * from \"clientes\" where id=" + id + " " );
         if ( v.size() > 0 ) {
         return v.get( 0 );
         }*/

        // return new Cliente();
        return null;
    }

    public void save(Materia m_data, Boolean valor) {
         if( valor ){
         mgr.execute( "insert into  \"materia\" (  nombre) values ("
                 + "'"+m_data.getNombre()+"'"
                 + ")");
         } else  {
         mgr.execute( "update \"materia\" set nombre= '" 
                 + m_data.getNombre() 
                 + "' where codigo = " + m_data.getId() + "" );
         }
    }

    public void delete(Materia m_data) {
         mgr.execute("delete from \"materia\" WHERE codigo = " + m_data.getId() + "" );
    }
    /*public Vector<Cliente> getCliente() {
     Vector<Cliente> v = executeQuery( "select id, nombre, direccion, telefono from \"Clientes\"" );
     return v;
     }*/

}
