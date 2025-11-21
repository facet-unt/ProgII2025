/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package productos.modelos;

import java.util.List;

/**
 *
 * @author damia
 */
public interface IGestorProductos {
    public String crearProducto(int codigo, String descripcion, float precio, Categoria categoria, Estado estado);
    public String modificarProducto(Producto productoAModificar, int codigo, String
    descripcion, float precio, Categoria categoria, Estado estado);
    public List<Producto> menu();
    public List<Producto> buscarProductos(String descripcion);
    public String borrarProducto(Producto producto);
    public boolean existeEsteProducto(Producto producto);
    public List<Producto> verProductosPorCategoria(Categoria categoria);
    public Producto obtenerProducto(Integer codigo);
}
