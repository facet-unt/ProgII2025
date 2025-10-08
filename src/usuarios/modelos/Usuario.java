/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;
import java.util.Objects;
import pedidos.modelos.Pedido;

/**
 *
 * @author damia
 */

public abstract class Usuario {
    private String correo;
    private String clave;
    private String apellido;
    private String nombre;
    
    public void mostrar(){
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
    
    public abstract ArrayList<Pedido> verPedidos();

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.correo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.correo, other.correo);
    }

    
    
    public Usuario(String correo, String clave, String apellido, String nombre) {
        this.correo = correo;
        this.clave = clave;
        this.apellido = apellido;
        this.nombre = nombre;
    }
    
}
