/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.List;
import pedidos.modelos.GestorPedidos;
import pedidos.modelos.Pedido;

/**
 *
 * @author Gaston
 */
public class Empleado extends Usuario{
    
    //Metodos
    @Override
    public void mostrar(){
        System.out.println("Empleado: " + verApellido() + " " + verNombre());
    }

    @Override
    public String toString() {
        return "Empleado{" + "correo=" + verCorreo() + ", clave=" + verClave() + ", apellido=" + verApellido() + ", nombre=" + verNombre() + '}';
    }
    
    //constructor

    public Empleado(String correo, String clave, String apellido, String nombre) {
        super(correo, clave, apellido, nombre);
    }
    
    @Override
    public List<Pedido> verPedidos(){
        GestorPedidos gestor = GestorPedidos.instanciar();
        return gestor.verPedidos();
    }
}
