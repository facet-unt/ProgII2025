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
 * @author Esteban
 */
public class Empleado extends Usuario {

    //Constructor
    public Empleado(String correo, String clave, String apellido, String nombre, Perfil perfil) {
        super(correo, clave, apellido, nombre, perfil);
    }

    //Metodos
    @Override
    public String toString() {
        return "Empleado{" + "correo=" + this.verCorreo() + ", clave=" + this.verClave() + ", apellido=" + this.verApellido() + ", nombre=" + this.verNombre() + '}';
    }

    @Override
    public void mostrar() {
        System.out.print("Empleado: ");
        super.mostrar();
    }

    @Override
    public List<Pedido> verPedidos() {
        GestorPedidos i = GestorPedidos.instanciar();
        return i.verPedidos();
    }
}
