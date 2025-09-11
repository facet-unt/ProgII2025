/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

/**
 *
 * @author lazar
 */
public class Cliente {
    public String correo;
    public String clave;
    public String apellido;
    public String nombre;
    
    
    void mostrar(){
        System.out.println("Correo: "+correo);
        System.out.println("clave: "+clave);
        System.out.println("apellido: "+apellido);
        System.out.println("nombre: "+nombre);
    }

    @Override
    public String toString() {
        return "Cliente{" + "correo=" + correo + ", clave=" + clave + ", apellido=" + apellido + ", nombre=" + nombre + '}';
    }
    
}
