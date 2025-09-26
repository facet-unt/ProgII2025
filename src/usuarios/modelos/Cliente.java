/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;
import pedidos.modelos.Pedido;

public class Cliente {

    private ArrayList<Pedido> pedido;
    private String correo;
    private String clave;
    private String apellido;
    private String nombre;

    public void mostrar(){
      
        System.out.println("Nombre: "+ verNombre());
        System.out.println("Apellido: "+ verApellido());
        System.out.println("Correo: "+ verCorreo());
        System.out.println("Clave: "+ verClave());
        
        
    }
    
    
    public Cliente(String c, String cl, String a, String n) {
        correo = c;
        clave = cl;
        apellido = a;
        nombre = n;
    }


    public String verCorreo() {
        return correo;
    }

    public void asignarCorreo(String c) {
        correo = c;
    }

    public String verClave() {
        return clave;
    }

    public void asignarClave(String cl) {
        clave = cl;
    }

    public String verApellido() {
        return apellido;
    }

    public void asignarApellido(String a) {
        apellido = a;
    }

    public String verNombre() {
        return nombre;
    }

    public void asignarNombre(String n) {
        nombre = n;

    }

    @Override
    public String toString() {
        return "Cliente{" + "correo=" + correo + ", clave=" + clave + ", apellido=" + apellido + ", nombre=" + nombre + '}';
    }

}
