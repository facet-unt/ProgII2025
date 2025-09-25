/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

/**
 *
 * @author lazar
 */
public class Empleado {
    private String correo;
    private String clave;
    private String apellido;
    private String nombre;
    
    public Empleado(String c,String a,String n,String cl){
        correo=c;
        apellido=a;
        nombre=n;
        clave=cl;
    }
    
    public void mostrar(){
        System.out.println("Correo: "+correo);
        System.out.println("apellido: "+apellido);
        System.out.println("nombre: "+nombre);
        System.out.println("clave: "+clave);
    }

    @Override
    public String toString() {
        return "Empleado{" + "correo=" + correo + ", clave=" + clave + ", apellido=" + apellido + ", nombre=" + nombre + '}';
    }
    
    public String verCorreo() {
        return correo;
    }

    public void sasignarCorreo(String c) {
        correo = c;
    }

    public String verClave() {
        return clave;
    }

    public void asignarClave(String c) {
        clave = c;
    }

    public String verApellido() {
        return apellido;
    }

    public void asignarApellido(String a) {
        apellido = a;
    }

    public String verNombre() {
        return nombre;
    }

    public void asignarNombre(String n) {
        nombre = n;
    }
    
}
