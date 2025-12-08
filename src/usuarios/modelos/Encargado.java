/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;
/**
 *
 * @author alumno
 */

import java.util.ArrayList;
import java.util.List;
import pedidos.modelos.GestorPedidos;
import pedidos.modelos.Pedido;

public class Encargado extends Usuario {

    public Encargado(String correo, String clave, String apellido, String nombre) {
        super(correo, clave, apellido, nombre);
    }

    //modificacion del metodo verPedido para que devuelva todos los pedidos 
     public List<Pedido> verPedidos() {
     GestorPedidos gp = GestorPedidos.instanciar();
     return gp.verPedidos();
    }
     
     //metodo para ver todos los usuarios
     public List<Usuario> verUsuarios(){
         GestorUsuarios gp = GestorUsuarios.instanciar();
     return gp.verUsuarios();
     }  
     
     //metodo para ver los productos
//     public ArrayList<ProductoDelPedido> verProductosDelPedido()){
//         GestorUsuarios gpdp = GestorUsuarios.instanciar();
//     return gpdp.();
//     }
}
