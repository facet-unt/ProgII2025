/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;
import pedidos.modelos.Pedido;

/**
 *
 * @author lazar
 */
public class Empleado extends Usuario{
    
    public Empleado(String c,String cl,String a,String n){
        super(c,cl,a,n);
    }

    @Override
    public String toString() {
        return "Empleado{" + "correo=" + this.verCorreo() + ", clave=" + this.verClave() + ", apellido=" + this.verApellido() + ", nombre=" + this.verNombre() + '}';
    }

    @Override
    public ArrayList<Pedido> verPedidos() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return null;
    }
}
