/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

/**
 *
 * @author estudiante
 */
public class Encargado
{
    String correo;
    String clave;
    String apellido;
    String nombre;
    
     public void mostrar ()
    {
      Encargado unEncargado=new Encargado();
      System.out.print(unEncargado.correo);
      System.out.print(unEncargado.clave);
      System.out.print(unEncargado.apellido);
      System.out.print(unEncargado.nombre);
      
    }
}
