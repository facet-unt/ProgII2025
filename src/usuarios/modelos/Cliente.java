/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;
import pedidos.modelos.Pedido;

/**
 *
 * @author Esteban
 */
public class Cliente {
    private String correo;
    private String clave;
    private String apellido;
    private String nombre;
    
    private ArrayList<Pedido> pedidos = new ArrayList<>();
    
    public void mostrar(){
        System.out.println("Apellido: " + apellido + "\tNombre:" + nombre);
        System.out.println("Correo: " + correo);
        System.out.println("Clave: " + clave);  
    }
    
    //constructor

    public Cliente(String correo, String clave, String apellido, String nombre) {
        this.correo = correo;
        this.clave = clave;
        this.apellido = apellido;
        this.nombre = nombre;
    }
    
    //metodos get/set
    public String verCorreo() {
        return correo;
    }

    public void asignarCorreo(String c) {
        if (c != null && !c.isBlank())
            correo = c;
    }

    public String verClave() {
        return clave;
    }

    public void asignarClave(String c) {
        if (c != null && !c.isBlank())
            correo = c;
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
