package productos.modelos;

import java.util.ArrayList;


public class GestorProductos {
    private ArrayList<Producto> listaProductos = new ArrayList<>();
    
    private static GestorProductos instancia;
    
    private GestorProductos() {
        
    }
    
    public static GestorProductos instanciar() {
        if (instancia == null)
            instancia = new GestorProductos();
        return instancia;
    }
    
    //Constantes
    public static final String EXITO = "Producto creado/modificado con exito";
    public static final String ERROR_CODIGO = "El codigo del producto es incorrecto";
    public static final String ERROR_DESCRIPCION = "La descripcion del producto es incorrecta";
    public static final String ERROR_PRECIO = "El precio del producto es incorrecto";
    public static final String ERROR_CATEGORIA = "La categoria del producto es incorrecta";
    public static final String ERROR_ESTADO = "El precio del producto es incorrecto";
    public static final String PRODUCTOS_DUPLICADOS = "Ya existe un producto con ese codigo";
    public static final String VALIDACION_EXITO = "Los datos del producto son correctos";
    public static final String PRODUCTO_INEXISTENTE = "No existe el producto especificado";
    
    // Metodos
    public String crearProducto(int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        String validacion = validacionDatos(codigo, descripcion, precio, categoria, estado);
        
        if (!validacion.equals(VALIDACION_EXITO)){
            return validacion;
        }
        
        if (this.obtenerProducto(codigo) != null) {
            return PRODUCTOS_DUPLICADOS;
        }
        
        Producto nuevoProducto = new Producto(codigo, descripcion, categoria, estado, precio);
        this.listaProductos.add(nuevoProducto);
        
        return EXITO;
    }
    
    public String modificarProducto(Producto productoAModificar, int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        if (!this.existeEsteProducto(productoAModificar)) {
            return PRODUCTO_INEXISTENTE;
        }
        
        String validacion = validacionDatos(codigo, descripcion, precio, categoria, estado);
        
        if (!validacion.equals(VALIDACION_EXITO)) {
            return validacion;
        }
        
        productoAModificar.asignarCodigo(codigo);
        productoAModificar.asignarDescripcion(descripcion);
        productoAModificar.asignarPrecio(precio);
        productoAModificar.asignarCategoria(categoria);
        productoAModificar.asignarEstado(estado);
        
        return EXITO;
    }
    
    public ArrayList<Producto> menu() {
        return this.listaProductos;
    }
    
    public ArrayList<Producto> buscarProductos(String descripcion) {
        ArrayList<Producto> productosEncontrados = new ArrayList();
        
        //Devuelvo lista vacia si la descripcion no es valida
        if (descripcion == null || descripcion.isEmpty()) {
            return productosEncontrados;
        }
        
        for (Producto p : this.listaProductos) {
            if (p.verDescripcion().toLowerCase().equals(descripcion.toLowerCase())) {
                productosEncontrados.add(p);
            }
        }
        
        return productosEncontrados;
    }
    
    public boolean existeEsteProducto(Producto producto) {
        return this.listaProductos.contains(producto);
    }
    
    public ArrayList<Producto> verProductosPorCategoria(Categoria categoria) {
        ArrayList<Producto> productosPorCategoria = new ArrayList();
        
        if (categoria == null) {
            return productosPorCategoria;
        }
        
        for (Producto p : this.listaProductos) {
            if (p.verCategoria() == categoria) {
                productosPorCategoria.add(p);
            }
        }
        
        return productosPorCategoria;
    }
    
    public Producto obtenerProducto(Integer codigo) {
        for (Producto p : this.listaProductos) {
            if (p.verCodigo() == codigo) {
                return p;
            }
        }
        return null;
    }
    
    // Verificacion datos
    
    private String validacionDatos (int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        if (codigo <= 0) {
            return ERROR_CODIGO;
        }
        if (descripcion == null || descripcion.isEmpty()) {
            return ERROR_DESCRIPCION;
        }
        if (precio <= 0) {
            return ERROR_PRECIO;
        }
        if (categoria == null) {
            return ERROR_CATEGORIA;
        }
        if (estado == null) {
            return ERROR_ESTADO;
        }
        
        return VALIDACION_EXITO;
    }
}
