/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;


public class Empleado extends Usuario {

    /*Constructor*/
    
    public Empleado(String correo, String clave, String apellido, String nombre) {
        super(correo, clave, apellido, nombre);
    }
    
    
    
    public void mostrar()
    {
      System.out.println("=================");
      System.out.println("Correo:" +  verCorreo());
      System.out.println("Clave:" + verClave());
      System.out.println("Apellido:"+ verApellido());
      System.out.println("Nombre:" + verNombre());  
    }
}
