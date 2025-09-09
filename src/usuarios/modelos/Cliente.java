/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

/**
 *
 * @author estudiante
 */
public class Cliente 
{
    String correo;
    String clave;
    String nombre;
    String apellido;
    void mostrar()
    {
        System.out.println("Correo : " + correo);
        System.out.println("\n");
        System.out.println("Clave : " + clave);
        System.out.println("\n");
        System.out.println("Nombre : " + nombre);
        System.out.println("\n");
        System.out.println("Apellido : " + apellido);
    }
}
