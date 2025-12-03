/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;
import productos.modelos.Categoria;
import productos.modelos.Estado;
import productos.modelos.Producto;

/**
 *
 * @author damia
 */
public interface IGestorProductos {
    public static final String EXITO = "Producto creado/modificado con éxito";
    public static final String ERROR_CODIGO = "El código del producto es incorrecto";
    public static final String ERROR_DESCRIPCION = "La descripción del producto es incorrecta";
    public static final String ERROR_PRECIO = "El precio del producto es incorrecto";
    public static final String ERROR_CATEGORIA = "La categoría del producto es incorrecta";
    public static final String ERROR_ESTADO = "El estado del producto es incorrecto";
    public static final String PRODUCTOS_DUPLICADOS = "Ya existe un producto con ese código";
    public static final String VALIDACION_EXITO = "Los datos del producto son correctos";
    public static final String PRODUCTO_INEXISTENTE = "No existe el producto especificado";
    
    public static final String LECTURA_ERROR = "Error al leer los productos";
    public static final String CREACION_ERROR = "Error al crear el archivo de productos";
    public static final String LECTURA_OK = "Se pudieron leer los productos";
    public static final String CREACION_OK = "Se pudo crear el archivo de productos";
    public static final String ESCRITURA_OK = "Se pudieron guardar los productos";
    public static final String ESCRITURA_ERROR = "Error al guardar los productos";
    
    /**
     * Crea un producto y lo guarda en un archivo de texto
     * @param codigo
     * @param descripcion
     * @param precio
     * @param categoria
     * @param estado
     * @return Devuelve un String con el resultado de la operacion
     */
    public String crearProducto(int codigo, String descripcion, float precio, Categoria categoria, Estado estado);
    /**
     * Modifica el producto ingresado con los parametros indicados
     * @param productoAModificar
     * @param codigo
     * @param descripcion
     * @param precio
     * @param categoria
     * @param estado
     * @return 
     */
    public String modificarProducto(Producto productoAModificar, int codigo, String
    descripcion, float precio, Categoria categoria, Estado estado);
    /**
     * 
     * @return Devuelve una lista con los pedidos ordenados 
     */
    public List<Producto> menu();
    /**
     * Busca los productos por descripcion
     * @param descripcion
     * @return Devuelve una lista con los productos que contengan la descripcion ingresada
     */
    public List<Producto> buscarProductos(String descripcion);
    /**
     * Borra el producto ingresado
     * @param producto
     * @return Devuelve un String con el resultado de la operacion
     */
    public String borrarProducto(Producto producto);
    /**
     * @param producto
     * @return Devuelve true si existe el producto ingresado
     */
    public boolean existeEsteProducto(Producto producto);
    /**
     * Busca los productos por categoria y los guarda en una lista
     * @param categoria
     * @return Devuelve una lista con los productos cuya categoria coincida con la descripcion ingresada
     */
    public List<Producto> verProductosPorCategoria(Categoria categoria);
    /**
     * Busca un producto por su codigo
     * @param codigo
     * @return Devuelve el producto cuyo codigo sea el ingresado
     */
    public Producto obtenerProducto(Integer codigo);
}
