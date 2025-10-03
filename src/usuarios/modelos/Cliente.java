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
    private String correo, clave, apellido, nombre;
    private ArrayList<Pedido> pedidos;
    
    public void mostrar(){
        System.out.println("Los datos de este cliente son:");
        System.out.println("Apellido: " + apellido);
        System.out.println("Nombre: "+nombre);
        System.out.println("Correo: "+correo);
        System.out.println("Clave: "+clave);
    }
    
    public String verCorreo(){
        return correo;
    }
    
    public void asignarCorreo(String c) {
        if (c != null && !c.isBlank()){
            correo = c;
        }
    }
    
    public String verClave(){
        return clave;
    }
    
    public void asignarClave(String c) {
        if (c != null && !c.isBlank()){
            clave = c;
        }
    }
    
    public String verNombre(){
        return nombre;
    }
    
    public void asignarNombre(String n) {
        if (n != null && !n.isBlank()){
            nombre = n;
        }
    }
    
    public String verApellido(){
        return apellido;
    }
    
    public void asignarApellido(String a) {
        if (a != null && !a.isBlank()){
            apellido = a;
        }
    }

    public Cliente(String correo, String clave, String apellido, String nombre) {
        this.correo = correo;
        this.clave = clave;
        this.apellido = apellido;
        this.nombre = nombre;
    }
}
