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
    String apellido;
    String nombre;
    
    public void mostrar ()
    {
      Cliente unCliente=new Cliente();
      System.out.println(unCliente.correo);
      System.out.println(unCliente.clave);
      System.out.println(unCliente.apellido);
      System.out.println(unCliente.nombre);



      
    }
    
}
