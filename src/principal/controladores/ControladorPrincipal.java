/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;


// Paquetes importados:

import java.util.ArrayList;
import productos.modelos.Producto;

/**
 *
 * @author Esteban
 */
public class ControladorPrincipal {
    
    public static void main(String[] args) {
                
        ArrayList<Producto> listaProductos = new ArrayList();
        
        Producto unProducto = new Producto ();
        Producto unProducto1 = new Producto ();
        Producto unProducto2 = new Producto ();
        
        //unProducto:
        unProducto.categoria= "Entrada";
        unProducto.codigo=01;
        unProducto.descripcion= "Berenjena al escabeche";
        unProducto.estado="Disponible";
        unProducto.precio= 510.5f ;
        
        //unProducto1:
        unProducto1.categoria= "Plato Principal";
        unProducto1.codigo=02;
        unProducto1.descripcion= "Asado";
        unProducto1.estado="Disponible";
        unProducto1.precio= 34054.1f ;
        
        //unProducto2:
        unProducto2.categoria= "Postre";
        unProducto2.codigo=03;
        unProducto2.descripcion= "Helado";
        unProducto2.estado="No disponible";
        unProducto2.precio= 2600.5f ;
        
        
        //agrego los productos a la lista de Productos
        listaProductos.add(unProducto);
        listaProductos.add(unProducto1);
        listaProductos.add(unProducto2);
        
        //muestro los atributos de los productos:
        
        for(Producto p : listaProductos)
            System.out.println(p); //utilizo internamente el metodo toString();
    }
}
