/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package usuarios.modelos;

import java.util.List;
import java.util.ArrayList;
import pedidos.modelos.Pedido;

public class Empleado extends Usuario {

    public Empleado (String correo, String clave, String apellido, String nombre) {
        super(correo, clave, apellido, nombre);
    }

    @Override
    public List<Pedido> verPedidos() {
        return new ArrayList<>();
    }
}