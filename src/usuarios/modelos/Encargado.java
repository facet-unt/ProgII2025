/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import pedidos.modelos.Pedido;

/**
 *
 * @author Lyan
 */

public class Encargado extends Usuario{

    /*Constructor*/
    public Encargado(String correo, String clave, String apellido, String nombre) {
        super(correo, clave, apellido, nombre);
    }
         

 public ArrayList<Pedido> p = new ArrayList<>();
    
    @Override
      public ArrayList<Pedido> verPedidos()
    {
        return new ArrayList<>(); /*Devuelve un arraylist vacio*/
    }

    @Override
    public void mostrar() {
        System.out.println("Encargado:" + verApellido() + "," + verNombre());
    }
      
    /*AGREGADO DEL METODO generarReporteVentas()"*/
    
    public String generarReporteVentas(LocalDate fecha)
    {
        String apellido;
        apellido = verApellido();
        String cadenaFecha = fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        
        return apellido + " genero el reporte de ventas del dia " + cadenaFecha;

    }
}    
