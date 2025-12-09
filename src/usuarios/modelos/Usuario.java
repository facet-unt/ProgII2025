/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import pedidos.modelos.Pedido;


public abstract class Usuario implements Comparable<Usuario> {
    
    private String correo;
    private String clave;
    private String apellido;
    private String nombre;
    
    
    public abstract Perfil verPerfil(); /*Permite saber que tipo de Usuario es*/
    
    /* Constructor */ 
    public Usuario(String correo, String clave, String apellido, String nombre) {
        this.correo = correo;
        this.clave = clave;
        this.apellido = apellido;
        this.nombre = nombre;
    }
    
    public void mostrar(){
        System.out.println( apellido + ", " + nombre);
    }
    
    /* Metodo tostring */
    @Override
    public String toString() {
        return "Usuario{" + "correo=" + correo + ", clave=" + clave + ", apellido=" + apellido + ", nombre=" + nombre + '}';
    }
    
    
    /*Metodos get/set */
    public String verCorreo() {
        return correo;
    }

    public void asignarCorreo(String correo) {
        if (correo != null && !correo.isBlank()){
            this.correo = correo;
        }
    }

    public String verClave() {
        return clave;
    }

    public void asignarClave(String clave) {
        if (clave != null && !clave.isBlank()){
            this.clave = clave;
        }
    }

    public String verApellido() {
        return apellido;
    }

    public void asignarApellido(String apellido) {
        if (apellido != null && !apellido.isBlank()){
            this.apellido = apellido;
        }
    }

    public String verNombre() {
        return nombre;
    }

    public void asignarNombre(String nombre) {
        if (nombre != null && !nombre.isBlank()){
            this.nombre = nombre;
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.correo);
        return hash;
    }
    
    /* Implemtnacion del metodo equals (compara correos) */
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
    
    public abstract List<Pedido> verPedido();

    /* Implementacion del metodo compareTo TP6 */
    @Override
    public int compareTo(Usuario u) {
        if(this.apellido.compareTo(u.verApellido()) == 0)
           return this.nombre.compareTo(u.verNombre());
        else
            return this.apellido.compareTo(u.verApellido());
    }
    
}
