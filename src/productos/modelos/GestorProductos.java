package productos.modelos;

import java.util.ArrayList;


public class GestorProductos {
    private ArrayList<Producto> productos = new ArrayList<>();
    public static final String ERROR_CODIGO = "El código del producto es incorrecto";
    public static final String ERROR_DESCRIPCION = "La descripción del producto es incorrecta";
    public static final String ERROR_PRECIO = "El precio del producto es incorrecto";
    public static final String ERROR_CATEGORIA = "La categoría del producto es incorrecta";
    public static final String ERROR_ESTADO = "El precio del producto es incorrecto";
    public static final String PRODUCTOS_DUPLICADOS = "Ya existe un producto con ese código";
    public static final String VALIDACION_EXITO = "Los datos del producto son correctos";
    public static final String PRODUCTO_INEXISTENTE = "No existe el producto especificado";
    private static GestorProductos instancia;
    
    private GestorProductos() {
        
    }
    
    public static GestorProductos instanciar() {
        if (instancia == null)
            instancia = new GestorProductos();
        return instancia;
    }
    
    public String crearProducto(int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        Producto producto= new Producto(codigo,descripcion,precio,categoria,estado);
        if(codigo<=0)
            return ERROR_CODIGO;
        if(descripcion.isEmpty()||descripcion.isBlank())
        return ERROR_DESCRIPCION;
        if(precio<=0)
            return ERROR_PRECIO;
        if(categoria==null)
            return ERROR_CATEGORIA;
        if(estado==null)
            return ERROR_ESTADO;
        if(productos.contains(producto))
            return PRODUCTOS_DUPLICADOS;
        else
            productos.add(producto);
        String cadena= "Se creo el Producto con exito";
        return cadena;
    }
    
    public String modificarProducto(Producto productoAModificar, int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        if(productoAModificar==null)
            return PRODUCTO_INEXISTENTE;
        if(codigo<=0)
            return ERROR_CODIGO;
        productoAModificar.asignarCodigo(codigo);
        if(descripcion.isEmpty()||descripcion.isBlank())
        return ERROR_DESCRIPCION;
        productoAModificar.asignarDescripcion(descripcion);
        if(precio<=0)
            return ERROR_PRECIO;
        productoAModificar.asignarPrecio(precio);
        if(categoria==null)
            return ERROR_CATEGORIA;
        productoAModificar.asignarCategoria(categoria);
        if(estado==null)
            return ERROR_ESTADO;
        productoAModificar.asignarEstado(estado);
        String cadena="Se modificó el Producto con exito";
        return cadena;
    }
    
    public ArrayList<Producto> menu() {
        return this.productos;
    }
    
    public ArrayList<Producto> buscarProductos(String descripcion) {
        ArrayList <Producto>productosbuscados =new ArrayList<>();
        for (Producto p : productos) {
            if(p.verDescripcion().toLowerCase().contains(descripcion.toLowerCase()))
                productosbuscados.add(p);
      }
        return productosbuscados;
    }
    
    public boolean existeEsteProducto(Producto producto) {
        for (Producto p: productos) {
            if(p.verCodigo()==producto.verCodigo())
            return true;
        }
        return false;
        }
    
    public ArrayList<Producto> verProductosPorCategoria(Categoria categoria) {
        ArrayList<Producto>productoDelaCategoria=new ArrayList<>();
        for(Producto p: productos){
            if(p.verCategoria()==categoria)
                productoDelaCategoria.add(p);
        }
        return productoDelaCategoria;
    }
    
    public Producto obtenerProducto(Integer codigo) {
        for(Producto p: productos){
            if(p.verCodigo()==codigo)
                return p;
        }
        return null;
        }
    }