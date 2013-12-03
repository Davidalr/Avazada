/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import BDClases.*;
import Negocio.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.joda.time.Days;
import org.joda.time.DateTime;
import org.joda.time.ReadableInstant;

/**
 *
 * @author juan2ramos
 */
public class PrestamoController {

    private static PrestamoController INSTANCE = null;
    private static ArrayList<Prestamo> prestamoArray = new ArrayList();
    public static int id = 0;

    public static PrestamoController getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PrestamoController();
            INSTANCE.llenar();
        }
        return INSTANCE;
    }

    public void llenar() {

        List<HashMap<String, Object>> prestamos = PrestamoDB.mgr.allItem();
        for (int i = 0; i < prestamos.size(); i++) {

            int idlibro = (int) prestamos.get(i).get("codigo_libros");
            int idCliente = (int) prestamos.get(i).get("codigo_clientes");
            prestamos.get(i).put("codigo_libro", getLibro(idlibro));
            prestamos.get(i).put("codigo_cliente", getCliente(idCliente));
            prestamoArray.add(new Prestamo(prestamos.get(i)));
            if (prestamos.size() - 1 == i) {
                PrestamoController.id = (int) prestamos.get(i).get("codigo");
            }
        }
    }

    private Libro getLibro(int idlibro) {
        ArrayList<Libro> libros = LibroController.getInstance().getLibroArray();
        Iterator it = libros.iterator();
        while (it.hasNext()) {
            Libro libro = (Libro) it.next();
            if (idlibro == libro.getId()) {
                return libro;
            }
        }
        return null;
    }

    private Cliente getCliente(int idCliente) {
        ArrayList<Cliente> clientes = ClienteController.getInstance().getClientesArray();
        Iterator it = clientes.iterator();
        while (it.hasNext()) {
            Cliente cliente = (Cliente) it.next();
            if (idCliente == cliente.getId()) {
                return cliente;
            }
        }
        return null;
    }

    public ArrayList<Cliente> cliente() {
        return ClienteController.getInstance().getClientesArray();
    }

    public ArrayList<Libro> libro() {
        return LibroController.getInstance().getLibroArray();
    }

    public void actualizarPrestamos(Negocio.Prestamo prestamo, HashMap<String, Object> data) {
        System.out.println(data.get("codigo"));
        prestamo.prestamoUpdate(data);
        System.out.println(prestamo.getId());
        PrestamoDB.mgr.save(prestamo, false);

    }

    private int contarPrestados(Libro libro) {
        ArrayList<Prestamo> prestamoL = prestamoArray;
        Iterator it = prestamoL.iterator();
        int cont = 0;
        while (it.hasNext()) //mientras queden elementos
        {
            Prestamo pres = (Prestamo) it.next();
            if (libro.equals(pres.getLibro())) {
                if ("0".equals(pres.getFechaDevolucion())) {
                    cont++;
                }

            }

        }

        return cont;

    }

    private boolean validarCliente(Cliente cliente) {

        ArrayList<Prestamo> prestamoL = prestamoArray;
        Iterator it = prestamoL.iterator();
        Date now = new Date();
        HashMap<String, Object> conf = Config.getInstance().getPrestamoCliente();
        String tipo = cliente.getClass().toString();

        HashMap<String, Object> confCliente = (HashMap<String, Object>) conf.get(tipo);

        int dias = (int) confCliente.get("dias");
        int libro = (int) confCliente.get("libros");
        int cont = 0;
        while (it.hasNext()) //mientras queden elementos
        {
            Prestamo pres = (Prestamo) it.next();
            if (cliente.equals(pres.getCliente())) {
                if ("0".equals(pres.getFechaDevolucion())) {
                    Date fecha = new Date(pres.getFecha());
                    int days = Days.daysBetween(new DateTime(fecha), new DateTime(now)).getDays();
                    System.out.println(pres.getFechaDevolucion() + "--" + dias + "--" + days);
                    cont++;
                    if (dias > days) {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }

    public ArrayList validarPrestamo(Libro libro, Cliente cliente) {
        ArrayList retorno = new ArrayList();
        int ejemplares = libro.getNumeroEjemplares();
        if (validarCliente(cliente)) {
            retorno.add("No se puede realizar prestamo \n Cliente en mora o maximo de libros prestados");
            retorno.add(false);
            return retorno;
        }

        if (ejemplares - contarPrestados(libro) <= 1) {
            retorno.add("No se puede realizar prestamo \n No hay existencias");
            retorno.add(false);
            return retorno;
        }
        retorno.add("no");
        retorno.add(false);
        return retorno;
    }

    public void llenarPrestamo(HashMap<String, Object> data) {
        data.put("codigo", PrestamoController.id + 1);
        Prestamo prestamo = new Prestamo(data);
        prestamoArray.add(prestamo);
        PrestamoDB.mgr.save(prestamo, true);

    }

    public ArrayList<Prestamo> getPrestamoArray() {
        return prestamoArray;
    }

}
