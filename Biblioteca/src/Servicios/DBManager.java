/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class DBManager {

    public DBManager() {

    }

    protected void addObject(Vector v, ResultSet rs) {

    }

    protected List<HashMap<String, Object>> executeQuery(String sz) {
        List<HashMap<String, Object>> list = new ArrayList<>();
        
        String db = "Bibliotecas";
        String url = "jdbc:postgresql://localhost:5432/" + db;
        try {
            Class.forName("org.postgresql.Driver");

            System.out.println("\nEstableciendo conexion...");

            Connection con = DriverManager.getConnection(url, "postgres", "pass");
            if (con == null) {
                System.out.println("database conection not working");
                return list;
            }
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sz);
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();
            while (rs.next()) {

                HashMap<String, Object> row = new HashMap<>(columns);
                for (int i = 1; i <= columns; ++i) {
                    row.put(md.getColumnName(i), rs.getObject(i));
                }
                list.add(row);

            }
            

            con.close();
        } catch (Exception e) {
            System.out.println("-------------------ERROR---------------------");
            System.out.println("SQL: " + sz);
            System.out.println("Exception: " + e);
        }
        
        return list;
    }

    public void execute(String sz) {
        String db = "Bibliotecas";
        String url = "jdbc:postgresql://localhost:5432/" + db;
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("\nEstableciendo conexion...");
            Connection con = DriverManager.getConnection(url, "postgres", "pass");
            if (con == null) {
                System.out.println("database conection not working");
                return;
            }

            Statement stm = con.createStatement();
            stm.execute(sz);
            con.close();
        } catch (Exception e) {
            System.out.println("-------------------ERROR---------------------");
            System.out.println("SQL: " + sz);
            System.out.println("Exception: " + e);
        }
    }
}
