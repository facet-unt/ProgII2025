package productos.modelos;

import interfaces.IGestorProductos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pedidos.modelos.*;

public class GestorProductos implements IGestorProductos{
    private List<Producto> productos = new ArrayList<>();
    
    private static GestorProductos instancia;
    private final String NOMBREARCHIVO = "Productos.txt";
    private final String SEPARADOR = "-";
    
    private GestorProductos() {
        /*Lee los datos del archivo*/
        this.leerArchivo(NOMBREARCHIVO);
    }
    
    public static GestorProductos instanciar() {
        if (instancia == null)
            instancia = new GestorProductos();
        return instancia;
    }
    
    
    
    public String crearProducto(int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        
        
        if(codigo>0 &&  descripcion!=null && !descripcion.isBlank() && precio>0 && categoria!=null && estado!=null)
        {
            Producto p = new Producto (codigo, descripcion, categoria, estado, precio);
            
            this.escribirArchivo(NOMBREARCHIVO, p);

            if(productos.contains(p)){
                return PRODUCTOS_DUPLICADOS;
            }
            else{
                productos.add(p);
                return (EXITO);
            }
        
        }
        else{
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

        if(codigo>0 && descripcion != null && precio>0 && categoria!= null && estado!=null)
        {
            p.asignarCodigo(codigo);
            p.asignarDescripcion(descripcion);
            p.asignarPrecio(precio);
            p.asignarCategoria(categoria);
            p.asignarEstado(estado);
            this.modificarArchivo(NOMBREARCHIVO);
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
    
    // Modificacion del metodo menu (devuelve productos ordenados por descripcion y categoria)
    public List<Producto> menu() {

        Collections.sort(this.productos);
        return this.productos;
    }
    
    public ArrayList<Producto> buscarProductos(String descripcion) {
         
        ArrayList<Producto> encontrados = new ArrayList<>();
        for (Producto p : productos) {
             
            if (p.verDescripcion().toLowerCase().contains(descripcion.toLowerCase())) {
                encontrados.add(p);
            }
                
        }
        Collections.sort(encontrados); /* Se ordena la lista por categoria y descripcion TP6 */
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
        Collections.sort(prodcat); /* Se ordenan los productos por categoria y descripcion TP6 */
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
    public String borrarProducto(Producto producto)
    {
        if (productos.contains(producto) && producto!=null)
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
             this.modificarArchivo(NOMBREARCHIVO);
             return (OPERACION_EXITOSA);
        }
        else
        {
            return (BORRADO_FALLIDO + PRODUCTO_INEXISTENTE);
        }
    }
    
    private String escribirArchivo(String NOMBREARCHIVO, Producto p)
    {
        
        
        try( FileWriter fw = new FileWriter(NOMBREARCHIVO, true))
        {
            fw.write(deProductoaString(p));
            return ESCRITURA_OK;
            
        } catch (IOException ex) {
            return ESCRITURA_ERROR;
        }   
    }

    private String modificarArchivo(String NOMBREARCHIVO){ /*Metodo que agrega la lista modificada al archivo */
        try( FileWriter fw = new FileWriter(NOMBREARCHIVO))
        {
            for(Producto p : this.productos){
                fw.write(deProductoaString(p));
            }
            return ESCRITURA_OK;
        } catch (IOException ex) {
            return ESCRITURA_ERROR;
        }
    }


    private String deProductoaString(Producto p){
        StringBuilder linea = new StringBuilder();
        linea.append(p.verCodigo());
        linea.append(SEPARADOR);
        linea.append(p.verDescripcion());
        linea.append(SEPARADOR);
        linea.append(p.verCategoria().toString());
        linea.append(SEPARADOR);
        linea.append(p.verEstado().toString());
        linea.append(SEPARADOR);
        linea.append(Float.toString(p.verPrecio()));
        linea.append("\n");
        return linea.toString();
  
    }
    
    private String leerArchivo(String NOMBREARCHIVO){
        
        try(FileReader fr = new FileReader(NOMBREARCHIVO))
        {
            BufferedReader bw = new BufferedReader(fr);
            String linea = "";
            while((linea = bw.readLine()) != null){
            Producto p = this.deStringaProducto(linea);
            this.productos.add(p);
            }
                 
            return LECTURA_OK;
            
        } catch (IOException ex) {
            return LECTURA_ERROR;
        }   
    }
    
    private Producto deStringaProducto(String linea){
        int codigo;
        String descripcion;
        Categoria unaCategoria;
        Estado unEstado;
        float precio;
        
        String[] cadenas = linea.split("-");
        codigo = Integer.parseInt(cadenas[0]);
        descripcion = cadenas[1];
        unaCategoria = Categoria.convertir(cadenas[2]);
        unEstado = Estado.convertirEstado(cadenas[3]);
        precio = Float.parseFloat(cadenas[4]);
        
        Producto p = new Producto (codigo, descripcion, unaCategoria, unEstado, precio);
        
        return p;
            
    }
    



    // <editor-fold defaultstate="collapsed" desc="nombre">
    
    // </editor-fold>
    
    }
