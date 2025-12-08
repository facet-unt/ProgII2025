/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;
/**
 *
 * @author alumno
 */

import java.util.List;
import pedidos.modelos.GestorPedidos;
import pedidos.modelos.Pedido; 
/**
 *
 * @author Asus
 */
public class Empleado extends Usuario {
     

    public Empleado (String correo, String clave, String apellido, String nombre) {
        super(correo, clave, nombre, apellido); 
    }

    @Override
    public void mostrar(){
        System.out.println ("Mail: " + verCorreo());
        System.out.println ("Nombre: " + verNombre());
        System.out.println ("Apellido: " + verApellido()); 
        System.out.println ("Clave: " + verClave());
    }

    @Override
    public String toString() {
        return super.toString(); 
    }
    
    //modificacion del metodo verPedido para que devuelva nada 
   
     public List<Pedido> verPedidos() {
     GestorPedidos gp = GestorPedidos.instanciar();
     return gp.verPedidos();
    }

   
}
