/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Negocio.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author juan2ramos
 */
public class ReporteClienteController {

    private Cliente cliente;

    public ReporteClienteController(Cliente cliente) {
        this.cliente = cliente;
    }

    public String reporte() {
        String cadena = "";
        String prestamoS = "";
        
        cadena += "CLiente :" + cliente.getNombre() + " " + cliente.getApellido() + ": \n\n";
        ArrayList<Prestamo> prestamos = PrestamoController.getInstance().getPrestamoArray();

        Iterator it = prestamos.iterator();
        
        while (it.hasNext()) //mientras queden elementos
        {
            Prestamo pres = (Prestamo) it.next();
            if (cliente.equals(pres.getCliente())) {
                String estado = (pres.getFechaDevolucion().equals("")) ? 
                        " Estado : prestado " : " Devolucion: "+pres.getFechaDevolucion();
                prestamoS += "** Libro: " + pres.getLibro() + " Prestado el :"
                        + pres.getFecha()
                        + estado + "\n";
            }

        }
        cadena += (prestamoS.equals(""))?" No tiene ningun prestamo ":prestamoS;
        return cadena;

    }

}
