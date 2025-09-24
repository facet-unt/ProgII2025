/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;
import pedidos.modelos.Pedido;



/**
 *
 * @author estudiante
 */
public class Cliente {
    private String correo;
    private String clave;
    private String apellido;
    private String nombre;

    private ArrayList<Pedido> pedidos; /*implementacion de asociacion con clase pedido*/
    
    public Cliente(String correo, String clave, String apellido, String nombre) {
        this.correo = correo;
        this.clave = clave;
        this.apellido = apellido;
        this.nombre = nombre;
    }

    public Cliente() {
    }

    public String verCorreo() {
        return correo;
    }

    public String verClave() {
        return clave;
    }

    public String verApellido() {
        return apellido;
    }

    public String verNombre() {
        return nombre;
    }

    public void asignarCorreo(String correo) {
        this.correo = correo;
    }

    public void asignarClave(String clave) {
        this.clave = clave;
    }

    public void asignarApellido(String apellido) {
        this.apellido = apellido;
    }

    public void asignarNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    public void mostrar() {
      System.out.println("=================");
      System.out.println("Correo:" + correo);
      System.out.println("Clave:" + clave);
      System.out.println("Apellido:"+ apellido);
      System.out.println("Nombre:" + nombre);      
    }
    
    @Override
    public String toString(){

        return "{" + "correo=" + correo + ", clave=" + clave + ", apellido=" + apellido + ", nombre=" + nombre + '}';
    }      
}
