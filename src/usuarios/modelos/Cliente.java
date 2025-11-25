/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

/**
 *
 * @author Esteban
 */
import java.util.ArrayList;
import java.util.List;
import pedidos.modelos.Pedido;

public class Cliente extends Usuario {

    //Atributos
    private ArrayList<Pedido> listaPedidos;

    //Constructor
    public Cliente(String correo, String clave, String apellido, String nombre, Perfil perfil) {
        super(correo, clave, apellido, nombre, perfil);
        this.listaPedidos = new ArrayList<>();
    }

    //Metodos
    @Override
    public String toString() {
        return "Cliente{" + "correo=" + this.verCorreo() + ", clave=" + this.verClave() + ", apellido=" + this.verApellido() + ", nombre=" + this.verNombre() + '}';
    }

    @Override
    public List<Pedido> verPedidos() {
        return this.listaPedidos;
    }

    @Override
    public void mostrar() {
        System.out.print("Cliente: ");
        super.mostrar();
    }

    public void agregarPedido(Pedido p) {
        if (this.equals(p.verCliente())) {
            if (!listaPedidos.contains(p)) {
                listaPedidos.add(p);
            } else {
                int indice = listaPedidos.indexOf(p);
                listaPedidos.set(indice, p);
            }
        } else {
            System.out.println("Error: El pedido que intenta agregar no corresponda con el cliente\n");
        }
    }

    public void cancelarPedido(Pedido p) {
        System.out.println("\n==================");
        System.out.print("Cliente: ");
        super.mostrar();
        if (listaPedidos.contains(p)) {
            listaPedidos.remove(p);
            System.out.println("Se ha cancelado el pedido numero: " + p.verNumero());
        } else {
            System.out.println("No se ha encontrado el pedido numero: " + p.verNumero());
        }
        System.out.println("==================\n");
    }
}
