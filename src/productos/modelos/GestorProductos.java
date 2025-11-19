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
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import pedidos.modelos.GestorPedidos;


public class GestorProductos implements IGestorProductos{
    
    public static final String CREACION_OK = "Se pudo crear el archivo de productos";
    public static final String CREACION_ERROR = "Error al crear el archivo de productos";
    public static final String ESCRITURA_ERROR = "Error al guardar los productos";
    public static final String ESCRITURA_OK = "Se pudieron guardar los productos";
    public static final String LECTURA_ERROR = "Error al leer los productos";
    public static final String LECTURA_OK = "Se pudieron leer los productos";
    public static final String SEPARADOR = ";";
    private static String NOMBRE_ARCHIVO = "Productos.txt";
    private List<Producto> productos = new ArrayList<>();
    
    private static GestorProductos instancia;
    
    private GestorProductos() {
        
    }
    
    public static GestorProductos instanciar() {
        if (instancia == null)
            instancia = new GestorProductos();
        System.out.println(crearArchivo());
        return instancia;
    }
    
    @Override
    public String crearProducto(int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        if(codigo<=0){
            return ERROR_CODIGO ;
        }
        for(Producto p1: productos){
            if(p1.verCodigo()==codigo){
                return PRODUCTOS_DUPLICADOS;
            }
        }
        if(descripcion==null||descripcion.isBlank()){
            return ERROR_DESCRIPCION ;
        }
        if(precio<=0){
            return ERROR_PRECIO ;
        }
        if(categoria==null){
            return ERROR_CATEGORIA ;
        }
        if(estado==null){
            return ERROR_ESTADO ;
        }
        Producto p = new Producto(codigo,descripcion,categoria,estado,precio);
        
        return agregarProducto(p);
    }
    
    @Override
    public String modificarProducto(Producto p, int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        if(p==null){
            return PRODUCTO_INEXISTENTE;
        }
        if(codigo<=0){
            return ERROR_CODIGO ;
        }
        for(Producto p1: productos){
            if(p.verCodigo()==codigo){
                break;
            }
            if(p1.verCodigo()==codigo){
                return PRODUCTOS_DUPLICADOS;
            }
        }
        if(descripcion==null||descripcion.isBlank()){
            return ERROR_DESCRIPCION ;
        }
        if(precio<=0){
            return ERROR_PRECIO ;
        }
        if(categoria==null){
            return ERROR_CATEGORIA ;
        }
        if(estado==null){
            return ERROR_ESTADO ;
        }
        Producto productoModificado = new Producto(codigo,descripcion,categoria,estado,precio);
        productos.set(productos.indexOf(p), productoModificado);
        return EXITO;
    }
    
    @Override
    public List<Producto> menu() {
        List<Producto> productosMenu = new ArrayList<>();
        productosMenu = this.leerArchivo();
        Collections.sort(productosMenu);
        return productosMenu;
    }
    
    @Override
    public List<Producto> buscarProductos(String descripcion) {
        List<Producto> productosEncontrados = new ArrayList<>();
        for(Producto p: productos){
            if(p.verDescripcion().contains(descripcion)){
                productosEncontrados.add(p);
            }
        }
        Collections.sort(productos);
        return productosEncontrados;
    }
    
    @Override
    public boolean existeEsteProducto(Producto producto) {
        for(Producto p: productos){
            if(producto.equals(p)){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public List<Producto> verProductosPorCategoria(Categoria categoria) {
        List<Producto> productosPorCategoria = new ArrayList<>();
        for(Producto p: productos){
            if(p.verCategoria()==categoria){
                productosPorCategoria.add(p);
            }
        }
        Collections.sort(productos);
        return productosPorCategoria;
    }
    
    @Override
    public Producto obtenerProducto(Integer codigo) {
        for(Producto p: productos){
            if(p.verCodigo()==codigo){
                return p;
            }
        }
        return null;
    }

    @Override
    public String borrarProducto(Producto producto) {
        if(producto==null){
            return PRODUCTO_INEXISTENTE;
        }
        GestorPedidos gp = GestorPedidos.instanciar();
        if(!(gp.hayPedidosConEsteProducto(producto))){
            productos.remove(producto);
        }
        return EXITO;
    }
    
    private static String crearArchivo(){
        try (FileWriter fw = new FileWriter(NOMBRE_ARCHIVO,true)){
            return CREACION_OK;
        }
        catch(IOException ioe) {
         return CREACION_ERROR;
        }
    }
    
    private String agregarProducto(Producto p){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO, true))){
            StringBuilder sb = new StringBuilder();
            sb.append(p.verCodigo()).append(SEPARADOR);
            sb.append(p.verDescripcion()).append(SEPARADOR);
            sb.append(p.verCategoria().toString()).append(SEPARADOR);
            sb.append(p.verEstado().toString()).append(SEPARADOR);
            sb.append(p.verPrecio()).append(SEPARADOR);
            bw.write(sb.toString());
            bw.newLine();
            return ESCRITURA_OK;
        }
        catch(IOException ioe) {
         return ESCRITURA_ERROR;
        }
    }
    
    private Producto leerUnProducto() {
        File f = new File(NOMBRE_ARCHIVO);
        try {
            BufferedReader br = new BufferedReader(new FileReader(NOMBRE_ARCHIVO));
            String linea = br.readLine();
            String[] cadenas = linea.split(SEPARADOR);
            Producto p = new Producto();
            p.asignarCodigo(Integer.parseInt(cadenas[0]));
            p.asignarDescripcion(cadenas[1]);
            p.asignarCategoria(this.convertirCategoria(cadenas[2]));
            p.asignarEstado(this.convertirEstado(cadenas[3]));
            p.asignarPrecio(Float.parseFloat(cadenas[4]));
            return p;
        } catch (FileNotFoundException ex) {
            System.out.println(LECTURA_ERROR);
            return null;
        } catch (IOException ex) {
            System.out.println(LECTURA_ERROR);
            return null;
        }
    }
    
    private List<Producto> leerArchivo(){
        BufferedReader br = null;
        try {
            File f = new File(NOMBRE_ARCHIVO);
            br = new BufferedReader(new FileReader(NOMBRE_ARCHIVO));
            List<Producto> listaProductos = new ArrayList<>();
            String linea;
            while((linea = br.readLine())!=null){
                listaProductos.add(this.leerUnProducto());
            }
            return listaProductos;
        } catch (FileNotFoundException ex) {
            System.out.println(LECTURA_ERROR);
            return null;
        } catch (IOException ex) {
            System.out.println(LECTURA_ERROR);
            return null;
        }
    }
    
    
    
    private Categoria convertirCategoria(String valor){
        Categoria[] valores = Categoria.values();
        for(Categoria c: valores){
            if(c.toString().equals(valor))
                return c;
        }
        return null;
    }
    
    private Estado convertirEstado(String valor){
        Estado[] valores = Estado.values();
        for(Estado e: valores){
            if(e.toString().equals(valor))
                return e;
        }
        return null;
    }
}
