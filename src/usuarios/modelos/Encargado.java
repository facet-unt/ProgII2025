/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

/**
 *
 * @author estudiante
 */
public class Encargado {
    public String correo, clave, apellido, nombre;
    
    public void mostrar(){
        System.out.println("Los datos de este encargado son:");
        System.out.println("Apellido: " + apellido);
        System.out.println("Nombre: "+nombre);
        System.out.println("Correo: "+correo);
        System.out.println("Clave: "+clave);
    }
    
    
    public String verCorreo(){
        return correo;
    }
    
    public void asignarCorreo(String c) {
        if (c != null && !c.isBlank()){
            correo = c;
        }
    }
    
    public String verClave(){
        return clave;
    }
    
    public void asignarClave(String c) {
        if (c != null && !c.isBlank()){
            clave = c;
        }
    }
    
    public String verNombre(){
        return nombre;
    }
    
    public void asignarNombre(String n) {
        if (n != null && !n.isBlank()){
            nombre = n;
        }
    }
    
    public String verApellido(){
        return apellido;
    }
    
    public void asignarApellido(String a) {
        if (a != null && !a.isBlank()){
            apellido = a;
        }
    }
    
    

    public Encargado(String correo, String clave, String apellido, String nombre) {
        this.correo = correo;
        this.clave = clave;
        this.apellido = apellido;
        this.nombre = nombre;
    }
}
