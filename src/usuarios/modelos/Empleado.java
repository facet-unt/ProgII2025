/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;
import java.util.List;
import pedidos.modelos.GestorPedidos;
import pedidos.modelos.Pedido;

/**
 *
 * @author Esteban
 */
public class Empleado extends Usuario {

    private ArrayList<Pedido> vacio = new ArrayList<>();
    //constructor

    public Empleado(String correo, String clave, String apellido, String nombre, Perfil perfil) {
        super(correo, clave, apellido, nombre, perfil);
    }

    @Override
    public List<Pedido> verPedido() {
        GestorPedidos gestor = GestorPedidos.instanciar();
        return gestor.verPedidos();
    }

}
