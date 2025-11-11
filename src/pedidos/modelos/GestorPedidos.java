/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

import java.util.ArrayList;

/**
 *
 * @author Amadeo
 */
public class GestorPedidos {

    private ArrayList<Pedido> pedidos = new ArrayList<>();

    private static GestorPedidos intstancia;

    private GestorPedidos() {
    }
    
    public static final String EXITO = "Pedido creado/modificado/cancelado con éxito";
    public static final String ERROR_FECHA = "La fecha del pedido es incorrecta";
    public static final String ERROR_HORA = "La hora del pedido es incorrecta";
    public static final String ERROR_PRODUCTOS_DEL_PEDIDO = "El pedido no tieneproductos";
    public static final String ERROR_CLIENTE = "El pedido no tiene un cliente";
    public static final String ERROR_ESTADO = "El pedido no tiene un estado";
    public static final String ERROR_CANCELAR = "No se puede cancelar el pedido eneste estado";
    public static final String PEDIDOS_DUPLICADOS = "Ya existe un pedido con esehjnúmero";
    public static final String PEDIDO_INEXISTENTE = "No existe el pedido";
}

