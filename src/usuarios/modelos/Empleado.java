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

    private String correo;
    private String clave;
    private String apellido;
    private String nombre;

    public Empleado(String c, String cl, String a, String n) {
        correo = c;
        clave = cl;
        apellido = a;
        nombre = n;
    }

    public String obtenerCorreo() {
        return correo;
    }

    public void asignarCorreo(String c) {
        correo = c;
    }

    public String obtenerClave() {
        return clave;
    }

    public void asignarClave(String cl) {
        clave = cl;
    }

    public String obtenerApellido() {
        return apellido;
    }

    public void asignarApellido(String a) {
        apellido = a;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public void asignarNombre(String n) {
        nombre = n;
    }

}
