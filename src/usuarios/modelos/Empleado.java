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
    public String correo;
    public String clave;
    public String apellido;
    public String nombre;
    
    //Metodos
    void mostrar(){
        System.out.println("Empleado: " + apellido + " " + nombre);   
    }

    @Override
    public String toString() {
        return "Empleado{" + "correo=" + correo + ", clave=" + clave + ", apellido=" + apellido + ", nombre=" + nombre + '}';
    }
}
