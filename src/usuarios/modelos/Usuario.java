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
 * @author Esteban
 */
public abstract class Usuario {
    //Atributos
    private String correo;
    private String clave;
    private String apellido;
    private String nombre;
    private Perfil perfil;
    
    //Constructor de la Super Clase
    public Usuario (String correo, String clave, String apellido, String nombre, Perfil perfil) {
        this.correo = correo;
        this.clave = clave;
        this.apellido = apellido;
        this.nombre = nombre;
        this.perfil = perfil;
    }
    
    //metodos
    public void mostrar(){
        System.out.println(this.verApellido() + ", " + this.verNombre());
    }
    
    public abstract ArrayList<Pedido> verPedidos();
    
    //metodos get/set
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

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
      
  
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.correo);
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
