package productos.modelos;

import interfaces.IGestorProductos;
import static interfaces.IGestorProductos.ERROR_CATEGORIA;
import static interfaces.IGestorProductos.ERROR_CODIGO;
import static interfaces.IGestorProductos.ERROR_DESCRIPCION;
import static interfaces.IGestorProductos.ERROR_PRECIO;
import static interfaces.IGestorProductos.PRODUCTOS_DUPLICADOS;
import static interfaces.IGestorProductos.PRODUCTO_INEXISTENTE;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import pedidos.modelos.GestorPedidos;

public class GestorProductos implements IGestorProductos {
    
    private List<Producto> productos = new ArrayList<>();
    
    private static final String SEPARADOR = "-";
    private static final String NOMBREARCHIVO = "Productos.txt";
    
    private static GestorProductos instancia;
    
    private GestorProductos() { }
    
    public static GestorProductos instanciar() {
        if (instancia == null)
            instancia = new GestorProductos();
        return instancia;
    }
    
  
    
    private String validarInfo(int codigo, String descripcion, float precio, Categoria categoria, Estado estado){
        if (codigo <= 0)
            return ERROR_CODIGO;
        
        if (descripcion == null || descripcion.isEmpty())
            return ERROR_DESCRIPCION;
        
        if (precio <= 0)
            return ERROR_PRECIO;
        
        if (categoria == null)
            return ERROR_CATEGORIA;
        
        if (estado == null)
            return ERROR_ESTADO;
        
        return VALIDACION_EXITO;
    }
    
    
    
    @Override
    public String crearProducto(int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        
        String resultado = validarInfo(codigo, descripcion, precio, categoria, estado);
        if (!resultado.equals(VALIDACION_EXITO))
            return resultado;
        
        if (obtenerProducto(codigo) != null)
            return PRODUCTOS_DUPLICADOS;
        
        Producto nuevo = new Producto(codigo, descripcion, categoria, estado, precio);
        productos.add(nuevo);
        
        guardarListaEnArchivo();
        
        return EXITO;
    }
    
    
    
    @Override
    public String modificarProducto(Producto p, int nuevoCodigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        
        if (p == null || !productos.contains(p))
            return PRODUCTO_INEXISTENTE;
        
        String validacion = validarInfo(nuevoCodigo, descripcion, precio, categoria, estado);
        if (!validacion.equals(VALIDACION_EXITO))
            return validacion;
        
        
        Producto otro = obtenerProducto(nuevoCodigo);
        if (otro != null && otro != p)
            return PRODUCTOS_DUPLICADOS;
        
        
        p.asignarCodigo(nuevoCodigo);
        p.asignarDescripcion(descripcion);
        p.asignarPrecio(precio);
        p.asignarCategoria(categoria);
        p.asignarEstado(estado);
        
        guardarListaEnArchivo(); 
        
        return EXITO;
    }
    
   
    
    @Override
    public String borrarProducto(Producto producto) {
        
        if (producto == null)
            return "Error: el producto es nulo.";
        
        if (!productos.contains(producto))
            return "El producto no existe en el sistema.";
        
        GestorPedidos gp = GestorPedidos.getInstancia();
        if (gp.hayPedidosConEsteProducto(producto))
            return "No se puede eliminar el producto, hay pedidos asociados.";
        
        productos.remove(producto);
        guardarListaEnArchivo();
        
        return "Producto eliminado con éxito.";
    }
    
    
    
    @Override
    public Producto obtenerProducto(Integer codigo) {
        for (Producto p : productos)
            if (p.verCodigo() == codigo)
                return p;
        return null;
    }
    
    @Override
    public List<Producto> buscarProductos(String descripcion) {
        List<Producto> lista = new ArrayList<>();
        for (Producto p : productos)
            if (p.verDescripcion().equals(descripcion))
                lista.add(p);
        lista.sort(dDesc);
        return lista;
    }
    
    @Override
    public boolean existeEsteProducto(Producto producto) {
        return productos.contains(producto);
    }
    
    @Override
    public List<Producto> verProductosPorCategoria(Categoria categoria) {
        List<Producto> filtrados = new ArrayList<>();
        for (Producto p : productos)
            if (p.verCategoria().equals(categoria))
                filtrados.add(p);
        filtrados.sort(dDesc);
        return filtrados;
    }
    
    @Override
    public List<Producto> menu() {
        productos = leerProductos();
        Collections.sort(productos);
        return productos;
    }
    
    Comparator<Producto> dDesc = (p1, p2) -> p1.verDescripcion().compareTo(p2.verDescripcion());
    
   
    
    private void guardarListaEnArchivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOMBREARCHIVO,true))) {
            
            for (Producto p : productos) {
                String linea = p.verCodigo() + SEPARADOR +
                               p.verDescripcion() + SEPARADOR +
                               p.verCategoria().toString() + SEPARADOR +
                               p.verEstado().toString() + SEPARADOR +
                               p.verPrecio();
                
                bw.write(linea);
                bw.newLine();
            }
            
        } catch (IOException e) {
            System.out.println(ESCRITURA_ERROR);
        }
    }
    
    
    
    private List<Producto> leerProductos() {
        List<Producto> lista = new ArrayList<>();
        
        File f = new File(NOMBREARCHIVO);
        if (!f.exists())
            return lista;
        
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(SEPARADOR);
                
                int codigo = Integer.parseInt(partes[0]);
                String descripcion = partes[1];
                Categoria categoria = convertirCategoria(partes[2]);
                Estado estado = convertirEstado(partes[3]);
                float precio = Float.parseFloat(partes[4]);
                
                Producto p = new Producto(codigo, descripcion, categoria, estado, precio);
                lista.add(p);
            }
            
        } catch (IOException e) {
            System.out.println(ERROR_LECTURA);
        }
        
        return lista;
    }
    
    
    
    private Categoria convertirCategoria(String valor) {
        for (Categoria c : Categoria.values())
            if (c.toString().equals(valor))
                return c;
        return null;
    }
    
    private Estado convertirEstado(String valor) {
        for (Estado e : Estado.values())
            if (e.toString().equals(valor))
                return e;
        return null;
    }
}

