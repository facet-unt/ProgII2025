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
    public String correo;
    public String clave;
    public String apellido;
    public String nombre;
    
    public void mostrar(){
        System.out.println("correo: " + correo);
        System.out.println("clave: " + clave);
        System.out.println("apelldio: " + apellido);
        System.out.println("nombre: " + nombre);
    }
         
}
