package productos.modelos;

import interfaces.IGestorPedidos;
import interfaces.IGestorProductos;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pedidos.modelos.GestorPedidos;
import pedidos.modelos.Pedido;
import pedidos.modelos.ProductoDelPedido;

public class GestorProductos implements IGestorProductos {

    public static final String ARCHIVO = "Productos.txt";
    public static final String SEPARADOR = "*";

    private List<Producto> productos = new ArrayList();

    private static GestorProductos instancia;

    private GestorProductos() {

    }

    public static GestorProductos instanciar() {
        if (instancia == null) {
            instancia = new GestorProductos();
        }
        return instancia;
    }
//<editor-fold defaultstate="collapsed" desc="Nombre">

    //</editor-fold>
    @Override
    public String borrarProducto(Producto producto) {
//      
        IGestorPedidos gped = GestorPedidos.instanciar();
        for (Pedido p : gped.verPedidos()) {
            for (ProductoDelPedido pdp : p.getCantidadProducto()) {
                if (pdp.getUnProducto().equals(producto)) {
                    return BORRADO_ERROR;
                }
            }
        }
        productos.remove(producto);
//        try {
//            FileWriter fw = new FileWriter(ARCHIVO);
//            for (Producto p : productos) {
//                cargarProductoEnArchivo(p);
//            }
//        } catch (IOException ex) {
//            System.out.println("IOException");
//
//        }
        return BORRADO_EXITO;
    }

    @Override
    public String crearProducto(int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {

        if (codigo < 0) {
            return ERROR_CODIGO;
        }
        if (descripcion == null || descripcion.isEmpty()) {
            return ERROR_DESCRIPCION;
        }
        if (precio < 0) {
            return ERROR_PRECIO;
        }
        if (categoria == null) {
            return ERROR_CATEGORIA;
        }
        if (estado == null) {
            return ERROR_ESTADO;
        }
        Producto p = new Producto(codigo, descripcion, categoria, estado, precio);
        productos.add(p);
        if (productos.contains(p)) {
            cargarProductoEnArchivo(p);
        }
        return VALIDACION_EXITO;

    }

    private void cargarProductoEnArchivo(Producto p) {
        try {
            FileWriter fw = new FileWriter(ARCHIVO, true);
            fw.write(Integer.toString(p.verCodigo()));
            fw.write(SEPARADOR);
            fw.write(p.verDescripcion());
            fw.write(SEPARADOR);
            fw.write(Float.toString(p.verPrecio()));
            fw.write(SEPARADOR);
            fw.write(p.verCategoria().toString());
            fw.write(SEPARADOR);
            fw.write(p.verEstado().toString());
            fw.write(SEPARADOR);
            fw.write("\n");
            fw.flush();

        } catch (IOException ex) {
            System.out.println("IOException");

        }

    }

    @Override
    public String modificarProducto(Producto p, int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        if (codigo < 0) {
            return ERROR_CODIGO;
        }
        if (descripcion == null || descripcion.isEmpty()) {
            return ERROR_DESCRIPCION;
        }
        if (precio < 0) {
            return ERROR_PRECIO;
        }
        if (categoria == null) {
            return ERROR_CATEGORIA;
        }
        if (estado == null) {
            return ERROR_ESTADO;
        }
//        int posicion=productos.indexOf(p);
//        p.asignarCodigo(codigo);
//        p.asignarDescripcion(descripcion);
//        p.asignarPrecio(precio);
//        p.asignarCategoria(categoria);
//        p.asignarEstado(estado);
//        productos.remove(posicion);
//        productos.add(posicion,p );
//        
//        try {
//            FileWriter fw = new FileWriter(ARCHIVO);
//            for (Producto pro : productos) {
//                cargarProductoEnArchivo(pro);
//            }
//        } catch (IOException ex) {
//            System.out.println("IOException");
//
//        }
//        
        return EXITO;
    }

    @Override
    public List<Producto> menu() {
        Collections.sort(productos);
        return this.productos;
    }

    public List<Producto> buscarProductos(String descripcion) {
        List<Producto> prod = new ArrayList();

        for (Producto p : productos) {
            if (p.verDescripcion().contains(descripcion)) {
                prod.add(p);
            }

        }
        Collections.sort(prod);
        return prod;
    }

    public boolean existeEsteProducto(Producto producto) {
        return productos.contains(producto);
    }

    public List<Producto> verProductosPorCategoria(Categoria categoria) {
        List<Producto> productosPorCategoria = new ArrayList();
        for (Producto p : productos) {
            if (p.verCategoria() == categoria);
            Collections.sort(productosPorCategoria);
            return productosPorCategoria;
        }
        return productosPorCategoria;
    }

    public Producto obtenerProducto(Integer codigo) {
        for (Producto p : productos) {
            if (p.verCodigo() == codigo) {
                return p;
            }
        }
        return null;
    }
}
