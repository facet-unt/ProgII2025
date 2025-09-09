/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import java.util.ArrayList;
import producto.modelos.Producto;
import usuarios.modelos.*;

/**
 *
 * @author estudiante
 */
public class ControladorPrincipal {
   
     public static void main(String[] args){
         Producto unProducto1=new Producto();
         unProducto1.codigo=45;
         unProducto1.descripcion="dugdjgd";
         unProducto1.categoria="ababa";
         unProducto1.estado="apagado";
         unProducto1.precio=60.75f;
         
         Producto producto1 = new Producto();
        producto1.codigo = 101;
        producto1.descripcion = "Laptop Dell Inspiron";
        producto1.categoria = "Electrónica";
        producto1.estado = "Nuevo";
        producto1.precio = 899.99f;

        // Segundo objeto de Producto
        Producto producto2 = new Producto();
        producto2.codigo = 202;
        producto2.descripcion = "Silla ergonómica";
        producto2.categoria = "Muebles";
        producto2.estado = "Usado";
        producto2.precio = 149.50f;
         
         ArrayList<Producto> productos=new ArrayList<>();

         productos.add(unProducto1);
         productos.add(producto1);
         productos.add(producto2);
         for(Producto unProducto:productos){
             unProducto.mostrar();
             System.out.println(unProducto);
         }
    
}}
