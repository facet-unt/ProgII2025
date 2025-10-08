/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;
import java.util.List;
import java.util.ArrayList;
import pedidos.modelos.Pedido; 
/**
 *
 * @author Asus
 */
public class Empleado extends Usuario {
     

    public Empleado (String correo, String clave, String apellido, String nombre) {
        super(correo, clave, nombre, apellido); 
    }

    @Override
    public void mostrar(){
        
    }

    @Override
    public String toString() {
        return super.toString(); 
    }
    
}
