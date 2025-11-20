package productos.modelos;

import interfaces.IGestorProductos;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import pedidos.modelos.*;


public class GestorProductos implements IGestorProductos{
    private ArrayList<Producto> productos = new ArrayList<>();
    private final String SEPARADOR = ";";
    private final String NOMBREARCHIVO = "Productos.txt";
    
    private static GestorProductos instancia;
    
    private GestorProductos() {
        this.leerArchivo();
    }
    
    public static GestorProductos instanciar() {
        if (instancia == null)
            instancia = new GestorProductos();
        return instancia;
    }
    
    public String crearProducto(int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        Producto p = new Producto (codigo, descripcion, categoria, estado, precio);
        if(codigo>0&&descripcion!=null&&precio>0&&categoria!=null&&estado!=null)
        {
            productos.add(p);
            this.guardarArchivo(p);
            return (EXITO); 
            
        }
        else
        {
            if (codigo<0)
                return (ERROR_CODIGO);
            else if (precio<0)
                return (ERROR_PRECIO);
            else if (descripcion==null)
                return (ERROR_DESCRIPCION);
            else if (categoria==null)
                return (ERROR_CATEGORIA);
            else
                return(ERROR_ESTADO);
        }
        
    }
    
    public String modificarProducto(Producto p, int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        if (productos.contains(p))
            {
                productos.remove(p);
            }
        p.asignarCodigo(codigo);
        p.asignarDescripcion(descripcion);
        p.asignarPrecio(precio);
        p.asignarCategoria(categoria);
        p.asignarEstado(estado);
        productos.add(p);
        if(codigo>0&&descripcion!=null&&precio>0&&categoria!=null&&estado!=null)
        {
            productos.add(p);
            return (EXITO); 
            
        }
        else
        {
            if (codigo<0)
                return (ERROR_CODIGO);
            else if (precio<0)
                return (ERROR_PRECIO);
            else if (descripcion==null)
                return (ERROR_DESCRIPCION);
            else if (categoria==null)
                return (ERROR_CATEGORIA);
            else
                return(ERROR_ESTADO);
        }
    }
    
    public ArrayList<Producto> menu() {
        return this.productos;
        
    }
    
    public ArrayList<Producto> buscarProductos(String descripcion) {
         
        ArrayList<Producto> encontrados = new ArrayList<>();
        for (Producto p : productos) {
             
            if (p.verDescripcion().toLowerCase().contains(descripcion.toLowerCase())) {
                encontrados.add(p);
            }
                
            }
        return encontrados;
    }
    
    public boolean existeEsteProducto(Producto producto) {
        if (productos.contains(producto))
            return true;
        else
            return false;
    }
    
    public ArrayList<Producto> verProductosPorCategoria(Categoria categoria) {
         ArrayList<Producto> prodcat = new ArrayList<>();
        for (Producto p : productos) {
             
            if (p.verCategoria()==(categoria)) {
                prodcat.add(p);
            }
                
            }
        return prodcat;
    }
    
    public Producto obtenerProducto(Integer codigo) {
        for (Producto p : productos) {
             
            if (p.verCodigo()==(codigo)) {
                return p;
            }
                
            }
        return null;
    }
    
    @Override
    public String borrarProducto(Producto producto) {
        if (productos.contains(producto)&&producto!=null)
        {
            GestorPedidos pedidos = GestorPedidos.instanciar();
            for(Pedido unPedido: pedidos.verPedidos())
            {
                for (ProductoDelPedido unProducto: unPedido.verProductoPedido())
                {
                   if((unProducto.verUnProducto()).equals(producto))
                   {
                       return (BORRADO_FALLIDO + PRODUCTO_EN_PEDIDO);
                   }
             
                }
               
            }
             productos.remove(producto);
             return (OPERACION_EXITOSA);
        }
        else
        {
            return (BORRADO_FALLIDO + PRODUCTO_INEXISTENTE);
        }
    }
    
    private void guardarArchivo(Producto producto) {        
        StringBuilder linea = new StringBuilder();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(NOMBREARCHIVO), true))) {
            linea.append("");
            linea.append(Integer.toString(producto.verCodigo()));
            linea.append(SEPARADOR);
            linea.append(producto.verDescripcion());
            linea.append(SEPARADOR);
            linea.append(producto.verCategoria().toString());
            linea.append(SEPARADOR);
            linea.append(producto.verEstado().toString());
            linea.append(SEPARADOR);
            linea.append(Float.toString(producto.verPrecio()));
            bw.write(linea.toString());            
            bw.newLine();
        } 
        catch (IOException ex) {
            System.out.println("IOException");
        }
    }
    
    private void leerArchivo() {
        String linea = null;
        File file = new File(NOMBREARCHIVO);
        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                while ((linea = br.readLine()) != null) {                    
                    this.procesarLinea(linea);                  
                }
            } 
            catch (FileNotFoundException ex) {
                System.out.println("FileNotFoundException");
            }
            catch(IOException ex) {
                System.out.println("IOException");
            }
        }
    }
    
    private void procesarLinea(String linea) {
        String[] cadenas = linea.split(SEPARADOR);
        int codigo = Integer.parseInt(cadenas[0]);
        String descripcion = cadenas[1];
        Categoria categoria = Categoria.verCategoria(cadenas[2]);
        Estado estado = Estado.verEstado(cadenas[3]);
        float precio = Float.parseFloat(cadenas[4]);
        Producto p = new Producto(codigo, descripcion, categoria, estado, precio);
        this.productos.add(p);
    }
}
