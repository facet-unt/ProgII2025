/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import java.util.ArrayList;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;
import usuarios.modelos.Empleado;
import usuarios.modelos.Encargado;

/**
 *
 * @author estudiante
 */
public class ControladorPrincipal {
       public static void main(String[] args) {
        Producto producto1 = new Producto();
        Producto producto2 = new Producto();
        Producto producto3 = new Producto();
        ArrayList<Cliente> unCliente= new ArrayList<>();
        ArrayList<Empleado> unEmpleado= new ArrayList<>();
        ArrayList<Encargado> unEncargado= new ArrayList<>();
        ArrayList<Producto> unProducto= new ArrayList<>();
        unProducto.add(producto1);
        unProducto.add(producto2);
        unProducto.add(producto3);
           for (int i = 0; i < unProducto.size(); i++) {
               Producto productoGenerico = unProducto.get(i);
               productoGenerico.mostrar(productoGenerico);
           }
    }
}
