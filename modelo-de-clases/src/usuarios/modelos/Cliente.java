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
      System.out.print(unCliente.correo);
      System.out.print(unCliente.clave);
      System.out.print(unCliente.apellido);
      System.out.print(unCliente.nombre);



      
    }
    
}
