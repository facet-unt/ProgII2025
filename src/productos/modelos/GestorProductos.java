package productos.modelos;

import java.util.ArrayList;


public class GestorProductos {
    private ArrayList<Producto> productos = new ArrayList<>();
    
    private static GestorProductos instancia;
    
    public static final String EXITO = "Producto creado/modificado con éxito";
    public static final String ERROR_CODIGO = "El código del producto es incorrecto";
    public static final String ERROR_DESCRIPCION = "La descripción del producto es incorrecta";
    public static final String ERROR_PRECIO = "El precio del producto es incorrecto";
    public static final String ERROR_CATEGORIA = "La categoría del producto es incorrecta";
    public static final String ERROR_ESTADO = "El precio del producto es incorrecto";
    public static final String PRODUCTOS_DUPLICADOS = "Ya existe un producto con ese código";
    public static final String VALIDACION_EXITO = "Los datos del producto son correctos";
    public static final String PRODUCTO_INEXISTENTE = "No existe el producto especificado";
    
    private GestorProductos() {
        
    }
    
    public static GestorProductos instanciar() {
        if (instancia == null)
            instancia = new GestorProductos();
        return instancia;
    }
    
    public String crearProducto(int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        if (!(codigo>0))
            return ERROR_CODIGO;
        if(descripcion == null || descripcion == "")
            return ERROR_DESCRIPCION;
        if(precio<=0)
            return ERROR_PRECIO;
        if (categoria == null)
            return ERROR_CATEGORIA;
        if (estado == null)
            return ERROR_ESTADO;
        Producto p = new Producto(codigo, descripcion, categoria, estado, precio);
        if(productos.contains(p))
            return PRODUCTOS_DUPLICADOS;

        productos.add(p);
        return EXITO;
    }
    
    public String modificarProducto(Producto p, int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        if(!this.productos.contains(p))
            return PRODUCTO_INEXISTENTE;
        if (codigo <= 0)
            return ERROR_CODIGO;
        if(descripcion == null || descripcion.equals(""))
            return ERROR_DESCRIPCION;
        if(precio<=0)
            return ERROR_PRECIO;
        if (categoria == null)
            return ERROR_CATEGORIA;
        if (estado == null)
            return ERROR_ESTADO;
        
        p.asignarCodigo(codigo);
        p.asignarDescripcion(descripcion);
        p.asignarPrecio(precio);
        p.asignarCategoria(categoria);
        p.asignarEstado(estado);

        return EXITO;
    }
    
    public ArrayList<Producto> menu() {
        return this.productos;
    }
    
    public ArrayList<Producto> buscarProductos(String descripcion) {
        int i=0;
        ArrayList<Producto> productosPorDescripcion = new ArrayList<>();
        for(Producto p: productos){
            if(p.verDescripcion().equalsIgnoreCase(descripcion)){
                productosPorDescripcion.add(p);
                i++;
            }
        }
        if(i == 0)
            System.out.println(PRODUCTO_INEXISTENTE);
        return productosPorDescripcion;
    }
    
    public boolean existeEsteProducto(Producto producto) {
        if(!productos.contains(producto)){
            System.out.println(PRODUCTO_INEXISTENTE);
            return false;
        }
        return true;
    }
    
    public ArrayList<Producto> verProductosPorCategoria(Categoria categoria) {
        int i = 0;
        ArrayList<Producto> productosPorCategoria = new ArrayList<>();
        for(Producto p: productos){
            if(p.verCategoria() == categoria){
                productosPorCategoria.add(p);
                i++;
            }
        }
        if (i == 0)
            System.out.println(PRODUCTO_INEXISTENTE);
        return productosPorCategoria;
    }
    
    public Producto obtenerProducto(Integer codigo) {
        if(codigo>0){
            for(Producto p: productos){
                if(p.verCodigo() == codigo){
                    System.out.println(VALIDACION_EXITO);
                    return p;
                }
            }
        } else {
            System.out.println(ERROR_CODIGO);
        }
        return null;
    }
}
