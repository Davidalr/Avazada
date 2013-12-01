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

public class PrestamoDB extends DBManager {

    public static PrestamoDB mgr = new PrestamoDB();

    private PrestamoDB() {
    }

    protected void addObject(Vector v, ResultSet rs) {
        //v.add( new Cliente( rs ) );
    }

    public List<HashMap<String, Object>> allItem() {

        return executeQuery("select * from \"prestamo\" ");
    }

    public Cliente getItem(String id) {
        /*Vector<Cliente> v = executeQuery( "select * from \"clientes\" where id=" + id + " " );
         if ( v.size() > 0 ) {
         return v.get( 0 );
         }*/

        // return new Cliente();
        return null;
    }

    public void save(Prestamo m_data, Boolean valor) {
        String idCliente = Integer.toString(m_data.getCliente().getId());
        String idLibro = Integer.toString(m_data.getLibro().getId());
        
        if (valor) {
            mgr.execute("insert into  \"prestamo\" (  fecha, codigo_clientes,fecha_devolucion,"
                    + "codigo_libros) values ("
                    + "'" + m_data.getFecha() + "',"
                    + "'" + idCliente + "',"
                    + "" + m_data.getFechaDevolucion() + ","
                    + "'" + idLibro + "'"
                    + ")");
        } else {
          String sql =  "update \"prestamo\" set fecha= '"
                    + m_data.getFecha()
                    + "', codigo_clientes= '" + idCliente
                    + "', fecha_devolucion= '" + m_data.getFechaDevolucion()
                    + "', codigo_libros= '" + idLibro
                    + "' where codigo = " + m_data.getId() + "";
            System.out.println("---"+sql);
            mgr.execute(sql);
        }
    }

    public void delete(Autor m_data) {
        mgr.execute("delete from \"prestamo\" WHERE codigo = " + m_data.getId() + "");
    }
    /*public Vector<Cliente> getCliente() {
     Vector<Cliente> v = executeQuery( "select id, nombre, direccion, telefono from \"Clientes\"" );
     return v;
     }*/

}
