/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

/**
 *
 * @author estudiante
 */
public class Empleado {
// lo nuestro, lo dejare en comentario
    /*public String correo;
    public String clave;
    public String apellido;
    public String nombre;
    public void mostrar(){
    }*/
// lo del ingeniero
    private String correo;
    private String clave;
    private String apellido;
    private String nombre;
    
    
    public void mostrar(){
        System.out.println("Soy un Cliente");
        System.out.println("Correo: " + correo);
        System.out.println("Clave: " + clave);
        System.out.println("apellido: " + apellido);
        System.out.println("Nombre: " + nombre);
    }

    public String verCorreo() {
        return correo;
    }

    public void asignarCorreo(String c) {
        if (c != null && !c.isBlank())
            correo = c;
    }

    public String verClave() {
        return clave;
    }

    public void asignarClave(String c) {
        if (c != null && !c.isBlank())
            correo = c;
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

    public Empleado(String correo, String clave, String apellido, String nombre) {
        this.correo = correo;
        this.clave = clave;
        this.apellido = apellido;
        this.nombre = nombre;
    }

}
