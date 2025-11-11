/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package productos.modelos;

import java.util.ArrayList;

/**
 *
 * @author damia
 */
public interface IGestorProductos {
    public String crearProducto(int codigo, String descripcion, float precio,
    Categoria categoria, Estado estado);
    public String modificarProducto(Producto productoAModificar, int codigo, String
    descripcion, float precio, Categoria categoria, Estado estado);
    public ArrayList<Producto> menu();
    public ArrayList<Producto> buscarProductos(String descripcion);
    public String borrarProducto(Producto producto);
    public boolean existeEsteProducto(Producto producto);
    public ArrayList<Producto> verProductosPorCategoria(Categoria categoria);
    public Producto obtenerProducto(Integer codigo);
}
