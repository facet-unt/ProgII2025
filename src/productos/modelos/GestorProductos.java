package productos.modelos;

import interfaces.IGestorProductos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import pedidos.modelos.GestorPedidos;

public class GestorProductos implements IGestorProductos{
    private ArrayList<Producto> productos = new ArrayList<>();
   
    private static GestorProductos instancia;
//Agrego las constantes de archivo
    private static final String NOMBRE_ARCHIVO= "Archivo.txt";
    private static final String SEPARADOR_ARCHIVO= ";";
    private GestorProductos() {

    }
    
    public static GestorProductos instanciar() {
        if (instancia == null)
            instancia = new GestorProductos();
        return instancia;
    }
    
    @Override
    public String crearProducto(int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        String error = validarDatosProducto(codigo, descripcion, precio, categoria, estado);
        if (error != null)
            return error;
        Producto pNuevo = new Producto(codigo, descripcion, categoria, estado, precio);
        
        if(existeEsteProducto(pNuevo))
            return PRODUCTOS_DUPLICADOS;
        productos.add(pNuevo);
        //Agregamos el producto en el archivo
        this.cargarProdEnArchivo();
        
        return EXITO;
    }
    
    @Override
    public String modificarProducto(Producto p, int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        if (p==null){
            return PRODUCTO_INEXISTENTE;
        }
        String error = validarDatosProducto(codigo, descripcion, precio, categoria, estado);
        if (error != null)
            return error;
        
        p.asignarCodigo(codigo);
        p.asignarDescripcion(descripcion);
        p.asignarPrecio(precio);
        p.asignarCategoria(categoria);
        p.asignarEstado(estado);
        
        return EXITO;
    }

    @Override
    public List<Producto> menu() {
        ArrayList<Producto> productosOrdenados = new ArrayList<>(this.productos);
        ordenarPorCategoriaYDescripcion(productosOrdenados);
        
        return productosOrdenados;
    }
    
    @Override
    public List<Producto> buscarProductos(String descripcion) {
        ArrayList<Producto> pEncontrados = new ArrayList<>();
        
        if(descripcion==null || descripcion.trim().isEmpty()){
            return pEncontrados;
        }
        for(Producto p : productos){
            if(p.verDescripcion().toLowerCase().contains(descripcion.toLowerCase())){
                pEncontrados.add(p);
            }
        }
        
        ordenarPorCategoriaYDescripcion(pEncontrados);
        return pEncontrados;
    }
    
    @Override
    public boolean existeEsteProducto(Producto producto) {
        for(Producto p : productos){
            if(p.verCodigo()== producto.verCodigo()){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public List<Producto> verProductosPorCategoria(Categoria categoria) {
        ArrayList<Producto> categoriaBusq = new ArrayList<>();
        
        for (Producto p : productos) {
            if (p.verCategoria() == categoria) {
                categoriaBusq.add(p);
            }
        }
        
        categoriaBusq.sort ((p1, p2) -> p1.verDescripcion().compareToIgnoreCase(p2.verDescripcion()));
        return categoriaBusq;
    }
    
    @Override
    public Producto obtenerProducto(Integer codigo) {
        for (Producto p : productos) {
            if (p.verCodigo() == codigo) {
                return p;
            }
        }
        return null;
    }
    
    @Override
    public String borrarProducto(Producto producto) {
        if (producto == null) {
            return PRODUCTO_INEXISTENTE;
        }
   
        GestorPedidos gp = GestorPedidos.instanciar();
        if (gp.hayPedidosConEsteProducto(producto)) {
            return "No se puede borrar el producto, existen pedidos con el mismo.";
        }
    
        if (productos.remove(producto)) {
            return "Producto borrado con éxito.";
        } else {
            return PRODUCTO_INEXISTENTE;
        }
    }
    
    private String validarDatosProducto(int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        if (codigo <= 0) {
            return ERROR_CODIGO;
        }
        if (descripcion == null || descripcion.trim().isEmpty()) {
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
        return null;
    }
    
    private void ordenarPorCategoriaYDescripcion(List<Producto> lista) {
        lista.sort((p1, p2) -> {
            int comparacionCategoria = p1.verCategoria().toString().compareToIgnoreCase(p2.verCategoria().toString());
            if (comparacionCategoria == 0) {
                return p1.verDescripcion().compareToIgnoreCase(p2.verDescripcion());
            }
            return comparacionCategoria;
        });
    }
    //Hacemos las validaciones de los datos del producto
    
    //Implementacion de los metodos agregados en IGestorProductos
    public String leerProductoConArchivo(){
        File prodArchivo = new File(NOMBRE_ARCHIVO);
        if(!prodArchivo.exists()){
            try{
                if(prodArchivo.createNewFile()){
                    return CREACION_OK; //Si el archivo se creo correctamente
                }
                else {
                    return CREACION_ERROR;
                }
            } catch(IOException e){
                return CREACION_ERROR;
            }
        }
        // Hago un try con argumento
        try(BufferedReader br = new BuffereadRead(new FileReader(prodArchivo))){
            productos.clear(); //Evitamos que se dupliquen los productos si se vuelve a leer
            String linea;
            
            while((linea = br.readLine())!=null){
                linea=linea.trim();
              Producto p = convertirLineaAProducto(linea);
              if(p!=null && !productos.contains(p)){
                  productos.add(p);
              return LECTURA_OK;
            }
        }  
        } catch(IOException | IllegalArgumentException e){
            return LECTURA_ERROR;
        }
    }
}