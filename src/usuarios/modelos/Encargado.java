/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.Objects;

/**
 *
 * @author Esteban
 */

public class Encargado extends Usuario {
    //Atributos
    private String correo;
    private String clave;
    private String apellido;
    private String nombre;
    
    //Metodos
    @Override
    public void mostrar(){
        super.mostrar();
    }

    @Override
    public String toString() {
        return "Encargado{" + "correo=" + correo + ", clave=" + clave + ", apellido=" + apellido + ", nombre=" + nombre + '}';
    }
    
    //constructor
    
    public Encargado(String correo, String clave, String apellido, String nombre) {
        super(correo,clave,apellido,nombre);
    }
    
    //metodos get/set
    @Override
    public String verCorreo() {
        return correo;
    }

    @Override
    public void asignarCorreo(String correo) {
        if (correo != null && !correo.isBlank()){
            this.correo = correo;
        }
    }

    @Override
    public String verClave() {
        return clave;
    }

    @Override
    public void asignarClave(String clave) {
        if (clave != null && !clave.isBlank()){
            this.clave = clave;
        }
    }

    @Override
    public String verApellido() {
        return apellido;
    }

    @Override
    public void asignarApellido(String apellido) {
        if (apellido != null && !apellido.isBlank()){
            this.apellido = apellido;
        }
    }

    @Override
    public String verNombre() {
        return nombre;
    }

    @Override
    public void asignarNombre(String nombre) {
        if (nombre != null && !nombre.isBlank()){
            this.nombre = nombre;
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.correo);
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
        final Encargado other = (Encargado) obj;
        return Objects.equals(this.correo, other.correo);
    }
    
}
