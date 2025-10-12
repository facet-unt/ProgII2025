/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

/**
 *
 * @author Esteban
 */

public class Empleado {
    //Atributos
    private String correo;
    private String clave;
    private String apellido;
    private String nombre;
    
    //Metodos
    public void mostrar(){
        System.out.println("Apellido: " + apellido + "\tNombre:" + nombre);
        System.out.println("Correo: " + correo);
        System.out.println("Clave: " + clave);     
    }

    @Override
    public String toString() {
        return "Empleado{" + "correo=" + correo + ", clave=" + clave + ", apellido=" + apellido + ", nombre=" + nombre + '}';
    }
    
    //constructor

    public Empleado(String correo, String clave, String apellido, String nombre) {
        this.correo = correo;
        this.clave = clave;
        this.apellido = apellido;
        this.nombre = nombre;
    }
    
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
}
