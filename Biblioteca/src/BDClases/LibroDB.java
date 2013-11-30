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

public class LibroDB extends DBManager {

    public static LibroDB mgr = new LibroDB();

    private LibroDB() {
    }

    protected void addObject(Vector v, ResultSet rs) {
        //v.add( new Cliente( rs ) );
    }

    public List<HashMap<String, Object>> allItem() {

        return executeQuery("select * from \"libros\" ");
    }

    public Cliente getItem(String id) {
        /*Vector<Cliente> v = executeQuery( "select * from \"clientes\" where id=" + id + " " );
         if ( v.size() > 0 ) {
         return v.get( 0 );
         }*/

        // return new Cliente();
        return null;
    }

    public void save(Libro m_data, Boolean valor) {
        String numeroEjemplares = Integer.toString(m_data.getNumeroEjemplares());
        String numeroPrestamos = Integer.toString(m_data.getNumeroPrestamos());
        String idMateria = Integer.toString(m_data.getMateria().getId());
        String idAutor = Integer.toString(m_data.getAutor().getId());
        if (valor) {

            mgr.execute("insert into  \"libros\" (  titulo, isbn,numero_ejemplares,"
                    + " numero_prestamos, codigo_materia,codigo_autor) values ("
                    + "'" + m_data.getTitiulo() + "',"
                    + "'" + m_data.getIsbn() + "',"
                    + "'" + numeroEjemplares + "',"
                    + "'" + numeroPrestamos + "',"
                    + "'" + idMateria + "',"
                    + "'" + idAutor + "'"
                    + ")");
        } else {
            mgr.execute("update \"libros\" set titulo= '"
                    + m_data.getTitiulo()
                    + "', isbn= '" + m_data.getIsbn()
                    + "', numero_ejemplares= '" + numeroEjemplares
                    + "', numero_prestamos= '" + numeroPrestamos
                    + "', codigo_materia= '" + idMateria
                    + "', codigo_autor= '" + idAutor
                    + "' where codigo = " + m_data.getId() + "");
        }
    }

    public void delete(Libro m_data) {
        mgr.execute("delete from \"libros\" WHERE codigo = " + m_data.getId() + "");
    }
    /*public Vector<Cliente> getCliente() {
     Vector<Cliente> v = executeQuery( "select id, nombre, direccion, telefono from \"Clientes\"" );
     return v;
     }*/

}
