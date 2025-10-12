/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;
import java.util.Objects;
import java.util.List;
import pedidos.modelos.Pedido;

/**
 *
 * @author HP Casa
 */
public abstract class Usuario {
    private String correo;
    private String clave;
    private String apellido;
    private String nombre;

    public Usuario(String correo, String clave, String apellido, String nombre) {
        this.correo = correo;
        this.clave = clave;
        this.apellido = apellido;
        this.nombre = nombre;
    }

    public String verCorreo() {
        return correo;
    }

    public void AsignarCorreo(String correo) {
        this.correo = correo;
    }

    public String verClave() {
        return clave;
    }

    public void asignarClave(String clave) {
        this.clave = clave;
    }

    public String verApellido() {
        return apellido;
    }

    public void asignarApellido(String apellido) {
        this.apellido = apellido;
    }

    public String verNombre() {
        return nombre;
    }

    public void asignarNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.correo);
        return hash;
    }
    
    public abstract List<Pedido> verPedidos();
     
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Usuario)) {
            //Modifico el equals que viene por defecto para poder comparar Usuarios de distintas clases
            return false;
        }
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.correo, other.correo);
        }
    
        public void mostrar(){
        System.out.println("\n-- Usuario --");
        System.out.println("Apellido: " + apellido);
        System.out.println("Nombre: " + nombre);
        System.out.println("Correo: " + correo);
        System.out.println("Clave: " + clave);
        }
     
}
