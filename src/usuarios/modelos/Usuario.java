/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

<<<<<<< HEAD
=======

>>>>>>> bab1bcd08362a00f95816f8e4b980d38761f6b17
import java.util.ArrayList;
import java.util.Objects;
import pedidos.modelos.Pedido;

/**
 *
 * @author estudiante
 */
<<<<<<< HEAD
public abstract class Usuario {
=======
public abstract class  Usuario {
>>>>>>> bab1bcd08362a00f95816f8e4b980d38761f6b17
    private String correo;
    private String clave;
    private String apellido;
    private String nombre;
    
<<<<<<< HEAD
    
    
    //CONSTRUCTOR
=======
   

    /*Contructores*/

>>>>>>> bab1bcd08362a00f95816f8e4b980d38761f6b17
    public Usuario(String correo, String clave, String apellido, String nombre) {
        this.correo = correo;
        this.clave = clave;
        this.apellido = apellido;
        this.nombre = nombre;
<<<<<<< HEAD
    
    }
    
    //MOSTRAR
    public void mostrar(){
        System.out.println( apellido + ", " + nombre);
    }
    
    //TOString
    @Override
    public String toString() {
        return "Usuario{" + "correo=" + correo + ", clave=" + clave + ", apellido=" + apellido + ", nombre=" + nombre + '}';
    }
    
    
    //METODOS GET/SET
=======
    }

    public Usuario() {
    }
    
    /*Metodos GET y SET */
      public void asignarClave(String clave) {
        this.clave = clave;
    }
    
>>>>>>> bab1bcd08362a00f95816f8e4b980d38761f6b17
    public String verCorreo() {
        return correo;
    }

<<<<<<< HEAD
    public void asignarCorreo(String correo) {
        if (correo != null && !correo.isBlank()){
            this.correo = correo;
        }
    }

=======
>>>>>>> bab1bcd08362a00f95816f8e4b980d38761f6b17
    public String verClave() {
        return clave;
    }

<<<<<<< HEAD
    public void asignarClave(String clave) {
        if (clave != null && !clave.isBlank()){
            this.clave = clave;
        }
    }

    public String verApellido() {
        return apellido;
    }

=======
    public String verApellido() {
        return apellido;
    }
    
>>>>>>> bab1bcd08362a00f95816f8e4b980d38761f6b17
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

<<<<<<< HEAD
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.correo);
        return hash;
    }

=======

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
    
>>>>>>> bab1bcd08362a00f95816f8e4b980d38761f6b17
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
<<<<<<< HEAD
        if (getClass().getSuperclass() != obj.getClass().getSuperclass()) {
=======
        if (getClass().getSuperclass() != obj.getClass().getSuperclass()) { /*se modifica el equals de usuario para que compare objetos distintos*/
>>>>>>> bab1bcd08362a00f95816f8e4b980d38761f6b17
            return false;
        }
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.correo, other.correo);
    }
    
<<<<<<< HEAD
    public abstract ArrayList<Pedido> verPedido();
 
}
=======
    /*Implementacion del metodo abstracto. No lleva cuerpo*/
    public abstract ArrayList<Pedido> verPedidos();
}
>>>>>>> bab1bcd08362a00f95816f8e4b980d38761f6b17
