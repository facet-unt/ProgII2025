/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

/**
 *
 * @author estudiante
 */
public class Empleado
{
   String correo;
   String clave;
   String apellido;
   String nombre;
   
    public void mostrar ()
    {
      Empleado unEmpleado=new Empleado();
      System.out.print(unEmpleado.correo);
      System.out.print(unEmpleado.clave);
      System.out.print(unEmpleado.apellido);
      System.out.print(unEmpleado.nombre);
      
    }
}
