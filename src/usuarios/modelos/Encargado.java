/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

/**
 *
<<<<<<< HEAD
 * @author Oli Toledo
=======
 * @author estudiante
>>>>>>> 22dc9e4978e472b497ec4e3c8fa0cb322aa6d032
 */
public class Encargado {
    private String apellido;
    private String nombre;
    private String correo;
    private String clave;

    public Encargado(String apellido, String nombre, String correo, String clave) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.correo = correo;
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
    
//    public void mostrar(){
//        System.out.println("-- ENCARGADO --");
//        System.out.println("Apellido: " + apellido);
//        System.out.println("Nombre: " + nombre);
//        System.out.println("Correo: " + correo);
//        System.out.println("Clave: " + clave);
//     } 
    
    @Override
    public String toString() {
        return "Encargado{" + "apellido=" + apellido + ", nombre=" + nombre + ", correo=" + correo + ", clave=" + clave + '}';
    }
    
}