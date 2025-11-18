/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.List;
import java.util.Objects;
import pedidos.modelos.Pedido;
/**
 *
 * @author Gaston
 * 
 */
public abstract class Usuario {
    private String correo;
    private String clave;
    private String apellido;
    private String nombre;

    public Usuario(String correo, String clave, String apellido, String nombre){
        this.correo = correo;
        this.clave = clave;
        this.apellido = apellido;
        this.nombre = nombre;
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
    
    public void mostrar(){
        System.out.println("Usuario: " + apellido + " " + nombre);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.correo);
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
        if (!(obj instanceof Usuario)) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.correo, other.correo);
    }
        
    public abstract List<Pedido> verPedidos();
}
