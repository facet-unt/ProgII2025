/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

/**
 *
 * @author estudiante
 */

public class Empleado 
{
    private String correo;
    private String clave;
    private String nombre;
    private String apellido;    
    
    public String verCorreo () {
        return correo;
    }
    
    public String verClave () { 
        return clave;
    }
    
    public String verNombre () {
        return nombre;
    }
    
    public String verApellido () {
        return apellido;
    }
    
    public void AsignarCorreo (String c) {
        correo = c;
    }
    
    public void AsignarClave (String cl) {
        clave = cl;
    }
    
    public void AsignarNombre (String n) {
        nombre = n;
    }
    
    public void AsignarApellido (String a) {
        apellido = a;
    }
    
    public void mostrar()
    {
        System.out.println("Correo : " + correo);
        System.out.println("\n");
        System.out.println("Clave : " + clave);
        System.out.println("\n");
        System.out.println("Nombre : " + nombre);
        System.out.println("\n");
        System.out.println("Apellido : " + apellido);
    }

    public Empleado(String correo, String clave, String nombre, String apellido)
    {
        this.correo = correo;
        this.clave = clave;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    
        @Override
        public String toString() {
        return "Empleado{" + "correo=" + correo + ", clave=" + clave + ", apellido=" + apellido + ", nombre=" + nombre + '}';
    }
}