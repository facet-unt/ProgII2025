package productos.modelos;

import interfaces.IGestorProductos;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import pedidos.modelos.GestorPedidos;


public class GestorProductos implements IGestorProductos  {
    private ArrayList<Producto> productos = new ArrayList<>();
    private static GestorProductos instancia;
    
    private GestorProductos() {
        
    }
    
    public static GestorProductos instanciar() {
        if (instancia == null)
            instancia = new GestorProductos();
        return instancia;
    }
    
    @Override
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
        GuardarProductos(Producto producto);
        return cadena;
        
    }
    
    @Override
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
    
    @Override
    public List<Producto> menu() {
        Collections.sort(productos);
        return this.productos;
    }
    
    @Override
    public ArrayList<Producto> buscarProductos(String descripcion) {
        ArrayList <Producto>productosbuscados =new ArrayList<>();
        for (Producto p : productos) {
            if(p.verDescripcion().toLowerCase().contains(descripcion.toLowerCase()))
                productosbuscados.add(p);
                Collections.sort(productosbuscados);
      }
        return productosbuscados;
    }
    
    @Override
    public boolean existeEsteProducto(Producto producto) {
        for (Producto p: productos) {
            if(p.verCodigo()==producto.verCodigo())
            return true;
        }
        return false;
        }
    
    @Override
    public ArrayList<Producto> verProductosPorCategoria(Categoria categoria) {
        ArrayList<Producto>productoDelaCategoria=new ArrayList<>();
        for(Producto p: productos){
            if(p.verCategoria()==categoria)
                productoDelaCategoria.add(p);
            Collections.sort(productoDelaCategoria);
        }
        return productoDelaCategoria;
    }
    
    @Override
    public Producto obtenerProducto(Integer codigo) {
        for(Producto p: productos){
            if(p.verCodigo()==codigo)
                return p;
        }
        return null;
        }
    @Override
    public String borrarProducto(Producto producto){
        GestorPedidos gPedidos= GestorPedidos.instanciar();
        if(gPedidos.hayPedidosConEsteProducto(producto)== true){
            return PRODUCTO_EN_PEDIDO;
        }
        else{
            productos.remove(producto);
            return PRODUCTO_BORRADO;
        }
    }

    private String CrearArchivo(){
        File f =  new File(NOMBRE_ARCHIVO);
        try{
            f.createNewFile();
            return CREACION_OK;
        }
        catch(IOException ioe){
            return CREACION_ERROR;
        }
    }
    public String GuardarProductos(Producto producto){
        String[] cadena = null;
        StringBuilder cadena1 = null;
        try {
            FileWriter fw = new FileWriter(NOMBRE_ARCHIVO,true);
            BufferedWriter bw = new BufferedWriter(fw);
            cadena[0] = Integer.toString(producto.verCodigo());
            cadena1.append(cadena[0]);
            cadena1.append(SEPARADOR);
            cadena[1] = producto.verDescripcion();
            cadena1.append(cadena[1]);
            cadena1.append(SEPARADOR);
            cadena[2] = Float.toString(producto.verPrecio());
            cadena1.append(cadena[2]);
            cadena1.append(SEPARADOR);
            cadena[3] = producto.verCategoria().toString();
            cadena1.append(cadena[3]);
            cadena[4] = producto.verEstado().toString();
            bw.write(cadena1.toString());
            bw.newLine();
            fw.close();
        } 
        catch (IOException ex) {
            return ESCRITURA_ERROR;
        }
        
    }
}
