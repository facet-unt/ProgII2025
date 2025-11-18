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
import java.util.List;
import pedidos.modelos.Pedido;

public class Cliente extends Usuario {
    
    private List<Pedido> listaPedidos;
    
    //Metodos
    @Override
    public void mostrar(){
        System.out.println("Cliente: " + verApellido() + " " + verNombre());
    }

    @Override
    public String toString() {
        return "Cliente{" + "correo=" + verCorreo() + ", clave=" + verClave() + ", apellido=" + verApellido() + ", nombre=" + verNombre() + '}';
    }
    
    //constructor

    public Cliente(String correo, String clave, String apellido, String nombre) {
        super(correo, clave, apellido, nombre);
        this.listaPedidos = new ArrayList<>();
    }
    
    
    @Override
    public List<Pedido> verPedidos() {
        return this.listaPedidos;
    }

    public void agregarPedido(Pedido p) {
        int indice = listaPedidos.indexOf(p);
        if(indice != -1/*indexOf() devuelve -1 si p no está en listaPedidos*/){
            listaPedidos.set(indice, p);
        } else{
            listaPedidos.add(p);
        }
    }
    
    public void cancelarPedido(Pedido p){
            listaPedidos.remove(p);
    }
}
