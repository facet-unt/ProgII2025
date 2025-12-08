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
    private static GestorProductos instancia;
    
    private GestorProductos() { 
        this.productos = leerProductos();
    }
    
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
        
        // Verificar si el nuevo código ya existe en otro producto
        Producto otro = obtenerProducto(nuevoCodigo);
        if (otro != null && otro != p)
            return PRODUCTOS_DUPLICADOS;
        
        // CORRECCIÓN 2: Modificar producto correctamente
        p.asignarCodigo(nuevoCodigo);
        p.asignarDescripcion(descripcion);
        p.asignarPrecio(precio);
        p.asignarCategoria(categoria);
        p.asignarEstado(estado);
        
        // Guardar cambios en el archivo
        guardarListaEnArchivo(); 
        
        return EXITO;
    }
    
    @Override
    public String borrarProducto(Producto producto) {

        if (producto == null)
            return "Error: el producto es nulo.";

        if (!productos.contains(producto))
            return "El producto no existe en el sistema.";

        // Verificar si hay pedidos asociados (comentar si GestorPedidos no existe aún)
        try {
            GestorPedidos gp = GestorPedidos.getInstancia();
            if (gp.hayPedidosConEsteProducto(producto))
                return "No se puede eliminar el producto, hay pedidos asociados.";
        } catch (Exception e) {
            // Si GestorPedidos no existe, continuar con la eliminación
        }

        // CORRECCIÓN 3: Eliminar de la lista Y del archivo
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
            if (p.verDescripcion().toLowerCase().contains(descripcion.toLowerCase()))
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
        Collections.sort(productos);
        return new ArrayList<>(productos); 
    }
    
    Comparator<Producto> dDesc = (p1, p2) -> p1.verDescripcion().compareTo(p2.verDescripcion());
    
    // CORRECCIÓN 5: Sobrescribir archivo completo (sin append)
    private void guardarListaEnArchivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOMBREARCHIVO))) {
            
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
            System.err.println(ESCRITURA_ERROR + ": " + e.getMessage());
        }
    }
    
    @Override
    public List<Producto> leerProductos() {
        List<Producto> lista = new ArrayList<>();
        
        File f = new File(NOMBREARCHIVO);
        if (!f.exists())
            return lista;
        
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            
            String linea;
            while ((linea = br.readLine()) != null) {
                // Ignorar líneas vacías
                if (linea.trim().isEmpty())
                    continue;
                    
                String[] partes = linea.split(SEPARADOR);
                
                if (partes.length != 5) {
                    System.err.println("Línea mal formateada: " + linea);
                    continue;
                }
                
                try {
                    int codigo = Integer.parseInt(partes[0].trim());
                    String descripcion = partes[1].trim();
                    Categoria categoria = convertirCategoria(partes[2].trim());
                    Estado estado = convertirEstado(partes[3].trim());
                    float precio = Float.parseFloat(partes[4].trim());
                    
                    if (categoria != null && estado != null) {
                        Producto p = new Producto(codigo, descripcion, categoria, estado, precio);
                        lista.add(p);
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Error al parsear números en línea: " + linea);
                }
            }
            
        } catch (IOException e) {
            System.err.println(ERROR_LECTURA + ": " + e.getMessage());
        }
        
        return lista;
    }
    
    private Categoria convertirCategoria(String valor) {
        try {
            return Categoria.valueOf(valor);
        } catch (IllegalArgumentException e) {
            // Si falla valueOf, intentar con toString()
            for (Categoria c : Categoria.values())
                if (c.toString().equalsIgnoreCase(valor))
                    return c;
            return null;
        }
    }
    
    private Estado convertirEstado(String valor) {
        try {
            return Estado.valueOf(valor);
        } catch (IllegalArgumentException e) {
            // Si falla valueOf, intentar con toString()
            for (Estado t : Estado.values())
                if (e.toString().equalsIgnoreCase(valor))
                    return t;
            return null;
        }
    }
}
