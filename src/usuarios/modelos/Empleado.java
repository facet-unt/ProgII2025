/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.List;
import pedidos.modelos.Pedido;

/**
 *
 * @author estudiante
 */
public class Empleado extends Usuario {
    
    @Override
    public void mostrar(){
        System.out.println("Los datos de este empleado son:");
        super.mostrar();
    }
    
    @Override
    public List<Pedido> verPedidos(){
        return null;
    } 
    
        // Constructor
    public Empleado(String correo, String clave, String apellido, String nombre) {
        super(correo, clave, apellido, nombre);
    }
}
