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
 * @author estudiante
 */
public class Usuario {
    private String correo;
    private String clave;
    private String apellido;
    private String nombre;
    
   

    /*Contructores*/

    public Usuario(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida) {
        this.correo = correo;
        this.clave = clave;
        this.apellido = apellido;
        this.nombre = nombre;
        
    }


    public Usuario() {
    }
    
    /*Metodos GET y SET */
      public void asignarClave(String clave) {
        this.clave = clave;
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


    public void mostrar()
    {
        System.out.println("=================");
        System.out.println("Correo: " + correo);
        System.out.println("Clave: " + clave);
        System.out.println("Apellido: " + apellido);
        System.out.println("Nombre: " + nombre);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.correo);
        return hash;
    }

    /* Agregado de equals y hashcode (para comparar si dos usuarios son iguales en base al correo) */
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass().getSuperclass() != obj.getClass().getSuperclass()) { /*se modifica el equals de usuario para que compare objetos distintos*/
            return false;
        }
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.correo, other.correo);
    }
    
//    /*Implementacion del metodo abstracto. No lleva cuerpo*/
//    public abstract ArrayList<Pedido> verPedidos();
}