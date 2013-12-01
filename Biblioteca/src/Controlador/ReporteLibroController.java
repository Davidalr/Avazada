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
public class ReporteLibroController {

    private Libro libro;

    public ReporteLibroController(Libro libro) {
        this.libro = libro;
    }

    

    public String reporte() {
        String cadena = "";
        String prestamoS = "";
        int ejemplares = libro.getNumeroEjemplares();
        cadena += "Libro :" + libro.getTitiulo()+ " - " + libro.getIsbn() + ": \n\n"
                +"la blioteca cuenta con "+ ejemplares + " ejemplares";
        ArrayList<Prestamo> prestamos = PrestamoController.getInstance().getPrestamoArray();

        Iterator it = prestamos.iterator();
        int cont = 0;
        while (it.hasNext()) //mientras queden elementos
        {
            Prestamo pres = (Prestamo) it.next();
            if (libro.equals(pres.getLibro())) {
                System.out.print(cont+" - "+pres.getFechaDevolucion());
                if(!"".equals(pres.getFechaDevolucion())){
                    cont++;
                }
            }

        }
        cadena += (cont == 0)?" \nTodos estan disponibles ":" \nDe los cuales hay : " + cont +" esta prestados"; 
        return cadena;

    }

}
