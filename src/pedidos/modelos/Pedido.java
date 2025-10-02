/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

import java.time.LocalDateTime;

/**
 *
 * @author octav
 */
public class Pedido {
    private int numero;
    private LocalDateTime fechaYhora;
    public void mostrar(){
        System.out.printf("Nro:" + numero );
        System.out.printf("Fecha:" +fechaYhora, "Hora:" +fechaYhora);
        System.out.printf("Cliente:");
        System.out.printf("Estado: ");
        System.out.printf("Producto","Cantidad");
        System.out.println("==================");
        
    }
}
