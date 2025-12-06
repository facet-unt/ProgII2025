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
 * @author estudiante
 */
public abstract class Usuario implements Comparable<Usuario> {

    private String correo;
    private String clave;
    private String apellido;
    private String nombre;
    private Perfil perfil;
    
    public Usuario(String correo, String clave, String apellido, String nombre) {
        this.correo = correo;
        this.clave = clave;
        this.apellido = apellido;
        this.nombre = nombre;
    }

    public abstract List<Pedido> verPedidos();

    public void mostrar() {
        System.out.println("Nombre: " + verNombre());
        System.out.println("Apellido: " + verApellido());
        System.out.println("Correo: " + verCorreo());
        System.out.println("Clave: " + verClave());

    }

    @Override
    public int compareTo(Usuario u) {
        if (this.apellido.compareTo(u.apellido) == 0) {
            return this.nombre.compareTo(u.nombre);
        }
        else{
        return this.apellido.compareTo(u.apellido);
        }
    }

    public String verCorreo() {
        return correo;
    }

    public void asignarCorreo(String correo) {
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

    public Perfil verPerfil() {
        return perfil;
    }

    public void asignarPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public String verNombre() {
        return nombre;
    }

    public void asignarNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.correo);
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
        if (getClass().getSuperclass() != obj.getClass().getSuperclass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.correo, other.correo);
    }

}
