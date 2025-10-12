/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

/**
 *
 * @author estudiante
 */
import java.util.ArrayList;
import pedidos.modelos.Pedido;

public class Cliente extends Usuario {
    private ArrayList<Pedido> listaPedidos;
    
    //Metodos
    

    @Override
    public String toString() {
        return "Cliente{" + "correo=" + super.verCorreo() + ", clave=" + super.verClave() + ", apellido=" + super.verApellido() + ", nombre=" + super.verNombre() + '}';
    }
    
    //constructores

    public Cliente(String correo, String clave, String apellido, String nombre) {
        super(correo, clave, apellido, nombre);
        this.listaPedidos = new ArrayList<>();
    }
    
    public ArrayList<Pedido> verListaPedidos() {
        return this.listaPedidos;
    }

    public void asignarPedido(Pedido p) {
        this.listaPedidos.add(p);
    }    
}
